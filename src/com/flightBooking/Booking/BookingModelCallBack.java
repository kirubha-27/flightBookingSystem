package com.flightBooking.Booking;

public interface BookingModelCallBack {
	public void checkAvailability(String boardingPoint, String destination);
	public void bookTicket(int flightId, String passengerName, int passengerAge);
	public void cancelTicket(int passengerId, int flightId);
}
