package com.btmatthews.alexa.adventure.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class IntentDescriptor {

    private final String intent;

    private final List<SlotDescriptor> slots;

    @JsonCreator
    public IntentDescriptor(final String intent, final List<SlotDescriptor> slots) {
        this.intent = intent;
        this.slots = slots;
    }

    public String getIntent() {

        return intent;
    }

    public List<SlotDescriptor> getSlots() {
        return slots;
    }
}
