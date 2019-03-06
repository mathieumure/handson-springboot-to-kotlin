package org.zenika.api.configuration;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zenika.api.client.ArenaApi;

@Configuration
class ApiClientConfiguration {
    @Bean
    fun arenaApi(): ArenaApi = Feign.builder()
                .encoder(JacksonEncoder())
                .decoder(JacksonDecoder())
                .target(ArenaApi::class.java, "http://localhost:9000")
}
