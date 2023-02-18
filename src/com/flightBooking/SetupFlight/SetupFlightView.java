package com.flightBooking.SetupFlight;

import java.util.List;
import java.util.Scanner;

import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;

public class SetupFlightView implements SetupFlightViewCallBack{
	private SetupFlightControllerViewCallBack setupFlightController;
	
	private Scanner scanner = new Scanner(System.in);
	
	public SetupFlightView() {
		setupFlightController = new SetupFlightController(this);
	}
	
	public void create() {
		show();
	}
	private void show(){
		boolean flag = true;
		while(flag){
			System.out.println("1.Add Flights");
			System.out.println("2.Show Flights");
			System.out.println("3.Show Passengers");
			System.out.println("4.logout");
			int choice = scanner.nextInt();
			switch (choice){
				case 1: addFlight();
					break;
				case 2: getFlights();
					break;
				case 3:
					getPassengers();
					break;
				case 4:
					flag = false;
					break;
			}
		}
	}
	private void getPassengers(){
		List<Passenger> passengers = setupFlightController.getPassengers();

		if(passengers.size()==0){
			System.out.println("There is no passengers");

		}else{
			displayPassengers(passengers);
		}
	}
	private void displayPassengers(List<Passenger> passengers){
		if(passengers==null){
			System.out.println("There is no passengers");
			return;
		}
		for(Passenger passenger:passengers){
			System.out.println("Passenger ID: "+passenger.getUserId()+" Passenger Name: "+passenger.getPassengerName()+" Flight Id: "+passenger.getFlightId());
		}
	}
	private void addFlight(){
		System.out.println("Enter the flight ID: ");
		int flightId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the name of Flight: ");
		String flightName = scanner.nextLine();

		System.out.println("Enter the Seating Capacity: ");
		int seatingCapacity = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the boarding point: ");
		String fromCity = scanner.nextLine();
		System.out.println("Enter the destination: ");
		String toCity = scanner.nextLine();
		System.out.println("Enter the Ticket Price: ");
		float ticketPrice = scanner.nextFloat();
		setupFlightController.setFlight(flightId,flightName,seatingCapacity,fromCity,toCity,ticketPrice);
	}
	
	public void flightAddedSuccessfully(Flight flight) {
		System.out.println("Flight "+flight.getFlightId()+" is successfully added");
	}
	
	public void flightAddingFailed(String errorMessage) {
		System.out.println(errorMessage);
	}

	public void getFlights(){
		List<Flight> allFlights = setupFlightController.getFlights();
		if(allFlights!=null){
			displayFlights(allFlights);
		}
	}
	private void displayFlights(List<Flight> flights) {
		System.out.println("------------------>Flights on Service<-------------------");
		System.out.println();
		for(Flight flight:flights) {

			System.out.println("Flight ID: "+flight.getFlightId()+"| Flight Name: "+flight.getFlightName()+"| No Of Seats: "+flight.getSeatingCapacity()+"| No of Seats Available: "+flight.getCurrentCapacity()+"| Boarding Point: "+flight.getFromCity()+"| Destination: "+flight.getToCity()+"| Ticket Price: "+flight.getTicketPrice());

		}
	}
}
