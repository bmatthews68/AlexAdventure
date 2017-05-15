package com.btmatthews.alexa.adventure.domain;

import java.util.Map;

public class Game {

    private final Player player;

    private final Map<String, Location> locations;

    private final Map<String, Character> characters;

    private final Map<String, Artifact> artifacts;

    public Game(final Player player,
                final Map<String, Location> locations,
                final Map<String, Character> characters,
                final Map<String, Artifact> artifacts) {
        this.player = player;
        this.locations = locations;
        this.characters = characters;
        this.artifacts = artifacts;
    }

    public Player getPlayer() {
        return player;
    }

    public Map<String, Location> getLocations() {
        return locations;
    }

    public Map<String, Character> getCharacters() {
        return characters;
    }

    public Map<String, Artifact> getArtifacts() {
        return artifacts;
    }
}
