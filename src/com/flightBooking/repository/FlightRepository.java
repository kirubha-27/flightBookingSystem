package com.flightBooking.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.flightBooking.dto.Admin;
import com.flightBooking.dto.AdminCredentials;
import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;
import com.flightBooking.dto.User;
import com.flightBooking.dto.UserCredentials;

public class FlightRepository {
	public static FlightRepository flightRepository;
	
	private List<UserCredentials> userCredentials = new ArrayList<>();
	
	private List<AdminCredentials> adminCredentials = new ArrayList<>();
	
	private List<Flight> flights = new ArrayList<>();
	
	private List<Passenger> passengers = new ArrayList<>(); 
	
	private FlightRepository() {
		
	}

	public static FlightRepository getInstance() {
		if(flightRepository==null) {
			flightRepository = new FlightRepository();
			flightRepository.initialUserSetUp();
			flightRepository.initialAdminSetUp();
			flightRepository.initialFlightSetUp();
		}
		return flightRepository;
	}
	
	public Passenger bookTicket(int passengerId,int flightId, String passengerName, int passengerAge) {
		Flight tempFlight = null;
		for (Flight flight : flights) {
			if (flight.getFlightId() == flightId) {
				tempFlight = flight;
				break;
			}
		}
		if (tempFlight != null && tempFlight.getCurrentCapacity()>0) {
			passengers.add(new Passenger(passengerId, passengerName, passengerAge, flightId));
			tempFlight.setCurrentCapacity(tempFlight.getCurrentCapacity()-1);
			return passengers.get(passengers.size() - 1);
		}
		return null;
	}


	
	private void initialFlightSetUp() {
		flights.add(new Flight(702,"Air Asia",10,"chennai","thiruvarur",5000));
		flights.add(new Flight(843,"Air India",10,"Chennai","Madurai",1));
	}
	private void initialAdminSetUp() {
		adminCredentials.add(new AdminCredentials(1,"kirubha","250784"));
		adminCredentials.add(new AdminCredentials(2,"gokul","250783"));
	}
	
	private void initialUserSetUp() {
		userCredentials.add(new UserCredentials(1,"gokul","250784"));
		
	}
	public List<Passenger> getPassengers(){
		return passengers;
	}
	public Passenger cancelTicket(int passengerId, int flightId){

		for(Passenger passenger:passengers){
			if(passenger.getUserId()==passengerId&&passenger.getFlightId()==flightId){
				Passenger tempPassenger=new Passenger(passenger.getUserId(),passenger.getPassengerName(),passenger.getPassengerAge(),passenger.getFlightId());

				for(Flight flight:flights){

					if(flight.getFlightId()==flightId){
						if(flight.getCurrentCapacity()==flight.getSeatingCapacity()){
							return null;
						}
						flight.setCurrentCapacity(flight.getCurrentCapacity()+1);
					}
				}
				passengers.remove(passenger);

				return tempPassenger;
			}
		}
		return null;
	}
	public List<Flight> checkAvailability(String boardingPoint, String destination) {
		List<Flight> flightAvailable = new ArrayList<>();
		for(Flight flight:flights) {
			if((flight.getFromCity().equals(boardingPoint)&&flight.getToCity().equals(destination))&&flight.getCurrentCapacity()>=1) {
				flightAvailable.add(flight);
			}
		}
		return flightAvailable;
	}
	public List<Flight> getAllFlights(){
		return flights;
	}
	
	public Flight CheckValidFlight(int flightId,String flightName,int seatingCapacity,String fromCity,String toCity,float ticketPrice) {
		for(Flight flight:flights) {
			if(flight.getFlightId()!=flightId) {
				Flight f = new Flight(flightId,flightName,seatingCapacity,fromCity,toCity,ticketPrice);
				flights.add(f);
				return f;

			}
		}
		return null;
	}
	
	public User checkValidUser(String userName,String password) {
		for(UserCredentials credentials:userCredentials) {
			if(credentials.getUserName().equals(userName)&&credentials.getPassword().equals(password)) {
				return credentials;
			}
		}
		return null;
	}
	
	public Admin checkValidAdmin(String userName,String password) {
		for(AdminCredentials credentials:adminCredentials) {
			if(credentials.getUserName().equals(userName)&&credentials.getPassword().equals(password)) {
				return credentials;
			}
		}
		return null;
	}
	
}
