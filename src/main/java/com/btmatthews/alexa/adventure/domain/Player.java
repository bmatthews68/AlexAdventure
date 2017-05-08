/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.domain;

import java.util.List;

public class Player {

    private final String id;

    private final String name;

    private final List<Artifact> artifacts;

    public Player(final String id,
                  final String name,
                  final List<Artifact> artifacts) {
        this.id = id;
        this.name = name;
        this.artifacts = artifacts;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }
}