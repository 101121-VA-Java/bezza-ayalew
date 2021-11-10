package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.util.ConnectionUtil;

public class SalesDao {
	
	String sql = "Select item.item_name, item_status.status, payment.paid_amount"
			+ "From item Inner Join item_status ON item.item_id = item_status.item_id"
			+ "Inner Join payment ON item.item_id = payment.item_id;";
			
	try (Connection con = ConnectionUtil.getConnectionFromFile()){
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);	
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
		}
		}
}

}
