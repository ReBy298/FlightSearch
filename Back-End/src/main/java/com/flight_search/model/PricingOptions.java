package com.flight_search.model;

import java.util.List;

public class PricingOptions {
    private List<String> fareType;
    private boolean includedCheckedBagsOnly;
	public List<String> getFareType() {
		return fareType;
	}
	public void setFareType(List<String> fareType) {
		this.fareType = fareType;
	}
	public boolean isIncludedCheckedBagsOnly() {
		return includedCheckedBagsOnly;
	}
	public void setIncludedCheckedBagsOnly(boolean includedCheckedBagsOnly) {
		this.includedCheckedBagsOnly = includedCheckedBagsOnly;
	}

    // Getters and Setters
    
    
}
