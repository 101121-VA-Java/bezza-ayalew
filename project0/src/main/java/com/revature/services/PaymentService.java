package com.revature.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.PaymentPostgres;
import com.revature.models.Payment;

public class PaymentService {
	private static PaymentPostgres pp = new PaymentPostgres();
	static List<String> paymentList = new ArrayList<>();
	public static List<String> viewPayment() throws IOException {
		for(Payment p: pp.getAll()) {
			
			String paymentDate = new SimpleDateFormat("MM/dd/yyyy").format(p.getPayementDate());
			String singlePayment = String.format("%-10d %-10d %-14d %-14s %-10.2f %-10.2f %-10.2f", 
					p.getPaymentId(), p.getItemId(), p.getCustomerId(), paymentDate,
					p.getPaymentAmount(), p.getSalePrice(), p.getBalance());
			paymentList.add(singlePayment);
		}
		
		return paymentList;
	}
	
}
