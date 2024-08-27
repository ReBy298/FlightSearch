package com.flight_search.dto;

import java.util.List;

public class FlightDTO {
    private String departureAirport;
    private String arrivalAirport;
    private String departureDate;
    private String arrivalDate;
    private String airline;
    private double price;
    private List<SegmentDTO> segments;
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<SegmentDTO> getSegments() {
		return segments;
	}
	public void setSegments(List<SegmentDTO> segments) {
		this.segments = segments;
	}

    // Getters and Setters
}