package com.ibm.app.csm.data;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Problem {

	private ObjectId id;
	private String objType = "problem";
	private String catalogProfile;
	private String problemId;
	private String problemDescription;
	private String defaultDeptId;
	private String defaultDeptDesc;
	private String[] operationList;

	public Problem() {

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
	 * @return the problemId
	 */
	public String getProblemId() {
		return problemId;
	}

	/**
	 * @param problemId
	 *            the problemId to set
	 */
	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	/**
	 * @return the problemDescription
	 */
	public String getProblemDescription() {
		return problemDescription;
	}

	/**
	 * @param problemDescription
	 *            the problemDescription to set
	 */
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	/**
	 * @return the defaultDeptId
	 */
	public String getDefaultDeptId() {
		return defaultDeptId;
	}

	/**
	 * @param defaultDeptId
	 *            the defaultDeptId to set
	 */
	public void setDefaultDeptId(String defaultDeptId) {
		this.defaultDeptId = defaultDeptId;
	}

	/**
	 * @return the defaultDeptDesc
	 */
	public String getDefaultDeptDesc() {
		return defaultDeptDesc;
	}

	/**
	 * @param defaultDeptDesc
	 *            the defaultDeptDesc to set
	 */
	public void setDefaultDeptDesc(String defaultDeptDesc) {
		this.defaultDeptDesc = defaultDeptDesc;
	}

	/**
	 * @return the operationList
	 */
	public String[] getOperationList() {
		return operationList;
	}

	/**
	 * @param operationList
	 *            the operationList to set
	 */
	public void setOperationList(String[] operationList) {
		this.operationList = operationList;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("catalogProfile", this.catalogProfile);
		dbObject.put("problemId", this.problemId);
		dbObject.put("problemDescription", this.problemDescription);
		dbObject.put("defaultDeptId", this.defaultDeptId);
		dbObject.put("defaultDeptDesc", this.defaultDeptDesc);
		dbObject.put("operationList", this.operationList);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static Problem parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			Problem parsedObject = new Problem();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setCatalogProfile((String) dbObject
					.get("catalogProfile"));
			parsedObject.setProblemId((String) dbObject.get("problemId"));
			parsedObject.setProblemDescription((String) dbObject
					.get("problemDescription"));
			parsedObject.setDefaultDeptId((String) dbObject
					.get("defaultDeptId"));
			parsedObject.setDefaultDeptDesc((String) dbObject
					.get("defaultDeptDesc"));
			BasicDBList list =(BasicDBList) dbObject
					.get("operationList");
			if(list!=null)
			{
				String[] objArray = list.toArray(new String[list.size()]);
				parsedObject.setOperationList(objArray );
			}
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
