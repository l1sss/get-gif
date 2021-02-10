package com.gmail.slisenko.dm.getgif.dao;

import com.gmail.slisenko.dm.getgif.domain.Gif;
import com.gmail.slisenko.dm.getgif.domain.GifResponse;
import com.gmail.slisenko.dm.getgif.domain.Medium;
import com.gmail.slisenko.dm.getgif.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class GifDaoTenor implements GifDao {
    private static final Logger LOG = LoggerFactory.getLogger(GifDaoTenor.class);

    private final String randomGifUrl;
    private final RestTemplate rest;

    public GifDaoTenor(String randomGifUrl, RestTemplate rest) {
        this.randomGifUrl = randomGifUrl;
        this.rest = rest;
    }

    @Override
    public String getRandomGifUrl() throws IOException {
        ResponseEntity<GifResponse> response = rest.getForEntity(randomGifUrl, GifResponse.class);
        HttpStatus status = response.getStatusCode();
        if (HttpStatus.OK.equals(status)) {
            return parse(response);
        }
        throw new IOException("Bad response from Tenor, HTTP Status: " + status);
    }

    private String parse(ResponseEntity<GifResponse> response) {
        LOG.debug("Parse response...");
        GifResponse gifResponse = response.getBody();
        List<Result> results = gifResponse.getResults();
        Result result = results.get(0);
        List<Medium> media = result.getMedia();
        Medium medium = media.get(0);
        Gif gif = medium.getGif();
        String url = gif.getUrl();
        LOG.debug("GIF url: " + url);
        return url;
    }
}
