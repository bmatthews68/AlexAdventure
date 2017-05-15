package com.btmatthews.alexa.adventure.handlers;

public class IntentResponse {

    private final IntentResponseType type;

    private final String text;

    private IntentResponse(final IntentResponseType type,
                           final String text) {
        this.type = type;
        this.text = text;
    }

    public IntentResponseType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static IntentResponse done(final String text) {
        return new IntentResponse(IntentResponseType.DONE, text);
    }

    public static IntentResponse end(final String text) {
        return new IntentResponse(IntentResponseType.END, text);
    }
}
