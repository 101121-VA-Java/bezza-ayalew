package com.revature.repositories;

import com.revature.models.Item;

public interface customerDao {
	Item viewItem(Item likedItem);
	Double makeOffer(Item likedItem);
	Double makePayment(Item purchasedItem);
	Double viewBalance(Double price, Double paidTotal);
	
}
