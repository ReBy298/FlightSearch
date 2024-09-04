package com.flight_search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SegmentDTO {
    private String departureTime;
    private String arrivalTime;
    private String departureAirportName;
    private String departureAirportCode;
    private String arrivalAirportName;
    private String arrivalAirportCode;
    private String carrierCode;
    private String carrierName;
    private String flightNumber;
    private String operatingCarrierCode;
    private String operatingCarrierName;
    private String aircraftType;
    private String cabin;
    private String fareBasis;
   
    @JsonProperty("class")
    private String flightClass;
    
    private List<AmenityDTO> amenities;
    private String layoverTime;
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
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
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOperatingCarrierCode() {
		return operatingCarrierCode;
	}
	public void setOperatingCarrierCode(String operatingCarrierCode) {
		this.operatingCarrierCode = operatingCarrierCode;
	}
	public String getOperatingCarrierName() {
		return operatingCarrierName;
	}
	public void setOperatingCarrierName(String operatingCarrierName) {
		this.operatingCarrierName = operatingCarrierName;
	}
	public String getAircraftType() {
		return aircraftType;
	}
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
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
	public List<AmenityDTO> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<AmenityDTO> amenities) {
		this.amenities = amenities;
	}
	public String getLayoverTime() {
		return layoverTime;
	}
	public void setLayoverTime(String layoverTime) {
		this.layoverTime = layoverTime;
	}
    
    
    
    
}
