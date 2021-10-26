package com.revature.repositories;

import com.revature.models.Item;

public interface ItemDao {
	Item[] getAllItems();
	Item viewItem();
	Item getItemByItemId();
	
	
}
