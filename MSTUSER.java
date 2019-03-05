/**
 * @(#)MTSUSER.java 2018/07/10
 *
 * Copyright(C) 2016 by 123456 CO., LTD.
 *
 * Last_Update 2018/07/10
 * Version 1.00.
 */
package fjs.cs.dto;

/**
 * Class MTSUSER 
 * 
 * @author name
 * @version 1.0
 */
public class MSTUSER {
	
	//PDN_CD
	private int PSN_CD;
	//user id
	private String USERID;
	//password info
	private String PASSWORD;
	//username info
	private String USERNAME;
	
	//constructor default
	public MSTUSER() {
		
	}
	
	/**
	 * constructor
	 * 
	 * @param pASSWORD: password info
	 * @param uSERNAME: username info
	 */
	public MSTUSER(String pASSWORD, String uSERNAME) {
		super();
		PASSWORD = pASSWORD;
		USERNAME = uSERNAME;
	}
	
	/**
	 * get PSN_CD info
	 * 
	 * @return  PSN_CD info
	 */
	public int getPSN_CD() {
		return PSN_CD;
	}
	
	/**
	 * set PSN_CD info
	 * @param pSN_CD
	 * 
	 */
	public void setPSN_CD(int pSN_CD) {
		PSN_CD = pSN_CD;
	}
	
	/**
	 * get USERID info
	 * 
	 * @return  USERID info
	 */
	public String getUSERID() {
		return USERID;
	}
	
	/**
	 * set USERID info
	 * @param pSN_CD
	 * 
	 */
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	
	/**
	 * get PASSWORD info
	 * 
	 * @return  PASSWORD info
	 */
	public String getPASSWORD() {
		return PASSWORD;
	}
	
	/**
	 * set PASSWORD info
	 * 
	 * @param  pASSWORD
	 */
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	/**
	 * get USERNAME info
	 * @return  USERNAME info
	 */
	public String getUSERNAME() {
		return USERNAME;
	}
	
	/**
	 * set USERNAME info
	 * 
	 * @param  USERNAME info
	 */
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	
}
