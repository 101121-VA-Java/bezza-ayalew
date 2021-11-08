package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeLoginController {

	private static EmployeeService es = new EmployeeService();
	private static Employee emp;
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
			emp = es.empLogin(username, password);
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
		}
		if(emp.getEmpRole() == "Manager") {
			System.out.println("Please select from the following options and enter the option number: "
								+ "====================================================================="
								+ "\n1. Add/remove item"
								+ "\n2. Approve offer"
								+ "\n3. View payment"
								+ "\n4. Add/remove new employee"
								+ "\n5. View sales history");
			String managerWantsTo = empScan.nextLine();
		}
		if(emp.getEmpRole() == "Basic_Employee") {
			System.out.println("Please select from the following options and enter the option number: "
					+ "====================================================================="
					+ "\n1. Add/remove item"
					+ "\n2. Approve offer"
					+ "\n3. View payment");
			String employeeWantsTo = empScan.nextLine();
		}
	}
}
