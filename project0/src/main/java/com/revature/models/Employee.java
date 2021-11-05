package com.revature.models;

import java.util.Objects;

public class Employee {

	private int empId;
	private String empName;
	private String empUsername;
	private String empPassword;
	private Employee manager;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String empName, String empUsername, String empPassword, Employee manager) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.manager = manager;
	}

	protected Employee(String empName, String empUsername, String empPassword, Employee manager) {
		super();
		this.empName = empName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.manager = manager;
	}

	public Employee(int manager2) {
		// TODO Auto-generated constructor stub
	}

	public int getempId() {
		return empId;
	}

	public void setempId(int empId) {
		this.empId = empId;
	}

	public String getempName() {
		return empName;
	}

	public void setempName(String empName) {
		this.empName = empName;
	}

	public String getempUsername() {
		return empUsername;
	}

	public void setempUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getempPassword() {
		return empPassword;
	}

	public void setempPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, empPassword, empUsername, manager);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(empName, other.empName)
				&& Objects.equals(empPassword, other.empPassword) && Objects.equals(empUsername, other.empUsername)
				&& Objects.equals(manager, other.manager);
	}


	
}
