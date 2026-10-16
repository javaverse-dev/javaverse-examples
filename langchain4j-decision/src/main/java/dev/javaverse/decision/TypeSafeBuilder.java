package dev.javaverse.decision;

import dev.langchain4j.model.decision.DecisionModel;
import dev.langchain4j.model.decision.request.ChoiceQuestion;
import dev.langchain4j.model.decision.request.DecisionRequest;
import dev.langchain4j.model.typesafe.TypeSafeDecisionModel;
import org.tinylog.Logger;

/// @author Javaverse
class TypeSafeBuilder {

    void main() {
        var csv = new Csv("/youtube-comments.csv");
        var comments = csv.getTop("Comment", 10);

        var dm = TypeSafeDecisionModel.builder()
                                      .apiKey(System.getenv("TYPESAFE_API_KEY"))
                                      .modelName("jev-latest")
                                      .build();

        Logger.info("Analyzing intent for top {} comments..", comments.size());
        var msgIntents = comments.stream()
                                 .map(c -> decide(dm, c))
                                 .toList();
        Logger.info(msgIntents);
    }

    MessageIntent decide(DecisionModel model, String comment) {
        var res = model.decide(buildRequest(comment));
        var intent = Intent.valueOf(res.choice("intent").value());
        return new MessageIntent(comment, intent);
    }

    DecisionRequest buildRequest(String comment) {
        return DecisionRequest.builder()
                              .input(comment)
                              .question("intent", ChoiceQuestion.builder()
                                                                .text("What is the intent of the given message")
                                                                .option(Intent.QUESTION.name())
                                                                .option(Intent.PRAISE.name())
                                                                .option(Intent.CRITICISM.name())
                                                                .option(Intent.SUGGESTION.name())
                                                                .option(Intent.DISCUSSION.name())
                                                                .option(Intent.JOKE.name())
                                                                .option(Intent.SPAM.name())
                                                                .option(Intent.OTHER.name())
                                                                .build())
                              .build();
    }
}
