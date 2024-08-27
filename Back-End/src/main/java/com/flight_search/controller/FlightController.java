package com.flight_search.controller;

import com.flight_search.dto.FlightDTO;
import com.flight_search.service.FlightService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<FlightDTO> searchFlights(@RequestParam("origin") String origin,
                                         @RequestParam("destination") String destination,
                                         @RequestParam("departureDate") String departureDate,
                                         @RequestParam("adults") int adults,
                                         @RequestParam("max") int max) {
        return flightService.searchFlights(origin, destination, departureDate, adults, max);
    }
}
