
package com.flight_search.controller;

import com.flight_search.dto.FlightDTO;
import com.flight_search.service.AirportService;
import com.flight_search.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;
    private AirportService airportService;

    
    @GetMapping("/iata-codes")
    public List<String> getIataCodes(@RequestParam("airportName") String airportName) {
        return airportService.getIataCodes(airportName);
    }

    @GetMapping("/search")
    public List<FlightDTO> searchFlights(@RequestParam("origin") String origin,
                                         @RequestParam("destination") String destination,
                                         @RequestParam("departureDate") String departureDate,
                                         @RequestParam("adults") int adults,
                                         @RequestParam("max") int max) {
        return flightService.searchFlights(origin, destination, departureDate, adults, max);
    }
    @GetMapping("/details")
    
    public String getAirlineDetails(@RequestParam("airlineCode") String airlineCode) {
        return flightService.getAirlineDetails(airlineCode);
    }
}
