package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DodajKnjigu {

	public static void doadajKnjigu(String ime, String imeAutora, boolean iznajmljena) {
		Connection connection = ConnectionManager.getInstance().getConnection();
		String sql = "INSERT INTO biblioteka.knjige (ime, imeAutora, iznajmljena) VALUES(?, ?, ?)";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, ime);
			ps.setString(2, imeAutora);
			ps.setBoolean(3, iznajmljena);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
