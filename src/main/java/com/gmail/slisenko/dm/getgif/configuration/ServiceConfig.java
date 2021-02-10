package com.gmail.slisenko.dm.getgif.configuration;

import com.gmail.slisenko.dm.getgif.dao.GifDaoTenor;
import com.gmail.slisenko.dm.getgif.service.GetGifService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean()
    public GetGifService getGifService(@Value("${default.gif.url}") String defaultGif,
                                       @Qualifier("gifDaoTenor") GifDaoTenor dao) {
        return new GetGifService(defaultGif, dao);
    }
}
