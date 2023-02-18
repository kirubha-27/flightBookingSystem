package com.flightBooking.Booking;

import java.util.List;

import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;
import com.flightBooking.repository.FlightRepository;

public class BookingModel implements BookingModelCallBack{
	private static int passengerId = 0;
	private BookingControllerModelCallBack bookingController;
	
	public BookingModel(BookingController bookingController) {
		this.bookingController = bookingController;
	}
	
	public void checkAvailability(String boardingPoint, String destination) {
		List<Flight> availableFlights = FlightRepository.getInstance().checkAvailability(boardingPoint, destination);
		bookingController.flightsAvailable(availableFlights);
	}
	public void bookTicket(int flightId, String passengerName, int passengerAge) {
		passengerId++;
		Passenger passenger = FlightRepository.getInstance().bookTicket(passengerId,flightId, passengerName, passengerAge);
		if(passenger!=null)
			bookingController.bookingSuccess(passenger);
		else
			bookingController.bookingFailure("No more seats are available");

	}

	public void cancelTicket(int passengerId, int flightId){
		Passenger passenger = FlightRepository.getInstance().cancelTicket(passengerId,flightId);
		if(passenger!=null){
			bookingController.cancelTicketSuccess(passenger);
		}else{
			bookingController.cancelTicketFailure("There is no ticket booked in this User ID");
		}
	}
}
