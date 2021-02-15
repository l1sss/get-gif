package com.gmail.slisenko.dm.getgif.configuration;

import com.gmail.slisenko.dm.getgif.buffer.GifBuffer;
import com.gmail.slisenko.dm.getgif.service.GifService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public GifService gifService(@Value("${default.gif.path}") String defaultGif,
                                    @Qualifier("gifBuffer") GifBuffer buffer) {
        return new GifService(defaultGif, buffer);
    }

}
