package ru.ema.test_dz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class Conn_DB {
 
	private Connection conn = null;
	
	public Connection conn_sqllite (){
		
	 String dbURL = "jdbc:sqlite:test.db";
		 try {
			   conn = DriverManager.getConnection(dbURL);
		     } catch (SQLException e) {
			  System.out.println("Не удалось подключится к БД");
			   e.printStackTrace();	}
		
		return conn;
		
	}
}
