package com.gmail.slisenko.dm.getgif.dao;

import com.gmail.slisenko.dm.getgif.domain.Gif;
import com.gmail.slisenko.dm.getgif.domain.GifResponse;
import com.gmail.slisenko.dm.getgif.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GifDaoTenor implements GifDao {
    private static final Logger LOG = LoggerFactory.getLogger(GifDaoTenor.class);
    private final String randomGifUrl;
    private final RestTemplate rest;
    private Optional<String> pos = Optional.empty();

    public GifDaoTenor(String randomGifUrl, RestTemplate rest) {
        this.randomGifUrl = randomGifUrl;
        this.rest = rest;
    }

    @Override
    public List<String> getGifs() throws IOException {
        ResponseEntity<GifResponse> response = sendRequest();
        checkStatus(response);
        return parse(response);
    }

    private ResponseEntity<GifResponse> sendRequest() {
        ResponseEntity<GifResponse> response;
        if (pos.isPresent()) {
            response = sendRequestWithPosition();
        } else {
            response = sendRequestWithoutPosition();
        }
        return response;
    }

    private ResponseEntity<GifResponse> sendRequestWithPosition() {
        //noinspection OptionalGetWithoutIsPresent
        return rest.getForEntity(randomGifUrl+pos.get(), GifResponse.class);
    }

    private ResponseEntity<GifResponse> sendRequestWithoutPosition() {
        return rest.getForEntity(randomGifUrl, GifResponse.class);
    }

    private void checkStatus(ResponseEntity<GifResponse> response) throws IOException {
        if (response == null) {
            throw new IOException("Null response from Tenor");
        }
        HttpStatus status = response.getStatusCode();
        if (!HttpStatus.OK.equals(status)) {
            throw new IOException("Bad response from Tenor, HTTP Status: " + status);
        }
    }

    private List<String> parse(ResponseEntity<GifResponse> response) {
        List<String> gifs = new ArrayList<>();
        LOG.debug("Parse response...");
        GifResponse gifResponse = response.getBody();
        Optional<List<Result>> results = Optional.ofNullable(gifResponse.getResults());
        results.ifPresent(resultList -> resultList.forEach(result -> result.getMedia().forEach(content -> {
            Gif gif = content.getGif();
            gifs.add(gif.getUrl());
        })));
        pos = Optional.ofNullable(gifResponse.getNext());
        return gifs;
    }

}
