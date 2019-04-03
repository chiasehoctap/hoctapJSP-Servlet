package fjs.cs.action;


import java.sql.Connection;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

import fjs.cs.bean.SearchBean;
import fjs.cs.dao.T002_DAO;
import fjs.cs.db.DBConnection;
import fjs.cs.dto.MSTCUSTOMER;





public class T002_Search2 extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		  SearchBean userForm = (SearchBean) form;
		 
		 // System.out.println("button: " +  userForm.getMode());
		  Connection conn = DBConnection.createConnection();
		
			//delete MSTCUSTOMER
		  String selectedCustomer = userForm.getSelectedCustomer();
			if ("delete".equalsIgnoreCase( userForm.getMode()) == true) {
				
				String currentDate = "2018/01/01";
				
				String pattern = "yyyy/MM/dd";
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				
					// formatting
					// System.out.println(format.format(new Date()));
					currentDate = format.format(new Date());
				
	
				if ("".equalsIgnoreCase(selectedCustomer) == false) {
					String[] arrayCustomer = selectedCustomer.split(",");
					for (String customer : arrayCustomer) {
						//System.out.println("id: " + customer);
						// delete MSTCUSTOMER
						T002_DAO.deleteMSTCUSTOMER(conn, customer, currentDate);
					}
				 
				   
				
				}
			}
		// get infomation of CUSTOMER to search
		String CUSTOMER_NAME = userForm.getTxtCustomerName();
		String SEX = userForm.getCboSex();
		String BIRTHDAYFROM = userForm.getTxtBirthdayFrom();
		String BIRTHDAYTO = userForm.getTxtBirthdayTo();
		String ADDRESS = "";
		// get session
		HttpSession session = request.getSession(true);

		// if you click switch page button
		if ("search".equalsIgnoreCase(userForm.getMode()) == false
				&& "delete".equalsIgnoreCase(userForm.getMode()) == false) {
			// get information of CUSTOMER to search
			CUSTOMER_NAME = (String) session.getAttribute("CUSTOMER_NAME");
			SEX = (String) session.getAttribute("SEX");
			BIRTHDAYFROM = (String) session.getAttribute("BIRTHDAYFROM");
			BIRTHDAYTO = (String) session.getAttribute("BIRTHDAYTO");
			ADDRESS = "";

			// update bean if you don't click search
			userForm.setTxtCustomerName(CUSTOMER_NAME);
			userForm.setCboSex(SEX);
			userForm.setTxtBirthdayFrom(BIRTHDAYFROM);
			userForm.setTxtBirthdayTo(BIRTHDAYTO);
		}
		// save session
		session.setAttribute("CUSTOMER_NAME", CUSTOMER_NAME);
		session.setAttribute("BIRTHDAYFROM", BIRTHDAYFROM);
		session.setAttribute("BIRTHDAYTO", BIRTHDAYTO);
		session.setAttribute("SEX", SEX);

		// list MSTCUSTOMER
		List<MSTCUSTOMER> list = null;

		String pageIdString = userForm.getPageid();
		// get page id

		// page number
		int pageid = Integer.parseInt(pageIdString);

		// max page number
		int count = 15;

		// load into list MTSCUSTOMER in the first page
		if (pageid == 1) {
			list = T002_DAO.searchMSTCUSTOMERPage(0, count, conn,
					CUSTOMER_NAME, SEX, BIRTHDAYFROM, BIRTHDAYTO, ADDRESS);
		} else {
			// start position
			int start = (Integer.parseInt(pageIdString) - 1) * count;
			list = T002_DAO.searchMSTCUSTOMERPage(start, count, conn,
					CUSTOMER_NAME, SEX, BIRTHDAYFROM, BIRTHDAYTO, ADDRESS);
		}

		// number of CUSTOMER
		int sumRow = T002_DAO.countMSTCUSTOMERPage(conn, CUSTOMER_NAME, SEX,
				BIRTHDAYFROM, BIRTHDAYTO, ADDRESS);

		// max page id
		int maxpageid = 1;
		if (sumRow % count == 0) {
			maxpageid = (sumRow / count);
		} else {
			maxpageid = (sumRow / count) + 1;
		}

		// max page id
		request.setAttribute("maxpageid", maxpageid);
		// current page
		request.setAttribute("stt", Integer.parseInt(pageIdString));

		T002_Search2.disableButton(request, response, list, pageIdString,
				sumRow, maxpageid);

		// return mapping.findForward("success");
		return mapping.findForward("preaction");
	}
	
	/**
	 * Init the first page when you login success
	 * 
	 * @param HttpServletRequest   req
	 * @param HttpServletResponse  res
	 * @param Connection conn
	 * @return RequestDispatcher
	 */
	public static final  void Init(HttpServletRequest req, HttpServletResponse res, Connection conn) {
		//list MSTCUSTOMER
		List<MSTCUSTOMER> list = null;
		//set default this is the first page
		String pageIdString = "1";
		int pageid = Integer.parseInt(pageIdString);
		//max page number
		int count = 15;
		
		//if this is the first page
		if (pageid == 1) {
			list = T002_DAO.searchMSTCUSTOMERPage(0, count, conn, "", "", "", "", "");
		}
		
		//get number of MSTCUSTOMER
		int sumRow = T002_DAO.countMSTCUSTOMER(conn);
		
		//max page id
		int maxpageid = 1;
		if (sumRow % count == 0) {
			maxpageid = (sumRow / count);
		} else {
			maxpageid = (sumRow / count) + 1;
		}
		req.setAttribute("maxpageid", maxpageid);
		req.setAttribute("stt", Integer.parseInt(pageIdString));
		
		//disable button
		T002_Search2.disableButton(req, res, list, pageIdString, sumRow, maxpageid);

	}
	
	/**
	 * disable button
	 * 
	 * @param HttpServletRequest   req
	 * @param HttpServletResponse  res
	 * @param List<MSTCUSTOMER> list
	 * @param String pageIdString
	 * @param int sumRow: number MSTCUSTOMER
	 * @param int maxpageid: max page id number
	 */
	public static void disableButton(HttpServletRequest req,
			HttpServletResponse res, List<MSTCUSTOMER> list,
			String pageIdString, int sumRow, int maxpageid) {
		// max page number
		int count = 15;
		// if list MSTCUSTOMER isn't null
		if (list != null) {
			req.setAttribute("listCustomer", list);
		}

		// check to enable or disable button, check = 0 is true
		int check = 0;

		// if list is empty and check is true we disable all button
		if (list.size() == 0 && check == 0) {
			
			req.setAttribute("disabled", "true");
			// disable Delete button
			req.setAttribute("deleteDisabled", "disabled");
			check = 1;
		}

		// if list is less than 15 and check is true we disable all button
		// if maxpageid is equal to 15 and check is true we disable all button
		if ((list.size() <= 15 || maxpageid == 0) && check == 0	&& sumRow < count) {
			
			req.setAttribute("disabled", "true");
			check = 1;
		}

		// if sumrow <= max page number
		if (sumRow <= count) {
			req.setAttribute("disabled", "true");
			check = 1;
		}

		// if currrent page is greater than max page number
		if ((Integer.parseInt(pageIdString) > (maxpageid - 1)) && check == 0) {
			
			req.setAttribute("maxpageDisabled", "true");
			check = 1;
		}
		// if currrent page is less than min page number
		if ((Integer.parseInt(pageIdString) <= 1) && check == 0) {
			
			req.setAttribute("minpageDisabled", "true");
			check = 1;
		}
	}
	
	

	}
