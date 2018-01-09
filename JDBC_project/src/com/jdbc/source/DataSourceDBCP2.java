package com.jdbc.source;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

final public class DataSourceDBCP2 extends DataSource {
	
	private static DataSourceDBCP2 instance=new DataSourceDBCP2();
	private DataSourceDBCP2(){};
	public static DataSourceDBCP2 getInstance(){
		return instance;
	} 
	
	
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String username = "jdbc";
	private String password = "jdbc";
	
	{
		loadJDBCDriver();
		initConnectionPool();
	}

	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.
					getConnection("jdbc:apache:commons:dbcp:cp");
		} catch (Exception e) {
			throw new RuntimeException("Fail To get Connection");
		}
		return conn;
	}

	private void loadJDBCDriver() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Fail to JDBC driver..");
		}
	}

	private void initConnectionPool() {
		try {
			
			ConnectionFactory conFactory = new DriverManagerConnectionFactory(url, username, password);

			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(conFactory, null);

			poolableConnFactory.setValidationQuery("select 1");

			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			// 컨넥션 검사주기
			poolConfig.setTimeBetweenEvictionRunsMillis(1000 * 60 * 1);
			// 풀에 있는 컨넥션이 유효한지 검사 유무 설정
			poolConfig.setTestWhileIdle(true);
			// 컨넥션 최소개수
			poolConfig.setMinIdle(4);
			// 컨넥션 최대개수
			poolConfig.setMaxIdle(50);

			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(
					poolableConnFactory, poolConfig);

			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("cp", connectionPool);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Fail to Connection Pool.. ");
		}
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DataSourceDBCP2 [driverName=" + driverName + ", url=" + url + ", username=" + username + ", password="
				+ password + "]";
	}

}
