package com.revature.util;

import java.io.IOException;
import java.util.List;

import com.revature.Daos.EmployeePostgres;
import com.revature.Daos.GenericDao;
import com.revature.Daos.ItemPostgres;
import com.revature.models.Employee;
import com.revature.models.Item;

public class JdbcDriver {

	public static void main(String[] args) throws IOException {
		GenericDao<Employee> ep = new EmployeePostgres();

		List<Employee> emps = ep.getAll();
		for (Employee e : emps) {
			System.out.println(e.getempName());
		}
		
		System.out.println("Get employeeById 3:" + ep.getById(3));
		
//		GenericDao<Item> itemdao = new ItemPostgres();
//		List<Item> items = itemdao.getAll();
//		for (Item i : items) {
//			System.out.println(i.getItemName());
//		}
//		System.out.println("Get itemById 45:" + itemdao.getById(45));
		
//		Employee newEmp = new Employee("TestName", "TestUsername", "TestPass", new Employee(4));
//		
//		System.out.println("Generated id was: " + ed.add(newEmp));

	}

}
