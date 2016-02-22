package com.ibm.app.csm.dao;

/**
 * Common application constants
 * @author SUDDUTT1
 *
 */
public interface ApplicationConstants {

	String USER_OBJECT = "CSM_USER";
	String JOB_TYPE_BREAK = "BREK";
	String JOB_TYPE_PREVTIVE="PREV";
	String JOB_TYPE_PREDICTIVE  = "PRED";
	
	String JOB_STATUS_ANALYZED = "ANZ";
	String JOB_STAUS_CREATED = "CRTD";
	String JOB_STAUS_CLOSED = "CLSD";
	String JOB_STAUS_WIP = "WRKP";
	String JOB_STAUS_REFRRED = "RFRD";
	
	String OPERATION_STATUS_ASSIGNED = "ASSIGNED";
	String OPERATION_STATUS_COMPLETED = "COMPLETED";
	String OPERATION_STATUS_REFERRED = "REFERRED";
	
	String REQUI_TYPE_PARTS = "PARTS";
	String REQUI_TYPE_SPARES = "SPARES";
	
	String REQUI_STATUS_ASSIGNED = "ASSIGNED";
	String REQUI_STATUS_ISSUED = "ISSUED";
}
