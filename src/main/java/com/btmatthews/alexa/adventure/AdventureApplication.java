/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import com.btmatthews.alexa.adventure.domain.Direction;
import com.btmatthews.alexa.adventure.handlers.IntentHandler;
import com.btmatthews.alexa.adventure.handlers.impl.DirectionMoveIntentHandler;
import com.btmatthews.alexa.adventure.services.LocationService;
import com.btmatthews.alexa.adventure.services.PlayerService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableEncryptableProperties
public class AdventureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventureApplication.class, args);
    }

    @Bean
    @Autowired
    public SpeechletServlet speechletServlet(final Speechlet speechlet) {
        final SpeechletServlet speechletServlet = new SpeechletServlet();
        speechletServlet.setSpeechlet(speechlet);
        return speechletServlet;
    }

    @Bean
    @Autowired
    public ServletRegistrationBean adventureServlet(final SpeechletServlet speechletServlet) {
        return new ServletRegistrationBean(speechletServlet, "/skill");
    }

    @Bean
    @Autowired
    public IntentHandler moveNorthIntentHandler(final PlayerService playerService,
                                                final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "NorthIntent", Direction.NORTH);
    }

    @Bean
    @Autowired
    public IntentHandler moveNorthEastIntentHandler(final PlayerService playerService,
                                                    final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "NorthEastIntent", Direction.NORTHEAST);
    }

    @Bean
    @Autowired
    public IntentHandler moveNorthWestIntentHandler(final PlayerService playerService,
                                                    final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "NorthWestIntent", Direction.NORTHWEST);
    }

    @Bean
    @Autowired
    public IntentHandler moveEastIntentHandler(final PlayerService playerService,
                                               final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "EastIntent", Direction.EAST);
    }

    @Bean
    @Autowired
    public IntentHandler moveWestIntentHandler(final PlayerService playerService,
                                               final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "WestIntent", Direction.WEST);
    }

    @Bean
    @Autowired
    public IntentHandler moveSouthIntentHandler(final PlayerService playerService,
                                                final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "SouthIntent", Direction.SOUTH);
    }

    @Bean
    @Autowired
    public IntentHandler moveSouthEastIntentHandler(final PlayerService playerService,
                                                    final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "SouthEastIntent", Direction.SOUTHEAST);
    }

    @Bean
    @Autowired
    public IntentHandler moveSouthWestIntentHandler(final PlayerService playerService,
                                                    final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "SouthWestIntent", Direction.SOUTHWEST);
    }

    @Bean
    @Autowired
    public IntentHandler moveUpIntentHandler(final PlayerService playerService,
                                             final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "UpIntent", Direction.UP);
    }

    @Bean
    @Autowired
    public IntentHandler moveDownIntentHandler(final PlayerService playerService,
                                               final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "DownIntent", Direction.DOWN);
    }

    @Bean
    @Autowired
    public IntentHandler moveInIntentHandler(final PlayerService playerService,
                                             final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "InIntent", Direction.IN);
    }

    @Bean
    @Autowired
    public IntentHandler moveOutIntentHandler(final PlayerService playerService,
                                              final LocationService locationService) {
        return new DirectionMoveIntentHandler(playerService, locationService, "OutIntent", Direction.OUT);
    }
}
