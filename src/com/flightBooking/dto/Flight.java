package com.flightBooking.dto;

public class Flight {
	private int flightId;
	
	private String flightName;
	
	private int seatingCapacity;
	
	private String fromCity;
	
	private String toCity;
	
	private float ticketPrice;

	private int currentCapacity;
	
	public Flight(int flightId, String flightName, int seatingCapacity, String fromCity ,String toCity, float ticketPrice) {
		this.flightId = flightId;
		this.flightName = flightName;
		this.ticketPrice = ticketPrice;
		this.seatingCapacity = seatingCapacity;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.currentCapacity = seatingCapacity;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public float getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	
	
}
