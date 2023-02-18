package com.flightBooking.Booking;

import java.util.List;
import java.util.Scanner;

import com.flightBooking.dto.Flight;
import com.flightBooking.dto.Passenger;

public class BookingView implements BookingViewCallBack{
	private BookingControllerViewCallBack bookingController;
	
	private Scanner scanner = new Scanner(System.in);
	
	public BookingView() {
		bookingController = new BookingController(this);
	}
	
	public void create() {
		show();
	}
	private void show(){
		boolean flag = true;
		while (flag){
			System.out.println("1.book ticket");
			System.out.println("2.cancel ticket");
			System.out.println("3.logout");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
				case 1: addPassenger();
					break;
				case 2:
					removePassenger();
					break;
				case 3:
					flag = false;
					break;
			}
		}
	}
	private void addPassenger() {
		//System.out.println("-------->Welcome to flight booking<----------");
		System.out.println("Enter the Boarding Point: ");
		String boardingPoint = scanner.nextLine();
		System.out.println("Enter the Destination: ");
		String destination = scanner.nextLine();
		bookingController.checkAvailability(boardingPoint,destination);
	}

	private void removePassenger(){
		System.out.println("Enter the Passenger ID: ");
		int passengerId = scanner.nextInt();
		System.out.println("Enter Flight ID: ");
		int flightId = scanner.nextInt();
		bookingController.cancelTicket(passengerId, flightId);
	}
	
	public void flightsAvailable(List<Flight> availableFlights) {
		if(availableFlights.size()!=0) {
			displayFlights(availableFlights);
			createBooking();
		}else {
			System.out.println("sorry........Flights are not available");
		}
		
	}
	
	private void createBooking() {
		System.out.println("Enter Flight Id: ");
		int flightId = scanner.nextInt();
		System.out.println("Enter Passenger Name: ");
		scanner.nextLine();
		String passengerName = scanner.nextLine();
		
		System.out.println("Enter Passenger Age: ");
		int passengerAge = scanner.nextInt();
		bookingController.bookTicket(flightId,passengerName,passengerAge);
	}
	
	private void displayFlights(List<Flight> flights) {
		System.out.println("------------------>Flights on Service<-------------------");
		System.out.println();
		for(Flight flight:flights) {
			
			System.out.println("Flight ID: "+flight.getFlightId()+"| Flight Name: "+flight.getFlightName()+"| No Of Seats: "+flight.getSeatingCapacity()+"| No of Seats Available: "+flight.getCurrentCapacity()+"| Boarding Point: "+flight.getFromCity()+"| Destination: "+flight.getToCity()+"| Ticket Price: "+flight.getTicketPrice());
			
		}
	}
	public void bookingSuccess(Passenger passenger) {
		System.out.println("passenger id: "+passenger.getUserId()+" Flight ID: "+passenger.getFlightId()+"passenger Name: "+passenger.getPassengerName());
		System.out.println("booked successfully");

	}
	public void bookingFailure(String errorMessage){
		System.out.println(errorMessage);
	}

	public void cancelTicketSuccess(Passenger passenger){
		System.out.println("Passenger ID: "+passenger.getUserId()+" Flight ID: "+passenger.getFlightId()+" are successfully cancelled");
	}

	public void cancelTicketFailure(String errorMessage){
		System.out.println(errorMessage);
	}
}
