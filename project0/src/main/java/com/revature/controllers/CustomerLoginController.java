package com.revature.controllers;

import java.io.IOException;
import java.util.Scanner;
import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class CustomerLoginController {

	private static CustomerService cs = new CustomerService();
	private static Scanner sc;
	public static Customer cust = new Customer();
	public static void login(Scanner scan) throws IOException, LoginException {
		sc = scan;		
		System.out.println();
		System.out.println("CUSTOMER LOGIN PAGE");
		System.out.println("====================");
		System.out.println();
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		cust =cs.customerLogin(username, password);
		if(cust != null) {
			CustomerService.services();
//			System.out.println();
//			System.out.println("Please choose from the following options.");
//			System.out.println("\n\n1. View items and shop\n2. Make payment");
//			String choice = sc.nextLine();
//			switch(choice) {
//				case "1":
//					ItemController.printListOfItems(sc);
//					System.out.println();
//					break;
//				case "2":
//					PaymentController.makePayment(sc);
//					System.out.println();
//					break;
//			}
		}

	}
}
