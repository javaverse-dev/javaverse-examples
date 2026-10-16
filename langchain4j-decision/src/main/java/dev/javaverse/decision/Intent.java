package dev.javaverse.decision;

import dev.langchain4j.model.output.structured.Description;

/// @author Javaverse
enum Intent {
        @Description("Question asked?") QUESTION,
        @Description("Praises for the") PRAISE,
        @Description("Doing Criticism") CRITICISM,
        @Description("Asking for the suggestion") SUGGESTION,
        @Description("Asking for the discussion") DISCUSSION,
        @Description("Joking") JOKE,
        @Description("Spamming") SPAM,
        @Description("Other") OTHER;
    }
