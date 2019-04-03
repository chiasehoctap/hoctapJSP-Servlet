package fjs.cs.bean;

import org.apache.struts.action.ActionForm;

public class SearchBean extends ActionForm{

	private String txtCustomerName = "";
	private String cboSex = "";
	private String txtBirthdayFrom = "";
	private String txtBirthdayTo = "";
	private String mode = "";
	private String message = "";
	private String pageid = "1";
	private String maxpageid = "1";
	private String selectedCustomer = "";
	
	public SearchBean(String txtCustomerName, String cboSex,
			String txtBirthdayFrom, String txtBirthdayTo, String mode,
			String message, String pageid, String maxpageid) {
		super();
		this.txtCustomerName = txtCustomerName;
		this.cboSex = cboSex;
		this.txtBirthdayFrom = txtBirthdayFrom;
		this.txtBirthdayTo = txtBirthdayTo;
		this.mode = mode;
		this.message = message;
		this.pageid = pageid;
		this.maxpageid = maxpageid;
	}



	

    public SearchBean() {
       
    }
    
   

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

	public String getTxtCustomerName() {
		return txtCustomerName;
	}
	public void setTxtCustomerName(String txtCustomerName) {
		this.txtCustomerName = txtCustomerName;
	}
	public String getCboSex() {
		return cboSex;
	}
	public void setCboSex(String cboSex) {
		this.cboSex = cboSex;
	}
	public String getTxtBirthdayTo() {
		return txtBirthdayTo;
	}
	public void setTxtBirthdayTo(String txtBirthdayTo) {
		this.txtBirthdayTo = txtBirthdayTo;
	}
	public String getTxtBirthdayFrom() {
		return txtBirthdayFrom;
	}
	public void setTxtBirthdayFrom(String txtBirthdayFrom) {
		this.txtBirthdayFrom = txtBirthdayFrom;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMaxpageid() {
		return maxpageid;
	}

	public void setMaxpageid(String maxpageid) {
		this.maxpageid = maxpageid;
	}



	public String getPageid() {
		return pageid;
	}



	public void setPageid(String pageid) {
		this.pageid = pageid;
	}





	public String getSelectedCustomer() {
		return selectedCustomer;
	}





	public void setSelectedCustomer(String selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}






}
