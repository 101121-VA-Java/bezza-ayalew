package com.revature.repositories;

import com.revature.models.Employee;

public interface EmployeeDao {
	int addItem(int newQuantity, int getquantityItem); // returns incremented item.quantity 
	int removeItem(int id);
	int addEmployee(Employee e); // returns assigned id
	boolean editEmployee(Employee e);  //returns boolean depending on operation success 
	boolean deleteEmployee(int id);  //returns boolean depending on operation success 
}
