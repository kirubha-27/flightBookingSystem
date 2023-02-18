package com.flightBooking.login;

import java.util.Scanner;

import com.flightBooking.AdminLogin.AdminLoginView;
import com.flightBooking.userLogin.UserLoginView;

public class LoginView {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		while(true) {
			
			System.out.println("Welcome to the flight booking app");
			System.out.println("1.User Login");
			System.out.println("2.Admin Login");
			System.out.println("3.Exit");
			choice = scanner.nextInt();
			switch(choice) {
				case 1: UserLoginView userLogin = new UserLoginView();
						userLogin.check();
						break;
				case 2: AdminLoginView adminLogin = new AdminLoginView();
						adminLogin.create();
						break;
				case 3: System.exit(0);
			}
			
		}
	}
}
