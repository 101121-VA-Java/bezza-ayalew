package com.revature.services;

import java.util.List;

import com.revature.daos.CustomerDao;
import com.revature.daos.CustomerList;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.models.Role;

public class CustomerService {

	private static CustomerDao cd = new CustomerList();
	
	public Customer addCustomer(Customer c) throws UsernameAlreadyExistsException {

		Customer newEmp = this.getCustomerByUsername(c.getUsername());
		if(newCustomer != null) {
			throw new UsernameAlreadyExistsException();
		}
		c.setRole(Role.BASIC_Customer);
		c.setManager(cd.getById(0));
 
		return cd.add(c);
	}
	
	public Customer getCustomerByUsername(String username){
		List<Customer> Customers = cd.getAll();
		for(Customer c : Customers) {
			if (e.getUsername().equals(username)) {
				return c;
			}
		}
		return null;
	}
	
	public Customer login(String username, String password) throws LoginException {
		Customer cust = this.getCustomerByUsername(username);
		if(cust == null || !cust.getPassword().equals(password)) {
			throw new LoginException();
		}
		return cust;
	}
}

