package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.njegos.entiteti.Clan;

public class ClanoviDao {

	Connection connection = ConnectionManager.getInstance().getConnection();
	
	public Map<Integer, Clan> getClanovi(){
		String sql = "SELECT * FROM biblioteka.clanovi";
		ResultSet rs = null;
		Clan clan = null;
		Map<Integer, Clan> clanovi = new LinkedHashMap<>();
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			rs = ps.executeQuery();
			
			while(rs.next()) {
			clan = new Clan();
			clan.setId(rs.getInt("id"));
			clan.setIme(rs.getString("ime"));
			clan.setPrezime(rs.getString("prezime"));
			clanovi.put(rs.getInt("id"), clan);
			clan = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clanovi;
	}
	
}
