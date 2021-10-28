package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class RegisterController {

	private static CustomerService us = new CustomerService();
	
	public static void run(Scanner sc) {
		System.out.println();
		System.out.println("Please enter your name: (at least 4 char)");
		String name = sc.nextLine();
		if(name.trim().length() < 3) {
			System.out.println("Your name should be at least 4 characters.");
			return;
		}
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
			newCustomer = us.addCustomer(newCustomer);
			System.out.println("Welcome " + newCustomer.getName() + "!");
		} catch (UsernameAlreadyExistsException e) {
			System.out.println("Username is already in use.\nPlease try again.");
		}
	}
}
