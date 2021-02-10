package com.gmail.slisenko.dm.getgif.configuration;

import com.gmail.slisenko.dm.getgif.dao.GifDaoTenor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DaoConfig {

    @Bean
    public GifDaoTenor gifDaoTenor(@Value("${random.gif.url}") String url,
                                   @Qualifier("restTemplate") RestTemplate rest) {
        return new GifDaoTenor(url, rest);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
