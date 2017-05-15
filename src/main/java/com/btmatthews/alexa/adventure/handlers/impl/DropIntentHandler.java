package com.btmatthews.alexa.adventure.handlers.impl;

import com.btmatthews.alexa.adventure.domain.Game;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
import com.btmatthews.alexa.adventure.handlers.IntentResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DropIntentHandler implements IntentHandler {
    @Override
    public boolean handles(String intentName) {
        return false;
    }

    @Override
    public IntentResponse handle(final Game game,
                                 final Player player,
                                 final Location location,
                                 final String intentName,
                                 final Map<String, String> slots) {
        return null;
    }
}
