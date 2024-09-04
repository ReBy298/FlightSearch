package com.flight_search.dto;

import java.util.List;

public class PriceBreakdownDTO {
    private String basePrice;
    private String totalPrice;
    private List<FeeDTO> fees;
    private String pricePerTraveler;
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<FeeDTO> getFees() {
		return fees;
	}
	public void setFees(List<FeeDTO> fees) {
		this.fees = fees;
	}
	public String getPricePerTraveler() {
		return pricePerTraveler;
	}
	public void setPricePerTraveler(String pricePerTraveler) {
		this.pricePerTraveler = pricePerTraveler;
	}
    
}
