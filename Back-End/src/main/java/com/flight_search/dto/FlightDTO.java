package com.flight_search.dto;

import java.util.List;

public class FlightDTO {
    private String departureAirport;
    private String arrivalAirport;
    private String departureDate;
    private String arrivalDate;
    private String airline;
    private String operatingAirline;
    private String totalTime;
    private double price;
    private double pricePerTraveler;
    private List<SegmentDTO> segments;
    
    

   
    public String getOperatingAirline() {
		return operatingAirline;
	}

	public void setOperatingAirline(String operatingAirline) {
		this.operatingAirline = operatingAirline;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public double getPricePerTraveler() {
		return pricePerTraveler;
	}

	public void setPricePerTraveler(double pricePerTraveler) {
		this.pricePerTraveler = pricePerTraveler;
	}

	// Getters and Setters
    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
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
}
