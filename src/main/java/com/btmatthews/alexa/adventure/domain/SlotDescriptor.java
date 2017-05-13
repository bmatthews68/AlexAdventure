package com.btmatthews.alexa.adventure.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SlotDescriptor {

    private final String name;

    private final String type;

    @JsonCreator
    public SlotDescriptor(final String name, final String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
