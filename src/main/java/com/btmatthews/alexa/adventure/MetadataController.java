package com.btmatthews.alexa.adventure;

import com.btmatthews.alexa.adventure.domain.IntentDescriptor;
import com.btmatthews.alexa.adventure.domain.UtteranceDescriptor;
import com.btmatthews.alexa.adventure.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class MetadataController {

    private final GameService gameService;

    @Autowired
    public MetadataController(final GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/metadata/{game}/IntentSchema.json", produces = "application/json")
    @ResponseBody
    public Map<String, List<IntentDescriptor>> intentSchemaJson(@PathVariable("game") final String game) throws IOException {
        final List<IntentDescriptor> intents = gameService.getIntents(game);
        return Collections.singletonMap("intents", intents);
    }

    @RequestMapping(value = "/metadata/{game}/SampleUtterances.txt", produces = "text/plain")
    public void sampleUtterancesTxt(@PathVariable("game") final String game, final HttpServletResponse response) throws IOException {
        final List<UtteranceDescriptor> utterances = gameService.getSampleUtterances(game);
        try (final PrintWriter writer = response.getWriter()) {
            utterances.forEach(utterance -> {
                writer.print(utterance.getIntent());
                writer.print(' ');
                writer.println(utterance.getUtterance());
            });
        }
    }
}
