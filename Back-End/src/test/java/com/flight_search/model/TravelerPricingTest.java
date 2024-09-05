package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TravelerPricingTest {

    private TravelerPricing travelerPricing;

    @BeforeEach
    public void setUp() {
        travelerPricing = new TravelerPricing();
        travelerPricing.setTravelerId("T123");
        travelerPricing.setFareOption("Economy");
        travelerPricing.setTravelerType("Adult");
        
        Price price = new Price();
        price.setCurrency("USD");
        price.setTotal("500.00");
        travelerPricing.setPrice(price);
        
        List<FareDetailsBySegment> fareDetailsBySegment = new ArrayList<>();
        FareDetailsBySegment fareDetail = new FareDetailsBySegment();
        fareDetail.setSegmentId("S1");
        fareDetailsBySegment.add(fareDetail);
        travelerPricing.setFareDetailsBySegment(fareDetailsBySegment);
    }

    @Test
    public void testGetTravelerId() {
        assertEquals("T123", travelerPricing.getTravelerId());
    }

    @Test
    public void testGetFareOption() {
        assertEquals("Economy", travelerPricing.getFareOption());
    }

    @Test
    public void testGetTravelerType() {
        assertEquals("Adult", travelerPricing.getTravelerType());
    }

    @Test
    public void testGetPrice() {
        assertNotNull(travelerPricing.getPrice());
        assertEquals("USD", travelerPricing.getPrice().getCurrency());
        assertEquals("500.00", travelerPricing.getPrice().getTotal());
    }

    @Test
    public void testGetFareDetailsBySegment() {
        assertNotNull(travelerPricing.getFareDetailsBySegment());
        assertEquals(1, travelerPricing.getFareDetailsBySegment().size());
        assertEquals("S1", travelerPricing.getFareDetailsBySegment().get(0).getSegmentId());
    }
}
