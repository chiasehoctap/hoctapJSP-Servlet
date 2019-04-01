package fjs.cs.action;

import java.sql.Connection;

import javax.servlet.http.*;

import org.apache.struts.action.*;




import fjs.cs.bean.MstUserBean;
import fjs.cs.dao.T001_DAO;
import fjs.cs.db.DBConnection;
import fjs.cs.dto.MSTUSER;

public class T001_Login extends Action{
 @Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	 		MstUserBean userBean = (MstUserBean) form;
			String userid = userBean.getTxtUserID();
			String password = userBean.getTxtPassword();
	
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
						userBean.setUserName(user.getUSERNAME());
						userBean.setPSN_CD(String.valueOf(user.getPSN_CD()));
	
					}
					//Init page
					T002_Search2.Init(request, response, conn);
					
					return (mapping.findForward("success"));
				
				}
			}
			return (mapping.findForward("bad-password"));
		
}
}
