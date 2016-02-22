package com.ibm.app.csm.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.app.csm.data.EquipmentMaster;
import com.ibm.app.csm.data.Operations;
import com.ibm.app.csm.data.OrderEmployee;
import com.ibm.app.csm.data.OrderMain;
import com.ibm.app.csm.data.OrderPRT;
import com.ibm.app.csm.data.OrderRequisition;
import com.ibm.app.csm.data.OrderSpares;
import com.ibm.app.csm.data.PRTMaster;
import com.ibm.app.csm.data.Problem;
import com.ibm.app.csm.data.SparesMaster;

/**
 * Domain model object for Supervisor view of a job order.
 * @author SUDDUTT1
 *
 */
public class JobDetailsSupervisor {

	private OrderMain jobOrderDetails;
	private Problem problemDetails;
	private List<Operations> operationsList;
	private EquipmentMaster equipmentDetails = null;
	private List<PRTMaster> proposedToolsList = null;
	private List<SparesMaster> proposedSparesList = null;
	private List<String> selectedEmployee = null;
	private List<OrderRequisition> requisitions = null;
	private List<EmployeeMaster> proposedEmpList = null;
	//For viewing the assigned item
	private List<OrderPRT> assignedPRTList = null;
	private List<OrderSpares> assignedSparesList = null;
	private List<OrderEmployee> assignedOrderEmpList = null;
	private Map<String,String> requisitionNumbers = null;
	
	public JobDetailsSupervisor()
	{
		super();
		this.selectedEmployee = new ArrayList<>();
	}
	
	/**
	 * @return the selectedEmployee
	 */
	public List<String> getSelectedEmployee() {
		return selectedEmployee;
	}
	
	/**
	 * @param selectedEmployee the selectedEmployee to set
	 */
	public void setSelectedEmployee(List<String> selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
	/**
	 * @return the proposedToolsList
	 */
	public List<PRTMaster> getProposedToolsList() {
		return proposedToolsList;
	}
	/**
	 * @param proposedToolsList the proposedToolsList to set
	 */
	public void setProposedToolsList(List<PRTMaster> proposedToolsList) {
		this.proposedToolsList = proposedToolsList;
	}
	/**
	 * @return the proposedSparesList
	 */
	public List<SparesMaster> getProposedSparesList() {
		return proposedSparesList;
	}
	/**
	 * @param proposedSparesList the proposedSparesList to set
	 */
	public void setProposedSparesList(List<SparesMaster> proposedSparesList) {
		this.proposedSparesList = proposedSparesList;
	}
	
	public JobDetailsSupervisor(OrderMain jobDetails)
	{
		this.jobOrderDetails  = jobDetails;
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
	 * @return the problemDetails
	 */
	public Problem getProblemDetails() {
		return problemDetails;
	}
	/**
	 * @param problemDetails the problemDetails to set
	 */
	public void setProblemDetails(Problem problemDetails) {
		this.problemDetails = problemDetails;
	}
	/**
	 * @return the operationsList
	 */
	public List<Operations> getOperationsList() {
		return operationsList;
	}
	/**
	 * @param operationsList the operationsList to set
	 */
	public void setOperationsList(List<Operations> operationsList) {
		this.operationsList = operationsList;
	}
	/**
	 * @return the equipmentDetails
	 */
	public EquipmentMaster getEquipmentDetails() {
		return equipmentDetails;
	}
	/**
	 * @param equipmentDetails the equipmentDetails to set
	 */
	public void setEquipmentDetails(EquipmentMaster equipmentDetails) {
		this.equipmentDetails = equipmentDetails;
	}
	/**
	 * @return the requisitions
	 */
	public List<OrderRequisition> getRequisitions() {
		return requisitions;
	}
	/**
	 * @param requisitions the requisitions to set
	 */
	public void setRequisitions(List<OrderRequisition> requisitions) {
		this.requisitions = requisitions;
	}
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		return gson.toJson(this);
	}
	/**
	 * @return the proposedEmpList
	 */
	public List<EmployeeMaster> getProposedEmpList() {
		return proposedEmpList;
	}
	/**
	 * @param proposedEmpList the proposedEmpList to set
	 */
	public void setProposedEmpList(List<EmployeeMaster> proposedEmpList) {
		this.proposedEmpList = proposedEmpList;
	}

	/**
	 * @return the assignedPRTList
	 */
	public List<OrderPRT> getAssignedPRTList() {
		return assignedPRTList;
	}

	/**
	 * @param assignedPRTList the assignedPRTList to set
	 */
	public void setAssignedPRTList(List<OrderPRT> assignedPRTList) {
		this.assignedPRTList = assignedPRTList;
	}

	/**
	 * @return the assignedSparesList
	 */
	public List<OrderSpares> getAssignedSparesList() {
		return assignedSparesList;
	}

	/**
	 * @param assignedSparesList the assignedSparesList to set
	 */
	public void setAssignedSparesList(List<OrderSpares> assignedSparesList) {
		this.assignedSparesList = assignedSparesList;
	}

	/**
	 * @return the assignedOrderEmpList
	 */
	public List<OrderEmployee> getAssignedOrderEmpList() {
		return assignedOrderEmpList;
	}

	/**
	 * @param assignedOrderEmpList the assignedOrderEmpList to set
	 */
	public void setAssignedOrderEmpList(List<OrderEmployee> assignedOrderEmpList) {
		this.assignedOrderEmpList = assignedOrderEmpList;
	}

	/**
	 * @return the requisitionNumbers
	 */
	public Map<String, String> getRequisitionNumbers() {
		return requisitionNumbers;
	}

	/**
	 * @param requisitionNumbers the requisitionNumbers to set
	 */
	public void setRequisitionNumbers(Map<String, String> requisitionNumbers) {
		this.requisitionNumbers = requisitionNumbers;
	}
	
}
