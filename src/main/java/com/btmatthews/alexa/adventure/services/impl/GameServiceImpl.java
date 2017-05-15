package com.btmatthews.alexa.adventure.services.impl;

import com.btmatthews.alexa.adventure.dao.GameRepository;
import com.btmatthews.alexa.adventure.domain.*;
import com.btmatthews.alexa.adventure.domain.Character;
import com.btmatthews.alexa.adventure.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameDescriptor getGameDescriptor(final String gameId) {
        return gameRepository.findOne(gameId);
    }

    @Override
    public Game getGame(final String userId, final String gameId) {
        return new Game(new Player(userId, "", "", Collections.emptyList()),
                Collections.emptyMap(),
                Collections.emptyMap(),
                Collections.emptyMap());
    }

    @Override
    public List<IntentDescriptor> getIntents(final String gameId) {
        final GameDescriptor gameDescriptor = gameRepository.findOne(gameId);
        if (gameDescriptor != null) {
            return gameDescriptor.getIntents();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<UtteranceDescriptor> getSampleUtterances(final String gameId) {
        final GameDescriptor gameDescriptor = gameRepository.findOne(gameId);
        if (gameDescriptor != null) {
            return gameDescriptor.getUtterances();
        } else {
            return Collections.emptyList();
        }
    }
}
