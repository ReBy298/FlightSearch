package com.flight_search.controller;

import com.flight_search.dto.FlightDTO;
import com.flight_search.dto.IataCodeDTO;
import com.flight_search.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<FlightDTO> searchFlights(@RequestParam("origin") String departure,
                                         @RequestParam("destination") String arrival,
                                         @RequestParam("departureDate") String departureDate,
                                         @RequestParam("returnDate") String returnDate,
                                         @RequestParam("adults") int adults,
                                         @RequestParam("nonStop") boolean nonStop,
                                         @RequestParam("max") int max,
                                         @RequestParam("currency") String currency,
                                         @RequestParam(value = "orderPrice", required = false) String orderPrice,
                                         @RequestParam(value = "orderDuration", required = false) String orderDuration) {
        return flightService.getFlights(departure,arrival, departureDate, returnDate, adults, max, currency, nonStop, orderPrice, orderDuration);
    }



    @GetMapping("/iata-codes")
    public List<IataCodeDTO> searchIataCodes(@RequestParam("keyword") String keyword) {
        return flightService.getIataCodes(keyword);
    }
    
    
    

}
