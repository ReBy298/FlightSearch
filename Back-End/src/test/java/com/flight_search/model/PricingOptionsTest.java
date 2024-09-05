package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PricingOptionsTest {

    private PricingOptions pricingOptions;

    @BeforeEach
    public void setUp() {
        pricingOptions = new PricingOptions();
        List<String> fareType = new ArrayList<>();
        fareType.add("Economy");
        fareType.add("Business");
        pricingOptions.setFareType(fareType);
        pricingOptions.setIncludedCheckedBagsOnly(true);
    }

    @Test
    public void testGetFareType() {
        assertEquals(2, pricingOptions.getFareType().size());
        assertEquals("Economy", pricingOptions.getFareType().get(0));
        assertEquals("Business", pricingOptions.getFareType().get(1));
    }

    @Test
    public void testIsIncludedCheckedBagsOnly() {
        assertTrue(pricingOptions.isIncludedCheckedBagsOnly());
    }
}
