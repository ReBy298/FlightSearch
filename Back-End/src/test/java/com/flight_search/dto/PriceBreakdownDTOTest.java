package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PriceBreakdownDTOTest {

    private PriceBreakdownDTO priceBreakdownDTO;

    @BeforeEach
    public void setUp() {
        priceBreakdownDTO = new PriceBreakdownDTO();
        priceBreakdownDTO.setBasePrice("450.00");
        priceBreakdownDTO.setTotalPrice("500.00");
        
        List<FeeDTO> fees = new ArrayList<>();
        FeeDTO fee = new FeeDTO();
        fee.setAmount("50.00");
        fee.setType("Service Fee");
        fees.add(fee);
        priceBreakdownDTO.setFees(fees);
        
        priceBreakdownDTO.setPricePerTraveler("250.00");
    }

    @Test
    public void testGetBasePrice() {
        assertEquals("450.00", priceBreakdownDTO.getBasePrice());
    }

    @Test
    public void testGetTotalPrice() {
        assertEquals("500.00", priceBreakdownDTO.getTotalPrice());
    }

    @Test
    public void testGetFees() {
        assertNotNull(priceBreakdownDTO.getFees());
        assertEquals(1, priceBreakdownDTO.getFees().size());
        assertEquals("50.00", priceBreakdownDTO.getFees().get(0).getAmount());
        assertEquals("Service Fee", priceBreakdownDTO.getFees().get(0).getType());
    }

    @Test
    public void testGetPricePerTraveler() {
        assertEquals("250.00", priceBreakdownDTO.getPricePerTraveler());
    }
}
