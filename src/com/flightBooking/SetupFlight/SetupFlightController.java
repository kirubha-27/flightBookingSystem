package com.flightBooking.SetupFlight;

import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;

import java.util.List;

public class SetupFlightController implements SetupFlightControllerViewCallBack,SetupFlightControllerModelCallBack {
	private SetupFlightViewCallBack setupFlightView;
	private SetupFlightModelCallBack setupFlightModel;
	
	public SetupFlightController(SetupFlightView setupFlightView) {
		this.setupFlightView = setupFlightView;
		this.setupFlightModel = new SetupFlightModel(this);
	}
	
	public void setFlight(int flightId,String flightName,int seatingCapacity,String fromCity,String toCity,float ticketPrice) {
		setupFlightModel.setFlight(flightId,flightName,seatingCapacity,fromCity,toCity,ticketPrice);
	}
	
	public void flightAddedSuccessfully(Flight flight) {
		setupFlightView.flightAddedSuccessfully(flight);
	}
	
	public void flightAddingFailed(String errorMessage) {
		setupFlightView.flightAddingFailed(errorMessage);
	}

	public List<Flight> getFlights(){
		return setupFlightModel.getFlights();
	}
	public List<Passenger> getPassengers(){
		return setupFlightModel.getPassengers();
	}
}
