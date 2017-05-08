/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.handlers.impl;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
import com.btmatthews.alexa.adventure.services.AdventureService;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class DescribeLocationIntentHandler implements IntentHandler {

    private final AdventureService adventureService;

    @Autowired
    public DescribeLocationIntentHandler(final AdventureService adventureService) {
        this.adventureService = adventureService;
    }

    @Override
    public boolean handles(final String intentName) {
        return "DescribeLocationIntent".equals(intentName);
    }

    @Override
    public SpeechletResponse handle(final Intent intent) {

        final Player player = adventureService.getPlayer();
        final Location location = adventureService.getLocation(player);

        final PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
        outputSpeech.setText(location.getDescription());

        return SpeechletResponse.newTellResponse(outputSpeech);
    }
}
