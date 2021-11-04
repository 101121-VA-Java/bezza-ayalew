package com.revature.services;

import java.util.List;

import com.revature.Daos.EmployeeDao;
import com.revature.Daos.EmployeeList;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.models.Role;

import java.util.List;

public class EmployeeService {

	private static EmployeeDao ed = new EmployeeList();
	
	public Employee addEmployee(Employee e) throws UsernameAlreadyExistsException {

		Employee newEmp = this.getEmployeeById(e.getId());
		if(newEmp != null) {
			throw new UsernameAlreadyExistsException();
		}
		e.setRole(Role.BASIC_EMP);
		e.setManager(ed.getById(0));
 
		return ed.add(e);
	}
	
	public Employee getEmployeeById(int id){
		List<Employee> employees = ed.getAll();
		for(Employee e : employees) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	

	public Employee removeEmployee(Employee e) {
		Employee firedEmp = this.getEmployeeById(e.getId());
		return ed.delete(firedEmp);
	}
	
//	public Employee login(String username, String password) throws LoginException {
//		Employee emp = this.getEmployeeById(username);
//		if(emp == null || !emp.getPassword().equals(password)) {
//			throw new LoginException();
//		}
//		return emp;
//	}
}

