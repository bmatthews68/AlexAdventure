package com.btmatthews.alexa.adventure.services;

import com.btmatthews.alexa.adventure.domain.Location;

public interface LocationService {

    Location getLocation(String locationId);
}
