package com.btmatthews.alexa.adventure.services;

import com.btmatthews.alexa.adventure.domain.IntentDescriptor;
import com.btmatthews.alexa.adventure.domain.UtteranceDescriptor;

import java.util.List;

public interface GameService {

    List<IntentDescriptor> getIntents(String gameId);

    List<UtteranceDescriptor> getSampleUtterances(String gameId);
}
