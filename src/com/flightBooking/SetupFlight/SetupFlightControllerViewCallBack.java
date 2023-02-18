package com.flightBooking.SetupFlight;

import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;

import java.util.List;

public interface SetupFlightControllerViewCallBack {
	public void setFlight(int flightId,String flightName,int seatingCapacity,String fromCity,String toCity,float ticketPrice);
	public List<Flight> getFlights();
	public List<Passenger> getPassengers();
}
