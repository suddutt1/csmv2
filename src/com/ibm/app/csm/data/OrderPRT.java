package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OrderPRT {

	private ObjectId id;
	private String objType = "ord_prt";
	private String orderNumber;
	private String operation;
	public String prtType;
	private int itemNumber;
	private String prtNumber;
	private Date usageStartDate;
	private Date usageEndDtae;
	private double duration;
	private double qtyAssigned;
	private double quantityUsed;

	public OrderPRT() {

	}
	public OrderPRT(String jobOrder) {
		this.orderNumber = jobOrder;
	}
	public OrderPRT(String jobOrder,String prtNumber) {
		this.orderNumber = jobOrder;
		this.prtNumber = prtNumber;
	}
	
	public OrderPRT(String jobOder,String operationNumber,PRTMaster prtMaster,int seq)
	{
		this.orderNumber = jobOder;
		this.operation = operationNumber;
		this.prtType =prtMaster.getPrtType();
		this.itemNumber = seq;
		this.prtNumber  = prtMaster.getPrtNumber();
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
	public static OrderPRT parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OrderPRT parsedObject = new OrderPRT();
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result
				+ ((prtNumber == null) ? 0 : prtNumber.hashCode());
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
		OrderPRT other = (OrderPRT) obj;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (prtNumber == null) {
			if (other.prtNumber != null)
				return false;
		} else if (!prtNumber.equals(other.prtNumber))
			return false;
		return true;
	}
	/*------Generated code--------------*/
	public void updateWith( OrderPRT  updatedObject)
	{ 
		this.id=(updatedObject.id!=null?updatedObject.id:this.id);
		this.objType=(updatedObject.objType!=null?updatedObject.objType:this.objType);
		this.orderNumber=(updatedObject.orderNumber!=null?updatedObject.orderNumber:this.orderNumber);
		this.operation=(updatedObject.operation!=null?updatedObject.operation:this.operation);
		this.prtType=(updatedObject.prtType!=null?updatedObject.prtType:this.prtType);
		this.itemNumber=(updatedObject.itemNumber!=0?updatedObject.itemNumber:this.itemNumber);
		this.prtNumber=(updatedObject.prtNumber!=null?updatedObject.prtNumber:this.prtNumber);
		this.usageStartDate=(updatedObject.usageStartDate!=null?updatedObject.usageStartDate:this.usageStartDate);
		this.usageEndDtae=(updatedObject.usageEndDtae!=null?updatedObject.usageEndDtae:this.usageEndDtae);
		this.duration=(updatedObject.duration!=0.0?updatedObject.duration:this.duration);
		this.qtyAssigned=(updatedObject.qtyAssigned!=0.0?updatedObject.qtyAssigned:this.qtyAssigned);
		this.quantityUsed=(updatedObject.quantityUsed!=0.0?updatedObject.quantityUsed:this.quantityUsed);
	} 

}
