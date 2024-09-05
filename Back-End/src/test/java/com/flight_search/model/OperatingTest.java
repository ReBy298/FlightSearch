package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperatingTest {

    private Operating operating;

    @BeforeEach
    public void setUp() {
        operating = new Operating();
        operating.setCarrierCode("AA");
    }

    @Test
    public void testGetCarrierCode() {
        assertEquals("AA", operating.getCarrierCode());
    }
}
