package com.ibm.app.csm.data;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class CSMUser {

	private ObjectId id;
	private String objType = "csm_user";
	private String userId;
	private String password;
	private String empId;
	private String role;
	private String emailId;
	
	private EmployeeMaster empMaster;

	public CSMUser() {
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("userId", this.userId);
		dbObject.put("password", this.password);
		dbObject.put("role", this.role);
		dbObject.put("emailId", this.emailId);
		dbObject.put("empId", this.empId);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static CSMUser parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			CSMUser parsedObject = new CSMUser();
			parsedObject.setId((ObjectId) dbObject.get("id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setUserId((String) dbObject.get("userId"));
			parsedObject.setPassword((String) dbObject.get("password"));
			parsedObject.setRole((String) dbObject.get("role"));
			parsedObject.setEmailId((String) dbObject.get("emailId"));
			parsedObject.setEmpId((String)dbObject.get("empId"));
			return parsedObject;
		}
		return null;
	}

	/**
	 * @return the empMaster
	 */
	public EmployeeMaster getEmpMaster() {
		return empMaster;
	}

	/**
	 * @param empMaster the empMaster to set
	 */
	public void setEmpMaster(EmployeeMaster empMaster) {
		this.empMaster = empMaster;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
