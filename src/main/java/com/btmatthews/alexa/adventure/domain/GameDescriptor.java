package com.btmatthews.alexa.adventure.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "games")
public class GameDescriptor {

    @Id
    private final String id;

    private final String startLocationId;

    private final List<Location> locations;

    private final List<Character> characters;

    private final List<Artifact> artifacts;

    private final List<IntentDescriptor> intents;

    private final List<UtteranceDescriptor> utterances;

    @JsonCreator
    public GameDescriptor(final String id,
                          final String startLocationId,
                          final List<Location> locations,
                          final List<Character> characters,
                          final List<Artifact> artifacts,
                          final List<IntentDescriptor> intents,
                          final List<UtteranceDescriptor> utterances) {
        this.id = id;
        this.startLocationId = startLocationId;
        this.locations = locations;
        this.characters = characters;
        this.artifacts = artifacts;
        this.intents = intents;
        this.utterances = utterances;
    }

    public String getId() {
        return id;
    }

    public String getStartLocationId() {
        return startLocationId;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public List<IntentDescriptor> getIntents() {
        return intents;
    }

    public List<UtteranceDescriptor> getUtterances() {
        return utterances;
    }
}
