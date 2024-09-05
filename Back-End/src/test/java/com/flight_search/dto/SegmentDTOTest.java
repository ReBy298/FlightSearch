package com.flight_search.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SegmentDTOTest {

    private SegmentDTO segmentDTO;

    @BeforeEach
    public void setUp() {
        segmentDTO = new SegmentDTO();
        segmentDTO.setDepartureTime("2024-09-05T10:00:00");
        segmentDTO.setArrivalTime("2024-09-05T14:00:00");
        segmentDTO.setDepartureAirportName("John F. Kennedy International Airport");
        segmentDTO.setDepartureAirportCode("JFK");
        segmentDTO.setArrivalAirportName("Los Angeles International Airport");
        segmentDTO.setArrivalAirportCode("LAX");
        segmentDTO.setCarrierCode("AA");
        segmentDTO.setCarrierName("American Airlines");
        segmentDTO.setFlightNumber("100");
        segmentDTO.setOperatingCarrierCode("AA");
        segmentDTO.setOperatingCarrierName("American Airlines");
        segmentDTO.setAircraftType("Boeing 737");
        segmentDTO.setCabin("Economy");
        segmentDTO.setFareBasis("Y");
        segmentDTO.setFlightClass("Economy");
        
        List<AmenityDTO> amenities = new ArrayList<>();
        AmenityDTO amenity = new AmenityDTO();
        amenity.setName("WiFi");
        amenity.setChargeable(true);
        amenities.add(amenity);
        segmentDTO.setAmenities(amenities);
        
        segmentDTO.setLayoverTime("1h");
    }

    @Test
    public void testGetDepartureTime() {
        assertEquals("2024-09-05T10:00:00", segmentDTO.getDepartureTime());
    }

    @Test
    public void testGetArrivalTime() {
        assertEquals("2024-09-05T14:00:00", segmentDTO.getArrivalTime());
    }

    @Test
    public void testGetDepartureAirportName() {
        assertEquals("John F. Kennedy International Airport", segmentDTO.getDepartureAirportName());
    }

    @Test
    public void testGetDepartureAirportCode() {
        assertEquals("JFK", segmentDTO.getDepartureAirportCode());
    }

    @Test
    public void testGetArrivalAirportName() {
        assertEquals("Los Angeles International Airport", segmentDTO.getArrivalAirportName());
    }

    @Test
    public void testGetArrivalAirportCode() {
        assertEquals("LAX", segmentDTO.getArrivalAirportCode());
    }

    @Test
    public void testGetCarrierCode() {
        assertEquals("AA", segmentDTO.getCarrierCode());
    }

    @Test
    public void testGetCarrierName() {
        assertEquals("American Airlines", segmentDTO.getCarrierName());
    }

    @Test
    public void testGetFlightNumber() {
        assertEquals("100", segmentDTO.getFlightNumber());
    }

    @Test
    public void testGetOperatingCarrierCode() {
        assertEquals("AA", segmentDTO.getOperatingCarrierCode());
    }

    @Test
    public void testGetOperatingCarrierName() {
        assertEquals("American Airlines", segmentDTO.getOperatingCarrierName());
    }

    @Test
    public void testGetAircraftType() {
        assertEquals("Boeing 737", segmentDTO.getAircraftType());
    }

    @Test
    public void testGetCabin() {
        assertEquals("Economy", segmentDTO.getCabin());
    }

    @Test
    public void testGetFareBasis() {
        assertEquals("Y", segmentDTO.getFareBasis());
    }

    @Test
    public void testGetFlightClass() {
        assertEquals("Economy", segmentDTO.getFlightClass());
    }

    @Test
    public void testGetAmenities() {
        assertNotNull(segmentDTO.getAmenities());
        assertEquals(1, segmentDTO.getAmenities().size());
        assertEquals("WiFi", segmentDTO.getAmenities().get(0).getName());
        assertEquals(true, segmentDTO.getAmenities().get(0).isChargeable());
    }

    @Test
    public void testGetLayoverTime() {
        assertEquals("1h", segmentDTO.getLayoverTime());
    }
}
