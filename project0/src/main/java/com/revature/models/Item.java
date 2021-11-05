package com.revature.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Item {
	public int itemId;
	public String itemName;
	public Date date;
	public Double initialPrice;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int itemId, String itemName, Date date, Double initialPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.date = date;
		this.initialPrice = initialPrice;
	}
	public Item(String itemName, Date date, Double initialPrice) {
		super();
		this.itemName = itemName;
		this.date = date;
		this.initialPrice = initialPrice;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(Double initialPrice) {
		this.initialPrice = initialPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, initialPrice, itemId, itemName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		return Objects.equals(date, other.date) && Objects.equals(initialPrice, other.initialPrice)
				&& itemId == other.itemId && Objects.equals(itemName, other.itemName);
	}
	
	
}
