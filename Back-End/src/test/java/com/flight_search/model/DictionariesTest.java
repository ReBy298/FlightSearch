package com.flight_search.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class DictionariesTest {

    @Test
    public void testGettersAndSetters() {
        Dictionaries dictionaries = new Dictionaries();
        
        Map<String, Location> locations = new HashMap<>();
        dictionaries.setLocations(locations);
        
        Map<String, String> aircraft = new HashMap<>();
        dictionaries.setAircraft(aircraft);
        
        Map<String, String> currencies = new HashMap<>();
        dictionaries.setCurrencies(currencies);
        
        Map<String, String> carriers = new HashMap<>();
        dictionaries.setCarriers(carriers);

        assertEquals(locations, dictionaries.getLocations());
        assertEquals(aircraft, dictionaries.getAircraft());
        assertEquals(currencies, dictionaries.getCurrencies());
        assertEquals(carriers, dictionaries.getCarriers());
    }
}
