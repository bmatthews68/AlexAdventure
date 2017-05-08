/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.services.impl;

import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import com.btmatthews.alexa.adventure.services.PlayerService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public final class PlayerServiceImpl implements PlayerService {

    private static final String PLAYER_ID = "P1";

    private static final String LOCATION_ID = "L1";

    @Override
    public Player getPlayer() {
        return getPlayer(PLAYER_ID);
    }

    @Override
    public Player getPlayer(String id) {
        return new Player(id, "Brian", LOCATION_ID, Collections.emptyList());
    }

    @Override
    public List<Player> getOtherPlayersAtLocation(final Location location) {
        return Collections.emptyList();
    }


    @Override
    public void updateLocation(Player player, Location location) {
        new Player(player.getId(), player.getName(), location.getId(), player.getArtifactIds());
    }
}
