package com.revature.driver;

import java.util.Scanner;

import com.revature.models.Dispatch;
import com.revature.models.Service;
import com.revature.services.OopService;

public class Driver {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Dispatch ns = new Dispatch("ab12d","delivery");
		System.out.println(ns.dispatched());
		OopService oop = new OopService();
		System.out.println("What would like to do?");
		String choice = sc.nextLine();
		switch (choice) {
		case "encapsulation":
			oop.doEncapsulation();
			break;
		case "inheritance":
			oop.doInheritance();
			break;
		case "polymorphism":
			oop.doPolymorphism();
			break;
		case "abstraction":
			oop.doAbstraction();
			break;
		default:
			System.out.println("Option not available.");
		}
		sc.close();
	}

}
