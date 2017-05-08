/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.handlers.impl;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.btmatthews.alexa.adventure.domain.Direction;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
import com.btmatthews.alexa.adventure.services.AdventureService;
import com.btmatthews.alexa.adventure.services.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public final class MoveIntentHandler implements IntentHandler {

    private final AdventureService adventureService;

    private final DirectionService directionService;

    @Autowired
    public MoveIntentHandler(final AdventureService adventureService,
                             final DirectionService directionService) {
        this.adventureService = adventureService;
        this.directionService = directionService;
    }

    @Override
    public boolean handles(final String intentName) {
        return "MoveIntent".equals(intentName);
    }

    @Override
    public SpeechletResponse handle(final Intent intent) {

        final Player player = adventureService.getPlayer();
        final Location location = adventureService.getLocation(player);
        final Map<Direction, String> exits = location.getExits();

        final Slot directionSlot = intent.getSlot("direction");
        if (directionSlot == null) {
            throw new RuntimeException();
        }

        final Direction direction = directionService.mapDirection(directionSlot.getValue());
        if (direction == Direction.UNKNOWN) {
        }

        return null;
    }
}
