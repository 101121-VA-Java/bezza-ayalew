package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Status {
	int statusId;
	int itemId;
	String status;
	Double price;
	Timestamp date;
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int statusId, int itemId, String status, Double price, Timestamp date) {
		super();
		this.statusId = statusId;
		this.itemId = itemId;
		this.status = status;
		this.price = price;
		this.date = date;
	}
	public Status(int itemId, String status, Double price) {
		this.itemId = itemId;
		this.status = status;
		this.price = price;
	}
	public Status(int statusId, int itemId, String status, Double price) {
		this.statusId = statusId;
		this.itemId = itemId;
		this.status = status;
		this.price = price;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}

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
