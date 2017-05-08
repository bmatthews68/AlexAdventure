package com.btmatthews.alexa.adventure.services;

import com.btmatthews.alexa.adventure.domain.Location;

import java.util.List;

public interface CharacterService {

    List<Character> getCharactersAtLocation(Location locataion);
}
