/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.handlers.impl;

import com.btmatthews.alexa.adventure.domain.Direction;
import com.btmatthews.alexa.adventure.services.DirectionService;
import com.btmatthews.alexa.adventure.services.LocationService;
import com.btmatthews.alexa.adventure.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public final class MoveIntentHandler extends AbstractMoveIntentHandler {

    private final DirectionService directionService;

    @Autowired
    public MoveIntentHandler(final PlayerService playerService,
                             final LocationService locationService,
                             final DirectionService directionService) {
        super("MoveIntent", playerService, locationService);
        this.directionService = directionService;
    }

    @Override
    public Direction resolveDirection(final Map<String, String> slots) {

        final String directionSlot = slots.get("direction");
        if (directionSlot == null) {
            throw new RuntimeException("");
        }

        return directionService.mapDirection(directionSlot);
    }
}
