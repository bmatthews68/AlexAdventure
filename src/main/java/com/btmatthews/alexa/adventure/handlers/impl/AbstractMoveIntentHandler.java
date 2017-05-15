package com.btmatthews.alexa.adventure.handlers.impl;

import com.btmatthews.alexa.adventure.domain.Direction;
import com.btmatthews.alexa.adventure.domain.Game;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
import com.btmatthews.alexa.adventure.handlers.IntentResponse;
import com.btmatthews.alexa.adventure.services.LocationService;
import com.btmatthews.alexa.adventure.services.PlayerService;

import java.util.Map;

public abstract class AbstractMoveIntentHandler implements IntentHandler {

    private final String intentName;

    private final PlayerService playerService;

    private final LocationService locationService;

    AbstractMoveIntentHandler(final String intentName,
                              final PlayerService playerService,
                              final LocationService locationService) {
        this.intentName = intentName;
        this.playerService = playerService;
        this.locationService = locationService;
    }

    protected abstract Direction resolveDirection(Map<String, String> slots);

    @Override
    public boolean handles(final String intentName) {
        return this.intentName.equals(intentName);
    }

    @Override
    public IntentResponse handle(final Game game,
                                 final Player player,
                                 final Location location,
                                 final String intentName,
                                 final Map<String, String> slots) {

        final Map<Direction, String> exits = location.getExits();

        final Direction direction = resolveDirection(slots);
        if (direction == Direction.UNKNOWN) {
            return IntentResponse.done("I did not understand the direction you asked for.");
        } else {
            final String newLocationId = exits.get(direction);
            if (newLocationId == null) {
                return IntentResponse.done("You cannot go in that direction.");
            } else if (newLocationId.equals(location.getId())) {
                return IntentResponse.done("You have gone around in a circle.");
            } else {
                final Location newLocation = locationService.getLocation(newLocationId);
                if (newLocation == null) {
                    throw new RuntimeException("");
                } else {
                    playerService.updateLocation(player, newLocation);
                    return IntentResponse.done(newLocation.getDescription());
                }
            }
        }
    }
}
