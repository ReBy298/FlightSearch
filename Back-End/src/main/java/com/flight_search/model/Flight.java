package com.flight_search.model;

import java.util.List;

public class Flight {

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

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	private String departureAirport;
    private String arrivalAirport;
    private String departureDate;
    private String arrivalDate;
    private String airline;
    private double price;
    private List<Segment> segments;

    // Getters and Setters

    public static class Segment {
        private String departureAirport;
        private String arrivalAirport;
        private String departureDate;
        private String arrivalDate;
        private String carrierCode;
        private String flightNumber;
        private String aircraft;
        private String cabin;
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
		public String getCarrierCode() {
			return carrierCode;
		}
		public void setCarrierCode(String carrierCode) {
			this.carrierCode = carrierCode;
		}
		public String getFlightNumber() {
			return flightNumber;
		}
		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}
		public String getAircraft() {
			return aircraft;
		}
		public void setAircraft(String aircraft) {
			this.aircraft = aircraft;
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
		public int getStops() {
			return stops;
		}
		public void setStops(int stops) {
			this.stops = stops;
		}
		private String fareBasis;
        private String flightClass;
        private int stops;

        // Getters and Setters
    }
}

