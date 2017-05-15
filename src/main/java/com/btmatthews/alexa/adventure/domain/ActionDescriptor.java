package com.btmatthews.alexa.adventure.domain;

import java.util.Map;

public class ActionDescriptor {

    private String intentName;

    private Map<String, String> slotValues;

    private String description;

    private String gotoLocationId;

    private boolean endGame;

    public ActionDescriptor(String intentName, Map<String, String> slotValues, String description, String gotoLocationId, boolean endGame) {
        this.intentName = intentName;
        this.slotValues = slotValues;
        this.description = description;
        this.gotoLocationId = gotoLocationId;
        this.endGame = endGame;
    }

    public String getIntentName() {
        return intentName;
    }

    public Map<String, String> getSlotValues() {
        return slotValues;
    }

    public String getDescription() {
        return description;
    }

    public String getGotoLocationId() {
        return gotoLocationId;
    }

    public boolean isEndGame() {
        return endGame;
    }
}
