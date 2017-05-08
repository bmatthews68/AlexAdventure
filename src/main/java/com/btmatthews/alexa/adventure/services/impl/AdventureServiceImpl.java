/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.services.impl;

import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;
import com.btmatthews.alexa.adventure.services.AdventureService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public final class AdventureServiceImpl implements AdventureService {

    private static final String PLAYER_ID = "P1";

    private static final String LOCATION_ID = "L1";

    @Override
    public Player getPlayer() {
        return new Player(PLAYER_ID, "Brian", Collections.emptyList());
    }

    @Override
    public Location getLocation(final Player player) {
        return new Location(
                LOCATION_ID,
                "Dark Room",
                "The room is dark",
                Collections.singletonList(PLAYER_ID),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyMap());
    }
}
