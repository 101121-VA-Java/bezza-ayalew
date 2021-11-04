package com.revature.Daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao extends GenericDao<Employee>{
	Employee getEmployeeById(int id);
	List<Employee> getEmployees();
	int addEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	int deleteEmployee(int id);

}
