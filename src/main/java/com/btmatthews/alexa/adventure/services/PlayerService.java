package com.btmatthews.alexa.adventure.services;

import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;

import java.util.List;

public interface PlayerService {

    Player getPlayer();

    Player getPlayer(String id);

    List<Player> getOtherPlayersAtLocation(Location location);

    void updateLocation(Player player, Location location);
}
