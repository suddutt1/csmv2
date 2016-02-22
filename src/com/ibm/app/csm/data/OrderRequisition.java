package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OrderRequisition {

	private ObjectId id;
	private String objType = "ord_req";

	private String orderNumber;
	private String reqNumber;
	private String reqType;// PARTS/SPARES
	private String status;
	private Date createDate;
	private String refDataId;// PRT NUMBER/MATERIAL NUMBER
	private String fromEmpId;
	private String forEmpId;
	private double qtyAssigned;
	private String unitOfMeasure;

	public OrderRequisition() {
		super();
	}
	public OrderRequisition(String jobOrder) {
		super();
		this.orderNumber = jobOrder;
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
	 * @return the reqNumber
	 */
	public String getReqNumber() {
		return reqNumber;
	}

	/**
	 * @param reqNumber
	 *            the reqNumber to set
	 */
	public void setReqNumber(String reqNumber) {
		this.reqNumber = reqNumber;
	}

	/**
	 * @return the reqType
	 */
	public String getReqType() {
		return reqType;
	}

	/**
	 * @param reqType
	 *            the reqType to set
	 */
	public void setReqType(String reqType) {
		this.reqType = reqType;
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
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the refDataId
	 */
	public String getRefDataId() {
		return refDataId;
	}

	/**
	 * @param refDataId
	 *            the refDataId to set
	 */
	public void setRefDataId(String refDataId) {
		this.refDataId = refDataId;
	}

	/**
	 * @return the fromEmpId
	 */
	public String getFromEmpId() {
		return fromEmpId;
	}

	/**
	 * @param fromEmpId
	 *            the fromEmpId to set
	 */
	public void setFromEmpId(String fromEmpId) {
		this.fromEmpId = fromEmpId;
	}

	/**
	 * @return the forEmpId
	 */
	public String getForEmpId() {
		return forEmpId;
	}

	/**
	 * @param forEmpId
	 *            the forEmpId to set
	 */
	public void setForEmpId(String forEmpId) {
		this.forEmpId = forEmpId;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("orderNumber", this.orderNumber);
		dbObject.put("reqNumber", this.reqNumber);
		dbObject.put("reqType", this.reqType);
		dbObject.put("status", this.status);
		dbObject.put("createDate", this.createDate);
		dbObject.put("refDataId", this.refDataId);
		dbObject.put("fromEmpId", this.fromEmpId);
		dbObject.put("forEmpId", this.forEmpId);
		dbObject.put("qtyAssigned", this.qtyAssigned);
		dbObject.put("unitOfMeasure", this.unitOfMeasure);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static OrderRequisition parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OrderRequisition parsedObject = new OrderRequisition();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setOrderNumber((String) dbObject.get("orderNumber"));
			parsedObject.setReqNumber((String) dbObject.get("reqNumber"));
			parsedObject.setReqType((String) dbObject.get("reqType"));
			parsedObject.setStatus((String) dbObject.get("status"));
			parsedObject.setCreateDate((Date) dbObject.get("createDate"));
			parsedObject.setRefDataId((String) dbObject.get("refDataId"));
			parsedObject.setFromEmpId((String) dbObject.get("fromEmpId"));
			parsedObject.setForEmpId((String) dbObject.get("forEmpId"));
			parsedObject.setQtyAssigned((double) dbObject.get("qtyAssigned"));
			parsedObject.setUnitOfMeasure((String) dbObject.get("unitOfMeasure"));
			return parsedObject;
		}
		return null;
	}

	/**
	 * @return the qtyAssigned
	 */
	public double getQtyAssigned() {
		return qtyAssigned;
	}

	/**
	 * @param qtyAssigned the qtyAssigned to set
	 */
	public void setQtyAssigned(double qtyAssigned) {
		this.qtyAssigned = qtyAssigned;
	}

	/**
	 * @return the unitOfMeasure
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * @param unitOfMeasure the unitOfMeasure to set
	 */
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
