package com.flight_search.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AircraftTest {

    @Test
    public void testGettersAndSetters() {
        Aircraft aircraft = new Aircraft();
        aircraft.setCode("A320");

        assertEquals("A320", aircraft.getCode());
    }
}