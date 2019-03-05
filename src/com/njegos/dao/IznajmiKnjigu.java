package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IznajmiKnjigu {

	public static void iznajmiKnjigu(int id, int idKnjige) {
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		String sql = "UPDATE biblioteka.knjige   SET idClana = ?,  iznajmljena = ? WHERE id = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			ps.setBoolean(2, true);
			ps.setInt(3, idKnjige);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
