package com.revature.models;

import java.util.Objects;

public class Employee {

	private int emp_id;
	private String emp_name;
	private String emp_username;
	private String emp_password;
	private Employee manager;
	
	public Employee() {
		super();
	}

	public Employee(int emp_id, String emp_name, String emp_username, String emp_password, Employee manager) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.manager = manager;
	}

	protected Employee(String emp_name, String emp_username, String emp_password, Employee manager) {
		super();
		this.emp_name = emp_name;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.manager = manager;
	}

	public Employee(int manager2) {
		// TODO Auto-generated constructor stub
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emp_id, emp_name, emp_password, emp_username, manager);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return emp_id == other.emp_id && Objects.equals(emp_name, other.emp_name)
				&& Objects.equals(emp_password, other.emp_password) && Objects.equals(emp_username, other.emp_username)
				&& Objects.equals(manager, other.manager);
	}


	
}
