package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OrderMain {

	private ObjectId id;
	private String objType = "ord_main";

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

	private double displayRatePerHours;
	private String displayEquipmentName;
	
	public OrderMain() {
		super();
	}

	public OrderMain(String ordNumber) {
		super();
		this.orderNumber = ordNumber;
	}
	public OrderMain(OrderMain otherObj)
	{
		this.objType= otherObj.getObjType();
		this.orderNumber= otherObj.getOrderNumber();
		this.orderType= otherObj.getOrderType();
		this.finishBy= otherObj.getFinishBy();
		this.createdOn= otherObj.getCreatedOn();
		this.catalogProfile= otherObj.getCatalogProfile();
		this.description= otherObj.getDescription();
		this.problem= otherObj.getProblem();
		this.equipmentNumber= otherObj.getEquipmentNumber();
		this.model= otherObj.getModel();
		this.plant= otherObj.getPlant();
		this.responsibleCostCenter= otherObj.getResponsibleCostCenter();
		this.orderCurrency= otherObj.getOrderCurrency();
		this.orderStatus= otherObj.getOrderStatus();
		this.priority= otherObj.getPriority();
		this.workStart= otherObj.getWorkStart();
		this.endOfWork= otherObj.getEndOfWork();
		this.totalHours= otherObj.getTotalHours();
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
	public static OrderMain parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OrderMain parsedObject = new OrderMain();
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

	/*------Generated code--------------*/
	public void updateWith( OrderMain  updatedObject)
	{ 

		this.objType=(updatedObject.objType!=null?updatedObject.objType:this.objType);
		this.orderNumber=(updatedObject.orderNumber!=null?updatedObject.orderNumber:this.orderNumber);
		this.orderType=(updatedObject.orderType!=null?updatedObject.orderType:this.orderType);
		this.finishBy=(updatedObject.finishBy!=null?updatedObject.finishBy:this.finishBy);
		this.createdOn=(updatedObject.createdOn!=null?updatedObject.createdOn:this.createdOn);
		this.catalogProfile=(updatedObject.catalogProfile!=null?updatedObject.catalogProfile:this.catalogProfile);
		this.description=(updatedObject.description!=null?updatedObject.description:this.description);
		this.problem=(updatedObject.problem!=null?updatedObject.problem:this.problem);
		this.equipmentNumber=(updatedObject.equipmentNumber!=null?updatedObject.equipmentNumber:this.equipmentNumber);
		this.model=(updatedObject.model!=null?updatedObject.model:this.model);
		this.plant=(updatedObject.plant!=null?updatedObject.plant:this.plant);
		this.responsibleCostCenter=(updatedObject.responsibleCostCenter!=null?updatedObject.responsibleCostCenter:this.responsibleCostCenter);
		this.orderCurrency=(updatedObject.orderCurrency!=null?updatedObject.orderCurrency:this.orderCurrency);
		this.orderStatus=(updatedObject.orderStatus!=null?updatedObject.orderStatus:this.orderStatus);
		this.priority=(updatedObject.priority!=0?updatedObject.priority:this.priority);
		this.workStart=(updatedObject.workStart!=null?updatedObject.workStart:this.workStart);
		this.endOfWork=(updatedObject.endOfWork!=null?updatedObject.endOfWork:this.endOfWork);
		this.totalHours=(updatedObject.totalHours!=0.0?updatedObject.totalHours:this.totalHours);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	/**
	 * @return the displayRatePerHours
	 */
	public double getDisplayRatePerHours() {
		return displayRatePerHours;
	}

	/**
	 * @param displayRatePerHours the displayRatePerHours to set
	 */
	public void setDisplayRatePerHours(double displayRatePerHours) {
		this.displayRatePerHours = displayRatePerHours;
	}

	/**
	 * @return the displayEquipmentName
	 */
	public String getDisplayEquipmentName() {
		return displayEquipmentName;
	}

	/**
	 * @param displayEquipmentName the displayEquipmentName to set
	 */
	public void setDisplayEquipmentName(String displayEquipmentName) {
		this.displayEquipmentName = displayEquipmentName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orderNumber == null) ? 0 : orderNumber.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderMain other = (OrderMain) obj;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		return true;
	}
	
}
