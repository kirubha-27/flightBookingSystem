package com.flightBooking.Booking;

import java.util.List;

import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;

public interface BookingViewCallBack  {
	public void flightsAvailable(List<Flight> availableFlights);
	public void bookingSuccess(Passenger passenger);
	public void bookingFailure(String errorMessage);
	public void cancelTicketFailure(String errorMessage);
	public void cancelTicketSuccess(Passenger passenger);
}
