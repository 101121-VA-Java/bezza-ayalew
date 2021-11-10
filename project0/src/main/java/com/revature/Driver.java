package com.revature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.revature.controllers.*;
import com.revature.daos.CustomerPostgres;
import com.revature.exceptions.LoginException;
import com.revature.services.EmployeeService;


public class Driver {

	public static void main(String[] args) throws IOException, LoginException {
		Scanner sc = new Scanner(System.in);
		FrontController fc = new FrontController();
		EmployeeLoginController elc = new EmployeeLoginController();
		CustomerLoginController clc = new CustomerLoginController();
		ItemController ic = new ItemController();
		PaymentController pc = new PaymentController();
		EmployeeController ec = new EmployeeController();
		RegisterController rc = new RegisterController();
		EmployeeService es = new EmployeeService();
		
		FrontController.runMenu();

	}
}
