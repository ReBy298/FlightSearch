package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrivalTest {

    @Test
    public void testGettersAndSetters() {
        Arrival arrival = new Arrival();
        arrival.setIataCode("JFK");
        arrival.setTerminal("4");
        arrival.setAt("2024-09-04T15:00:00");

        assertEquals("JFK", arrival.getIataCode());
        assertEquals("4", arrival.getTerminal());
        assertEquals("2024-09-04T15:00:00", arrival.getAt());
    }
}
