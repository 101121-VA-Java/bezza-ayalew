package com.revature.models;

import java.util.Date;
import java.util.Objects;

public class Offer {
	int offerId;
	int customerId;
	int itemId;
	Date offerDate;
	double offerAmount;
	double offerPrice;
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(int offerId, int customerId, int itemId, Date offerDate, double offerAmount, double offerPrice) {
		super();
		this.offerId = offerId;
		this.customerId = customerId;
		this.itemId = itemId;
		this.offerDate = offerDate;
		this.offerAmount = offerAmount;
		this.offerPrice = offerPrice;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	public double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, itemId, offerAmount, offerDate, offerId, offerPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Offer))
			return false;
		Offer other = (Offer) obj;
		return customerId == other.customerId && itemId == other.itemId
				&& Double.doubleToLongBits(offerAmount) == Double.doubleToLongBits(other.offerAmount)
				&& Objects.equals(offerDate, other.offerDate) && offerId == other.offerId
				&& Double.doubleToLongBits(offerPrice) == Double.doubleToLongBits(other.offerPrice);
	}
	
	
}
