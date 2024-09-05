package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItineraryTest {

    private Itinerary itinerary;

    @BeforeEach
    public void setUp() {
        itinerary = new Itinerary();
        itinerary.setDuration("5h 30m");
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment());
        segments.add(new Segment());
        itinerary.setSegments(segments);
    }

    @Test
    public void testGetDuration() {
        assertEquals("5h 30m", itinerary.getDuration());
    }

    @Test
    public void testGetSegments() {
        assertNotNull(itinerary.getSegments());
        assertEquals(2, itinerary.getSegments().size());
    }
}
