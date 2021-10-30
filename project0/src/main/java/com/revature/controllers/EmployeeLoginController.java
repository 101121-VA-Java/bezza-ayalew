package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.services.EmployeeService;

public class EmployeeLoginController {

	private static EmployeeService es = new EmployeeService();
	private static Employee principal;
	private static Scanner empScan;
	
	public static void run(Scanner scan) {
		empScan = scan;
		System.out.println("EMPLOYEE LOGIN PAGE");
		System.out.println();
		System.out.println("Please enter your username:");
		String username = empScan.nextLine();
		System.out.println("Please enter your password:");
		String password = empScan.nextLine();
		
		try {
			principal = es.login(username, password);

			
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
		}
		if(principal.getRole() == Role.BASIC_EMP) {
			//Add EmployeeMenu() with BASIC_EMP privileges
		}
		if(principal.getRole() == Role.MANAGER) {
			//Add ManagerMenu() with MANAGER privileges
		}
	}
	
	public static void EmployeeMenu() {
		
	}
	
	public static void ManagerMenu() {
		
	}
	
	public static void AdminMenu() {
		
	}
}
