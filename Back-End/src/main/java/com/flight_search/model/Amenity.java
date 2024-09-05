package com.flight_search.model;

import java.util.List;

public class Amenity {
	private String description;
	private boolean isChargeable;
	private String amenityType;
	private AmenityProvider amenityProvider;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isChargeable() {
		return isChargeable;
	}
	public void setChargeable(boolean isChargeable) {
		this.isChargeable = isChargeable;
	}
	public String getAmenityType() {
		return amenityType;
	}
	public void setAmenityType(String amenityType) {
		this.amenityType = amenityType;
	}
	public AmenityProvider getAmenityProvider() {
		return amenityProvider;
	}
	public void setAmenityProvider(AmenityProvider amenityProvider) {
		this.amenityProvider = amenityProvider;
	}
	
	 
	
}
