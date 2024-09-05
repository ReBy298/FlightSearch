package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AirlineDTOTest {

    private AirlineDTO airlineDTO;

    @BeforeEach
    public void setUp() {
        airlineDTO = new AirlineDTO();
        airlineDTO.setIataCode("AA");
        airlineDTO.setBussinessName("American Airlines");
    }

    @Test
    public void testGetIataCode() {
        assertEquals("AA", airlineDTO.getIataCode());
    }

    @Test
    public void testGetBussinessName() {
        assertEquals("American Airlines", airlineDTO.getBussinessName());
    }
}
