package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmenityDTOTest {

    private AmenityDTO amenityDTO;

    @BeforeEach
    public void setUp() {
        amenityDTO = new AmenityDTO();
        amenityDTO.setName("WiFi");
        amenityDTO.setChargeable(true);
    }

    @Test
    public void testGetName() {
        assertEquals("WiFi", amenityDTO.getName());
    }

    @Test
    public void testIsChargeable() {
        assertEquals(true, amenityDTO.isChargeable());
    }
}
