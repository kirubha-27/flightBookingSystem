package com.flightBooking.Booking;

import java.util.List;

import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;

public class BookingController implements BookingControllerModelCallBack,BookingControllerViewCallBack{
	private BookingViewCallBack bookingView;
	
	private BookingModelCallBack bookingModel;
	
	public BookingController(BookingView bookingView) {
		this.bookingView = bookingView;
		this.bookingModel = new BookingModel(this);
	}
	
	public void checkAvailability(String boardingPoint, String destination) {
		bookingModel.checkAvailability(boardingPoint,destination);
	}
	public void flightsAvailable(List<Flight> availableFlights) {
		bookingView.flightsAvailable(availableFlights);
	}
	
	public void bookTicket(int flightId, String passengerName, int passengerAge) {
		bookingModel.bookTicket(flightId, passengerName, passengerAge);
	}
	
	public void bookingSuccess(Passenger passenger) {
		bookingView.bookingSuccess(passenger);
	}

	public void bookingFailure(String errorMessage){
		bookingView.bookingFailure(errorMessage);
	}

	public void cancelTicket(int passengerId, int flightId){
		bookingModel.cancelTicket(passengerId,flightId);
	}
	public void cancelTicketSuccess(Passenger passenger){
		bookingView.cancelTicketSuccess(passenger);
	}
	public void cancelTicketFailure(String errorMessage){
		bookingView.cancelTicketFailure(errorMessage);
	}
}
