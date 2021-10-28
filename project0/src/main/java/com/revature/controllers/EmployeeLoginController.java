package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.services.EmployeeService;

public class EmployeeLoginController {

	private static EmployeeService es = new EmployeeService();
	private static Employee principal;
	private static Scanner sc;
	
	public static void run(Scanner scan) {
		sc = scan;
		
		System.out.println();
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		
		try {
			principal = es.login(username, password);

			
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
		}
	}
	
	public static void EmployeeMenu() {
		
	}
	
	public static void ManagerMenu() {
		
	}
	
	public static void AdminMenu() {
		
	}
}
