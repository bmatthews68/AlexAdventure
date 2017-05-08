package com.btmatthews.alexa.adventure.services.impl;

import com.btmatthews.alexa.adventure.domain.Location;
import com.btmatthews.alexa.adventure.services.CharacterService;

import java.util.Collections;
import java.util.List;

public class CharacterServiceImpl implements CharacterService {
    @Override
    public List<Character> getCharactersAtLocation(final Location locataion) {
        return Collections.emptyList();
    }
}
