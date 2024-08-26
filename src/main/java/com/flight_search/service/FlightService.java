package com.flight_search.service;

import com.flight_search.config.AmadeusConfig;
import com.flight_search.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {

    private final RestTemplate restTemplate;

    @Value("${amadeus.api.key}")
    private String apiKey;

    @Value("${amadeus.api.secret}")
    private String apiSecret;

    public FlightService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private String getAccessToken() {
        String url = "https://test.api.amadeus.com/v1/security/oauth2/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        Map<String, String> body = new HashMap<>();
        body.put("grant_type", "client_credentials");
        body.put("client_id", apiKey);
        body.put("client_secret", apiSecret);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        return (String) response.getBody().get("access_token");
    }

    public String searchFlights(String origin, String destination, String departureDate, int adults, boolean nonStop, int max) {
        String url = "https://test.api.amadeus.com/v2/shopping/flight-offers?originLocationCode=" + origin +
                     "&destinationLocationCode=" + destination + "&departureDate=2025-05-02"+
                     "&adults=" + adults + "&nonStop=" + nonStop + "&max=" + max;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + getAccessToken());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}