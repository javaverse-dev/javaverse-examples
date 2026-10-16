package dev.javaverse.decision;

import dev.langchain4j.model.typesafe.TypeSafeDecisionModel;
import dev.langchain4j.service.decision.Decide;
import dev.langchain4j.service.decision.DecisionServices;
import org.tinylog.Logger;

/// @author Javaverse
class TypeSafeAIService {

    void main() {
        var csv = new Csv("/youtube-comments.csv");
        var comments = csv.getTop("Comment", 10);

        var decisionModel = TypeSafeDecisionModel.builder()
                                                 .apiKey(System.getenv("TYPESAFE_API_KEY"))
                                                 .modelName("jev-latest")
                                                 .build();

        Logger.info("Analyzing intent for top {} comments..", comments.size());

        var analysis = DecisionServices.create(IntentAnalysis.class, decisionModel);
        var msgIntents = comments.stream()
                                 .map(c -> new MessageIntent(c, analysis.analyze(c)))
                                 .toList();

        Logger.info(msgIntents);
    }


    interface IntentAnalysis {

        @Decide("What is the intent of the given message")
        Intent analyze(String message);
    }

}
