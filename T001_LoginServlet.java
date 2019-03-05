/**
 * @(#)T001_LoginServlet.java 2018/07/04.
 *
 * Copyright(C) 2016 by 123456 CO., LTD.
 *
 * Last_Update 2018/07/10.
 * Version 1.00.
 */
package fjs.cs.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fis.cs.db.DBConnection;
import fis.cs.dao.T001_DAO;
import fjs.cs.common.Constants;
import fjs.cs.dto.MSTUSER;

/**
 * LoginServlet(Login)
 * 
 * @author name
 * @version 1.00
 * 
 */
public class T001_LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Event screen: switch page
	 * 
	 * @param HttpServletRequest req
	 * @param HttpServletResponse resp
	 * @return RequestDispatcher
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//remove session
		HttpSession session = req.getSession(false);
							
		RequestDispatcher myRD = null;
		// Display Login screen
		myRD = req.getRequestDispatcher(Constants.T001_LOGIN);
		myRD.forward(req, resp);
	
	}

	/**
	 * Init screen
	 * 
	 * @param HttpServletRequest req
	 * @param HttpServletResponse resp
	 * @return RequestDispatcher
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// user_id info
		String userid = req.getParameter("txtUserID");
		// password info
		String password = req.getParameter("txtPassword");

		RequestDispatcher myRD = null;
		myRD = req.getRequestDispatcher(Constants.T001_LOGIN);
	
		// compare userID and password in database
		if (userid.trim().length() > 0 && password.trim().length() > 0) {
			// create connection
			Connection conn = DBConnection.createConnection();
			// check user exits
			int temp = T001_DAO.checkMstUser(conn, userid, password);
			if (temp == 1) {
				MSTUSER user = null;
				// get user info
				user = T001_DAO.getMSTUSER(conn, userid, password);
				if (user != null) {
					//save user info into session
					HttpSession session = req.getSession(true);
					session.setAttribute("sessionname", user.getUSERNAME());
					session.setAttribute("PSN_CD", user.getPSN_CD());
					session.setAttribute("CUSTOMER_NAME", "");
					session.setAttribute("BIRTHDAYFROM", "");
					session.setAttribute("BIRTHDAYTO", "");
					session.setAttribute("SEX", "");
				}
				
				//Init page
				T002_SearchServlet.Init(req, resp, conn);

				// display search screen
				myRD = req.getRequestDispatcher(Constants.T002_SEARCH);

			} else if (temp != 1) {
				//display error
				req.setAttribute("message", "ƒ†�[ƒU�[ID‚Ü‚½‚ÍƒpƒXƒ��[ƒh‚ª•s�³‚Å‚·�B");
				myRD = req.getRequestDispatcher(Constants.T001_LOGIN);
			}
		}
		myRD.forward(req, resp);
	}
}
