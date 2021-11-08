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

import com.revature.models.Customer;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.util.ConnectionUtil;

public class OfferPostgres implements GenericDao<Offer>{
	private static final Timestamp CURRENT_TIMESTAMP = null;
	public static Customer customer = new Customer();
	public static Item item = new Item();
	
	public OfferPostgres() {
		super();
	}
	
	@Override
	public Offer add(Offer offer) throws IOException {
		String sql = "insert into offer (customer_id, item_id, offer_amount) "
				+ "values (?, ?, ? CURRENT_TIMESTAMP) returning offer_id;";
		Double newOfferAmount = null;
		Offer newOffer = null;
//		int genId = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, customer.getId());
			ps.setInt(2, item.getItemId());
			ps.setDouble(3,  newOfferAmount);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
//				genId = rs.getInt("item_id");
//				newOffer = Offer(genId, customer.getId(), item.getItemId(), newOfferAmount, CURRENT_TIMESTAMP);
				newOffer = (Offer)rs;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return newOffer;
	}

	@Override
	public int delete(int id) throws IOException {
		String sql = "delete from offer where offer_id = ? ";
		int result = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, id);
			result = ps.executeUpdate(sql);
	        con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Offer getById(int id) throws IOException {
		String sql = "select * from item where item_id = ? ";
		Offer singleOffer = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int offerId = rs.getInt("offer_id");
				int customerId = rs.getInt("customer_id");
				int itemId = rs.getInt("item_id");
				Double offerAmount = rs.getDouble("offer_amount");
				Timestamp offerDate = rs.getTimestamp("offer_date");		
				singleOffer = new Offer(offerId, customerId, itemId, offerAmount, offerDate);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return singleOffer;
	}

	@Override
	public List<Offer> getAll() throws IOException {
		String sql = "select * from offer;";
		List<Offer> offers = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int offerId = rs.getInt("offer_id");
				int customerId = rs.getInt("customer_id");
				int itemId = rs.getInt("item_id");
				Double offerAmount = rs.getDouble("offer_amount");
				Timestamp offerDate = rs.getTimestamp("offer_date");		
				Offer singleOffer = new Offer(offerId, customerId, itemId, offerAmount, offerDate);
				offers.add(singleOffer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return offers;
	}

	@Override
	public int update(Offer o) {
		int result = 0;
		String sql = "update offer set customer_id = ?, item_id = ?, "
				+ "offer_amount = ?, offer_date = CURRENT_TIMESTAMP where offer_id = ?;";
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, o.getCustomerId());
			ps.setInt(2, o.getItemId());
			ps.setDouble(3, o.getOfferAmount());
			ps.setInt(4, o.getOfferId());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
