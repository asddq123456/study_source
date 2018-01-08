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

	/*
	 * JDBC 구성..
	 * 
	 * 1. connection driver API ex)ojdbc6.jar 2. Driver loading 3. DriverManager
	 * Connection 가져오기 4. Statement / PreparedStatement 5. sql문 injection 6. 질의
	 * 대한 결과 : ResultSet 7. VO 클래스를 통한 객체화.
	 */
	static {
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		username = "jdbc";
		password = "jdbc";
	}
	private static DataSource instance = new DataSource();

	private DataSource() {
	}

	public static DataSource getInstance() {
		return instance;
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver loading Fail!");
		} catch (SQLException e) {
			System.out.println("Connection failure!!");
		}
		return conn;
	}

}
