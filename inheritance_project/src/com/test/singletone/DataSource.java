package com.test.singletone;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
		
		private static DataSource instance=new DataSource();
		private DataSource(){}
		public static DataSource getInstance(){
			return instance;
		}
	
		// DBMS Driver 이름
	    // 위치정보 : url 
	    // username
	    // password
	
		private String driver="oracle.jdbc.driver.OracleDriver";
		private String url="jdbc:oracle:thin:@localhost:1521:XE";
		private String username="java";
		private String password="java";
		
		private Connection con=null;
		
		{
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url,username,password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public Connection getConnection(){
			return this.con;
		}
		
		
}










