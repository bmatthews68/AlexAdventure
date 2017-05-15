package com.btmatthews.alexa.adventure.services;

import com.btmatthews.alexa.adventure.domain.Game;
import com.btmatthews.alexa.adventure.domain.GameDescriptor;
import com.btmatthews.alexa.adventure.domain.IntentDescriptor;
import com.btmatthews.alexa.adventure.domain.UtteranceDescriptor;

import java.util.List;

public interface GameService {

    GameDescriptor getGameDescriptor(String gameId);

    Game getGame(String userId, String gameId);

    List<IntentDescriptor> getIntents(String gameId);

    List<UtteranceDescriptor> getSampleUtterances(String gameId);
}
