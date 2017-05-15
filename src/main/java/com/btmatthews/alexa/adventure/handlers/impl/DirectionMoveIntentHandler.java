package com.btmatthews.alexa.adventure.handlers.impl;

import com.btmatthews.alexa.adventure.domain.Direction;
import com.btmatthews.alexa.adventure.services.LocationService;
import com.btmatthews.alexa.adventure.services.PlayerService;

import java.util.Map;

public class DirectionMoveIntentHandler extends AbstractMoveIntentHandler {

    private final Direction direction;

    public DirectionMoveIntentHandler(final PlayerService playerService,
                                      final LocationService locationService,
                                      final String intentName,
                                      final Direction direction) {
        super(intentName, playerService, locationService);
        this.direction = direction;
    }

    @Override
    public Direction resolveDirection(final Map<String, String> slots) {
        return direction;
    }
}