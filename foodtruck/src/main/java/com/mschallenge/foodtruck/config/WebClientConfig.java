package com.mschallenge.foodtruck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private WebClient webClient;

    @Bean
    public WebClient webClient() {
        if (webClient == null) {
            webClient = WebClient.builder()
                    .baseUrl("https://data.sfgov.org")
                    .exchangeStrategies(ExchangeStrategies.builder()
                            .codecs(configurer -> configurer
                                    .defaultCodecs()
                                    .maxInMemorySize(16 * 1024 * 1024))
                            .build())
                    .build();
        }
        return webClient;
    }
};
