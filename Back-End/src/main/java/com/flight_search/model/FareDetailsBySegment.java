package com.flight_search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FareDetailsBySegment {
    private String segmentId;
    private String cabin;
    private String fareBasis;
    
    @JsonProperty("class")
    private String flightClass;
    private IncludedCheckedBags includedCheckedBags;
    
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
