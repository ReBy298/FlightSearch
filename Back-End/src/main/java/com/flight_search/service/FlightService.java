package com.flight_search.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flight_search.dto.FlightDTO;
import com.flight_search.dto.SegmentDTO;
import com.flight_search.mapper.FlightMapper;
import com.flight_search.mapper.SegmentMapper;
import com.flight_search.model.Flight;
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
public class FlightService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${amadeus.api.key}")
    private String apiKey;

    @Value("${amadeus.api.secret}")
    private String apiSecret;

    public FlightService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
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
            System.out.println("Access Token: " + accessToken);
            return accessToken;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("Error obtaining access token: " + e.getStatusCode() + " " + e.getResponseBodyAsString());
            throw e;
        } catch (ResourceAccessException e) {
            System.err.println("Connection error: " + e.getMessage());
            throw new RuntimeException("Failed to connect to Amadeus API", e);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to obtain access token", e);
        }
    }


    public List<FlightDTO> searchFlights(String origin, String destination, String departureDate, int adults, int max) {
        String url = "https://test.api.amadeus.com/v2/shopping/flight-offers?originLocationCode=" + origin + 
                     "&destinationLocationCode=" + destination + "&departureDate=" + departureDate +
                     "&adults=" + adults + "&max=" + max;
        HttpHeaders headers = new HttpHeaders();
        String accessToken = getAccessToken();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return parseFlights(response.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("Error searching flights: " + e.getStatusCode() + " " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to search flights", e);
        }
    }


    private List<FlightDTO> parseFlights(String jsonResponse) {
        List<FlightDTO> flightDTOs = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode data = root.path("data");

            for (JsonNode flightNode : data) {
                Flight flight = new Flight();
                flight.setPrice(flightNode.path("price").path("grandTotal").asDouble());
                flight.setAirline(flightNode.path("validatingAirlineCodes").get(0).asText());

                List<Flight.Segment> segments = new ArrayList<>();
                for (JsonNode itinerary : flightNode.path("itineraries")) {
                    for (JsonNode segmentNode : itinerary.path("segments")) {
                        Flight.Segment segment = new Flight.Segment();
                        segment.setDepartureAirport(segmentNode.path("departure").path("iataCode").asText());
                        segment.setArrivalAirport(segmentNode.path("arrival").path("iataCode").asText());
                        segment.setDepartureDate(segmentNode.path("departure").path("at").asText());
                        segment.setArrivalDate(segmentNode.path("arrival").path("at").asText());
                        segment.setCarrierCode(segmentNode.path("carrierCode").asText());
                        segment.setFlightNumber(segmentNode.path("number").asText());
                        segment.setAircraft(segmentNode.path("aircraft").path("code").asText());
                        segment.setCabin(segmentNode.path("cabin").asText());
                        segment.setFareBasis(segmentNode.path("fareBasis").asText());
                        segment.setFlightClass(segmentNode.path("class").asText());
                        segment.setStops(segmentNode.path("numberOfStops").asInt());
                        segments.add(segment);
                    }
                }
                flight.setSegments(segments);
                FlightDTO flightDTO = FlightMapper.INSTANCE.flightToFlightDTO(flight);
                flightDTOs.add(flightDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightDTOs;
    }
    
    public String getAirlineDetails(String airlineCode) {
        String url = "https://test.api.amadeus.com/v1/reference-data/airlines?airlineCodes=" + airlineCode;
        HttpHeaders headers = new HttpHeaders();
        String accessToken = getAccessToken();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("Error fetching airline details: " + e.getStatusCode() + " " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to fetch airline details", e);
        }
    }
}

