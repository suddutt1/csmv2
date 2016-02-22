package com.ibm.app.csm.data;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Operations {

	private ObjectId id;
	private String objType = "operations";
	private String operationId;
	private String deptId;
	private String deptDesc;
	private String operationShortText;
	private int noofEmp;
	private double avgDuration;
	private double ratePerHr;
	private String taskManual;
	
	private List<String> stepList;
	public Operations() {
		this.stepList = new ArrayList<>();
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
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId
	 *            the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the deptDesc
	 */
	public String getDeptDesc() {
		return deptDesc;
	}

	/**
	 * @param deptDesc
	 *            the deptDesc to set
	 */
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	/**
	 * @return the operationShortText
	 */
	public String getOperationShortText() {
		return operationShortText;
	}

	/**
	 * @param operationShortText
	 *            the operationShortText to set
	 */
	public void setOperationShortText(String operationShortText) {
		this.operationShortText = operationShortText;
	}

	/**
	 * @return the noofEmp
	 */
	public int getNoofEmp() {
		return noofEmp;
	}

	/**
	 * @param noofEmp
	 *            the noofEmp to set
	 */
	public void setNoofEmp(int noofEmp) {
		this.noofEmp = noofEmp;
	}

	/**
	 * @return the avgDuration
	 */
	public double getAvgDuration() {
		return avgDuration;
	}

	/**
	 * @param avgDuration
	 *            the avgDuration to set
	 */
	public void setAvgDuration(double avgDuration) {
		this.avgDuration = avgDuration;
	}

	/**
	 * @return the ratePerHr
	 */
	public double getRatePerHr() {
		return ratePerHr;
	}

	/**
	 * @param ratePerHr
	 *            the ratePerHr to set
	 */
	public void setRatePerHr(double ratePerHr) {
		this.ratePerHr = ratePerHr;
	}

	/**
	 * @return the taskManual
	 */
	public String getTaskManual() {
		return taskManual;
	}

	/**
	 * @param taskManual
	 *            the taskManual to set
	 */
	public void setTaskManual(String taskManual) {
		this.taskManual = taskManual;
	}

	/**
	 * @return the stepList
	 */
	public List<String> getStepList() {
		return stepList;
	}

	/**
	 * @param stepList the stepList to set
	 */
	public void setStepList(List<String> stepList) {
		this.stepList = stepList;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("operationId", this.operationId);
		dbObject.put("deptId", this.deptId);
		dbObject.put("deptDesc", this.deptDesc);
		dbObject.put("operationShortText", this.operationShortText);
		dbObject.put("noofEmp", this.noofEmp);
		dbObject.put("avgDuration", this.avgDuration);
		dbObject.put("ratePerHr", this.ratePerHr);
		dbObject.put("taskManual", this.taskManual);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static Operations parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			Operations parsedObject = new Operations();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setOperationId((String) dbObject.get("operationId"));
			parsedObject.setDeptId((String) dbObject.get("deptId"));
			parsedObject.setDeptDesc((String) dbObject.get("deptDesc"));
			parsedObject.setOperationShortText((String) dbObject
					.get("operationShortText"));
			parsedObject.setNoofEmp((int) dbObject.get("noofEmp"));
			parsedObject.setAvgDuration((double) dbObject.get("avgDuration"));
			parsedObject.setRatePerHr((double) dbObject.get("ratePerHr"));
			parsedObject.setTaskManual((String) dbObject.get("taskManual"));
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
