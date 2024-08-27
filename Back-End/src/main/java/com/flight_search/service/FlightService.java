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
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        return (String) response.getBody().get("access_token");
    }

    public List<FlightDTO> searchFlights(String origin, String destination, String departureDate, int adults, int max) {
        String url = "https://test.api.amadeus.com/v2/shopping/flight-offers?originLocationCode=" + origin + 
                     "&destinationLocationCode=" + destination + "&departureDate=" + departureDate +
                     "&adults=" + adults + "&max=" + max;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + getAccessToken());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return parseFlights(response.getBody());
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
}

