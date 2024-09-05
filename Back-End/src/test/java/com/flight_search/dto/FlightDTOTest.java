package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlightDTOTest {

    private FlightDTO flightDTO;

    @BeforeEach
    public void setUp() {
        flightDTO = new FlightDTO();
        flightDTO.setId("FL123");
        flightDTO.setInitialDepartureDateTime("2024-09-05T10:00:00");
        flightDTO.setFinalArrivalDateTime("2024-09-05T14:00:00");
        flightDTO.setDepartureAirportName("John F. Kennedy International Airport");
        flightDTO.setDepartureAirportCode("JFK");
        flightDTO.setArrivalAirportName("Los Angeles International Airport");
        flightDTO.setArrivalAirportCode("LAX");
        flightDTO.setAirlineName("American Airlines");
        flightDTO.setAirlineCode("AA");
        flightDTO.setOperatingAirlineName("American Airlines");
        flightDTO.setOperatingAirlineCode("AA");
        flightDTO.setTotalFlightTime("4h");
        
        List<StopDTO> stops = new ArrayList<>();
        stops.add(new StopDTO());
        flightDTO.setStops(stops);
        
        flightDTO.setTotalPrice(500.00);
        flightDTO.setPricePerTraveler(250.00);
        
        List<SegmentDTO> segments = new ArrayList<>();
        segments.add(new SegmentDTO());
        flightDTO.setSegments(segments);
        
        PriceBreakdownDTO priceBreakdown = new PriceBreakdownDTO();
        flightDTO.setPriceBreakdown(priceBreakdown);
    }

    @Test
    public void testGetId() {
        assertEquals("FL123", flightDTO.getId());
    }

    @Test
    public void testGetInitialDepartureDateTime() {
        assertEquals("2024-09-05T10:00:00", flightDTO.getInitialDepartureDateTime());
    }

    @Test
    public void testGetFinalArrivalDateTime() {
        assertEquals("2024-09-05T14:00:00", flightDTO.getFinalArrivalDateTime());
    }

    @Test
    public void testGetDepartureAirportName() {
        assertEquals("John F. Kennedy International Airport", flightDTO.getDepartureAirportName());
    }

    @Test
    public void testGetDepartureAirportCode() {
        assertEquals("JFK", flightDTO.getDepartureAirportCode());
    }

    @Test
    public void testGetArrivalAirportName() {
        assertEquals("Los Angeles International Airport", flightDTO.getArrivalAirportName());
    }

    @Test
    public void testGetArrivalAirportCode() {
        assertEquals("LAX", flightDTO.getArrivalAirportCode());
    }

    @Test
    public void testGetAirlineName() {
        assertEquals("American Airlines", flightDTO.getAirlineName());
    }

    @Test
    public void testGetAirlineCode() {
        assertEquals("AA", flightDTO.getAirlineCode());
    }

    @Test
    public void testGetOperatingAirlineName() {
        assertEquals("American Airlines", flightDTO.getOperatingAirlineName());
    }

    @Test
    public void testGetOperatingAirlineCode() {
        assertEquals("AA", flightDTO.getOperatingAirlineCode());
    }

    @Test
    public void testGetTotalFlightTime() {
        assertEquals("4h", flightDTO.getTotalFlightTime());
    }

    @Test
    public void testGetStops() {
        assertNotNull(flightDTO.getStops());
        assertEquals(1, flightDTO.getStops().size());
    }

    @Test
    public void testGetTotalPrice() {
        assertEquals(500.00, flightDTO.getTotalPrice());
    }

    @Test
    public void testGetPricePerTraveler() {
        assertEquals(250.00, flightDTO.getPricePerTraveler());
    }

    @Test
    public void testGetSegments() {
        assertNotNull(flightDTO.getSegments());
        assertEquals(1, flightDTO.getSegments().size());
    }

    @Test
    public void testGetPriceBreakdown() {
        assertNotNull(flightDTO.getPriceBreakdown());
    }
}
