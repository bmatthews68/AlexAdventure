package com.btmatthews.alexa.adventure.services.impl;

import com.btmatthews.alexa.adventure.domain.Direction;
import com.btmatthews.alexa.adventure.services.DirectionService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DirectionServiceImpl implements DirectionService {

    private Map<String, Direction> mappings = new HashMap<>();

    @Override
    public Direction mapDirection(final String value) {
        return mappings.getOrDefault(value, Direction.UNKNOWN);
    }
}
