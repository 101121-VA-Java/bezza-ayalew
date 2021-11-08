package com.revature.controllers;

import java.io.IOException;
import java.util.Scanner;

import com.revature.Daos.ItemPostgres;
import com.revature.models.Item;
import com.revature.services.ItemService;

public class ItemController {
	Scanner sc = new Scanner(System.in);
	public ItemService is = new ItemService();
	public ItemPostgres ip = new ItemPostgres();
	public void printListOfItems() throws IOException {
		System.out.println(is.availableItems());
	}
	public void addItems(Scanner sc) throws IOException {
		System.out.println("Please enter the name and initial price of items");
		System.out.println("Name of item: ");
		String itemName = sc.nextLine();
		System.out.println("Initial price: ");
		Double initialPrice = Double.parseDouble(sc.nextLine());
		Item addedItem = new Item(itemName, initialPrice);
		ip.add(addedItem);
	}
	public void removeItem()
}
