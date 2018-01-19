package com.jdbc.source;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DataSourceDBCPIbatis extends DataSource{

	private static DataSourceDBCPIbatis instance = new DataSourceDBCPIbatis();

	private DataSourceDBCPIbatis() {
	}

	public static DataSourceDBCPIbatis getInstance() {
		return instance;
	}

	private SqlMapClient client;

	{
		try {
			String config = "com/cms/sqlConfig/ibatis-sqlConfig.xml";
			Reader reader = Resources.getResourceAsReader(config);
			client=SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Fail to init SqlMapConfig.. ");
		}

	}
	
	public SqlMapClient getSqlMapClient(){
		return this.client;
	}
}







