package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTest {

    private Location location;

    @BeforeEach
    public void setUp() {
        location = new Location();
        location.setCityCode("NYC");
        location.setCountryCode("US");
    }

    @Test
    public void testGetCityCode() {
        assertEquals("NYC", location.getCityCode());
    }

    @Test
    public void testGetCountryCode() {
        assertEquals("US", location.getCountryCode());
    }
}
