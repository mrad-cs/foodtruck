package com.mschallenge.foodtruck.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mschallenge.foodtruck.model.MobileFoodTruckPermit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.List;

class PermitsWebClientTest {

    public static MockWebServer mockBackEnd;

    private PermitsWebClient permitsWebClient;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://localhost:%s",
                mockBackEnd.getPort());
        WebClient webClient = WebClient.create(baseUrl);
        permitsWebClient = new PermitsWebClient(webClient);
    }

    @Test
    void retrievePermitsTest() throws Exception {
        MobileFoodTruckPermit permit = new MobileFoodTruckPermit();
        permit.setApplicant("test1");
        permit.setAddress("test2");
        permit.setLatitude("12.12");
        permit.setLongitude("13.13");
        List<MobileFoodTruckPermit> mockData = List.of(permit);
        ObjectMapper objectMapper = new ObjectMapper();

        mockBackEnd.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(mockData))
                .addHeader("Content-Type", "application/json"));

        Mono<List<MobileFoodTruckPermit>> permits = permitsWebClient.retrievePermits();
        StepVerifier.create(permits)
                .expectNextMatches(x -> x.get(0).getApplicant()
                        .equals("test1"))
                .verifyComplete();

    }
}