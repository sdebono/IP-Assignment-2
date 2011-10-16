package com.ip.assign2.Utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DbConnection implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String MSSQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private static final String MSSQL_CONNECTION_STRING = "jdbc:sqlserver://localhost:1433;Instance=SQLEXPRESS;DatabaseName=IP Auction Site";
	
	private static final String MSSQL_USER = "ipuser";
	
	private static final String MSSQL_PASSWORD = "password";
		
	private Connection mDbCon;
			
	public DbConnection() {
		super();
	}
	
	public void connect() throws Exception {
		Class.forName(MSSQL_DRIVER).newInstance();
		mDbCon = DriverManager.getConnection(MSSQL_CONNECTION_STRING, MSSQL_USER, MSSQL_PASSWORD);
	}
	
	public void close() throws SQLException {
		mDbCon.close();
	}
	
	/**
	 * Internal method to commit an update to the database
	 * @param sql The sql string to execute
	 * @return The number of rows affected by the transaction (-1 on error)
	 */
	private int executeUpdate(String sql) {
		try {
			Statement s = mDbCon.createStatement();
			int result = s.executeUpdate(sql);
			return result;
		} catch(Exception e) {
			return -1;
		}
	}
	
	public boolean executeUpdate(String command, Vector<String> params) {
		
		StringBuilder sql= new StringBuilder(); 
		sql.append(DbCommand.EXEC + command);
		
		//Add all parameters (including separators except for on last parameter)
		for(int i = 0, size = params.size(); i < size; i++) {
			if( i == (size - 1) ) {
				sql.append("'").append(params.get(i)).append("'");
			} else {
				sql.append("'").append(params.get(i)).append("'").append(DbCommand.SEPARATOR);
			}
		}
		
		System.err.println("SQL STRING: " + sql.toString());
		
		if( executeUpdate(sql.toString()) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
