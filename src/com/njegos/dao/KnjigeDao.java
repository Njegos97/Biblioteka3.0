package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.njegos.entiteti.Knjiga;

public class KnjigeDao {

	Connection connection = ConnectionManager.getInstance().getConnection();

	public Map<Integer, Knjiga> getKnjige() {
		String sql = "SELECT * FROM biblioteka.knjige";
		ResultSet rs = null;
		Knjiga knjiga = null;
		Map<Integer, Knjiga> knjige = new TreeMap<>();

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			rs = ps.executeQuery();
			while (rs.next()) {
				knjiga = new Knjiga();
				knjiga.setId(rs.getInt("id"));
				knjiga.setIme(rs.getString("ime"));
				knjiga.setImeAutora(rs.getString("imeAutora"));
				knjiga.setIznajmljena(rs.getBoolean("iznajmljena"));
                knjige.put(rs.getInt("Id"), knjiga);
                knjiga = null;
  				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return knjige;
	}

}
