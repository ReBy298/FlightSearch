package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AirportDTOTest {

    private AirportDTO airportDTO;

    @BeforeEach
    public void setUp() {
        airportDTO = new AirportDTO();
        airportDTO.setIataCode("JFK");
        airportDTO.setName("John F. Kennedy International Airport");
    }

    @Test
    public void testGetIataCode() {
        assertEquals("JFK", airportDTO.getIataCode());
    }

    @Test
    public void testGetName() {
        assertEquals("John F. Kennedy International Airport", airportDTO.getName());
    }
}
