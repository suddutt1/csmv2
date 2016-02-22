package com.ibm.app.csm.data;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class OperationInstructon {

	private ObjectId id;
	private String objType = "op_instruction";
	
	private String operationId;
	private String step;

	public OperationInstructon() {
		super();
	}

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param objType the objType to set
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
	 * @return the step
	 */
	public String getStep() {
		return step;
	}

	/**
	 * @param step
	 *            the step to set
	 */
	public void setStep(String step) {
		this.step = step;
	}

	public static OperationInstructon parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			OperationInstructon parsedObject = new OperationInstructon();
			parsedObject.setObjType((String)dbObject.get("objType"));
			parsedObject.setOperationId((String) dbObject.get("operationId"));
			parsedObject.setStep((String) dbObject.get("step"));
			return parsedObject;
		}
		return null;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("objType", objType);
		dbObject.put("operationId", this.operationId);
		dbObject.put("step", this.step);
		return dbObject;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting()
				.create();
		return gson.toJson(this);
	}

}
