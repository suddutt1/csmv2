package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OrderPRTHistory {

	private ObjectId id;
	private String objType = "ord_prt_hist";
	private String orderNumber;
	private String operation;
	private String prtType;
	private int itemNumber;
	private String prtNumber;
	private Date usageStartDate;
	private Date usageEndDtae;
	private double duration;
	private double qtyAssigned;
	private double quantityUsed;

	public OrderPRTHistory() {

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
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the prtType
	 */
	public String getPrtType() {
		return prtType;
	}

	/**
	 * @param prtType
	 *            the prtType to set
	 */
	public void setPrtType(String prtType) {
		this.prtType = prtType;
	}

	/**
	 * @return the itemNumber
	 */
	public int getItemNumber() {
		return itemNumber;
	}

	/**
	 * @param itemNumber
	 *            the itemNumber to set
	 */
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	/**
	 * @return the prtNumber
	 */
	public String getPrtNumber() {
		return prtNumber;
	}

	/**
	 * @param prtNumber
	 *            the prtNumber to set
	 */
	public void setPrtNumber(String prtNumber) {
		this.prtNumber = prtNumber;
	}

	/**
	 * @return the usageStartDate
	 */
	public Date getUsageStartDate() {
		return usageStartDate;
	}

	/**
	 * @param usageStartDate
	 *            the usageStartDate to set
	 */
	public void setUsageStartDate(Date usageStartDate) {
		this.usageStartDate = usageStartDate;
	}

	/**
	 * @return the usageEndDtae
	 */
	public Date getUsageEndDtae() {
		return usageEndDtae;
	}

	/**
	 * @param usageEndDtae
	 *            the usageEndDtae to set
	 */
	public void setUsageEndDtae(Date usageEndDtae) {
		this.usageEndDtae = usageEndDtae;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the qtyAssigned
	 */
	public double getQtyAssigned() {
		return qtyAssigned;
	}

	/**
	 * @param qtyAssigned
	 *            the qtyAssigned to set
	 */
	public void setQtyAssigned(double qtyAssigned) {
		this.qtyAssigned = qtyAssigned;
	}

	/**
	 * @return the quantityUsed
	 */
	public double getQuantityUsed() {
		return quantityUsed;
	}

	/**
	 * @param quantityUsed
	 *            the quantityUsed to set
	 */
	public void setQuantityUsed(double quantityUsed) {
		this.quantityUsed = quantityUsed;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("orderNumber", this.orderNumber);
		dbObject.put("operation", this.operation);
		dbObject.put("prtType", this.prtType);
		dbObject.put("itemNumber", this.itemNumber);
		dbObject.put("prtNumber", this.prtNumber);
		dbObject.put("usageStartDate", this.usageStartDate);
		dbObject.put("usageEndDtae", this.usageEndDtae);
		dbObject.put("duration", this.duration);
		dbObject.put("qtyAssigned", this.qtyAssigned);
		dbObject.put("quantityUsed", this.quantityUsed);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static OrderPRTHistory parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OrderPRTHistory parsedObject = new OrderPRTHistory();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setOrderNumber((String) dbObject.get("orderNumber"));
			parsedObject.setOperation((String) dbObject.get("operation"));
			parsedObject.setPrtType((String) dbObject.get("prtType"));
			parsedObject.setItemNumber((int) dbObject.get("itemNumber"));
			parsedObject.setPrtNumber((String) dbObject.get("prtNumber"));
			parsedObject.setUsageStartDate((Date) dbObject
					.get("usageStartDate"));
			parsedObject.setUsageEndDtae((Date) dbObject.get("usageEndDtae"));
			parsedObject.setDuration((double) dbObject.get("duration"));
			parsedObject.setQtyAssigned((double) dbObject.get("qtyAssigned"));
			parsedObject.setQuantityUsed((double) dbObject.get("quantityUsed"));
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
