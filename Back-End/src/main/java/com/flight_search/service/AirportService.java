package com.flight_search.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;





@Service
public class AirportService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${amadeus.api.key}")
    private String apiKey;

    @Value("${amadeus.api.secret}")
    private String apiSecret;

    public AirportService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    private String getAccessToken() {
        String url = "https://test.api.amadeus.com/v1/security/oauth2/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("client_id", apiKey);
        body.add("client_secret", apiSecret);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
        try {
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
            String accessToken = (String) response.getBody().get("access_token");
            return accessToken;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new RuntimeException("Error obtaining access token: " + e.getStatusCode() + " " + e.getResponseBodyAsString(), e);
        } catch (ResourceAccessException e) {
            throw new RuntimeException("Connection error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage(), e);
        }
    }

    public List<String> getIataCodes(String airportName) {
        String url = "https://test.api.amadeus.com/v1/reference-data/locations?subType=AIRPORT&keyword=" + airportName + "&page[limit]=10";
        HttpHeaders headers = new HttpHeaders();
        String accessToken = getAccessToken();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return parseIataCodes(response.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new RuntimeException("Error fetching IATA codes: " + e.getStatusCode() + " " + e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage(), e);
        }
    }

    private List<String> parseIataCodes(String jsonResponse) {
        List<String> iataCodes = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode data = root.path("data");

            for (JsonNode locationNode : data) {
                String iataCode = locationNode.path("iataCode").asText();
                iataCodes.add(iataCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iataCodes;
    }
}
