package com.btmatthews.alexa.adventure.handlers.impl;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.btmatthews.alexa.adventure.domain.Direction;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
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

    protected abstract Direction resolveDirection(Intent intent);

    @Override
    public boolean handles(final String intentName) {
        return this.intentName.equals(intentName);
    }

    @Override
    public SpeechletResponse handle(final Intent intent) {

        final Player player = playerService.getPlayer();
        final Location location = locationService.getLocation(player.getLocationId());
        final Map<Direction, String> exits = location.getExits();

        final PlainTextOutputSpeech speech = new PlainTextOutputSpeech();

        final Direction direction = resolveDirection(intent);
        if (direction == Direction.UNKNOWN) {
            speech.setText("I did not understand the direction you asked for.");
        } else {
            final String newLocationId = exits.get(direction);
            if (newLocationId == null) {
                speech.setText("You cannot go in that direction.");
            } else if (newLocationId.equals(location.getId())) {
                speech.setText("You have gone around in a circle.");
            } else {
                final Location newLocation = locationService.getLocation(newLocationId);
                if (newLocation == null) {
                    throw new RuntimeException("");
                } else {
                    playerService.updateLocation(player, newLocation);
                    speech.setText(newLocation.getDescription());
                }
            }
        }

        return SpeechletResponse.newTellResponse(speech);
    }
}
