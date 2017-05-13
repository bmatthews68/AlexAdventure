package com.btmatthews.alexa.adventure.services.impl;

import com.btmatthews.alexa.adventure.dao.GameRepository;
import com.btmatthews.alexa.adventure.domain.GameDescriptor;
import com.btmatthews.alexa.adventure.domain.IntentDescriptor;
import com.btmatthews.alexa.adventure.domain.UtteranceDescriptor;
import com.btmatthews.alexa.adventure.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
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
