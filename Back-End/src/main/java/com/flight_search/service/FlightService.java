package com.flight_search.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flight_search.dto.FlightDTO;
import com.flight_search.dto.IataCodeDTO;
import com.flight_search.dto.SegmentDTO;
import com.flight_search.mock.MockFlight;
import com.flight_search.model.FareDetailsBySegment;
import com.flight_search.model.FlightOffer;
import com.flight_search.model.Segment;
import com.flight_search.model.TravelerPricing;

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
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final MockFlight mockFlight;


    @Value("${amadeus.api.key}")
    private String apiKey;

    @Value("${amadeus.api.secret}")
    private String apiSecret;
    
    private String flightSearch = "https://test.api.amadeus.com/v2/shopping/flight-offers?";
    

    public FlightService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper, MockFlight mockFlight) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
        this.mockFlight = mockFlight;
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
    
    
    /*

    public List<FlightDTO> getFlights(String origin, String destination, String departureDate, int adults, int max, String token) {
        try {
            String URL = "shopping/flight-offers?" +
                    "originLocationCode=" + origin +
                    "&destinationLocationCode=" + destination +
                    "&departureDate=" + departureDate +
                    "&adults=" + adults +
                    "&nonStop=false" +
                    "&currencyCode=USD" +
                    "&max=" + max;

            URI URIRequest = new URI(flightSearch + URL);

            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(URIRequest)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return convertToDTO(parseFlights(response.body()));
            }

            throw new RuntimeException("Failed to fetch flight offers: " + response.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
    
    
    /*
     
     public List<FlightDTO> getFlights(String origin, String destination, String departureDate, int adults, boolean nonStop, int max, boolean nonStop, String currency) {
        try {
            String URL = "shopping/flight-offers?" +
                    "originLocationCode=" + origin +
                    "&destinationLocationCode=" + destination +
                    "&departureDate=" + departureDate +
                    "&adults=" + adults +
                    "&nonStop=false" +
                    "&currencyCode=USD" +
                    "&max=" + max;

        URI URIRequest = new URI(flightSearch + URL);
        HttpHeaders headers = new HttpHeaders();
        String accessToken = getAccessToken();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(URIRequest, HttpMethod.GET, entity, String.class);
            List<FlightOffer> flightOffers = parseFlights(response.getBody());
            List<FlightDTO> flightDTOs = convertToDTO(flightOffers, currency);

        	// sortFlights(flightDTOs, sortBy);

        	return flightDTOs;
            
            return parseFlights();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("Error searching flights: " + e.getStatusCode() + " " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to search flights", e);
        }
    }
    */
    
    
    
    public List<FlightDTO> getFlights(String origin, String destination, String departureDate, String returnDate, int adults, int max, String currency, boolean nonStop) {
        if (isDateInPast(departureDate) || (returnDate != null && isDateInPast(returnDate)) || (returnDate != null && isReturnDateBeforeDepartureDate(departureDate, returnDate))) {
            throw new IllegalArgumentException("Invalid dates");
        }

        String jsonResponse = mockFlight.getMockFlightOffers();
        List<FlightOffer> flightOffers = parseFlights(jsonResponse);

 
        List<FlightDTO> flightDTOs = convertToDTO(flightOffers, currency);

        // sortFlights(flightDTOs, sortBy);

        return flightDTOs;
    }

    private boolean isDateInPast(String date) {
    
    	return false;
    }

    private boolean isReturnDateBeforeDepartureDate(String departureDate, String returnDate) {
       
    	return false;
    }

    private List<FlightOffer> parseFlights(String jsonResponse) {
        List<FlightOffer> flightOffers = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode data = root.path("data");

            for (JsonNode flightNode : data) {
                FlightOffer flightOffer = objectMapper.treeToValue(flightNode, FlightOffer.class);
                flightOffers.add(flightOffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightOffers;
    }

    private List<FlightDTO> convertToDTO(List<FlightOffer> flightOffers, String currency) {
        List<FlightDTO> flightDTOs = new ArrayList<>();
        for (FlightOffer flightOffer : flightOffers) {
            FlightDTO flightDTO = new FlightDTO();
            
           
            double totalPrice = Double.parseDouble(flightOffer.getPrice().getGrandTotal());
            flightDTO.setPrice(totalPrice);

  
            int numberOfTravelers = flightOffer.getTravelerPricings().size();
            flightDTO.setPricePerTraveler(flightDTO.getPrice() / numberOfTravelers);

            String departureAirportCode = flightOffer.getItineraries().get(0).getSegments().get(0).getDeparture().getIataCode();
            String arrivalAirportCode = flightOffer.getItineraries().get(0).getSegments().get(flightOffer.getItineraries().get(0).getSegments().size() - 1).getArrival().getIataCode();
            flightDTO.setDepartureDate(flightOffer.getItineraries().get(0).getSegments().get(0).getDeparture().getAt());
            flightDTO.setArrivalDate(flightOffer.getItineraries().get(0).getSegments().get(flightOffer.getItineraries().get(0).getSegments().size() - 1).getArrival().getAt());
            flightDTO.setTotalTime(flightOffer.getItineraries().get(0).getDuration());

            List<SegmentDTO> segmentDTOs = new ArrayList<>();
            for (Segment segment : flightOffer.getItineraries().get(0).getSegments()) {
                SegmentDTO segmentDTO = new SegmentDTO();
                segmentDTO.setDepartureDate(segment.getDeparture().getAt());
                segmentDTO.setArrivalDate(segment.getArrival().getAt());
                segmentDTO.setCarrierCode(segment.getCarrierCode());
                segmentDTO.setFlightNumber(segment.getNumber());
                segmentDTO.setAircraft(segment.getAircraft().getCode());
                segmentDTO.setStops(segment.getNumberOfStops());
                segmentDTO.setOperatingCarrierCode(segment.getOperating().getCarrierCode());

                
                segmentDTO.setDepartureAirport(segment.getDeparture().getIataCode());
                segmentDTO.setArrivalAirport(segment.getArrival().getIataCode());

                
                for (TravelerPricing travelerPricing : flightOffer.getTravelerPricings()) {
                    for (FareDetailsBySegment fareDetails : travelerPricing.getFareDetailsBySegment()) {
                        if (fareDetails.getSegmentId().equals(segment.getId())) {
                            segmentDTO.setCabin(fareDetails.getCabin());
                            segmentDTO.setFareBasis(fareDetails.getFareBasis());
                            segmentDTO.setFlightClass(fareDetails.getFlightClass());
                        }
                    }
                }

                segmentDTOs.add(segmentDTO);
            }
            flightDTO.setSegments(segmentDTOs);

            
            flightDTO.setAirline(segmentDTOs.get(0).getCarrierCode());
            if (!segmentDTOs.get(0).getCarrierCode().equals(segmentDTOs.get(0).getOperatingCarrierCode())) {
                flightDTO.setOperatingAirline(segmentDTOs.get(0).getOperatingCarrierCode());
            }

            flightDTO.setDepartureAirport(departureAirportCode);
            flightDTO.setArrivalAirport(arrivalAirportCode);

            flightDTOs.add(flightDTO);
        }
        return flightDTOs;
    }

    

    private String calculateLayoverTime(String arrivalDate, String departureDate) {
 
        return "layover time";
    }

    public List<FlightDTO> sortFlights(List<FlightDTO> flightDTOs, String sortBy) {
        if ("price".equalsIgnoreCase(sortBy)) {
            flightDTOs.sort(Comparator.comparingDouble(FlightDTO::getPrice));
        } else if ("duration".equalsIgnoreCase(sortBy)) {
            flightDTOs.sort(Comparator.comparing(FlightDTO::getTotalTime));
        }
        return flightDTOs;
    }
    
    public List<IataCodeDTO> getIataCodes(String keyword) {
        String jsonResponse = mockFlight.getMockAirport();
        List<IataCodeDTO> iataCodes = parseIataCodes(jsonResponse, keyword);
        return iataCodes;
    }

    private List<IataCodeDTO> parseIataCodes(String jsonResponse, String keyword) {
        List<IataCodeDTO> iataCodes = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode data = root.path("data");

            for (JsonNode node : data) {
                String name = node.path("name").asText();
                String iataCode = node.path("iataCode").asText();
                if (name.toLowerCase().contains(keyword.toLowerCase()) || iataCode.toLowerCase().contains(keyword.toLowerCase())) {
                    IataCodeDTO iataCodeDTO = new IataCodeDTO();
                    iataCodeDTO.setName(name);
                    iataCodeDTO.setIataCode(iataCode);
                    iataCodes.add(iataCodeDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iataCodes;
    }



}

