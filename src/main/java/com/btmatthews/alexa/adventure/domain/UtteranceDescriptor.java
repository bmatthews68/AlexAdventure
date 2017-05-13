package com.btmatthews.alexa.adventure.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UtteranceDescriptor {

    private final String intent;

    private final String utterance;

    @JsonCreator
    public UtteranceDescriptor(String intent, String utterance) {
        this.intent = intent;
        this.utterance = utterance;
    }

    public String getIntent() {
        return intent;
    }

    public String getUtterance() {
        return utterance;
    }
}
