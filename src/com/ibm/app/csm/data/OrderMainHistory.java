package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OrderMainHistory {

	private ObjectId id;
	private String objType = "ord_main_hist";

	private String orderNumber;
	private String orderType;
	private Date finishBy;
	private Date createdOn;
	private String catalogProfile;
	private String description;
	private String problem;
	private String equipmentNumber;
	private String model;
	private String plant;
	private String responsibleCostCenter;
	private String orderCurrency;
	private String orderStatus;
	private int priority;
	private Date workStart;
	private Date endOfWork;
	private double totalHours;

	public OrderMainHistory() {
		super();
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
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType
	 *            the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the finishBy
	 */
	public Date getFinishBy() {
		return finishBy;
	}

	/**
	 * @param finishBy
	 *            the finishBy to set
	 */
	public void setFinishBy(Date finishBy) {
		this.finishBy = finishBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the catalogProfile
	 */
	public String getCatalogProfile() {
		return catalogProfile;
	}

	/**
	 * @param catalogProfile
	 *            the catalogProfile to set
	 */
	public void setCatalogProfile(String catalogProfile) {
		this.catalogProfile = catalogProfile;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the equipmentNumber
	 */
	public String getEquipmentNumber() {
		return equipmentNumber;
	}

	/**
	 * @param equipmentNumber
	 *            the equipmentNumber to set
	 */
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the plant
	 */
	public String getPlant() {
		return plant;
	}

	/**
	 * @param plant
	 *            the plant to set
	 */
	public void setPlant(String plant) {
		this.plant = plant;
	}

	/**
	 * @return the responsibleCostCenter
	 */
	public String getResponsibleCostCenter() {
		return responsibleCostCenter;
	}

	/**
	 * @param responsibleCostCenter
	 *            the responsibleCostCenter to set
	 */
	public void setResponsibleCostCenter(String responsibleCostCenter) {
		this.responsibleCostCenter = responsibleCostCenter;
	}

	/**
	 * @return the orderCurrency
	 */
	public String getOrderCurrency() {
		return orderCurrency;
	}

	/**
	 * @param orderCurrency
	 *            the orderCurrency to set
	 */
	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus
	 *            the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the workStart
	 */
	public Date getWorkStart() {
		return workStart;
	}

	/**
	 * @param workStart
	 *            the workStart to set
	 */
	public void setWorkStart(Date workStart) {
		this.workStart = workStart;
	}

	/**
	 * @return the endOfWork
	 */
	public Date getEndOfWork() {
		return endOfWork;
	}

	/**
	 * @param endOfWork
	 *            the endOfWork to set
	 */
	public void setEndOfWork(Date endOfWork) {
		this.endOfWork = endOfWork;
	}

	/**
	 * @return the totalHours
	 */
	public double getTotalHours() {
		return totalHours;
	}

	/**
	 * @param totalHours
	 *            the totalHours to set
	 */
	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("orderNumber", this.orderNumber);
		dbObject.put("orderType", this.orderType);
		dbObject.put("finishBy", this.finishBy);
		dbObject.put("createdOn", this.createdOn);
		dbObject.put("catalogProfile", this.catalogProfile);
		dbObject.put("description", this.description);
		dbObject.put("problem", this.problem);
		dbObject.put("equipmentNumber", this.equipmentNumber);
		dbObject.put("model", this.model);
		dbObject.put("plant", this.plant);
		dbObject.put("responsibleCostCenter", this.responsibleCostCenter);
		dbObject.put("orderCurrency", this.orderCurrency);
		dbObject.put("orderStatus", this.orderStatus);
		dbObject.put("priority", this.priority);
		dbObject.put("workStart", this.workStart);
		dbObject.put("endOfWork", this.endOfWork);
		dbObject.put("totalHours", this.totalHours);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static OrderMainHistory parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OrderMainHistory parsedObject = new OrderMainHistory();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setOrderNumber((String) dbObject.get("orderNumber"));
			parsedObject.setOrderType((String) dbObject.get("orderType"));
			parsedObject.setFinishBy((Date) dbObject.get("finishBy"));
			parsedObject.setCreatedOn((Date) dbObject.get("createdOn"));
			parsedObject.setCatalogProfile((String) dbObject
					.get("catalogProfile"));
			parsedObject.setDescription((String) dbObject.get("description"));
			parsedObject.setProblem((String) dbObject.get("problem"));
			parsedObject.setEquipmentNumber((String) dbObject
					.get("equipmentNumber"));
			parsedObject.setModel((String) dbObject.get("model"));
			parsedObject.setPlant((String) dbObject.get("plant"));
			parsedObject.setResponsibleCostCenter((String) dbObject
					.get("responsibleCostCenter"));
			parsedObject.setOrderCurrency((String) dbObject
					.get("orderCurrency"));
			parsedObject.setOrderStatus((String) dbObject.get("orderStatus"));
			parsedObject.setPriority((int) dbObject.get("priority"));
			parsedObject.setWorkStart((Date) dbObject.get("workStart"));
			parsedObject.setEndOfWork((Date) dbObject.get("endOfWork"));
			parsedObject.setTotalHours((double) dbObject.get("totalHours"));
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
