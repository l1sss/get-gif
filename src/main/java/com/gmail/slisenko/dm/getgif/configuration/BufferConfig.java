package com.gmail.slisenko.dm.getgif.configuration;

import com.gmail.slisenko.dm.getgif.buffer.GifBuffer;
import com.gmail.slisenko.dm.getgif.dao.GifDaoTenor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BufferConfig {

    @Bean(initMethod = "fillBuffer")
    public GifBuffer gifBuffer(@Qualifier("gifDaoTenor") GifDaoTenor dao) {
        return new GifBuffer(dao);
    }

}
