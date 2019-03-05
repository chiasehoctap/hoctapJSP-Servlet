/**
 * @(#)T001_DAO.java 2019/03/05.
 *
 * Copyright(C) 2016 by FUJINET CO., LTD.
 *
 * Last_Update 2018/07/13.
 * Version 1.00.
 */
package fis.cs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fjs.cs.dto.MSTUSER;

/**
 * T001_DAO
 * 
 * @author QUANG_DUONGV
 * @version 1.0
 */
public class T001_DAO {
	
	 /**
     * get MSTUSER info 
     * 
     * @param conn: Connection
     * @param userid: userid is used to login
     * @param password: password is used to login
     * @return user : MSTUSER
     */
	public static MSTUSER getMSTUSER(Connection conn, String userid, String password) {
		MSTUSER user = null;

		PreparedStatement pstm = null;
		//query sentences
		String sql = "SELECT * FROM MSTUSER WHERE USERID = '" + userid
				+ "' AND PASSWORD = '" + password + "' AND DELETE_YMD IS NULL";
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				user = new MSTUSER();
				user.setPSN_CD(rs.getInt(1));
				user.setUSERID(rs.getString(2));
				user.setPASSWORD(rs.getString(3));
				user.setUSERNAME(rs.getString(4));
			}
		} catch (Exception ex) {
			//print error
			String error = ex.getMessage();
			System.out.println("Error: " + error);
		}
		return user;
	}

	 /**
     * count and check user if exist 
     * 
     * @param conn: Connection
     * @param userid: userid is used to login
     * @param password: password is used to login
     * @return user : MSTUSER
     */
	public static int 
(Connection conn, String userid,
			String password) {
		int result = 0;
		PreparedStatement pstm = null;
		//query sentences
		String sql = "SELECT count(*) FROM MSTUSER WHERE USERID = '" + userid
				+ "' AND PASSWORD = '" + password + "' AND DELETE_YMD IS NULL";
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception ex) {
			//print error
			String error = ex.getMessage();
			System.out.println("Error: " + error);
		}
		return result;
	}
}
