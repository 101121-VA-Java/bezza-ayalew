package com.revature.services;

import com.revature.Daos.PaymentPostgres;
import com.revature.models.Payment;

public class PaymentService {
	private static PaymentPostgres pp = new PaymentPostgres();
	public Payment makePayment() {
//		After login customers should be shown list of items and 
//		asked if they want to make offer or make payment, 
//		the latter choice ushering the payment controller.
//		This controller should list previous payments grouped by
//		customerId and itemId.
		return null;
	}
	
}
