package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.njegos.entiteti.Biblioteka;
import com.njegos.entiteti.Clan;
import com.njegos.entiteti.Knjiga;
import com.njegos.logika.BibliotekaLogika;

public class IznajmljeneKnjige {

	public static void iznajmljeneKnjige (Biblioteka biblioteka) {
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		String sql = "SELECT * from biblioteka.knjige";
		Knjiga knjiga = null;
		Clan clan = null;
		
		ResultSet rs = null;
		Map<Integer, Knjiga> iznajmljeneKnjige = new LinkedHashMap<>(); 
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("idClana") > 0) {
					knjiga = BibliotekaLogika.pronadjiKnjigu(biblioteka.getKnjige(), rs.getInt("id"));
				    clan = BibliotekaLogika.pronadjiClana(biblioteka.getClanovi(), rs.getInt("idClana"));
				    clan.getMojeKnjige().put(rs.getInt("id"), knjiga);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
