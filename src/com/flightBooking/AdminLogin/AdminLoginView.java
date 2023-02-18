package com.flightBooking.AdminLogin;

import java.util.Scanner;

import com.flightBooking.SetupFlight.SetupFlightView;
import com.flightBooking.dto.Admin;

public class AdminLoginView implements AdminLoginViewCallBack{
	private AdminLoginControllerViewCallBack adminLoginController;
	
	private Scanner scanner = new Scanner(System.in);
	
	public AdminLoginView() {
		adminLoginController = new AdminLoginController(this);
	}
	
	public void create() {
		checkForLogin();
	}
	
	private void checkForLogin() {
		System.out.flush();
		System.out.println("----------->Admin Login<-----------");
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		adminLoginController.checkCredentials(userName, password);	
	}
	
	public void loginSuccess(Admin admin) {
		System.out.println("------>welcome "+admin.getUserName()+"<------");
		SetupFlightView setupFlightView = new SetupFlightView();
		setupFlightView.create();
	}
	
	public void loginFailure(String errorMessage) {
		System.out.println(errorMessage);
	}
}
