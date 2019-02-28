package com.njegos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager instance = null;
	private Connection connection = null;
	
	private static final String IME = "root";
	private static final String SIFRA = "root123";
	private static final String URL = "jdbc:mysql://localhost:3306/?user=root";
	
	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
		
	}
	
	private boolean openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, IME, SIFRA);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Connection getConnection() {
		if(connection == null) {
			if(openConnection()) {
				System.out.println("Konekcija je otvorena");
				return connection;
			}
			return null;
		}
		return connection;
	}
	
	public void close() {
	System.out.println("Konekcija se zatvara");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
