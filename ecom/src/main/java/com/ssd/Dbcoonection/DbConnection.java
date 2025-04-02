package com.ssd.Dbcoonection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public static Connection conn = null;
	public static Connection getDbConnection() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-cart","root","Sai@1919");	
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
		
		return conn;
	}
	
}
