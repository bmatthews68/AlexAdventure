/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.services;

import com.btmatthews.alexa.adventure.domain.Direction;
import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.domain.Player;

public interface AdventureService {

    /**
     * Get the current player.
     *
     * @return The current player.
     */
    Player getPlayer();

    /**
     * Get the location of the player.
     *
     * @param player The player.
     * @return The location of the player.
     */
    Location getLocation(Player player);
}
