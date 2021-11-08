package com.revature.Daos;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements GenericDao<Employee> {

	public int add(Employee employee) throws IOException {
		int genId = -1;
		String sql = "insert into employee (emp_name, emp_username, emp_password, manager) "
				+ "values (?, ?, ?, ?) returning emp_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, employee.getempName());
			ps.setString(2, employee.getempUsername());
			ps.setString(3, employee.getempPassword());
			ps.setInt(4, employee.getManager());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				genId = rs.getInt("emp_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return genId;
	}

	public int delete(int id) {
		String sql = "delete from employee where emp_id = ? ";
		int result = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Employee getById(int id) {
		String sql = "select * from employee where emp_id = ? ";
		Employee emp = null;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String emp_username = rs.getString("emp_username");
				String emp_password = rs.getString("emp_password");
				int manager = rs.getInt("manager");
				
				emp = new Employee(emp_id, emp_name, emp_username, emp_password, manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return emp;
	}

	public List<Employee> getAll() {
		String sql = "select * from employee;";
		List<Employee> employees = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String emp_username = rs.getString("emp_username");
				String emp_password = rs.getString("emp_password");
				int manager = rs.getInt("manager");
				
				Employee newEmp = new Employee(emp_id, emp_name, emp_username, emp_password, manager);
				employees.add(newEmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return employees;
	}

	public int update(Employee employee) {

		int result = 0;
		String sql = "update employee set emp_name = ?, emp_username = ?, emp_password = ? where emp_id = ?;";
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setString(1, employee.getempName());
			ps.setString(2, employee.getempUsername());
			ps.setString(3, employee.getempPassword());
			ps.setInt(4, employee.getempId());
			
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
