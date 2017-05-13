/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class AdventureSpeechlet implements Speechlet {

    private final List<IntentHandler> handlers;

    @Autowired
    public AdventureSpeechlet(final List<IntentHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void onSessionStarted(final SessionStartedRequest request,
                                 final Session session)
            throws SpeechletException {
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request,
                                      final Session session)
            throws SpeechletException {

        final String speechText = "Welcome to Alexa Adventure, what game do you want to play?";

        final SimpleCard card = new SimpleCard();
        card.setTitle("Welcome");
        card.setContent(speechText);

        final PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        final Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request,
                                      final Session session)
            throws SpeechletException {
        final Intent intent = request.getIntent();
        if (intent != null) {
            final String intentName = intent.getName();
            return handlers.stream()
                    .filter(handler -> handler.handles(intentName))
                    .findFirst()
                    .orElseThrow(() -> new SpeechletException("Invalid intent: " + intentName))
                    .handle(intent);
        }
        throw new SpeechletException("Invalid intent");
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request,
                               final Session session)
            throws SpeechletException {
    }
}