package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AmenityTest {

    @Test
    public void testGettersAndSetters() {
        Amenity amenity = new Amenity();
        amenity.setDescription("WiFi");
        amenity.setChargeable(true);
        amenity.setAmenityType("Internet");
        
        AmenityProvider provider = new AmenityProvider();
        provider.setName("ProviderName");
        amenity.setAmenityProvider(provider);

        assertEquals("WiFi", amenity.getDescription());
        assertTrue(amenity.isChargeable());
        assertEquals("Internet", amenity.getAmenityType());
        assertEquals(provider, amenity.getAmenityProvider());
        assertEquals("ProviderName", amenity.getAmenityProvider().getName());
    }
}
