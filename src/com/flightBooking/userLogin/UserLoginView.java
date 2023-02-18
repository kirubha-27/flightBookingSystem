package com.flightBooking.userLogin;

import java.util.Scanner;

import com.flightBooking.Booking.BookingView;
import com.flightBooking.dto.User;

public class UserLoginView implements UserLoginViewCallBack {
	private UserLoginControllerViewCallBack userLoginController;
	
	private Scanner scanner = new Scanner(System.in);
	
	public UserLoginView() {
		userLoginController = new UserLoginController(this);
		
	}
	
	public void check() {
		System.out.println("-----------Welcome to the User Login----------");
		checkForLogin();
	}
	
	private void checkForLogin() {
		
		System.out.print("Enter the user name: ");
		String userName = scanner.nextLine();
		System.out.println();
		System.out.print("Enter the password: ");
		String password = scanner.nextLine();
		userLoginController.checkCredentials(userName,password);
	}
	
	public void loginSuccess(User user) {
		System.out.println("---->welcome "+user.getUserName()+"<----");
		BookingView bookingView = new BookingView();
		bookingView.create();
	}
	
	public void loginFailure(String errorMessage) {
		System.out.println(errorMessage);
		
		System.out.println("-----------Re-login----------");
		checkForLogin();
		
	}
}
