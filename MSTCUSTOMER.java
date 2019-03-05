/**
 * @(#)MSTCUSTOMER.java 2018/07/10
 *
 * Copyright(C) 2016 by FUJINET CO., LTD.
 *
 * Last_Update 2018/07/10
 * Version 1.00.
 */
package fjs.cs.dto;

/**
 * Class MSTCUSTOMER 
 * 
 * @author QUANG_DUONGV
 * @version 1.0
 */
public class MSTCUSTOMER {
		//CUSTOMER_ID
		private int CUSTOMER_ID;
		//CUSTOMER_NAME
		private String CUSTOMER_NAME;
		//SEX info
		private String SEX;
		//BIRTHDAY info
		private String BIRTHDAY;
		//EMAIL
		private String EMAIL;
		//ADDRESS
		private String ADDRESS;
		
		/**
		 * get CUSTOMER_ID info
		 * 
		 * @return  CUSTOMER_ID info
		 */
		public int getCUSTOMER_ID() {
			return CUSTOMER_ID;
		}
		
		/**
		 * set CUSTOMER_ID info
		 * 
		 * @param  cUSTOMER_ID info
		 */
		public void setCUSTOMER_ID(int cUSTOMER_ID) {
			CUSTOMER_ID = cUSTOMER_ID;
		}
		
		/**
		 * get CUSTOMER_NAME info
		 * 
		 * @return  CUSTOMER_NAME info
		 */
		public String getCUSTOMER_NAME() {
			return CUSTOMER_NAME;
		}
		
		/**
		 * set CUSTOMER_NAME info
		 * 
		 * @param  cUSTOMER_NAME info
		 */
		public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
			CUSTOMER_NAME = cUSTOMER_NAME;
		}
		
		/**
		 * get SEX info
		 * 
		 * @return  SEX info
		 */
		public String getSEX() {
			return SEX;
		}
		
		/**
		 * set SEX info
		 * 
		 * @param  sEX info
		 */
		public void setSEX(String sEX) {
			SEX = sEX;
		}
		
		/**
		 * get BIRTHDAY info
		 * 
		 * @return  BIRTHDAY info
		 */
		public String getBIRTHDAY() {
			return BIRTHDAY;
		}
		
		/**
		 * set BIRTHDAY info
		 * 
		 * @param bIRTHDAY info
		 */
		public void setBIRTHDAY(String bIRTHDAY) {
			BIRTHDAY = bIRTHDAY;
		}
		
		
		/**
		 * get EMAIL info
		 * 
		 * @return  EMAIL info
		 */
		public String getEMAIL() {
			return EMAIL;
		}
		
		/**
		 * set EMAIL info
		 * 
		 * @param  eMAIL info
		 */
		public void setEMAIL(String eMAIL) {
			EMAIL = eMAIL;
		}
		
		/**
		 * get ADDRESS info
		 * 
		 * @return  ADDRESS info
		 */
		public String getADDRESS() {
			return ADDRESS;
		}


		/**
		 * set ADDRESS
		 * 
		 * param aDDRESS info
		 */
		public void setADDRESS(String aDDRESS) {
			ADDRESS = aDDRESS;
		}
		
}
