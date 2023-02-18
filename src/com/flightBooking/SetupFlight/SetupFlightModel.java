package com.flightBooking.SetupFlight;

import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;
import com.flightBooking.repository.FlightRepository;

import java.util.List;

public class SetupFlightModel implements SetupFlightModelCallBack{
	private SetupFlightControllerModelCallBack setupFlightController;
	
	public SetupFlightModel(SetupFlightController setupFlightController) {
		this.setupFlightController = setupFlightController;
	}
	
	public void setFlight(int flightId,String flightName,int seatingCapacity,String fromCity,String toCity,float ticketPrice) {
		Flight flight = FlightRepository.getInstance().CheckValidFlight(flightId, flightName, seatingCapacity, fromCity, toCity,ticketPrice);
		
		if(flight!=null) {
			setupFlightController.flightAddedSuccessfully(flight);
		}else {
			setupFlightController.flightAddingFailed("Flight is already exist");
		}
	}
	public List<Passenger> getPassengers(){
		return FlightRepository.getInstance().getPassengers();
	}
	public List<Flight> getFlights(){
		List<Flight> flightList = FlightRepository.getInstance().getAllFlights();
		return flightList;
	}
}
