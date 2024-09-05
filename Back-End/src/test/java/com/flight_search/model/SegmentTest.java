package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SegmentTest {

    private Segment segment;

    @BeforeEach
    public void setUp() {
        segment = new Segment();
        segment.setDeparture(new Departure());
        segment.setArrival(new Arrival());
        segment.setCarrierCode("AA");
        segment.setNumber("100");
        segment.setAircraft(new Aircraft());
        segment.setOperating(new Operating());
        segment.setDuration("6h");
        segment.setId("SEG1");
        segment.setNumberOfStops(0);
        segment.setBlacklistedInEU(false);
    }

    @Test
    public void testGetDeparture() {
        assertNotNull(segment.getDeparture());
    }

    @Test
    public void testGetArrival() {
        assertNotNull(segment.getArrival());
    }

    @Test
    public void testGetCarrierCode() {
        assertEquals("AA", segment.getCarrierCode());
    }

    @Test
    public void testGetNumber() {
        assertEquals("100", segment.getNumber());
    }

    @Test
    public void testGetAircraft() {
        assertNotNull(segment.getAircraft());
    }

    @Test
    public void testGetOperating() {
        assertNotNull(segment.getOperating());
    }

    @Test
    public void testGetDuration() {
        assertEquals("6h", segment.getDuration());
    }

    @Test
    public void testGetId() {
        assertEquals("SEG1", segment.getId());
    }

    @Test
    public void testGetNumberOfStops() {
        assertEquals(0, segment.getNumberOfStops());
    }

    @Test
    public void testIsBlacklistedInEU() {
        assertEquals(false, segment.isBlacklistedInEU());
    }
}
