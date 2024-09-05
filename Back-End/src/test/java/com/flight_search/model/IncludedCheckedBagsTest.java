package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IncludedCheckedBagsTest {

    private IncludedCheckedBags includedCheckedBags;

    @BeforeEach
    public void setUp() {
        includedCheckedBags = new IncludedCheckedBags();
        includedCheckedBags.setQuantity(2);
    }

    @Test
    public void testGetQuantity() {
        assertEquals(2, includedCheckedBags.getQuantity());
    }
}
