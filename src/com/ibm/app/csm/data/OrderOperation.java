package com.ibm.app.csm.data;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OrderOperation {

	private ObjectId id;
	private String objType = "ord_operation";
	private String orderNumber;
	private int itemNumber;
	private String operationNumber;
	private String plant;
	private double costsInTheActivity;
	private String completionConfirmationNumber;
	private Date actualStartDate;
	private Date actualFinishDate;
	private double actualDuration;
	private String status;
	private List<String> steps;
	
	public OrderOperation() {

	}
	public OrderOperation(String jobOrder) {

		this.orderNumber = jobOrder;
	}
	public OrderOperation(String jobOrder,String operationid) {

		this.orderNumber = jobOrder;
		this.operationNumber = operationid;
	}
	public OrderOperation(OrderMain jobOrder,Operations ops,int seq)
	{
		this.orderNumber = jobOrder.getOrderNumber();
		this.itemNumber = seq;
		this.operationNumber = ops.getOperationId();
		this.plant = jobOrder.getPlant();
		this.costsInTheActivity = ops.getRatePerHr()*ops.getAvgDuration();
	}
	/**
	 * @return the steps
	 */
	public List<String> getSteps() {
		return steps;
	}
	/**
	 * @param steps the steps to set
	 */
	public void setSteps(List<String> steps) {
		this.steps = steps;
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
	 * @return the operationNumber
	 */
	public String getOperationNumber() {
		return operationNumber;
	}

	/**
	 * @param operationNumber
	 *            the operationNumber to set
	 */
	public void setOperationNumber(String operationNumber) {
		this.operationNumber = operationNumber;
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
	 * @return the costsInTheActivity
	 */
	public double getCostsInTheActivity() {
		return costsInTheActivity;
	}

	/**
	 * @param costsInTheActivity
	 *            the costsInTheActivity to set
	 */
	public void setCostsInTheActivity(double costsInTheActivity) {
		this.costsInTheActivity = costsInTheActivity;
	}

	/**
	 * @return the completionConfirmationNumber
	 */
	public String getCompletionConfirmationNumber() {
		return completionConfirmationNumber;
	}

	/**
	 * @param completionConfirmationNumber
	 *            the completionConfirmationNumber to set
	 */
	public void setCompletionConfirmationNumber(
			String completionConfirmationNumber) {
		this.completionConfirmationNumber = completionConfirmationNumber;
	}

	/**
	 * @return the actualStartDate
	 */
	public Date getActualStartDate() {
		return actualStartDate;
	}

	/**
	 * @param actualStartDate
	 *            the actualStartDate to set
	 */
	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	/**
	 * @return the actualFinishDate
	 */
	public Date getActualFinishDate() {
		return actualFinishDate;
	}

	/**
	 * @param actualFinishDate
	 *            the actualFinishDate to set
	 */
	public void setActualFinishDate(Date actualFinishDate) {
		this.actualFinishDate = actualFinishDate;
	}

	/**
	 * @return the actualDuration
	 */
	public double getActualDuration() {
		return actualDuration;
	}

	/**
	 * @param actualDuration
	 *            the actualDuration to set
	 */
	public void setActualDuration(double actualDuration) {
		this.actualDuration = actualDuration;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("orderNumber", this.orderNumber);
		dbObject.put("itemNumber", this.itemNumber);
		dbObject.put("operationNumber", this.operationNumber);
		dbObject.put("plant", this.plant);
		dbObject.put("costsInTheActivity", this.costsInTheActivity);
		dbObject.put("completionConfirmationNumber",
				this.completionConfirmationNumber);
		dbObject.put("actualStartDate", this.actualStartDate);
		dbObject.put("actualFinishDate", this.actualFinishDate);
		dbObject.put("actualDuration", this.actualDuration);
		dbObject.put("status",this.status);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static OrderOperation parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OrderOperation parsedObject = new OrderOperation();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setOrderNumber((String) dbObject.get("orderNumber"));
			parsedObject.setItemNumber((int) dbObject.get("itemNumber"));
			parsedObject.setOperationNumber((String) dbObject
					.get("operationNumber"));
			parsedObject.setPlant((String) dbObject.get("plant"));
			parsedObject.setCostsInTheActivity((double) dbObject
					.get("costsInTheActivity"));
			parsedObject.setCompletionConfirmationNumber((String) dbObject
					.get("completionConfirmationNumber"));
			parsedObject.setActualStartDate((Date) dbObject
					.get("actualStartDate"));
			parsedObject.setActualFinishDate((Date) dbObject
					.get("actualFinishDate"));
			parsedObject.setActualDuration((double) dbObject
					.get("actualDuration"));
			parsedObject.setStatus((String)dbObject.get("status"));
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
				+ ((operationNumber == null) ? 0 : operationNumber.hashCode());
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
		OrderOperation other = (OrderOperation) obj;
		if (operationNumber == null) {
			if (other.operationNumber != null)
				return false;
		} else if (!operationNumber.equals(other.operationNumber))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		return true;
	}
	
	public void updateWith( OrderOperation  updatedObject)
	{ 
		this.id=(updatedObject.id!=null?updatedObject.id:this.id);
		this.objType=(updatedObject.objType!=null?updatedObject.objType:this.objType);
		this.orderNumber=(updatedObject.orderNumber!=null?updatedObject.orderNumber:this.orderNumber);
		this.itemNumber=(updatedObject.itemNumber!=0?updatedObject.itemNumber:this.itemNumber);
		this.operationNumber=(updatedObject.operationNumber!=null?updatedObject.operationNumber:this.operationNumber);
		this.plant=(updatedObject.plant!=null?updatedObject.plant:this.plant);
		this.costsInTheActivity=(updatedObject.costsInTheActivity!=0.0?updatedObject.costsInTheActivity:this.costsInTheActivity);
		this.completionConfirmationNumber=(updatedObject.completionConfirmationNumber!=null?updatedObject.completionConfirmationNumber:this.completionConfirmationNumber);
		this.actualStartDate=(updatedObject.actualStartDate!=null?updatedObject.actualStartDate:this.actualStartDate);
		this.actualFinishDate=(updatedObject.actualFinishDate!=null?updatedObject.actualFinishDate:this.actualFinishDate);
		this.actualDuration=(updatedObject.actualDuration!=0.0?updatedObject.actualDuration:this.actualDuration);
		this.steps=(updatedObject.steps!=null?updatedObject.steps:this.steps);
		this.status = (updatedObject.status!=null?updatedObject.status:this.status);
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	} 

}
