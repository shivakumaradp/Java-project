package com.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteClass {
	
	static Connection conn = null;
	
	public static Connection dbconnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection("jdbc:sqlite:E:\\SqliteDB\\BankingDB.db");
			//System.out.println("Database Connected....");
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			return conn;
		} catch (SQLException e) {
			System.out.println(e);
			return conn;
		}
		
		
	}

}
