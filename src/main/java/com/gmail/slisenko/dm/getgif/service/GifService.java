package com.gmail.slisenko.dm.getgif.service;

import com.gmail.slisenko.dm.getgif.buffer.GifBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

import java.util.Optional;

public class GifService {
    private static final Logger LOG = LoggerFactory.getLogger(GifService.class);
    private final String defaultGif;
    private final GifBuffer buffer;

    public GifService(@NonNull String defaultGif,
                      @NonNull GifBuffer buffer) {
        this.defaultGif = defaultGif;
        this.buffer = buffer;
    }

    public String getDefaultGif() {
        LOG.info("Get default GIF");
        return defaultGif;
    }

    public String getRandomGif() {
        LOG.info("Get random GIF");
        Optional<String> gif = buffer.getGif();
        return gif.orElseGet(this::getDefaultGif);
    }

}
