package com.revature.Daos;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements GenericDao<Employee> {

	public Employee add(Employee employee) throws IOException {
		int genId = -1;
		String sql = "insert into employees (emp_name, emp_username, emp_password, manager) "
				+ "values (?, ?, ?, ?) returning emp_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, employee.getEmp_name());
			ps.setString(2, employee.getEmp_username());
			ps.setString(3, employee.getEmp_password());
			ps.setInt(5, employee.getManager().getEmp_id());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				int genId = rs.getInt("emp_id");
			}
		
			return genId;
	}



	public Employee delete(Employee employee) {
		String sql = "delete from employee where condition;";
		return 0;
	}


	public Employee getById(int id) {
		String sql = "select * from employees where emp_id = ? ";
		Employee emp = null;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); // 1 refers to the first '?'	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String emp_username = rs.getString("emp_username");
				String emp_password = rs.getString("emp_password");
				int manager = rs.getInt("manager");
				
				emp = new Employee(emp_id, emp_name, emp_username, emp_password, new Employee(manager));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return emp;
	}

	public List<Employee> getAll() {
		String sql = "select * from employees;";
		List<Employee> employees = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			java.sql.Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String emp_username = rs.getString("emp_username");
				String emp_password = rs.getString("emp_password");
				int manager = rs.getInt("manager");
				
				Employee newEmp = new Employee(emp_id, emp_name, emp_username, emp_password, new Employee(manager));
				employees.add(newEmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return employees;
	}

	public boolean update(Employee employee) {
		String sql = "update employee set column = value where condition;";
		return false;
	}


}
