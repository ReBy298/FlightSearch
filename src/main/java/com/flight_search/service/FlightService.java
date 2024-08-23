package com.flight_search.service;

import com.flight_search.config.AmadeusConfig;
import com.flight_search.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private AmadeusConfig amadeusConfig;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Flight> searchFlights(String departure, String arrival, String date) {
        // Usa amadeusConfig.getKey() y amadeusConfig.getSecret() para acceder a las propiedades
        String apiKey = amadeusConfig.getKey();
        String apiSecret = amadeusConfig.getSecret();

        // Implement API call to Amadeus and map response to Flight objects
        // Example endpoint: https://test.api.amadeus.com/v2/shopping/flight-offers
        return List.of(); // Replace with actual implementation
    }
}
