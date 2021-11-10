package com.revature.controllers;

import java.io.IOException;
import java.util.Scanner;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class RegisterController {

	private static CustomerService cs = new CustomerService();
	
	public static void run(Scanner sc) throws IOException {
		System.out.println();
		System.out.println("Please enter your full name)");
		String name = sc.nextLine();
		System.out.println("Please enter your username: at least 4 char");
		String username = sc.nextLine();
		if(username.trim().length() < 3) {
			System.out.println("Your username should be at least 4 characters.");
			return;
		}
		
		System.out.println("Please enter your password: at least 4 char");
		String password = sc.nextLine();
		if(password.trim().length() < 3) {
			System.out.println("Your password should be at least 4 characters.");
			return;
		}
		
		Customer newCustomer = new Customer(name, username, password);
		
		try {
			newCustomer = cs.register(newCustomer);
			System.out.println("Welcome " + newCustomer.getName() + "!");
//			Redirect the new customer to customerLogin page
		} catch (UsernameAlreadyExistsException e) {
			System.out.println("Username is already in use.\nPlease try again.");
		}
	}
}
