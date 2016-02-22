package com.ibm.app.csm.domain.model;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.app.csm.data.OrderEmployee;
import com.ibm.app.csm.data.OrderMain;
import com.ibm.app.csm.data.OrderOperation;
import com.ibm.app.csm.data.OrderPRT;
import com.ibm.app.csm.data.OrderRequisition;
import com.ibm.app.csm.data.OrderSpares;

/**
 * Domain model for work level job order details
 * @author SUDDUTT1
 *
 */
public class JobDetailsWorker {

	private String problemDetails;
	private OrderMain jobOrderDetails;
	private OrderEmployee orderEmployee;
	private EmployeeMaster empDetails;
	private List<OrderOperation> operations;
	private List<OrderPRT> toolsList;
	private List<OrderSpares> sparesList;
	private List<OrderRequisition> requisitionList;
	
	public JobDetailsWorker()
	{
		super();
	}

	/**
	 * @return the jobOrderDetails
	 */
	public OrderMain getJobOrderDetails() {
		return jobOrderDetails;
	}

	/**
	 * @param jobOrderDetails the jobOrderDetails to set
	 */
	public void setJobOrderDetails(OrderMain jobOrderDetails) {
		this.jobOrderDetails = jobOrderDetails;
	}

	/**
	 * @return the empDetails
	 */
	public EmployeeMaster getEmpDetails() {
		return empDetails;
	}

	/**
	 * @param empDetails the empDetails to set
	 */
	public void setEmpDetails(EmployeeMaster empDetails) {
		this.empDetails = empDetails;
	}

	/**
	 * @return the operations
	 */
	public List<OrderOperation> getOperations() {
		return operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(List<OrderOperation> operations) {
		this.operations = operations;
	}

	/**
	 * @return the toolsList
	 */
	public List<OrderPRT> getToolsList() {
		return toolsList;
	}

	/**
	 * @param toolsList the toolsList to set
	 */
	public void setToolsList(List<OrderPRT> toolsList) {
		this.toolsList = toolsList;
	}

	/**
	 * @return the sparesList
	 */
	public List<OrderSpares> getSparesList() {
		return sparesList;
	}

	/**
	 * @param sparesList the sparesList to set
	 */
	public void setSparesList(List<OrderSpares> sparesList) {
		this.sparesList = sparesList;
	}

	/**
	 * @return the problemDetails
	 */
	public String getProblemDetails() {
		return problemDetails;
	}

	/**
	 * @param problemDetails the problemDetails to set
	 */
	public void setProblemDetails(String problemDetails) {
		this.problemDetails = problemDetails;
	}
	
	/**
	 * @return the orderEmployee
	 */
	public OrderEmployee getOrderEmployee() {
		return orderEmployee;
	}

	/**
	 * @param orderEmployee the orderEmployee to set
	 */
	public void setOrderEmployee(OrderEmployee orderEmployee) {
		this.orderEmployee = orderEmployee;
	}

	/**
	 * @return the requisitionList
	 */
	public List<OrderRequisition> getRequisitionList() {
		return requisitionList;
	}

	/**
	 * @param requisitionList the requisitionList to set
	 */
	public void setRequisitionList(List<OrderRequisition> requisitionList) {
		this.requisitionList = requisitionList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
