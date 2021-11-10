package com.revature.services;

import java.io.IOException;

import com.revature.daos.CustomerPostgres;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;

public class CustomerService {
	private static CustomerPostgres cp = new CustomerPostgres();
	
	public Customer customerLogin(String uname, String pword) throws LoginException {
		Customer cust = cp.getByUsernameAndPassword(uname, pword);
		if(cust.setUsername(uname).equals(uname) && cust.getPassword().equals(pword)) {
			return cust;
		}
		throw new LoginException();
	}
	
	public Customer register(Customer c) throws UsernameAlreadyExistsException, IOException{
		for(Customer cust: cp.getAll()) {
			if(!cust.getUsername().equals(c.getUsername())) {
				return cp.add(c);
			}
		}
		throw new UsernameAlreadyExistsException();
	}
	

}