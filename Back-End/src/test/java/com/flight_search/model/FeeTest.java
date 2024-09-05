package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FeeTest {

    private Fee fee;

    @BeforeEach
    public void setUp() {
        fee = new Fee();
        fee.setAmount("100");
        fee.setType("Service");
    }

    @Test
    public void testGetAmount() {
        assertEquals("100", fee.getAmount());
    }

    @Test
    public void testGetType() {
        assertEquals("Service", fee.getType());
    }
}
