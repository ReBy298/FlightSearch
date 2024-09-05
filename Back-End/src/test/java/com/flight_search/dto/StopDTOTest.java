package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StopDTOTest {

    private StopDTO stopDTO;

    @BeforeEach
    public void setUp() {
        stopDTO = new StopDTO();
        stopDTO.setAirportName("Chicago O'Hare International Airport");
        stopDTO.setAirportCode("ORD");
        stopDTO.setLayoverTime("2h");
    }

    @Test
    public void testGetAirportName() {
        assertEquals("Chicago O'Hare International Airport", stopDTO.getAirportName());
    }

    @Test
    public void testGetAirportCode() {
        assertEquals("ORD", stopDTO.getAirportCode());
    }

    @Test
    public void testGetLayoverTime() {
        assertEquals("2h", stopDTO.getLayoverTime());
    }
}
