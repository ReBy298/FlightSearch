package com.flight_search.dto;

import java.util.List;

public class FlightDTO {
	private String id;
    private String initialDepartureDateTime;
    private String finalArrivalDateTime;
    private String departureAirportName;
    private String departureAirportCode;
    private String arrivalAirportName;
    private String arrivalAirportCode;
    private String airlineName;
    private String airlineCode;
    private String operatingAirlineName;
    private String operatingAirlineCode;
    private String totalFlightTime;
    private List<StopDTO> stops;
    private double totalPrice;
    private double pricePerTraveler;
    private List<SegmentDTO> segments;
    private PriceBreakdownDTO priceBreakdown;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PriceBreakdownDTO getPriceBreakdown() {
		return priceBreakdown;
	}
	public void setPriceBreakdown(PriceBreakdownDTO priceBreakdown) {
		this.priceBreakdown = priceBreakdown;
	}
	public String getInitialDepartureDateTime() {
		return initialDepartureDateTime;
	}
	public void setInitialDepartureDateTime(String initialDepartureDateTime) {
		this.initialDepartureDateTime = initialDepartureDateTime;
	}
	public String getFinalArrivalDateTime() {
		return finalArrivalDateTime;
	}
	public void setFinalArrivalDateTime(String finalArrivalDateTime) {
		this.finalArrivalDateTime = finalArrivalDateTime;
	}
	public String getDepartureAirportName() {
		return departureAirportName;
	}
	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}
	public String getArrivalAirportName() {
		return arrivalAirportName;
	}
	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}
	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}
	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	public String getOperatingAirlineName() {
		return operatingAirlineName;
	}
	public void setOperatingAirlineName(String operatingAirlineName) {
		this.operatingAirlineName = operatingAirlineName;
	}
	public String getOperatingAirlineCode() {
		return operatingAirlineCode;
	}
	public void setOperatingAirlineCode(String operatingAirlineCode) {
		this.operatingAirlineCode = operatingAirlineCode;
	}
	public String getTotalFlightTime() {
		return totalFlightTime;
	}
	public void setTotalFlightTime(String totalFlightTime) {
		this.totalFlightTime = totalFlightTime;
	}
	public List<StopDTO> getStops() {
		return stops;
	}
	public void setStops(List<StopDTO> stops) {
		this.stops = stops;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getPricePerTraveler() {
		return pricePerTraveler;
	}
	public void setPricePerTraveler(double pricePerTraveler) {
		this.pricePerTraveler = pricePerTraveler;
	}
	public List<SegmentDTO> getSegments() {
		return segments;
	}
	public void setSegments(List<SegmentDTO> segments) {
		this.segments = segments;
	}
    
    
    
}