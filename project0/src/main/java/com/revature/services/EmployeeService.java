package com.revature.services;

import java.io.IOException;
import java.sql.Timestamp;
import com.revature.Daos.EmployeePostgres;
import com.revature.Daos.ItemPostgres;
import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Item;

public class EmployeeService {

	private static Timestamp CURRENT_TIMESTAMP;
	private static final Timestamp Timestamp = CURRENT_TIMESTAMP;
	public ItemPostgres ip;
	public EmployeePostgres ep;
	
	public EmployeeService() {
		ip = new ItemPostgres();
		ep = new EmployeePostgres();
	}
	
	public Employee empLogin(String username, String password) throws LoginException {
		Employee emp = new Employee();
		if(emp.getempUsername().equals(username) && emp.getempPassword().equals(password)) {
			return emp;
		}
		throw new LoginException();
	}

	public int addEmployee(Employee e) throws IOException{
		String empName = "";
		String empUsername = "";
		String empPassword = ""; 
		int manager = 0;
		String empRole = "Basic_Employee";
		Employee newEmp = new Employee(empName,empUsername,empPassword,manager,empRole);
		return ep.add(newEmp);
	}
	
	public int removeEmployee(int id) throws IOException{
		return ep.delete(id);
	}
	public int addItem() throws IOException {
		String itemName = "";
		Timestamp dateAdded = Timestamp;
		Double initialPrice = null;
		Item newItem = new Item(itemName, dateAdded, initialPrice);
		return(ip.add(newItem));
	}
	public String acceptRejectOffer() {
		
	}
	

	public Item removeItem(Item i) {
		
	}
	public Sales viewSalesHistory() {
		
	}
	
}

