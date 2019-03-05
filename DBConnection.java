/**
 * @(#)DBConnection.java 2018/07/04.
 *
 * Copyright(C) 2016 by FUJINET CO., LTD.
 *
 * Last_Update 2018/07/10.
 * Version 1.00.
 */
package fis.cs.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class DBConnection create connection 
 * 
 * @author QUANG_DUONGV
 * @version 1.0
 */
public class DBConnection {

	//user name info 
	private static String USER_NAME = "sa";
	//password info 
	private static String PASSWORD = "Abc12345";
	//host name  info
	static String hostName = "localhost";
	//SQL instance name info 
	static String sqlInstanceName = "PHUONG-TD-W7";
	//database name info 
	static String database = "customersystem";
	//URL info 
	private static String DB_URL = "jdbc:sqlserver://" + hostName + ":1433" 
               + ";instance=" + sqlInstanceName + ";databaseName=" + database;

	 /**
     * create connection 
     * 
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}

		return conn;
	}
}
