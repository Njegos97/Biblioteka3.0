package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IzbrisiClana {

	public static void izbrisiClana(int id) {
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		String sql = "DELETE * FROM biblioteka.clanovi where (id = ?)";
		
		try (PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Izbisali ste " + rs.getString("ime"));
			}
			else {
				System.out.println("Ups");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}