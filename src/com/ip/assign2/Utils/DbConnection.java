package com.ip.assign2.Utils;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
	 * Creates an executable SQL statement
	 * @param command Stored Proc to execute. Should be a constant from DbCommand class
	 * @param params Vector of string parameters to the stored procedure
	 * @return Valid SQL string 
	 */
	private String buildSql(String command, Vector<String> params) {
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
		
		return sql.toString();
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
	
	/**
	 * Validates a user authentication attempt
	 * @param uname Username to validate
	 * @param pwd Matching password for given user
	 * @return true if the login is valid, false otherwise
	 */
	public boolean validateLogin(String uname, String pwd) {
		/*Vector<String> params = new Vector<String>();
		params.add(uname);
		params.add(pwd);
		
		//Get the sql command
		String sql = buildSql(DbCommand.VALIDATE_LOGIN, params);*/
		
		try {
			CallableStatement proc = mDbCon.prepareCall("{ ? = call " + DbCommand.VALIDATE_LOGIN + "(?,?) }");
			
			proc.registerOutParameter(1, Types.INTEGER);
			proc.setString(2, uname);
			proc.setString(3, pwd);
			
			proc.execute();
			
			int retval = proc.getInt(1);
			
			if(retval > 0) {
				Log.debug("Log in was successful with code: " + retval);
				//Login was valid
				return true;
			} else {
				Log.debug("Log in was unsuccessful with code: " + retval);
				//Invalid login attempt
				return false;
			}
		} catch(Exception e) {
			Log.info("ERROR: " + e.toString());
			return false;
		}
	}
			
	public boolean executeUpdate(String command, Vector<String> params) {
		
		String sql = buildSql(command, params);
		Log.debug("SQL STRING: " + sql);
		
		if( executeUpdate(sql) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
