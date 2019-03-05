package com.njegos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.njegos.entiteti.Clan;

public class DodajClana {

	 
	
	public static void dodajClana(String ime, String prezime, int brojIznajmljenihKnjiga) {
	Connection connection = ConnectionManager.getInstance().getConnection();
	String sql = "INSERT INTO biblioteka.clanovi(ime, prezime, brojIznajmljenihKnjiga) VALUES (?, ?, ?)";
	
	try(PreparedStatement ps = connection.prepareStatement(sql)){
	
	ps.setString(1, ime);
	ps.setString(2, prezime);
	ps.setInt(3, brojIznajmljenihKnjiga);

	ps.executeUpdate();
	
	
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
}
