/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.servlet.SpeechletServlet;
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
}
