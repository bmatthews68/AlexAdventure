/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.domain;

import java.util.List;
import java.util.Map;

public class Location {

    private final String id;

    private final String name;

    private final String description;

    private final List<String> players;

    private final List<String> characters;

    private final List<String> artifacts;

    private final Map<Direction, String> exits;

    private final List<ActionDescriptor> actions;

    public Location(final String id, final String name, final String description, final List<String> players,
                    final List<String> characters, final List<String> artifacts, final Map<Direction, String> exits,
                    final List<ActionDescriptor> actions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.players = players;
        this.characters = characters;
        this.artifacts = artifacts;
        this.exits = exits;
        this.actions = actions;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public List<String> getArtifacts() {
        return artifacts;
    }

    public Map<Direction, String> getExits() {
        return exits;
    }

    public List<ActionDescriptor> getActions() {
        return actions;
    }
}