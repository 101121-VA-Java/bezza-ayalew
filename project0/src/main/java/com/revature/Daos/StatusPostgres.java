package com.revature.Daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Status;
import com.revature.util.ConnectionUtil;

public class StatusPostgres  implements GenericDao<Status> {

	@Override
	public int add(Status s) throws IOException {
		
		String sql = "insert into item_status (item_id, status, price, date_updated) "
				+ "values (?, ?, ?, CURRENT_TIMESTAMP) returning status_id;";
		int genId = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, s.getItemId());
			ps.setString(2, s.getStatus());
			ps.setDouble(3, s.getPrice());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				genId = rs.getInt("status_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return genId;
	}

	@Override
	public int delete(int id) throws IOException {
		String sql = "delete from item_status where status_id = ? ";
		int result = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, id);
			result = ps.executeUpdate();
//	        con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Status getById(int id) throws IOException {
		String sql = "select * from item_status where status_id = ? ";
		Status singleItemStatus = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int statusId = rs.getInt("status_id");
				int itemId = rs.getInt("item_id");
				String status = rs.getString("status");
				Double price = rs.getDouble("price");

		
				singleItemStatus = new Status(statusId, itemId, status, price);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return singleItemStatus;
	}

	@Override
	public List<Status> getAll() throws IOException {
		String sql = "select * from item_status;";
		List<Status> statuses = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int statusId = rs.getInt("status_id");
				int itemId = rs.getInt("item_id");
				String status = rs.getString("status");
				Double price = rs.getDouble("price");
				Timestamp date = rs.getTimestamp("date_updated");
				
				
				Status newStatus = new Status(statusId, itemId, status, price, date);
				statuses.add(newStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return statuses;
	}

	@Override
	public int update(Status s) {
		int result = 0;		
		String sql = "update item_status set status = ?, price = ?, date_updated = CURRENT_TIMESTAMP;";
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setString(1, s.getStatus());
			ps.setDouble(2, s.getPrice());
			
			result = ps.executeUpdate(sql);
	        con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
