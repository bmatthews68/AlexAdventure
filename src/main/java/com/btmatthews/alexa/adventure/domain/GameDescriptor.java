package com.btmatthews.alexa.adventure.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "games")
public class GameDescriptor {

    @Id
    private final String id;

    private final List<IntentDescriptor> intents;

    private final List<UtteranceDescriptor> utterances;

    @JsonCreator
    public GameDescriptor(final String id,
                          final List<IntentDescriptor> intents,
                          final List<UtteranceDescriptor> utterances) {
        this.id = id;
        this.intents = intents;
        this.utterances = utterances;
    }

    public String getId() {
        return id;
    }

    public List<IntentDescriptor> getIntents() {
        return intents;
    }

    public List<UtteranceDescriptor> getUtterances() {
        return utterances;
    }
}
