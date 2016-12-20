package com.neweye.jdbc.loader;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.impl.GenericObjectPool;

import com.neweye.jdbc.DataSource;

public class DBCPInit extends DataSource{

	private static DBCPInit instance =new DBCPInit();	
	public static DBCPInit getInstance(){
		return instance;
	}
	
	private PoolingDataSource<PoolableConnection> dataSource;

	private DBCPInit(){

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
					"jdbc:oracle:thin:@localhost:1521:XE", "jspexam", "jspex");
			PoolableConnectionFactory poolableConnectionFractory = new PoolableConnectionFactory(
					connectionFactory, null);
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(
					poolableConnectionFractory);
			dataSource = new PoolingDataSource<PoolableConnection>(
					connectionPool);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();

		return conn;
	}

}
