package com.revature.controllers;

import java.util.Scanner;

public class FrontController {
	
	private static Scanner sc = new Scanner(System.in);
	private static EmployeeLoginController newEmpLogin = new EmployeeLoginController();
	
	public static void runMenu() {
		boolean run = true;
		while(run) {
			System.out.println("Welcome to Horizon Antiques! Please select from the following options:"
					+ "\nCUSTOMERS							EMPLOYEES"		
					+ "\n1: Login							4: Login"
					+ "\n2: Register						5: Exit"
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
			case "4":
				System.out.println("Redirecting to Employee login page");
				newEmpLogin.run(sc);
				break;
			case "5":
				System.out.println("Goodbye!");
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
