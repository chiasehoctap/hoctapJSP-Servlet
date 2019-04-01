package fjs.cs.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fjs.cs.bean.MstUserBean;

public class T001_PreAction extends Action{
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	MstUserBean user = (MstUserBean) form;
	user.setTxtUserID("");
	user.setTxtPassword("");
	return mapping.findForward("preaction");
}
}
