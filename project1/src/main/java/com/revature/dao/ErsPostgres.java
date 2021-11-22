package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.ErsReimbursement;
import com.revature.util.ConnectionUtil;

public class ErsPostgres implements GenericDao<ErsReimbursement>{

	@Override
	public ErsReimbursement add(ErsReimbursement reimbursement) throws IOException {
		ErsReimbursement newClaim = null;
		
		String sql = "insert into ers_reimbursement (reimb_amount,"
				+ "reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,"
				+ "reimb_author,reimb_resolver,reimb_status_id,reimb_type_id) "
				+ "values (?, ?, ?, ?, ?) returning reimb_id,reimb_amount,"
				+ "reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,"
				+ "reimb_author,reimb_resolver,reimb_status_id,reimb_type_id;";
		
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, reimbursement.getReimbAmount());
			ps.setTimestamp(2, reimbursement.getReimbSubmitted());
			ps.setTimestamp(3, reimbursement.getReimbResolved());
			ps.setString(4, reimbursement.getReimbDescription());
			ps.setString(5, reimbursement.getReimbReceipt());
			ps.setInt(6, reimbursement.getReimbAuthor());
			ps.setInt(7, reimbursement.getReimbResolver());
			ps.setInt(8, reimbursement.getReimbStatusId());
			ps.setInt(9, reimbursement.getReimbTypeId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int reimbId = rs.getInt("reimb_id");
				Double reimbAmount = rs.getDouble("reimb_amount");
				Timestamp reimbSubmitted = rs.getTimestamp("reimb_submitted");
				Timestamp reimbResolved = rs.getTimestamp("reimb_resolved");
				String reimbDescription = rs.getString("reimb_description");
				String reimbReceipt = rs.getString("reimb_receipt");
				int reimbAuthor = rs.getInt("reimb_author");
				int reimbResolver = rs.getInt("reimb_resolver");
				int reimbStatusId = rs.getInt("reimb_status_id");
				int reimbTypeId = rs.getInt("reimb_type_id");
				
				newClaim = new ErsReimbursement(reimbId, reimbAmount, reimbSubmitted, 
						reimbResolved, reimbDescription, reimbReceipt, 
						reimbAuthor, reimbResolver, reimbStatusId, reimbTypeId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return newClaim;
	}

	@Override
	public int delete(int id) throws IOException {
		String sql = "delete from ers_reimbursement where reimb_id = ? ";
		int result = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, id);
			if(ps.execute()) result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ErsReimbursement getById(int id) throws IOException {
		
		ErsReimbursement newClaim = null;	
		String sql = "select * from ers_reimbursement reimb_id = ?;";
			
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int reimbId = rs.getInt("reimb_id");
				Double reimbAmount = rs.getDouble("reimb_amount");
				Timestamp reimbSubmitted = rs.getTimestamp("reimb_submitted");
				Timestamp reimbResolved = rs.getTimestamp("reimb_resolved");
				String reimbDescription = rs.getString("reimb_description");
				String reimbReceipt = rs.getString("reimb_receipt");
				int reimbAuthor = rs.getInt("reimb_author");
				int reimbResolver = rs.getInt("reimb_resolver");
				int reimbStatusId = rs.getInt("reimb_status_id");
				int reimbTypeId = rs.getInt("reimb_type_id");
				
				newClaim = new ErsReimbursement(reimbId, reimbAmount, reimbSubmitted, 
						reimbResolved, reimbDescription, reimbReceipt, 
						reimbAuthor, reimbResolver, reimbStatusId, reimbTypeId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return newClaim;
	}

	@Override
	public List<ErsReimbursement> getAll() throws IOException {
		List<ErsReimbursement> allClaims = new ArrayList<>();	
		String sql = "select * from ers_reimbursement;";
			
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int reimbId = rs.getInt("reimb_id");
				Double reimbAmount = rs.getDouble("reimb_amount");
				Timestamp reimbSubmitted = rs.getTimestamp("reimb_submitted");
				Timestamp reimbResolved = rs.getTimestamp("reimb_resolved");
				String reimbDescription = rs.getString("reimb_description");
				String reimbReceipt = rs.getString("reimb_receipt");
				int reimbAuthor = rs.getInt("reimb_author");
				int reimbResolver = rs.getInt("reimb_resolver");
				int reimbStatusId = rs.getInt("reimb_status_id");
				int reimbTypeId = rs.getInt("reimb_type_id");
				
				ErsReimbursement singleClaim = new ErsReimbursement(reimbId, reimbAmount, reimbSubmitted, 
						reimbResolved, reimbDescription, reimbReceipt, 
						reimbAuthor, reimbResolver, reimbStatusId, reimbTypeId);
				allClaims.add(singleClaim);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return allClaims;
	}

	@Override
	public boolean update(ErsReimbursement reimbursement) {
		boolean result = false;
		String sql = "update ers_reimbursement set reimb_resolved = ?, reimb_resolver = ?, "
				+ "reimb_status_id = ? where reimb_id = ?;";
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setTimestamp(1, reimbursement.getReimbResolved());
			ps.setInt(2, reimbursement.getReimbResolver());
			ps.setInt(3, reimbursement.getReimbStatusId());
			ps.setInt(4, reimbursement.getReimbId());
			
			if(ps.executeUpdate() >0) result = true;
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
