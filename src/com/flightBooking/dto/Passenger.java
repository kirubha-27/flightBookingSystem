package com.flightBooking.dto;

public class Passenger {
	private String passengerName;
	
	private int userId;
	
	private int passengerAge;
	
	private int flightId;
	
	

	
	public Passenger(int userId, String passengerName, int passengerAge, int flightId) {
		this.flightId = flightId;
		this.passengerAge = passengerAge;
		this.passengerName = passengerName;
		this.userId = userId;
	}




	public String getPassengerName() {
		return passengerName;
	}




	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public int getPassengerAge() {
		return passengerAge;
	}




	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}




	public int getFlightId() {
		return flightId;
	}




	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}


	
	
}
