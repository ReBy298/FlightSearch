package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FlightOfferTest {

    @Test
    public void testGettersAndSetters() {
        FlightOffer flightOffer = new FlightOffer();
        flightOffer.setType("Economy");
        flightOffer.setId("12345");
        flightOffer.setSource("API");
        flightOffer.setInstantTicketingRequired(true);
        flightOffer.setNonHomogeneous(false);
        flightOffer.setOneWay(true);
        flightOffer.setLastTicketingDate("2024-12-31");
        flightOffer.setNumberOfBookableSeats(5);
        
        List<Itinerary> itineraries = new ArrayList<>();
        flightOffer.setItineraries(itineraries);
        
        Price price = new Price();
        flightOffer.setPrice(price);
        
        PricingOptions pricingOptions = new PricingOptions();
        flightOffer.setPricingOptions(pricingOptions);
        
        List<String> validatingAirlineCodes = new ArrayList<>();
        flightOffer.setValidatingAirlineCodes(validatingAirlineCodes);
        
        List<TravelerPricing> travelerPricings = new ArrayList<>();
        flightOffer.setTravelerPricings(travelerPricings);
        
        flightOffer.setUpsellOffer(true);
        flightOffer.setLastTicketingDateTime("2024-12-31T23:59:59");

        assertEquals("Economy", flightOffer.getType());
        assertEquals("12345", flightOffer.getId());
        assertEquals("API", flightOffer.getSource());
        assertTrue(flightOffer.isInstantTicketingRequired());
        assertEquals(false, flightOffer.isNonHomogeneous());
        assertTrue(flightOffer.isOneWay());
        assertEquals("2024-12-31", flightOffer.getLastTicketingDate());
        assertEquals(5, flightOffer.getNumberOfBookableSeats());
        assertEquals(itineraries, flightOffer.getItineraries());
        assertEquals(price, flightOffer.getPrice());
        assertEquals(pricingOptions, flightOffer.getPricingOptions());
        assertEquals(validatingAirlineCodes, flightOffer.getValidatingAirlineCodes());
        assertEquals(travelerPricings, flightOffer.getTravelerPricings());
        assertTrue(flightOffer.isUpsellOffer());
        assertEquals("2024-12-31T23:59:59", flightOffer.getLastTicketingDateTime());
    }
}
