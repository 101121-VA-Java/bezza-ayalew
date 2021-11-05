package com.revature.models;
import java.util.Date;
import java.util.Objects;
public class Payment {
	int payementId;
	int itemId;
	int customerId;
	Date payementDate;
	double paymentAmount;
	double salePrice;
	double balance;
	
	protected Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Payment(int payementId, int itemId, int customerId, Date payementDate, double paymentAmount,
			double salePrice, double balance) {
		super();
		this.payementId = payementId;
		this.itemId = itemId;
		this.customerId = customerId;
		this.payementDate = payementDate;
		this.paymentAmount = paymentAmount;
		this.salePrice = salePrice;
		this.balance = balance;
	}

	public int getPayementId() {
		return payementId;
	}

	public void setPayementId(int payementId) {
		this.payementId = payementId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getPayementDate() {
		return payementDate;
	}

	public void setPayementDate(Date payementDate) {
		this.payementDate = payementDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, customerId, itemId, payementDate, payementId, paymentAmount, salePrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Payment))
			return false;
		Payment other = (Payment) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& customerId == other.customerId && itemId == other.itemId
				&& Objects.equals(payementDate, other.payementDate) && payementId == other.payementId
				&& Double.doubleToLongBits(paymentAmount) == Double.doubleToLongBits(other.paymentAmount)
				&& Double.doubleToLongBits(salePrice) == Double.doubleToLongBits(other.salePrice);
	}
	
	
}
