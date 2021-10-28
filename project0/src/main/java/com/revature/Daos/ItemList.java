package com.revature.Daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;

public class ItemList implements ItemDao{

	private List<Item> items = new ArrayList<>();

	@Override
	//returns a newly registered Item's record with the id set to the order of registration
	public Item add(Item t) {
		t.setId(items.size());
		items.add(t);
		return t;
	}

	@Override
	public Item getById(int id) {
		for (Item c : items) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public List<Item> getAll() {
		return items;
	}

	@Override
	public boolean update(Item t) {
		Item temp = getById(t.getId());
		if (temp == null || temp.equals(t)) {
			return false;
		}
		items.set(t.getId(), t);
		return true;
	}


}
