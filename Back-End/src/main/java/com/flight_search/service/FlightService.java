package com.flight_search.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flight_search.dto.AirlineDTO;
import com.flight_search.dto.AirportDTO;
import com.flight_search.dto.AmenityDTO;
import com.flight_search.dto.FeeDTO;
import com.flight_search.dto.FlightDTO;
import com.flight_search.dto.IataCodeDTO;
import com.flight_search.dto.PriceBreakdownDTO;
import com.flight_search.dto.SegmentDTO;
import com.flight_search.dto.StopDTO;
import com.flight_search.mock.MockFlight;
import com.flight_search.model.Amenity;
import com.flight_search.model.FareDetailsBySegment;
import com.flight_search.model.Fee;
import com.flight_search.model.FlightOffer;
import com.flight_search.model.Segment;
import com.flight_search.model.TravelerPricing;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class FlightService {

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	private final MockFlight mockFlight;

	@Value("${amadeus.api.key}")
	private String apiKey;

	@Value("${amadeus.api.secret}")
	private String apiSecret;

	private String flightSearch = "https://test.api.amadeus.com/v2/shopping/flight-offers?";

	public FlightService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper, MockFlight mockFlight) {
		this.restTemplate = restTemplateBuilder.build();
		this.objectMapper = objectMapper;
		this.mockFlight = mockFlight;
	}

	private String getAccessToken() {
		String url = "https://test.api.amadeus.com/v1/security/oauth2/token";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "client_credentials");
		body.add("client_id", apiKey);
		body.add("client_secret", apiSecret);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		try {
			ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
			String accessToken = (String) response.getBody().get("access_token");
			System.out.println("Access Token: " + accessToken);
			return accessToken;
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			System.err
					.println("Error obtaining access token: " + e.getStatusCode() + " " + e.getResponseBodyAsString());
			throw e;
		} catch (ResourceAccessException e) {
			System.err.println("Connection error: " + e.getMessage());
			throw new RuntimeException("Failed to connect to Amadeus API", e);
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
			throw new RuntimeException("Failed to obtain access token", e);
		}
	}

	/*
	 * 
	 * public List<FlightDTO> getFlights(String origin, String destination, String
	 * departureDate, int adults, int max, String token) { try { String URL =
	 * "shopping/flight-offers?" + "originLocationCode=" + origin +
	 * "&destinationLocationCode=" + destination + "&departureDate=" + departureDate
	 * + "&adults=" + adults + "&nonStop=false" + "&currencyCode=USD" + "&max=" +
	 * max;
	 * 
	 * URI URIRequest = new URI(flightSearch + URL);
	 * 
	 * HttpRequest getRequest = HttpRequest.newBuilder() .uri(URIRequest)
	 * .header("Content-Type", "application/x-www-form-urlencoded")
	 * .header("Authorization", "Bearer " + token) .GET() .build();
	 * 
	 * HttpClient httpClient = HttpClient.newHttpClient(); HttpResponse<String>
	 * response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
	 * 
	 * if (response.statusCode() == 200) { return
	 * convertToDTO(parseFlights(response.body())); }
	 * 
	 * throw new RuntimeException("Failed to fetch flight offers: " +
	 * response.toString()); } catch (Exception e) { throw new RuntimeException(e);
	 * } }
	 */

	/*
	 * 
	 * public List<FlightDTO> getFlights(String origin, String destination, String
	 * departureDate, int adults, boolean nonStop, int max, boolean nonStop, String
	 * currency) { try { String URL = "shopping/flight-offers?" +
	 * "originLocationCode=" + origin + "&destinationLocationCode=" + destination +
	 * "&departureDate=" + departureDate + "&adults=" + adults + "&nonStop=false" +
	 * "&currencyCode=USD" + "&max=" + max;
	 * 
	 * URI URIRequest = new URI(flightSearch + URL); HttpHeaders headers = new
	 * HttpHeaders(); String accessToken = getAccessToken();
	 * headers.set("Authorization", "Bearer " + accessToken); HttpEntity<String>
	 * entity = new HttpEntity<>(headers); try { ResponseEntity<String> response =
	 * restTemplate.exchange(URIRequest, HttpMethod.GET, entity, String.class);
	 * List<FlightOffer> flightOffers = parseFlights(response.getBody());
	 * List<FlightDTO> flightDTOs = convertToDTO(flightOffers, currency);
	 * 
	 * // sortFlights(flightDTOs, sortBy);
	 * 
	 * return flightDTOs;
	 * 
	 * return parseFlights(); } catch (HttpClientErrorException |
	 * HttpServerErrorException e) { System.err.println("Error searching flights: "
	 * + e.getStatusCode() + " " + e.getResponseBodyAsString()); throw e; } catch
	 * (Exception e) { System.err.println("Unexpected error: " + e.getMessage());
	 * throw new RuntimeException("Failed to search flights", e); } }
	 */

	public List<FlightDTO> getFlights(String departure, String arrival, String departureDate, String returnDate,
			int adults, int max, String currency, boolean nonStop, String orderPrice, String orderDuration) {
		if (isDateInPast(departureDate) || (returnDate != null && isDateInPast(returnDate))
				|| (returnDate != null && isReturnDateBeforeDepartureDate(departureDate, returnDate))) {
			throw new IllegalArgumentException("Invalid dates");
		}

		String jsonResponse = mockFlight.getMockFlightOffers();
		List<FlightOffer> flightOffers = parseFlights(jsonResponse);

		List<FlightDTO> flightDTOs = convertToDTO(flightOffers, currency);

		if (orderPrice != null || orderDuration != null) {
			flightDTOs = sortFlights(flightDTOs, orderPrice, orderDuration);
		}

		return flightDTOs;
	}

	public List<AirlineDTO> getAirlines() {

		String jsonResponse = mockFlight.getMockAirline();
		List<AirlineDTO> airlinesDTO = parseAirlines(jsonResponse);

		return airlinesDTO;
	}

	private List<AirlineDTO> parseAirlines(String jsonResponse) {
		List<AirlineDTO> airlines = new ArrayList<>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(jsonResponse);
			JsonNode data = root.path("data");

			for (JsonNode airlineNode : data) {
				AirlineDTO airline = new AirlineDTO();
				airline.setIataCode(airlineNode.path("iataCode").asText());
				airline.setBussinessName(airlineNode.path("businessName").asText());
				airlines.add(airline);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return airlines;
	}

	private String getAirlineNameByCode(List<AirlineDTO> airlines, String iataCode) {
		for (AirlineDTO airline : airlines) {
			if (airline.getIataCode().equals(iataCode)) {
				return airline.getBussinessName();
			}
		}
		return "Unknown Airline";
	}

	public List<AirportDTO> getAirports() {

		String jsonResponse = mockFlight.getMockAirport();
		List<AirportDTO> airportsDTO = parseAirports(jsonResponse);

		return airportsDTO;
	}

	private List<AirportDTO> parseAirports(String jsonResponse) {
		List<AirportDTO> airports = new ArrayList<>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(jsonResponse);
			JsonNode data = root.path("data");

			for (JsonNode airportNode : data) {
				AirportDTO airport = new AirportDTO();
				airport.setIataCode(airportNode.path("iataCode").asText());
				airport.setName(airportNode.path("name").asText());
				airports.add(airport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return airports;
	}

	private String getAirportNameByCode(List<AirportDTO> airports, String iataCode) {
		for (AirportDTO airport : airports) {
			if (airport.getIataCode().equals(iataCode)) {
				return airport.getName();
			}
		}
		return "Unknown Airport";
	}

	private boolean isDateInPast(String date) {

		return false;
	}

	private boolean isReturnDateBeforeDepartureDate(String departureDate, String returnDate) {

		return false;
	}

	private List<FlightOffer> parseFlights(String jsonResponse) {
		List<FlightOffer> flightOffers = new ArrayList<>();
		try {
			JsonNode root = objectMapper.readTree(jsonResponse);
			JsonNode data = root.path("data");

			for (JsonNode flightNode : data) {
				FlightOffer flightOffer = objectMapper.treeToValue(flightNode, FlightOffer.class);
				flightOffers.add(flightOffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flightOffers;
	}

	private Duration calculateDuration(String departureTime, String arrivalTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime departure = LocalDateTime.parse(departureTime, formatter);
		LocalDateTime arrival = LocalDateTime.parse(arrivalTime, formatter);

		if (arrival.isBefore(departure)) {
			arrival = arrival.plusDays(1);
		}

		return Duration.between(departure, arrival);
	}

	private List<FlightDTO> convertToDTO(List<FlightOffer> flightOffers, String currency) {
		List<FlightDTO> flightDTOs = new ArrayList<>();
		List<AirlineDTO> airlines = getAirlines();
		List<AirportDTO> airports = getAirports();

		for (FlightOffer flightOffer : flightOffers) {
			FlightDTO flightDTO = new FlightDTO();

			flightDTO.setId(UUID.randomUUID().toString());

			// Set initial and final departure/arrival times
			flightDTO.setInitialDepartureDateTime(
					flightOffer.getItineraries().get(0).getSegments().get(0).getDeparture().getAt());
			flightDTO.setFinalArrivalDateTime(flightOffer.getItineraries().get(0).getSegments()
					.get(flightOffer.getItineraries().get(0).getSegments().size() - 1).getArrival().getAt());

			// Set airport names and codes
			String departureAirportCode = flightOffer.getItineraries().get(0).getSegments().get(0).getDeparture()
					.getIataCode();
			String arrivalAirportCode = flightOffer.getItineraries().get(0).getSegments()
					.get(flightOffer.getItineraries().get(0).getSegments().size() - 1).getArrival().getIataCode();
			flightDTO.setDepartureAirportCode(departureAirportCode);
			flightDTO.setDepartureAirportName(getAirportNameByCode(airports, departureAirportCode));
			flightDTO.setArrivalAirportCode(arrivalAirportCode);
			flightDTO.setArrivalAirportName(getAirportNameByCode(airports, arrivalAirportCode));

			// Set airline names and codes
			String carrierCode = flightOffer.getItineraries().get(0).getSegments().get(0).getCarrierCode();
			flightDTO.setAirlineCode(carrierCode);
			flightDTO.setAirlineName(getAirlineNameByCode(airlines, carrierCode));

			String operatingCarrierCode = flightOffer.getItineraries().get(0).getSegments().get(0).getOperating()
					.getCarrierCode();
			if (!carrierCode.equals(operatingCarrierCode)) {
				flightDTO.setOperatingAirlineCode(operatingCarrierCode);
				flightDTO.setOperatingAirlineName(getAirlineNameByCode(airlines, operatingCarrierCode));
			}

			// Set total flight time
			Duration totalFlightTime = Duration.ZERO;
			for (Segment segment : flightOffer.getItineraries().get(0).getSegments()) {
				totalFlightTime = totalFlightTime
						.plus(calculateDuration(segment.getDeparture().getAt(), segment.getArrival().getAt()));
			}
			flightDTO.setTotalFlightTime(totalFlightTime.toString());

			// Set stops
			List<StopDTO> stops = new ArrayList<>();
			for (Segment segment : flightOffer.getItineraries().get(0).getSegments()) {
				StopDTO stopDTO = new StopDTO();
				stopDTO.setAirportCode(segment.getArrival().getIataCode());
				stopDTO.setAirportName(getAirportNameByCode(airports, segment.getArrival().getIataCode()));
				stopDTO.setLayoverTime(segment.getDuration());
				stops.add(stopDTO);
			}
			flightDTO.setStops(stops);

			// Set prices
			double totalPrice = Double.parseDouble(flightOffer.getPrice().getGrandTotal());
			flightDTO.setTotalPrice(totalPrice);
			int numberOfTravelers = flightOffer.getTravelerPricings().size();
			flightDTO.setPricePerTraveler(totalPrice / numberOfTravelers);

			// Set segments
			int counter = 0;
			List<SegmentDTO> segmentDTOs = new ArrayList<>();
			for (Segment segment : flightOffer.getItineraries().get(0).getSegments()) {
				SegmentDTO segmentDTO = new SegmentDTO();
				counter = counter + 1;
				segmentDTO.setDepartureTime(segment.getDeparture().getAt());
				segmentDTO.setArrivalTime(segment.getArrival().getAt());
				segmentDTO.setDepartureAirportCode(segment.getDeparture().getIataCode());
				segmentDTO
						.setDepartureAirportName(getAirportNameByCode(airports, segment.getDeparture().getIataCode()));
				segmentDTO.setArrivalAirportCode(segment.getArrival().getIataCode());
				segmentDTO.setArrivalAirportName(getAirportNameByCode(airports, segment.getArrival().getIataCode()));
				segmentDTO.setCarrierCode(segment.getCarrierCode());
				segmentDTO.setCarrierName(getAirlineNameByCode(airlines, segment.getCarrierCode()));
				segmentDTO.setFlightNumber(segment.getNumber());
				segmentDTO.setOperatingCarrierCode(segment.getOperating().getCarrierCode());
				segmentDTO.setOperatingCarrierName(
						getAirlineNameByCode(airlines, segment.getOperating().getCarrierCode()));
				segmentDTO.setAircraftType(segment.getAircraft().getCode());

				// FareDetails
				for (TravelerPricing travelerPricing : flightOffer.getTravelerPricings()) {
					for (FareDetailsBySegment fareDetails : travelerPricing.getFareDetailsBySegment()) {
						if (fareDetails.getSegmentId().equals(segment.getId())) {
							segmentDTO.setCabin(fareDetails.getCabin());
							segmentDTO.setFareBasis(fareDetails.getFareBasis());
							segmentDTO.setFlightClass(fareDetails.getFlightClass());
						}
					}
				}

				// Set amenities
				List<AmenityDTO> amenities = new ArrayList<>();
				for (TravelerPricing travelerPricing : flightOffer.getTravelerPricings()) {
					for (FareDetailsBySegment fareDetails : travelerPricing.getFareDetailsBySegment()) {
						if (fareDetails.getSegmentId().equals(segment.getId())) {
							for (Amenity amenity : fareDetails.getAmenities()) {
								AmenityDTO amenityDTO = new AmenityDTO();
								amenityDTO.setName(amenity.getDescription());
								amenityDTO.setChargeable(amenity.isChargeable());
								amenities.add(amenityDTO);
							}
						}
					}
				}
				segmentDTO.setAmenities(amenities);

				// Set layover time
				segmentDTO.setLayoverTime(segment.getDuration());

				segmentDTOs.add(segmentDTO);
			}
			flightDTO.setSegments(segmentDTOs);

			// Set price breakdown
			PriceBreakdownDTO priceBreakdown = new PriceBreakdownDTO();
			priceBreakdown.setBasePrice(flightOffer.getPrice().getBase());
			priceBreakdown.setTotalPrice(flightOffer.getPrice().getGrandTotal());
			List<FeeDTO> fees = new ArrayList<>();
			for (Fee fee : flightOffer.getPrice().getFees()) {
				FeeDTO feeDTO = new FeeDTO();
				feeDTO.setAmount(fee.getAmount());
				feeDTO.setType(fee.getType());
				fees.add(feeDTO);
			}
			priceBreakdown.setFees(fees);
			priceBreakdown.setPricePerTraveler(String.valueOf(flightDTO.getPricePerTraveler()));
			flightDTO.setPriceBreakdown(priceBreakdown);

			flightDTOs.add(flightDTO);
		}
		return flightDTOs;
	}

	public List<FlightDTO> sortFlights(List<FlightDTO> flights, String orderPrice, String orderDuration) {
	    Comparator<FlightDTO> comparator = Comparator.comparing(FlightDTO::getTotalPrice);

	    if ("desc".equalsIgnoreCase(orderPrice)) {
	        comparator = comparator.reversed();
	    }

	    if (orderDuration != null) {
	        Comparator<FlightDTO> durationComparator = Comparator.comparing(flight -> Duration.parse(flight.getTotalFlightTime()));
	        if ("desc".equalsIgnoreCase(orderDuration)) {
	            durationComparator = durationComparator.reversed();
	        }
	        comparator = comparator.thenComparing(durationComparator);
	    }

	    flights.sort(comparator);

	    return flights;
	}


	public List<IataCodeDTO> getIataCodes(String keyword) {
		String jsonResponse = mockFlight.getMockAirport();
		List<IataCodeDTO> iataCodes = parseIataCodes(jsonResponse, keyword);
		return iataCodes;
	}

	private List<IataCodeDTO> parseIataCodes(String jsonResponse, String keyword) {
		List<IataCodeDTO> iataCodes = new ArrayList<>();
		try {
			JsonNode root = objectMapper.readTree(jsonResponse);
			JsonNode data = root.path("data");

			for (JsonNode node : data) {
				String name = node.path("name").asText();
				String iataCode = node.path("iataCode").asText();
				if (name.toLowerCase().contains(keyword.toLowerCase())
						|| iataCode.toLowerCase().contains(keyword.toLowerCase())) {
					IataCodeDTO iataCodeDTO = new IataCodeDTO();
					iataCodeDTO.setName(name);
					iataCodeDTO.setIataCode(iataCode);
					iataCodes.add(iataCodeDTO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iataCodes;
	}

}

