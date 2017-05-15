package com.btmatthews.alexa.adventure.handlers.impl;

import com.btmatthews.alexa.adventure.domain.ActionDescriptor;
import com.btmatthews.alexa.adventure.domain.Game;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
import com.btmatthews.alexa.adventure.handlers.IntentResponse;
import com.btmatthews.alexa.adventure.services.LocationService;

import java.util.Map;

public class ActionIntentHandler implements IntentHandler {

    private final String intentName;

    private final LocationService locationService;

    public ActionIntentHandler(final String intentName,
                               final LocationService locationService) {
        this.intentName = intentName;
        this.locationService = locationService;
    }

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
        final ActionDescriptor action = findAction(location, slots);
        if (action != null) {
            final StringBuilder builder = new StringBuilder();
            if (action.getDescription() != null) {
                builder.append(action.getDescription());
            }
            if (action.getGotoLocationId() != null) {
                final Location newLocation = locationService.getLocation(action.getGotoLocationId());
                if (builder.length() > 0) {
                    builder.append("  )");
                }
                builder.append(newLocation.getDescription());
            }
            if (action.isEndGame()) {
                return IntentResponse.end(builder.toString());
            } else {
                return IntentResponse.done(builder.toString());
            }
        }
        return null;
    }

    private ActionDescriptor findAction(final Location location,
                                        final Map<String, String> slots) {
        return location.getActions().stream()
                .filter(action -> matchAction(action, slots))
                .findFirst()
                .orElse(null);
    }

    private boolean matchAction(final ActionDescriptor action,
                                final Map<String, String> slots) {
        if (action.getIntentName().equals(intentName)) {
            if (action.getSlotValues() != null) {
                for (final Map.Entry<String, String> slotEntry : action.getSlotValues().entrySet()) {
                    final String slotValue = slots.get(slotEntry.getKey());
                    if (slotValue == null || !slotValue.equals(slotEntry.getValue())) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
