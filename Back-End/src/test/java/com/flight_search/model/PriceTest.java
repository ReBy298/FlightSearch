package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PriceTest {

    private Price price;

    @BeforeEach
    public void setUp() {
        price = new Price();
        price.setCurrency("USD");
        price.setTotal("500.00");
        price.setBase("450.00");
        List<Fee> fees = new ArrayList<>();
        fees.add(new Fee());
        price.setFees(fees);
        price.setGrandTotal("500.00");
    }

    @Test
    public void testGetCurrency() {
        assertEquals("USD", price.getCurrency());
    }

    @Test
    public void testGetTotal() {
        assertEquals("500.00", price.getTotal());
    }

    @Test
    public void testGetBase() {
        assertEquals("450.00", price.getBase());
    }

    @Test
    public void testGetFees() {
        assertNotNull(price.getFees());
        assertEquals(1, price.getFees().size());
    }

    @Test
    public void testGetGrandTotal() {
        assertEquals("500.00", price.getGrandTotal());
    }
}
