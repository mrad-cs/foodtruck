package com.mschallenge.foodtruck.client;

import com.mschallenge.foodtruck.model.MobileFoodTruckPermit;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PermitsWebClient {
    private final WebClient webClient;

    public PermitsWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<List<MobileFoodTruckPermit>> retrievePermits() {
        Mono<List<MobileFoodTruckPermit>> response = webClient.get()
                .uri("/resource/rqzj-sfat.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                //TODO exchangeToMono Exception Handling
                .onStatus(HttpStatus::is4xxClientError, res -> res.createException().flatMap(Mono::error))
                .onStatus(HttpStatus::is5xxServerError, res -> res.createException().flatMap(Mono::error))
                .bodyToMono(new ParameterizedTypeReference<List<MobileFoodTruckPermit>>() {
                });
        return response;
    }
}
