package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DepartureTest {

    @Test
    public void testGettersAndSetters() {
        Departure departure = new Departure();
        departure.setIataCode("LAX");
        departure.setTerminal("5");
        departure.setAt("2024-09-04T10:00:00");

        assertEquals("LAX", departure.getIataCode());
        assertEquals("5", departure.getTerminal());
        assertEquals("2024-09-04T10:00:00", departure.getAt());
    }
}
