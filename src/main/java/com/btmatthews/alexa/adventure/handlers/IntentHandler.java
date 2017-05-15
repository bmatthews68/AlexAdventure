/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.handlers;

import com.btmatthews.alexa.adventure.domain.Game;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;

import java.util.Map;

public interface IntentHandler {

    boolean handles(String intentName);

    IntentResponse handle(Game game,
                          Player player,
                          Location location,
                          String intentName,
                          Map<String, String> slots);
}
