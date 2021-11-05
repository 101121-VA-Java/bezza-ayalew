package com.revature.Daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.revature.models.Item;
import com.revature.util.ConnectionUtil;

public class ItemPostgres implements GenericDao<Item> {

	@Override
	public int add(Item item) throws IOException {
		String sql = "insert into item (item_name, date_added, initial_price) "
				+ "values (?, ?, ?) returning item_id;";
		int genId = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, item.getItemName());
			ps.setDate(2, item.getDate());
			ps.setDouble(3, item.getInitialPrice());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				genId = rs.getInt("item_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return genId;
	}

	@Override
	public int delete(Item item) throws IOException {
		String sql = "delete from item where item_id = ? ";
		int result = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setInt(1, item.getItemId());
			result = ps.executeUpdate(sql);
	        con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Item getById(int id) throws IOException {
		String sql = "select * from item where item_id = ? ";
		Item singleItem = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int itemId = rs.getInt("item_id");
				String itemName = rs.getString("item_name");
				Date dateAdded = rs.getDate("date_added");
				Double initialPrice = rs.getDouble("initial_price");		
				singleItem = new Item(itemId, itemName, dateAdded, initialPrice);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		return singleItem;
	}

	@Override
	public List<Item> getAll() throws IOException {
		String sql = "select * from item;";
		List<Item> items = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int itemId = rs.getInt("item_id");
				String itemName = rs.getString("item_name");
				Date dateAdded = rs.getDate("date_added");
				Double initialPrice = rs.getDouble("initial_price");
				
				Item newItem = new Item(itemId, itemName, dateAdded, initialPrice);
				items.add(newItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return items;
	}

	@Override
	public int update(Item t) {
		int result = 0;
		// replace the values of the following variables to modify the respective fields
		String item_name = t.getItemName();
		Double item_price = t.getInitialPrice();
		Date date_added = t.getDate();
		
		String sql = "update item set item_name = ?, item_price = ?, date_added = ?;";
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);	
			ps.setString(1, item_name);
			ps.setDouble(2, item_price);
			ps.setDate(3, date_added);
			
			result = ps.executeUpdate(sql);
	        con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
