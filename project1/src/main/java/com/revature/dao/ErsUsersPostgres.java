package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.ErsUsers;
import com.revature.util.ConnectionUtil;

public class ErsUsersPostgres implements ErsUsersDao{
	
	@Override
	public List<ErsUsers> getErsUsers() throws IOException {
		String sql = "select * from ers.ers_users;";
		List<ErsUsers> users = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				ErsUsers user = new ErsUsers(rs.getInt("ers_users_id"),
											rs.getString("ers_username"),
											rs.getString("ers_password"),
											rs.getString("user_first_name"),
											rs.getString("user_last_name"),
											rs.getString("user_email"),
											rs.getInt("user_role_id"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return users;
	}

	@Override
	public ErsUsers getErsUserById(int id) throws IOException {
		String sql = "select * from ers.ers_users where ers_users_id = ? ";
		ErsUsers ersUser = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ersUser = new ErsUsers(rs.getInt("ers_users_id"),
									rs.getString("ers_username"),
									rs.getString("ers_password"),
									rs.getString("user_first_name"),
									rs.getString("user_last_name"),
									rs.getString("user_email"),
									rs.getInt("user_role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ersUser;
	}

	@Override
	public ErsUsers getErsUserByUsername(String username) throws IOException {
		String sql = "select * from ers.ers_users where ers_username = ?;"; 
		
		ErsUsers ersUser = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ersUser = new ErsUsers(rs.getInt("ers_users_id"),
									rs.getString("ers_username"),
									rs.getString("ers_password"),
									rs.getString("user_first_name"),
									rs.getString("user_last_name"),
									rs.getString("user_email"),
									rs.getInt("user_role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ersUser;
	}

	@Override
	public boolean updateErsUser(ErsUsers ersUser) {
		boolean result = false;
		String sql = "update ers.ers_users set user_first_name = ?, user_last_name = ?,"
				+ "ers_username = ?, ers_password = ?, where emp_id = ?;";
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setString(1, ersUser.getUserFirstName());
			ps.setString(2, ersUser.getUserLastName());
			ps.setString(3, ersUser.getErsUsername());
			ps.setString(4, ersUser.getErsPassword());
			ps.setInt(5, ersUser.getErsUserId());
			
			if(ps.executeUpdate()>0) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ErsUsers addErsUser(ErsUsers ersUser) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public ErsUsers getById(int id) throws IOException {
//		String sql = "select * from ers.ers_users where ers_users_id = ? ";
//		ErsUsers user = null;
//		
//		try (Connection con = ConnectionUtil.getConnectionFromFile()){
//			PreparedStatement ps = con.prepareStatement(sql);
//			
//			ps.setInt(1, id);	
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				int emp_id = rs.getInt("ers_users_id");
//				String emp_username = rs.getString("ers_username");
//				String emp_password = rs.getString("ers_password");
//				String emp_firstName = rs.getString("user_first_name");
//				String emp_lastName = rs.getString("user_last_name");
//				String emp_email = rs.getString("user_email");
//				int emp_role_id = rs.getInt("user_role_id");
//				
//				user = new ErsUsers(emp_id, emp_username, emp_password, emp_firstName, emp_lastName, emp_email, emp_role_id);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return user;
//	}
//	
//	public ErsUsers getByUsernameAndPassword(String username, String password) throws IOException {
//		String sql = "select * from ers.ers_users where ers_username = ? and ers_password = ?;"; 
//				
//		ErsUsers user = null;
//		
//		try (Connection con = ConnectionUtil.getConnectionFromFile()){
//			PreparedStatement ps = con.prepareStatement(sql);
//			
//			ps.setString(1, username);
//			ps.setString(2, password);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				int emp_id = rs.getInt("ers_users_id");
//				String emp_username = rs.getString("ers_username");
//				String emp_password = rs.getString("ers_password");
//				String emp_firstName = rs.getString("user_first_name");
//				String emp_lastName = rs.getString("user_last_name");
//				String emp_email = rs.getString("user_email");
//				int emp_role_id = rs.getInt("user_role_id");
//				
//				user = new ErsUsers(emp_id, emp_username, emp_password, emp_firstName, emp_lastName, emp_email, emp_role_id);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
//	}
//	public ErsUsers getByUsername(String username) throws IOException {
//		String sql = "select * from ers.ers_users where ers_username = ?;"; 
//				
//		ErsUsers user = null;
//		
//		try (Connection con = ConnectionUtil.getConnectionFromFile()){
//			PreparedStatement ps = con.prepareStatement(sql);
//			
//			ps.setString(1, username);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				int emp_id = rs.getInt("ers_users_id");
//				String emp_username = rs.getString("ers_username");
//				String emp_password = rs.getString("ers_password");
//				String emp_firstName = rs.getString("user_first_name");
//				String emp_lastName = rs.getString("user_last_name");
//				String emp_email = rs.getString("user_email");
//				int emp_role_id = rs.getInt("user_role_id");
//				
//				user = new ErsUsers(emp_id, emp_username, emp_password, emp_firstName, emp_lastName, emp_email, emp_role_id);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
//	}
//
//	@Override
//	public List<ErsUsers> getAll() throws IOException {
//		String sql = "select * from ers.ers_users;";
//		List<ErsUsers> users = new ArrayList<>();
//		try (Connection con = ConnectionUtil.getConnectionFromFile()){
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
//			
//			while(rs.next()) {
//				int emp_id = rs.getInt("ers_users_id");
//				String emp_username = rs.getString("ers_username");
//				String emp_password = rs.getString("ers_password");
//				String emp_firstName = rs.getString("user_first_name");
//				String emp_lastName = rs.getString("user_last_name");
//				String emp_email = rs.getString("user_email");
//				int emp_role_id = rs.getInt("user_role_id");
//				
//				ErsUsers user = new ErsUsers(emp_id, emp_username, emp_password, emp_firstName, emp_lastName, emp_email, emp_role_id);
//				users.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return users;
//	}
//
//	@Override
//	public boolean update(ErsUsers user) {
//
//		boolean result = false;
//		String sql = "update ers.ers_users set user_first_name = ?, user_last_name = ?,"
//				+ "ers_username = ?, ers_password = ?, where emp_id = ?;";
//		try (Connection con = ConnectionUtil.getConnectionFromFile()){
//			PreparedStatement ps = con.prepareStatement(sql);	
//			ps.setString(1, user.getUserFirstName());
//			ps.setString(2, user.getUserLastName());
//			ps.setString(3, user.getErsUsername());
//			ps.setString(4, user.getErsPassword());
//			ps.setInt(5, user.getErsUserId());
//			
//			if(ps.executeUpdate()>0) result = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//	@Override
//	public ErsUsers add(ErsUsers user) throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int delete(int id) throws IOException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//

}


