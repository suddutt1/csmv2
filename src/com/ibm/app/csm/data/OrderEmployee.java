package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OrderEmployee {

	private ObjectId id;
	private String objType = "ord_emp";
	private String orderNumber;
	private String employeeId;
	private String problem;
	private String operationId;
	private Date startDate;
	private Date endDate;
	private double actualHours;
	private String status;
	private Date assignedDate;

	public OrderEmployee() {

	}
	public OrderEmployee(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderEmployee(OrderMain ordMain, String opId,EmployeeMaster otherObj)
	{
		this.orderNumber= ordMain.getOrderNumber();
		this.employeeId= otherObj.getEmployeeId();
		this.problem= ordMain.getProblem();
		this.operationId= opId;
		this.assignedDate= new Date();
	}

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @return the objType
	 */
	public String getObjType() {
		return objType;
	}

	/**
	 * @param objType
	 *            the objType to set
	 */
	public void setObjType(String objType) {
		this.objType = objType;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber
	 *            the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the problem
	 */
	public String getProblem() {
		return problem;
	}

	/**
	 * @param problem
	 *            the problem to set
	 */
	public void setProblem(String problem) {
		this.problem = problem;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}

	/**
	 * @param operationId
	 *            the operationId to set
	 */
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the actualHours
	 */
	public double getActualHours() {
		return actualHours;
	}

	/**
	 * @param actualHours
	 *            the actualHours to set
	 */
	public void setActualHours(double actualHours) {
		this.actualHours = actualHours;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the assignedDate
	 */
	public Date getAssignedDate() {
		return assignedDate;
	}

	/**
	 * @param assignedDate
	 *            the assignedDate to set
	 */
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("orderNumber", this.orderNumber);
		dbObject.put("employeeId", this.employeeId);
		dbObject.put("problem", this.problem);
		dbObject.put("operationId", this.operationId);
		dbObject.put("startDate", this.startDate);
		dbObject.put("endDate", this.endDate);
		dbObject.put("actualHours", this.actualHours);
		dbObject.put("status", this.status);
		dbObject.put("assignedDate", this.assignedDate);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static OrderEmployee parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OrderEmployee parsedObject = new OrderEmployee();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setOrderNumber((String) dbObject.get("orderNumber"));
			parsedObject.setEmployeeId((String) dbObject.get("employeeId"));
			parsedObject.setProblem((String) dbObject.get("problem"));
			parsedObject.setOperationId((String) dbObject.get("operationId"));
			parsedObject.setStartDate((Date) dbObject.get("startDate"));
			parsedObject.setEndDate((Date) dbObject.get("endDate"));
			parsedObject.setActualHours((double) dbObject.get("actualHours"));
			parsedObject.setStatus((String) dbObject.get("status"));
			parsedObject.setAssignedDate((Date) dbObject.get("assignedDate"));
			return parsedObject;
		}
		return null;
	}
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
