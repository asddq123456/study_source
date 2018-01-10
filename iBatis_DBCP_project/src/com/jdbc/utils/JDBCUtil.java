package com.jdbc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	private JDBCUtil(){}
	
	public static void close(Connection conn)throws SQLException{
		try{
			if(conn!=null) conn.close();
		}catch(Exception ignore){}
	}
	public static void close(Connection conn, Statement stmt)
		throws SQLException{
		if(stmt!=null) stmt.close();
		try{
			if(conn!=null) conn.close();
		}catch(Exception ignore){}
	}
	public static void close(Connection conn, Statement stmt,
			ResultSet rs) throws SQLException{		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		try{
			if(conn!=null) conn.close();
		}catch(Exception ignore){}
	}
	
	
}









