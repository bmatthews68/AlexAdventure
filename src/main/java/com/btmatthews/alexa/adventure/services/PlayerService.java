package com.btmatthews.alexa.adventure.services;

import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;

public interface PlayerService {

    Player getPlayer();

    Player getPlayer(String id);

    void updateLocation(Player player, Location location);
}
