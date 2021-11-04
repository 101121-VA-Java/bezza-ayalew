package com.revature.util;

import java.util.List;

import com.revature.Daos.EmployeePostgres;
import com.revature.Daos.GenericDao;
import com.revature.models.Employee;

public class JdbcDriver {

	public static void main(String[] args) {
		GenericDao<Employee> ed = new EmployeePostgres();

		List<Employee> emps = ed.getAll();
		for (Employee e : emps) {
			System.out.println(e);
		}
		
		System.out.println("Get employeeById 4:" + ed.getById(4));
		
//		Employee newEmp = new Employee("TestName", "TestUsername", "TestPass", new Employee(4));
//		
//		System.out.println("Generated id was: " + ed.add(newEmp));

	}

}
