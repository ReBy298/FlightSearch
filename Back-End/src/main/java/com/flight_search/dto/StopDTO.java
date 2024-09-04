package com.flight_search.dto;

public class StopDTO {
    private String airportName;
    private String airportCode;
    private String layoverTime;
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getLayoverTime() {
		return layoverTime;
	}
	public void setLayoverTime(String layoverTime) {
		this.layoverTime = layoverTime;
	}
    
    
}
