package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IzbrisiKnjigu {

	
	public static void izbrisiKnjigu(int id) {
		Connection connection = ConnectionManager.getInstance().getConnection();
		String sql = "DELETE * FROM biblioteka.knjige where (id = ?)";
		
		try (PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Izbrisali ste " + rs.getString("ime"));
			}
			else {
				System.out.println("Nema takve knjige");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
