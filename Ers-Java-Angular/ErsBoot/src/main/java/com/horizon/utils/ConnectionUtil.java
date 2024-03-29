package com.horizon.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection con;

	//bad practice
	public static Connection getHardCodedConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "";

		/*
		 * If Connection con is null or closed, we're creating a new connection 
		 * otherwise we're returning an existing connection.
		 */
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
	
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("prop.properties"));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		
		return con;
	}
	
	public static Connection getConnectionFromEnv() throws SQLException {
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		
		return con;
	}
}

