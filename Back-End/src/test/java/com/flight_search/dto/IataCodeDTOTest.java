package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IataCodeDTOTest {

    private IataCodeDTO iataCodeDTO;

    @BeforeEach
    public void setUp() {
        iataCodeDTO = new IataCodeDTO();
        iataCodeDTO.setName("John F. Kennedy International Airport");
        iataCodeDTO.setIataCode("JFK");
    }

    @Test
    public void testGetName() {
        assertEquals("John F. Kennedy International Airport", iataCodeDTO.getName());
    }

    @Test
    public void testGetIataCode() {
        assertEquals("JFK", iataCodeDTO.getIataCode());
    }
}
