package com.gmail.slisenko.dm.getgif.service;

import com.gmail.slisenko.dm.getgif.dao.GifDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

public class GetGifService {
    private static final Logger LOG = LoggerFactory.getLogger(GetGifService.class);

    private final String defaultGif;
    private final GifDao dao;

    public GetGifService(@NonNull String defaultGif,
                         @NonNull GifDao dao) {
        this.defaultGif = defaultGif;
        this.dao = dao;
    }

    public String getDefaultGif() {
        LOG.info("Get default GIF");
        return defaultGif;
    }

    public String getRandomGif() {
        LOG.info("Try get random GIF from Tenor...");
        try {
            return dao.getRandomGifUrl();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return getDefaultGif();
        }
    }
}
