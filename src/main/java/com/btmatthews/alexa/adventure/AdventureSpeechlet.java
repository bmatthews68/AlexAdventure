/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.btmatthews.alexa.adventure.domain.Game;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
import com.btmatthews.alexa.adventure.handlers.IntentResponse;
import com.btmatthews.alexa.adventure.services.GameService;
import com.btmatthews.alexa.adventure.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public final class AdventureSpeechlet implements Speechlet {

    /**
     * The intent handlers are perform the actions requested by the player.
     */
    private final List<IntentHandler> handlers;

    /**
     * The game service is used to manage game state and metadata.
     */
    private final GameService gameService;

    /**
     * The player service is used to manage location state.
     */
    private final LocationService locationService;

    /**
     * @param handlers        The intent handlers perform the actions requested by the player.
     * @param gameService     The game service is used to manage game state and metadata.
     * @param locationService The location service is used to manage location.
     */
    @Autowired
    public AdventureSpeechlet(final List<IntentHandler> handlers,
                              final GameService gameService,
                              final LocationService locationService) {
        this.handlers = handlers;
        this.gameService = gameService;
        this.locationService = locationService;
    }

    /**
     * The callback is invoked by Alexa when a new user session is initiated.
     *
     * @param request The start request.
     * @param session The new session.
     * @throws SpeechletException If the session could not be initiated.
     */
    @Override
    public void onSessionStarted(final SessionStartedRequest request,
                                 final Session session)
            throws SpeechletException {
    }

    /**
     * This callback is invoked by Alexa when the user launches an application.
     *
     * @param request The launch request.
     * @param session The user session.
     * @return
     * @throws SpeechletException If the application could not be launched.
     */
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

    /**
     * This callback is invoked by Alexa to perform an action on behalf of a user.
     *
     * @param request The intent request.
     * @param session The user session.
     * @return
     * @throws SpeechletException If the action could not be performed or was unknown.
     */
    @Override
    public SpeechletResponse onIntent(final IntentRequest request,
                                      final Session session)
            throws SpeechletException {
        final String userId = session.getUser().getUserId();
        final Game game = gameService.getGame(userId, session.getApplication().getApplicationId());
        final Player player = game.getPlayer();
        final Intent intent = request.getIntent();
        if (intent != null) {
            final Location location = locationService.getLocation(player.getLocationId());
            final String intentName = intent.getName();
            final IntentResponse response = handlers.stream()
                    .filter(handler -> handler.handles(intentName))
                    .findFirst()
                    .map(handler -> handler.handle(game, player, location, intentName, getSlots(intent)))
                    .orElseThrow(() -> new SpeechletException("Invalid intent: " + intentName));

            final SimpleCard card = new SimpleCard();
            card.setTitle("TODO"); // TODO Set name
            card.setContent(response.getText());

            final PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText(response.getText());


            switch (response.getType()) {
                case DONE:
                    final Reprompt reprompt = new Reprompt();
                    reprompt.setOutputSpeech(outputSpeech);
                    return SpeechletResponse.newAskResponse(outputSpeech, reprompt, card);
                case END:
                    return SpeechletResponse.newTellResponse(outputSpeech, card);
            }
        }
        throw new SpeechletException("Invalid intent");
    }

    /**
     * @param request
     * @param session
     * @throws SpeechletException If the session could not be terminated.
     */
    @Override
    public void onSessionEnded(final SessionEndedRequest request,
                               final Session session)
            throws SpeechletException {
    }

    /**
     * Convert the slots in the intent to a generic map of key/value pairs.
     *
     * @param intent The intent request.
     * @return The generic map of key/value pairs.
     */
    private Map<String, String> getSlots(final Intent intent) {
        return intent.getSlots().values().stream().collect(Collectors.toMap(Slot::getName, Slot::getValue));
    }
}