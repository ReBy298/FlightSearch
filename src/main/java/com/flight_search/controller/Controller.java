package com.flight_search.controller;


import com.flight_search.model.Flight;
import com.flight_search.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class Controller {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String departure,
                                      @RequestParam String arrival,
                                      @RequestParam String date) {
        return flightService.searchFlights(departure, arrival, date);
    }
}
