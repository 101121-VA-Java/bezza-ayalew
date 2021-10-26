package com.revature.models;

import java.util.Objects;

public class Customer {
	private int customerId;
	private String username;
	private String password;
	private String name;
	private String email;
	private String address;
	
	protected Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Customer(int customerId, String username, String password, String name, String email, String address) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password + ", name="
				+ name + ", email=" + email + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, customerId, email, name, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && customerId == other.customerId
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
}

