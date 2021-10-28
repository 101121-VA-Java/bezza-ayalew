package com.revature.controllers;

import java.util.Scanner;

public class FrontController {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void runMenu() {
		boolean run = true;
		while(run) {
			System.out.println("Welcome to RevaCompany! Please select from the following options:"
					+ "\n1: Login"
					+ "\n2: Register"
					+ "\n3: Exit");
			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				System.out.println("Login in creation");
				System.out.println();
				break;
			case "2":
				RegisterController.run(sc);
				System.out.println();
				break;
			case "3":
				System.out.println("Thanks for visiting! Come again.");
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
				System.out.println();
			}
		}
		sc.close();
	}
}
