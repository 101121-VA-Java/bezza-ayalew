package com.revature.models;

import java.util.Date;
import java.util.Objects;

public class Status {
	int itemId;
	String status;
	Double price;
	Date date;
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int itemId, String status, Double price, Date date) {
		super();
		this.itemId = itemId;
		this.status = status;
		this.price = price;
		this.date = date;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		itemId = itemId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, date, price, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Status))
			return false;
		Status other = (Status) obj;
		return itemId == other.itemId && Objects.equals(date, other.date) && Objects.equals(price, other.price)
				&& Objects.equals(status, other.status);
	}
	
	
}
