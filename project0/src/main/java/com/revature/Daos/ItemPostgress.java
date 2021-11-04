package com.revature.Daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.revature.models.Item;
import com.revature.util.ConnectionUtil;

public interface ItemPostgress implements GenericDao<Item> {

	@Override
	default Item add(Item t) throws IOException {
		String sql = "insert into item (item_name, date_added, initial_price) "
				+ "values (?, ?, ?) returning item_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, Item.getItem_name());
			ps.setDate(2, Item.getDate_added());
			ps.setDouble(3, Item.getInitial_price());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				int genId = rs.getInt("emp_id");
			}
		
			return genId;
		return null;
	}

	@Override
	default Item delete(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Item getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default boolean update(Item t) {
		// TODO Auto-generated method stub
		return false;
	}

}
