package com.jdbc.source;

import java.sql.Connection;

public class DataSourceTest {
	
	public static void main(String[] args){
		
		Connection conn=DataSource.getConnection();
		
		System.out.println(conn);
	}
}
