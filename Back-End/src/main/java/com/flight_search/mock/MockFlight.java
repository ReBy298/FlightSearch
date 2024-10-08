package com.flight_search.mock;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MockFlight {
	public String getMockFlightOffers() {
        return "{\n"
        		+ "  \"meta\": {\n"
        		+ "    \"count\": 3,\n"
        		+ "    \"links\": {\n"
        		+ "      \"self\": \"https://test.api.amadeus.com/v2/shopping/flight-offers?departureAirportCode=BOS&arrivalAirportCode=EWR&departureDate=2024-10-20&numberAdults=2&currency=USD&nonStops=false&max=3\"\n"
        		+ "    }\n"
        		+ "  },\n"
        		+ "  \"data\": [\n"
        		+ "    {\n"
        		+ "        \"type\": \"flight-offer\",\n"
        		+ "        \"id\": \"1\",\n"
        		+ "        \"source\": \"GDS\",\n"
        		+ "        \"instantTicketingRequired\": false,\n"
        		+ "        \"nonHomogeneous\": false,\n"
        		+ "        \"oneWay\": false,\n"
        		+ "        \"isUpsellOffer\": false,\n"
        		+ "        \"lastTicketingDate\": \"2024-08-28\",\n"
        		+ "        \"lastTicketingDateTime\": \"2024-08-28\",\n"
        		+ "        \"numberOfBookableSeats\": 9,\n"
        		+ "        \"itineraries\": [\n"
        		+ "            {\n"
        		+ "                \"duration\": \"PT1H23M\",\n"
        		+ "                \"segments\": [\n"
        		+ "                    {\n"
        		+ "                        \"departure\": {\n"
        		+ "                            \"iataCode\": \"BOS\",\n"
        		+ "                            \"terminal\": \"B\",\n"
        		+ "                            \"at\": \"2024-10-20T06:00:00\"\n"
        		+ "                        },\n"
        		+ "                        \"arrival\": {\n"
        		+ "                            \"iataCode\": \"EWR\",\n"
        		+ "                            \"terminal\": \"C\",\n"
        		+ "                            \"at\": \"2024-10-20T07:23:00\"\n"
        		+ "                        },\n"
        		+ "                        \"carrierCode\": \"UA\",\n"
        		+ "                        \"number\": \"1833\",\n"
        		+ "                        \"aircraft\": {\n"
        		+ "                            \"code\": \"7M9\"\n"
        		+ "                        },\n"
        		+ "                        \"operating\": {\n"
        		+ "                            \"carrierCode\": \"UA\"\n"
        		+ "                        },\n"
        		+ "                        \"duration\": \"PT1H23M\",\n"
        		+ "                        \"id\": \"1\",\n"
        		+ "                        \"numberOfStops\": 0,\n"
        		+ "                        \"blacklistedInEU\": false\n"
        		+ "                    }\n"
        		+ "                ]\n"
        		+ "            }\n"
        		+ "        ],\n"
        		+ "        \"price\": {\n"
        		+ "            \"currency\": \"USD\",\n"
        		+ "            \"total\": \"167.02\",\n"
        		+ "            \"base\": \"127.22\",\n"
        		+ "            \"fees\": [\n"
        		+ "                {\n"
        		+ "                    \"amount\": \"0.00\",\n"
        		+ "                    \"type\": \"SUPPLIER\"\n"
        		+ "                },\n"
        		+ "                {\n"
        		+ "                    \"amount\": \"0.00\",\n"
        		+ "                    \"type\": \"TICKETING\"\n"
        		+ "                }\n"
        		+ "            ],\n"
        		+ "            \"grandTotal\": \"167.02\"\n"
        		+ "        },\n"
        		+ "        \"pricingOptions\": {\n"
        		+ "            \"fareType\": [\n"
        		+ "                \"PUBLISHED\"\n"
        		+ "            ],\n"
        		+ "            \"includedCheckedBagsOnly\": false\n"
        		+ "        },\n"
        		+ "        \"validatingAirlineCodes\": [\n"
        		+ "            \"UA\"\n"
        		+ "        ],\n"
        		+ "        \"travelerPricings\": [\n"
        		+ "            {\n"
        		+ "                \"travelerId\": \"1\",\n"
        		+ "                \"fareOption\": \"STANDARD\",\n"
        		+ "                \"travelerType\": \"ADULT\",\n"
        		+ "                \"price\": {\n"
        		+ "                    \"currency\": \"USD\",\n"
        		+ "                    \"total\": \"83.51\",\n"
        		+ "                    \"base\": \"63.61\"\n"
        		+ "                },\n"
        		+ "                \"fareDetailsBySegment\": [\n"
        		+ "                    {\n"
        		+ "                        \"segmentId\": \"1\",\n"
        		+ "                        \"cabin\": \"ECONOMY\",\n"
        		+ "                        \"fareBasis\": \"GAA4PFDN\",\n"
        		+ "                        \"brandedFare\": \"ECONOMY\",\n"
        		+ "                        \"brandedFareLabel\": \"ECONOMY\",\n"
        		+ "                        \"class\": \"G\",\n"
        		+ "                        \"includedCheckedBags\": {\n"
        		+ "                            \"quantity\": 0\n"
        		+ "                        },\n"
        		+ "                        \"amenities\": [\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"CHECKED BAG FIRST\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"BAGGAGE\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"SECOND BAG\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"BAGGAGE\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"PRE RESERVED SEAT ASSIGNMENT\",\n"
        		+ "                                \"isChargeable\": false,\n"
        		+ "                                \"amenityType\": \"PRE_RESERVED_SEAT\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"PRIORITY BOARDING\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"TRAVEL_SERVICES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"ECONOMY TO ECONOMY PLUS\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"UPGRADES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"MILEAGE ACCRUAL\",\n"
        		+ "                                \"isChargeable\": false,\n"
        		+ "                                \"amenityType\": \"BRANDED_FARES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            }\n"
        		+ "                        ]\n"
        		+ "                    }\n"
        		+ "                ]\n"
        		+ "            }\n"
        		+ "        ]\n"
        		+ "    },\n"
        		+ "    {\n"
        		+ "        \"type\": \"flight-offer\",\n"
        		+ "        \"id\": \"2\",\n"
        		+ "        \"source\": \"GDS\",\n"
        		+ "        \"instantTicketingRequired\": false,\n"
        		+ "        \"nonHomogeneous\": false,\n"
        		+ "        \"oneWay\": false,\n"
        		+ "        \"isUpsellOffer\": false,\n"
        		+ "        \"lastTicketingDate\": \"2024-08-28\",\n"
        		+ "        \"lastTicketingDateTime\": \"2024-08-28\",\n"
        		+ "        \"numberOfBookableSeats\": 9,\n"
        		+ "        \"itineraries\": [\n"
        		+ "            {\n"
        		+ "                \"duration\": \"PT1H23M\",\n"
        		+ "                \"segments\": [\n"
        		+ "                    {\n"
        		+ "                        \"departure\": {\n"
        		+ "                            \"iataCode\": \"BOS\",\n"
        		+ "                            \"terminal\": \"B\",\n"
        		+ "                            \"at\": \"2024-10-20T07:30:00\"\n"
        		+ "                        },\n"
        		+ "                        \"arrival\": {\n"
        		+ "                            \"iataCode\": \"EWR\",\n"
        		+ "                            \"terminal\": \"C\",\n"
        		+ "                            \"at\": \"2024-10-20T08:53:00\"\n"
        		+ "                        },\n"
        		+ "                        \"carrierCode\": \"UA\",\n"
        		+ "                        \"number\": \"570\",\n"
        		+ "                        \"aircraft\": {\n"
        		+ "                            \"code\": \"7M9\"\n"
        		+ "                        },\n"
        		+ "                        \"operating\": {\n"
        		+ "                            \"carrierCode\": \"UA\"\n"
        		+ "                        },\n"
        		+ "                        \"duration\": \"PT1H23M\",\n"
        		+ "                        \"id\": \"2\",\n"
        		+ "                        \"numberOfStops\": 0,\n"
        		+ "                        \"blacklistedInEU\": false\n"
        		+ "                    }\n"
        		+ "                ]\n"
        		+ "            }\n"
        		+ "        ],\n"
        		+ "        \"price\": {\n"
        		+ "            \"currency\": \"USD\",\n"
        		+ "            \"total\": \"167.02\",\n"
        		+ "            \"base\": \"127.22\",\n"
        		+ "            \"fees\": [\n"
        		+ "                {\n"
        		+ "                    \"amount\": \"0.00\",\n"
        		+ "                    \"type\": \"SUPPLIER\"\n"
        		+ "                },\n"
        		+ "                {\n"
        		+ "                    \"amount\": \"0.00\",\n"
        		+ "                    \"type\": \"TICKETING\"\n"
        		+ "                }\n"
        		+ "            ],\n"
        		+ "            \"grandTotal\": \"167.02\"\n"
        		+ "        },\n"
        		+ "        \"pricingOptions\": {\n"
        		+ "            \"fareType\": [\n"
        		+ "                \"PUBLISHED\"\n"
        		+ "            ],\n"
        		+ "            \"includedCheckedBagsOnly\": false\n"
        		+ "        },\n"
        		+ "        \"validatingAirlineCodes\": [\n"
        		+ "            \"UA\"\n"
        		+ "        ],\n"
        		+ "        \"travelerPricings\": [\n"
        		+ "            {\n"
        		+ "                \"travelerId\": \"1\",\n"
        		+ "                \"fareOption\": \"STANDARD\",\n"
        		+ "                \"travelerType\": \"ADULT\",\n"
        		+ "                \"price\": {\n"
        		+ "                    \"currency\": \"USD\",\n"
        		+ "                    \"total\": \"83.51\",\n"
        		+ "                    \"base\": \"63.61\"\n"
        		+ "                },\n"
        		+ "                \"fareDetailsBySegment\": [\n"
        		+ "                    {\n"
        		+ "                        \"segmentId\": \"2\",\n"
        		+ "                        \"cabin\": \"ECONOMY\",\n"
        		+ "                        \"fareBasis\": \"GAA4PFDN\",\n"
        		+ "                        \"brandedFare\": \"ECONOMY\",\n"
        		+ "                        \"brandedFareLabel\": \"ECONOMY\",\n"
        		+ "                        \"class\": \"G\",\n"
        		+ "                        \"includedCheckedBags\": {\n"
        		+ "                            \"quantity\": 0\n"
        		+ "                        },\n"
        		+ "                        \"amenities\": [\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"CHECKED BAG FIRST\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"BAGGAGE\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"SECOND BAG\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"BAGGAGE\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"PRE RESERVED SEAT ASSIGNMENT\",\n"
        		+ "                                \"isChargeable\": false,\n"
        		+ "                                \"amenityType\": \"PRE_RESERVED_SEAT\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"PRIORITY BOARDING\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"TRAVEL_SERVICES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"ECONOMY TO ECONOMY PLUS\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"UPGRADES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"MILEAGE ACCRUAL\",\n"
        		+ "                                \"isChargeable\": false,\n"
        		+ "                                \"amenityType\": \"BRANDED_FARES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            }\n"
        		+ "                        ]\n"
        		+ "                    }\n"
        		+ "                ]\n"
        		+ "            }\n"
        		+ "        ]\n"
        		+ "    },\n"
        		+ "    {\n"
        		+ "        \"type\": \"flight-offer\",\n"
        		+ "        \"id\": \"3\",\n"
        		+ "        \"source\": \"GDS\",\n"
        		+ "        \"instantTicketingRequired\": false,\n"
        		+ "        \"nonHomogeneous\": false,\n"
        		+ "        \"oneWay\": false,\n"
        		+ "        \"isUpsellOffer\": false,\n"
        		+ "        \"lastTicketingDate\": \"2024-08-28\",\n"
        		+ "        \"lastTicketingDateTime\": \"2024-08-28\",\n"
        		+ "        \"numberOfBookableSeats\": 9,\n"
        		+ "        \"itineraries\": [\n"
        		+ "            {\n"
        		+ "                \"duration\": \"PT1H25M\",\n"
        		+ "                \"segments\": [\n"
        		+ "                    {\n"
        		+ "                        \"departure\": {\n"
        		+ "                            \"iataCode\": \"BOS\",\n"
        		+ "                            \"terminal\": \"B\",\n"
        		+ "                            \"at\": \"2024-10-20T09:05:00\"\n"
        		+ "                        },\n"
        		+ "                        \"arrival\": {\n"
        		+ "                            \"iataCode\": \"EWR\",\n"
        		+ "                            \"terminal\": \"C\",\n"
        		+ "                            \"at\": \"2024-10-20T10:30:00\"\n"
        		+ "                        },\n"
        		+ "                        \"carrierCode\": \"UA\",\n"
        		+ "                        \"number\": \"1805\",\n"
        		+ "                        \"aircraft\": {\n"
        		+ "                            \"code\": \"739\"\n"
        		+ "                        },\n"
        		+ "                        \"operating\": {\n"
        		+ "                            \"carrierCode\": \"UA\"\n"
        		+ "                        },\n"
        		+ "                        \"duration\": \"PT1H25M\",\n"
        		+ "                        \"id\": \"3\",\n"
        		+ "                        \"numberOfStops\": 0,\n"
        		+ "                        \"blacklistedInEU\": false\n"
        		+ "                    }\n"
        		+ "                ]\n"
        		+ "            }\n"
        		+ "        ],\n"
        		+ "        \"price\": {\n"
        		+ "            \"currency\": \"USD\",\n"
        		+ "            \"total\": \"196.92\",\n"
        		+ "            \"base\": \"155.12\",\n"
        		+ "            \"fees\": [\n"
        		+ "                {\n"
        		+ "                    \"amount\": \"0.00\",\n"
        		+ "                    \"type\": \"SUPPLIER\"\n"
        		+ "                },\n"
        		+ "                {\n"
        		+ "                    \"amount\": \"0.00\",\n"
        		+ "                    \"type\": \"TICKETING\"\n"
        		+ "                }\n"
        		+ "            ],\n"
        		+ "            \"grandTotal\": \"196.92\"\n"
        		+ "        },\n"
        		+ "        \"pricingOptions\": {\n"
        		+ "            \"fareType\": [\n"
        		+ "                \"PUBLISHED\"\n"
        		+ "            ],\n"
        		+ "            \"includedCheckedBagsOnly\": false\n"
        		+ "        },\n"
        		+ "        \"validatingAirlineCodes\": [\n"
        		+ "            \"UA\"\n"
        		+ "        ],\n"
        		+ "        \"travelerPricings\": [\n"
        		+ "            {\n"
        		+ "                \"travelerId\": \"1\",\n"
        		+ "                \"fareOption\": \"STANDARD\",\n"
        		+ "                \"travelerType\": \"ADULT\",\n"
        		+ "                \"price\": {\n"
        		+ "                    \"currency\": \"USD\",\n"
        		+ "                    \"total\": \"98.46\",\n"
        		+ "                    \"base\": \"77.56\"\n"
        		+ "                },\n"
        		+ "                \"fareDetailsBySegment\": [\n"
        		+ "                    {\n"
        		+ "                        \"segmentId\": \"3\",\n"
        		+ "                        \"cabin\": \"ECONOMY\",\n"
        		+ "                        \"fareBasis\": \"KAA7PFDN\",\n"
        		+ "                        \"brandedFare\": \"ECONOMY\",\n"
        		+ "                        \"brandedFareLabel\": \"ECONOMY\",\n"
        		+ "                        \"class\": \"K\",\n"
        		+ "                        \"includedCheckedBags\": {\n"
        		+ "                            \"quantity\": 0\n"
        		+ "                        },\n"
        		+ "                        \"amenities\": [\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"CHECKED BAG FIRST\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"BAGGAGE\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"SECOND BAG\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"BAGGAGE\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"PRE RESERVED SEAT ASSIGNMENT\",\n"
        		+ "                                \"isChargeable\": false,\n"
        		+ "                                \"amenityType\": \"PRE_RESERVED_SEAT\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"PRIORITY BOARDING\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"TRAVEL_SERVICES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"ECONOMY TO ECONOMY PLUS\",\n"
        		+ "                                \"isChargeable\": true,\n"
        		+ "                                \"amenityType\": \"UPGRADES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            },\n"
        		+ "                            {\n"
        		+ "                                \"description\": \"MILEAGE ACCRUAL\",\n"
        		+ "                                \"isChargeable\": false,\n"
        		+ "                                \"amenityType\": \"BRANDED_FARES\",\n"
        		+ "                                \"amenityProvider\": {\n"
        		+ "                                    \"name\": \"BrandedFare\"\n"
        		+ "                                }\n"
        		+ "                            }\n"
        		+ "                        ]\n"
        		+ "                    }\n"
        		+ "                ]\n"
        		+ "            }\n"
        		+ "        ]\n"
        		+ "    }\n"
        		+ "  ]\n"
        		+ "}";
	}
	
	 public String getMockAirline () {
	        return "{\"meta\": {\"count\": 1,\"links\": {\"self\":\"https://test.api.amadeus.com/v1/reference-data/airlines?airlineCodes=BA\"}},\"data\": [{\"type\": \"airline\",\"iataCode\": \"BA\",\"icaoCode\": \"BAW\",\"businessName\": \"BRITISH AIRWAYS\",\"commonName\": \"BRITISH A/W\"}]}";
	        
	 }
	 
	 public String getMockAirport() {
	        return  "{\n" +
	                "  \"meta\": {\n" +
	                "    \"count\": 3,\n" +
	                "    \"links\": {\n" +
	                "      \"self\": \"https://test.api.amadeus.com/v1/reference-data/locations?subType=AIRPORT&keyword=MUC&countryCode=DE\"\n" +
	                "    }\n" +
	                "  },\n" +
	                "  \"data\": [\n" +
	                "    {\n" +
	                "      \"type\": \"location\",\n" +
	                "      \"subType\": \"AIRPORT\",\n" +
	                "      \"name\": \"MUNICH INTERNATIONAL\",\n" +
	                "      \"detailedName\": \"MUNICH/DE:MUNICH INTERNATIONAL\",\n" +
	                "      \"id\": \"AMUC\",\n" +
	                "      \"self\": {\n" +
	                "        \"href\": \"https://test.api.amadeus.com/v1/reference-data/locations/AMUC\",\n" +
	                "        \"methods\": [\n" +
	                "          \"GET\"\n" +
	                "        ]\n" +
	                "      },\n" +
	                "      \"timeZoneOffset\": \"+02:00\",\n" +
	                "      \"iataCode\": \"MUC\",\n" +
	                "      \"geoCode\": {\n" +
	                "        \"latitude\": 48.35378,\n" +
	                "        \"longitude\": 11.78609\n" +
	                "      },\n" +
	                "      \"address\": {\n" +
	                "        \"cityName\": \"MUNICH\",\n" +
	                "        \"cityCode\": \"MUC\",\n" +
	                "        \"countryName\": \"GERMANY\",\n" +
	                "        \"countryCode\": \"DE\",\n" +
	                "        \"regionCode\": \"EUROP\"\n" +
	                "      },\n" +
	                "      \"analytics\": {\n" +
	                "        \"travelers\": {\n" +
	                "          \"score\": 27\n" +
	                "        }\n" +
	                "      }\n" +
	                "    },\n" +
	                "    {\n" +
	                "      \"type\": \"location\",\n" +
	                "      \"subType\": \"AIRPORT\",\n" +
	                "      \"name\": \"FRANKFURT INTERNATIONAL\",\n" +
	                "      \"detailedName\": \"FRANKFURT/DE:FRANKFURT INTERNATIONAL\",\n" +
	                "      \"id\": \"AFRA\",\n" +
	                "      \"self\": {\n" +
	                "        \"href\": \"https://test.api.amadeus.com/v1/reference-data/locations/AFRA\",\n" +
	                "        \"methods\": [\n" +
	                "          \"GET\"\n" +
	                "        ]\n" +
	                "      },\n" +
	                "      \"timeZoneOffset\": \"+02:00\",\n" +
	                "      \"iataCode\": \"FRA\",\n" +
	                "      \"geoCode\": {\n" +
	                "        \"latitude\": 50.03793,\n" +
	                "        \"longitude\": 8.56215\n" +
	                "      },\n" +
	                "      \"address\": {\n" +
	                "        \"cityName\": \"FRANKFURT\",\n" +
	                "        \"cityCode\": \"FRA\",\n" +
	                "        \"countryName\": \"GERMANY\",\n" +
	                "        \"countryCode\": \"DE\",\n" +
	                "        \"regionCode\": \"EUROP\"\n" +
	                "      },\n" +
	                "      \"analytics\": {\n" +
	                "        \"travelers\": {\n" +
	                "          \"score\": 30\n" +
	                "        }\n" +
	                "      }\n" +
	                "    },\n" +
	                "    {\n" +
	                "      \"type\": \"location\",\n" +
	                "      \"subType\": \"AIRPORT\",\n" +
	                "      \"name\": \"BERLIN TEGEL\",\n" +
	                "      \"detailedName\": \"BERLIN/DE:BERLIN TEGEL\",\n" +
	                "      \"id\": \"ABER\",\n" +
	                "      \"self\": {\n" +
	                "        \"href\": \"https://test.api.amadeus.com/v1/reference-data/locations/ABER\",\n" +
	                "        \"methods\": [\n" +
	                "          \"GET\"\n" +
	                "        ]\n" +
	                "      },\n" +
	                "      \"timeZoneOffset\": \"+02:00\",\n" +
	                "      \"iataCode\": \"TXL\",\n" +
	                "      \"geoCode\": {\n" +
	                "        \"latitude\": 52.55972,\n" +
	                "        \"longitude\": 13.28771\n" +
	                "      },\n" +
	                "      \"address\": {\n" +
	                "        \"cityName\": \"BERLIN\",\n" +
	                "        \"cityCode\": \"BER\",\n" +
	                "        \"countryName\": \"GERMANY\",\n" +
	                "        \"countryCode\": \"DE\",\n" +
	                "        \"regionCode\": \"EUROP\"\n" +
	                "      },\n" +
	                "      \"analytics\": {\n" +
	                "        \"travelers\": {\n" +
	                "          \"score\": 25\n" +
	                "        }\n" +
	                "      }\n" +
	                "    }\n" +
	                "  ]\n" +
	                "}";
	    }
	}
