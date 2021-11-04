package com.revature.services;

import java.util.List;

import com.revature.Daos.ItemDao;
import com.revature.Daos.ItemList;
import com.revature.models.Employee;
import com.revature.models.Item;

public class CustomerService {

	private static ItemDao allItems = new ItemList();
	
	public Item getItemByName(String name){
		List<Item> items = allItems.getAll();
		for(Item i : items) {
			if (i.getName() == name) {
				return i;
			}
		}
		return null;
	}

}