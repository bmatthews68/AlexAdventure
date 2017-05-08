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

    private final String locationId;

    private final List<String> artifactIds;

    public Player(final String id,
                  final String name,
                  final String locationId,
                  final List<String> artifactIds) {
        this.id = id;
        this.name = name;
        this.locationId = locationId;
        this.artifactIds = artifactIds;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocationId() {
        return locationId;
    }

    public List<String> getArtifactIds() {
        return artifactIds;
    }
}