package com.revature.Daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;

public class CustomerList implements CustomerDao{

	private List<Customer> customers = new ArrayList<>();

	@Override
	//returns a newly registered customer's record with the id set to the order of registration
	public Customer add(Customer t) {
		t.setId(customers.size());
		customers.add(t);
		return t;
	}

	@Override
	public Customer getById(int id) {
		for (Customer c : customers) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public List<Customer> getAll() {
		return customers;
	}

	@Override
	public boolean update(Customer t) {
		Customer temp = getById(t.getId());
		if (temp == null || temp.equals(t)) {
			return false;
		}
		customers.set(t.getId(), t);
		return true;
	}


}
