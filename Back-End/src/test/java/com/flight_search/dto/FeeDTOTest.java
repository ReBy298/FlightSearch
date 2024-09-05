package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FeeDTOTest {

    private FeeDTO feeDTO;

    @BeforeEach
    public void setUp() {
        feeDTO = new FeeDTO();
        feeDTO.setAmount("100.00");
        feeDTO.setType("Service Fee");
    }

    @Test
    public void testGetAmount() {
        assertEquals("100.00", feeDTO.getAmount());
    }

    @Test
    public void testGetType() {
        assertEquals("Service Fee", feeDTO.getType());
    }
}
