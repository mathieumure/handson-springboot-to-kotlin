package org.zenika.api.configuration;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zenika.api.client.ArenaApi;

@Configuration
public class ApiClientConfiguration {

    @Bean
    public ArenaApi arenaApi() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(ArenaApi.class, "http://localhost:9000");
    }
}
