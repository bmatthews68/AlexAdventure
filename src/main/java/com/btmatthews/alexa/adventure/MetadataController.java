package com.btmatthews.alexa.adventure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class MetadataController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public MetadataController(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping(value = "/metadata/{game}/IntentSchema.json", produces = "application/json")
    @ResponseBody
    public byte[] intentSchemaJson(@PathVariable("game") final String game) throws IOException {
        final Resource resource = resourceLoader.getResource("classpath:IntentSchema.json");
        try (final InputStream inputStream = resource.getInputStream()) {
            return StreamUtils.copyToByteArray(inputStream);
        }
    }

    @RequestMapping(value = "/metadata/{game}/SampleUtterances.txt", produces = "text/plain")
    @ResponseBody
    public byte[] sampleUtternancesTxt(@PathVariable("game") final String game) throws IOException {
        final Resource resource = resourceLoader.getResource("classpath:SampleUtterances.txt");
        try (final InputStream inputStream = resource.getInputStream()) {
            return StreamUtils.copyToByteArray(inputStream);
        }
    }
}
