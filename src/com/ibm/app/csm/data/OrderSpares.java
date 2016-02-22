package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OrderSpares {

	private ObjectId id;
	private String objType = "ord_spares";
	private String orderNumber;
	private String operation;
	private String materialNumber;
	private String unitOfMeasure;
	private double amountInCurrency;
	private String currency;
	private String plant;
	private double requiredQty;
	private String storageLocation;
	private double usedQty;
	private Date createdate;

	public OrderSpares() {

	}
	public OrderSpares(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public OrderSpares(OrderMain jobOrder,String operationNumber,SparesMaster spMaster,int seq)
	{
		this.orderNumber= jobOrder.getOrderNumber();
		this.operation= operationNumber;
		this.materialNumber= spMaster.getMaterialNumber();
		this.unitOfMeasure= spMaster.getUnitOfMeasure();
		this.amountInCurrency= spMaster.getAmountInCurrency();
		this.currency= spMaster.getCurrency();
		this.plant= jobOrder.getPlant();
		this.storageLocation= spMaster.getStorageLocation();
		this.createdate= new Date();

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
	 * @return the materialNumber
	 */
	public String getMaterialNumber() {
		return materialNumber;
	}

	/**
	 * @param materialNumber
	 *            the materialNumber to set
	 */
	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}

	/**
	 * @return the unitOfMeasure
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * @param unitOfMeasure
	 *            the unitOfMeasure to set
	 */
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	/**
	 * @return the amountInCurrency
	 */
	public double getAmountInCurrency() {
		return amountInCurrency;
	}

	/**
	 * @param amountInCurrency
	 *            the amountInCurrency to set
	 */
	public void setAmountInCurrency(double amountInCurrency) {
		this.amountInCurrency = amountInCurrency;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	 * @return the requiredQty
	 */
	public double getRequiredQty() {
		return requiredQty;
	}

	/**
	 * @param requiredQty
	 *            the requiredQty to set
	 */
	public void setRequiredQty(double requiredQty) {
		this.requiredQty = requiredQty;
	}

	/**
	 * @return the storageLocation
	 */
	public String getStorageLocation() {
		return storageLocation;
	}

	/**
	 * @param storageLocation
	 *            the storageLocation to set
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	/**
	 * @return the usedQty
	 */
	public double getUsedQty() {
		return usedQty;
	}

	/**
	 * @param usedQty
	 *            the usedQty to set
	 */
	public void setUsedQty(double usedQty) {
		this.usedQty = usedQty;
	}

	/**
	 * @return the createdate
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/**
	 * @param createdate
	 *            the createdate to set
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
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
		dbObject.put("materialNumber", this.materialNumber);
		dbObject.put("unitOfMeasure", this.unitOfMeasure);
		dbObject.put("amountInCurrency", this.amountInCurrency);
		dbObject.put("currency", this.currency);
		dbObject.put("plant", this.plant);
		dbObject.put("requiredQty", this.requiredQty);
		dbObject.put("storageLocation", this.storageLocation);
		dbObject.put("usedQty", this.usedQty);
		dbObject.put("createdate", this.createdate);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static OrderSpares parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OrderSpares parsedObject = new OrderSpares();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setOrderNumber((String) dbObject.get("orderNumber"));
			parsedObject.setOperation((String) dbObject.get("operation"));
			parsedObject.setMaterialNumber((String) dbObject
					.get("materialNumber"));
			parsedObject.setUnitOfMeasure((String) dbObject
					.get("unitOfMeasure"));
			parsedObject.setAmountInCurrency((double) dbObject
					.get("amountInCurrency"));
			parsedObject.setCurrency((String) dbObject.get("currency"));
			parsedObject.setPlant((String) dbObject.get("plant"));
			parsedObject.setRequiredQty((double) dbObject.get("requiredQty"));
			parsedObject.setStorageLocation((String) dbObject
					.get("storageLocation"));
			parsedObject.setUsedQty((double) dbObject.get("usedQty"));
			parsedObject.setCreatedate((Date) dbObject.get("createdate"));
			return parsedObject;
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((materialNumber == null) ? 0 : materialNumber.hashCode());
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
		OrderSpares other = (OrderSpares) obj;
		if (materialNumber == null) {
			if (other.materialNumber != null)
				return false;
		} else if (!materialNumber.equals(other.materialNumber))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		return true;
	}
	public void updateWith( OrderSpares  updatedObject)
	{ 
		this.id=(updatedObject.id!=null?updatedObject.id:this.id);
		this.objType=(updatedObject.objType!=null?updatedObject.objType:this.objType);
		this.orderNumber=(updatedObject.orderNumber!=null?updatedObject.orderNumber:this.orderNumber);
		this.operation=(updatedObject.operation!=null?updatedObject.operation:this.operation);
		this.materialNumber=(updatedObject.materialNumber!=null?updatedObject.materialNumber:this.materialNumber);
		this.unitOfMeasure=(updatedObject.unitOfMeasure!=null?updatedObject.unitOfMeasure:this.unitOfMeasure);
		this.amountInCurrency=(updatedObject.amountInCurrency!=0.0?updatedObject.amountInCurrency:this.amountInCurrency);
		this.currency=(updatedObject.currency!=null?updatedObject.currency:this.currency);
		this.plant=(updatedObject.plant!=null?updatedObject.plant:this.plant);
		this.requiredQty=(updatedObject.requiredQty!=0.0?updatedObject.requiredQty:this.requiredQty);
		this.storageLocation=(updatedObject.storageLocation!=null?updatedObject.storageLocation:this.storageLocation);
		this.usedQty=(updatedObject.usedQty!=0.0?updatedObject.usedQty:this.usedQty);
		this.createdate=(updatedObject.createdate!=null?updatedObject.createdate:this.createdate);
	} 
}
