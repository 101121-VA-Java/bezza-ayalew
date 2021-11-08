package com.revature.controllers;

import java.util.Scanner;
import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class CustomerLoginController {

	private static CustomerService cs = new CustomerService();
	private static Scanner sc;
	
	public static void run(Scanner scan) {
		sc = scan;		
		System.out.println();
		System.out.println("CUSTOMER LOGIN PAGE");
		System.out.println("====================");
		System.out.println();
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		
		try {
			login(username, password);
			
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
		}
	}
	public static Customer login(String username, String password) throws LoginException {
		Customer cust = cs.customerLogin(username, password);
		System.out.println("Login successful!");
		return cust;
	}
}
