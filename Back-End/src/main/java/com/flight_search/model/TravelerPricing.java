package com.flight_search.model;

import java.util.List;

public class TravelerPricing {
    private String travelerId;
    private String fareOption;
    private String travelerType;
    private Price price;
    private List<FareDetailsBySegment> fareDetailsBySegment;
	public String getTravelerId() {
		return travelerId;
	}
	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}
	public String getFareOption() {
		return fareOption;
	}
	public void setFareOption(String fareOption) {
		this.fareOption = fareOption;
	}
	public String getTravelerType() {
		return travelerType;
	}
	public void setTravelerType(String travelerType) {
		this.travelerType = travelerType;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public List<FareDetailsBySegment> getFareDetailsBySegment() {
		return fareDetailsBySegment;
	}
	public void setFareDetailsBySegment(List<FareDetailsBySegment> fareDetailsBySegment) {
		this.fareDetailsBySegment = fareDetailsBySegment;
	}

    // Getters and Setters
    
    
}
