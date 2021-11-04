package com.revature.Daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;

public class ItemList implements ItemDao{

	private List<Item> items = new ArrayList<>();

	@Override
	//returns a newly registered Item's record with the id set to the order of registration
	public Item add(Item i) {
		i.setId(items.size());
		i.setName(null); //What is the source?
		items.add(i);
		return i;
	}
	// 

	@Override
	public Item getById(int id) {
		for (Item t : items) {
			if (t.getId() == id) {
				return t;
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

	@Override
	public Item delete(Item t) {
		Item toDelete = getById(t.getId());
		toDelete.setId(0);
		toDelete.setName(null);
		return toDelete;
	}


}
