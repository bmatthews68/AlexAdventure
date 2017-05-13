package com.btmatthews.alexa.adventure.dao;

import com.btmatthews.alexa.adventure.domain.GameDescriptor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<GameDescriptor, String> {
}
