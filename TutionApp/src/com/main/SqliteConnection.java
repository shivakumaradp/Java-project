package com.main;

import java.sql.*;

import javax.swing.*;

public class SqliteConnection {
	
	static Connection conn=null;
	
	public static Connection dbconnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection("jdbc:sqlite:E:\\SqliteDB\\TutionDB.db");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Unsuccessful");
			return null;
		}
	}
	
	

}
