package com.revature.services;

import java.io.IOException;
import com.revature.Daos.CustomerPostgres;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;

public class CustomerService {
	private static CustomerPostgres cp = new CustomerPostgres();
	
	public Customer customerLogin(String username, String password) throws LoginException {
		Customer cust = new Customer();
		if(cust.getUsername().equals(username) && cust.getPassword().equals(password)) {
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