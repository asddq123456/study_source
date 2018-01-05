package com.jdbc.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	static private String driver;
	static private String url;
	static private String username;
	static private String password;
	
	static private Connection conn;
	
	/*JDBC ����..

	1. connection driver API ex)ojdbc6.jar
	2. Driver loading
	3. DriverManager Connection ��������
	4. Statement / PreparedStatement 
	5. sql�� injection
	6. ���� ���� ��� : ResultSet
	7. VO Ŭ������ ���� ��üȭ.
*/	
	static{
		driver="oracle.jdbc.driver.OracleDriver";
		url="jdbc:oracle:thin:@localhost:1521:XE";
		username="jdbc";
		password="jdbc";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver loading Fail!");
		} catch (SQLException e) {
			System.out.println("Connection failure!!");
		}
		
	}
	
	private DataSource(){}
	
	public static Connection getConnection(){
		return conn;
	}
	
}










