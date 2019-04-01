/**
 * @(#)MTSUSER.java 2018/07/10
 *
 * Copyright(C) 2016 by FUJINET CO., LTD.
 *
 * Last_Update 2018/07/10
 * Version 1.00.
 */
package fjs.cs.bean;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fjs.cs.dao.T001_DAO;
import fjs.cs.db.DBConnection;

/**
 * Class MTSUSER 
 * 
 * @author phuong-td
 * @version 1.0
 */
public class MstUserBean extends ActionForm {
	
	
	private String txtUserID = "";
	private String txtPassword = "";
	private String userName = "";
	private String PSN_CD = "";
	
	
	public ActionErrors validate(ActionMapping mapping,	HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
//		if (txtUserID == null || txtUserID.length() < 1) {
//			errors.add("txtUserID", new ActionMessage("error.userName.required"));
//			// TODO: add 'error.name.required' key to your resources
//		}
//		if (txtPassword == null || txtPassword.length() < 1) {
//			errors.add("txtPassword", new ActionMessage("error.password.required"));
//			// TODO: add 'error.name.required' key to your resources
//		}
		if (txtUserID.trim().length() > 0 && txtPassword.trim().length() > 0) {
			// create connection
			Connection conn = DBConnection.createConnection();
			// check user exits
			int temp = T001_DAO.checkMstUser(conn, txtUserID, txtPassword);
			if (temp != 1) {
				//display error
				errors.add("txtUserID", new ActionMessage("error.userID.required"));
			}
		}
		return errors;
	}
	
	/*This method will be called when you press the reset button
    or load the form. You may want to populate the form here also*/

		public void reset(ActionMapping mapping, HttpServletRequest request){
//		String reset = (String)request.getAttribute("mstUserBean.reset");
//		System.out.println("reset click1:  " + reset);
//		  if ((null == reset) || ("true".equals(reset))) {
	//		  System.out.println("reset click");
//			  txtUserID = null;
//			  txtPassword = null;
//		  }
			txtPassword = "";
			txtPassword = "";
		}
	
	public String getTxtUserID() {
		return txtUserID;
	}
	public void setTxtUserID(String txtUserID) {
		this.txtUserID = txtUserID;
	}
	public String getTxtPassword() {
		return txtPassword;
	}
	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPSN_CD() {
		return PSN_CD;
	}

	public void setPSN_CD(String pSN_CD) {
		PSN_CD = pSN_CD;
	}
	
	

}
