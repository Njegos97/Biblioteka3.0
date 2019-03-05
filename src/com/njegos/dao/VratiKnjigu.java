package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VratiKnjigu {

	public static void vratiKnjigu(int id) {
		Connection connection = ConnectionManager.getInstance().getConnection();
		String sql = "UPDATE  biblioteka.knjige SET idClana = null, iznajmljena = false  WHERE id = ?";
		
       try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
