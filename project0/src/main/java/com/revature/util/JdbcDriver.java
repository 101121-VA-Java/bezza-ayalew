package com.revature.util;

import java.io.IOException;

import com.revature.Daos.EmployeePostgres;
import com.revature.Daos.GenericDao;

import com.revature.models.Employee;


public class JdbcDriver {

	public static void main(String[] args) throws IOException {
//		GenericDao<Status> ns = new StatusPostgres();
//		Status newStatus = new Status(11, "offered", (double)2105);
//		StatusPostgres sp = new StatusPostgres();
//		System.out.println(sp.getById(10));
		GenericDao<Employee> ep = new EmployeePostgres();
//
//		List<Employee> emps = ep.getAll();
//		for (Employee e : emps) {
//			System.out.println(e.getempName());
//		}
//		
//		System.out.println("Get employeeById 3:" + ep.getById(3));
		
//		GenericDao<Item> itemdao = new ItemPostgres();
//		List<Item> items = itemdao.getAll();
//		for (Item i : items) {
//			System.out.println(i.getItemName());
//		}
//		System.out.println("Get itemById 45:" + itemdao.getById(45));
		
		Employee newEmp = new Employee("TestName", "TestPass", "TestUsername", 4);
		
		System.out.println("Generated id was: " + ep.add(newEmp));

	}

}
