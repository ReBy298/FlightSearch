package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FareDetailsBySegmentTest {

    @Test
    public void testGettersAndSetters() {
        FareDetailsBySegment fareDetails = new FareDetailsBySegment();
        
        String segmentId = "123";
        String cabin = "Economy";
        String fareBasis = "Y";
        String brandedFare = "Basic";
        String brandedFareLabel = "Basic Economy";
        String flightClass = "Economy";
        IncludedCheckedBags includedCheckedBags = new IncludedCheckedBags();
        List<Amenity> amenities = new ArrayList<>();
        
        fareDetails.setSegmentId(segmentId);
        fareDetails.setCabin(cabin);
        fareDetails.setFareBasis(fareBasis);
        fareDetails.setBrandedFare(brandedFare);
        fareDetails.setBrandedFareLabel(brandedFareLabel);
        fareDetails.setFlightClass(flightClass);
        fareDetails.setIncludedCheckedBags(includedCheckedBags);
        fareDetails.setAmenities(amenities);

        assertEquals(segmentId, fareDetails.getSegmentId());
        assertEquals(cabin, fareDetails.getCabin());
        assertEquals(fareBasis, fareDetails.getFareBasis());
        assertEquals(brandedFare, fareDetails.getBrandedFare());
        assertEquals(brandedFareLabel, fareDetails.getBrandedFareLabel());
        assertEquals(flightClass, fareDetails.getFlightClass());
        assertEquals(includedCheckedBags, fareDetails.getIncludedCheckedBags());
        assertEquals(amenities, fareDetails.getAmenities());
    }
}
