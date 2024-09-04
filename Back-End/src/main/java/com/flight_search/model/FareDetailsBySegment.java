package com.flight_search.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FareDetailsBySegment {
    private String segmentId;
    private String cabin;
    private String fareBasis;
    private String brandedFare;
    private String brandedFareLabel;
    
    @JsonProperty("class")
    private String flightClass;
    private IncludedCheckedBags includedCheckedBags;
    private List<Amenity> amenities;
    
	public String getBrandedFare() {
		return brandedFare;
	}
	public void setBrandedFare(String brandedFare) {
		this.brandedFare = brandedFare;
	}
	public String getBrandedFareLabel() {
		return brandedFareLabel;
	}
	public void setBrandedFareLabel(String brandedFareLabel) {
		this.brandedFareLabel = brandedFareLabel;
	}
	public List<Amenity> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}
	public String getSegmentId() {
		return segmentId;
	}
	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public String getFareBasis() {
		return fareBasis;
	}
	public void setFareBasis(String fareBasis) {
		this.fareBasis = fareBasis;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public IncludedCheckedBags getIncludedCheckedBags() {
		return includedCheckedBags;
	}
	public void setIncludedCheckedBags(IncludedCheckedBags includedCheckedBags) {
		this.includedCheckedBags = includedCheckedBags;
	}

    // Getters and Setters
    
    
    
}
