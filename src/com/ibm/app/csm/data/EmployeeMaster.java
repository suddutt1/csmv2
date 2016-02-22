package com.ibm.app.csm.data;

import java.util.Date;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class EmployeeMaster {

	private ObjectId id;
	private String objType = "emp_master";

	private String employeeId;
	private String employeeName;
	private Date dateOfJoining;
	private String skillNumber;
	private String skillDescription;
	private String workCenter;
	private String deptId;
	private String shiftGrouping;
	private String shiftDefinition;
	private long skillLevel;
	

	private double calcExperience;
	
	private int calcWorkCount;
	private double score;
	
	public EmployeeMaster() {

	}
	public EmployeeMaster(String empId)
	{
		this.employeeId = empId;
	}
	
	public EmployeeMaster(EmployeeMaster otherObj )
	{
		this.objType= otherObj.getObjType();
		this.employeeId= otherObj.getEmployeeId();
		this.employeeName= otherObj.getEmployeeName();
		this.dateOfJoining= otherObj.getDateOfJoining();
		this.skillNumber= otherObj.getSkillNumber();
		this.skillDescription= otherObj.getSkillDescription();
		this.workCenter= otherObj.getWorkCenter();
		this.deptId= otherObj.getDeptId();
		this.shiftGrouping= otherObj.getShiftGrouping();
		this.shiftDefinition= otherObj.getShiftDefinition();
		this.skillLevel= otherObj.getSkillLevel();
		this.calcExperience= otherObj.getCalcExperience();
		this.calcWorkCount= otherObj.getCalcWorkCount();
		this.score= otherObj.getScore();

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
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining
	 *            the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the skillNumber
	 */
	public String getSkillNumber() {
		return skillNumber;
	}

	/**
	 * @param skillNumber
	 *            the skillNumber to set
	 */
	public void setSkillNumber(String skillNumber) {
		this.skillNumber = skillNumber;
	}

	/**
	 * @return the skillDescription
	 */
	public String getSkillDescription() {
		return skillDescription;
	}

	/**
	 * @param skillDescription
	 *            the skillDescription to set
	 */
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}

	/**
	 * @return the workCenter
	 */
	public String getWorkCenter() {
		return workCenter;
	}

	/**
	 * @param workCenter
	 *            the workCenter to set
	 */
	public void setWorkCenter(String workCenter) {
		this.workCenter = workCenter;
	}

	/**
	 * @return the shiftGrouping
	 */
	public String getShiftGrouping() {
		return shiftGrouping;
	}

	/**
	 * @param shiftGrouping
	 *            the shiftGrouping to set
	 */
	public void setShiftGrouping(String shiftGrouping) {
		this.shiftGrouping = shiftGrouping;
	}

	/**
	 * @return the shiftDefinition
	 */
	public String getShiftDefinition() {
		return shiftDefinition;
	}

	/**
	 * @param shiftDefinition
	 *            the shiftDefinition to set
	 */
	public void setShiftDefinition(String shiftDefinition) {
		this.shiftDefinition = shiftDefinition;
	}

	/**
	 * @return the skillLevel
	 */
	public long getSkillLevel() {
		return skillLevel;
	}

	/**
	 * @param skillLevel
	 *            the skillLevel to set
	 */
	public void setSkillLevel(long skillLevel) {
		this.skillLevel = skillLevel;
	}

	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();
		if (this.id == null) {
			this.id = new ObjectId();
		}
		dbObject.put("_id", this.id);
		dbObject.put("objType", this.objType);
		dbObject.put("employeeId", this.employeeId);
		dbObject.put("employeeName", this.employeeName);
		dbObject.put("dateOfJoining", this.dateOfJoining);
		dbObject.put("skillNumber", this.skillNumber);
		dbObject.put("skillDescription", this.skillDescription);
		dbObject.put("workCenter", this.workCenter);
		dbObject.put("shiftGrouping", this.shiftGrouping);
		dbObject.put("shiftDefinition", this.shiftDefinition);
		dbObject.put("skillLevel", this.skillLevel);
		dbObject.put("deptId",this.deptId);
		return dbObject;
	}

	/*------Generated code--------------*/
	public static EmployeeMaster parseToObject(DBObject dbObject) {
		if (dbObject != null) {
			EmployeeMaster parsedObject = new EmployeeMaster();
			parsedObject.setId((ObjectId) dbObject.get("_id"));
			parsedObject.setObjType((String) dbObject.get("objType"));
			parsedObject.setEmployeeId((String) dbObject.get("employeeId"));
			parsedObject.setEmployeeName((String) dbObject.get("employeeName"));
			parsedObject.setDateOfJoining((Date) dbObject.get("dateOfJoining"));
			parsedObject.setSkillNumber((String) dbObject.get("skillNumber"));
			parsedObject.setSkillDescription((String) dbObject
					.get("skillDescription"));
			parsedObject.setWorkCenter((String) dbObject.get("workCenter"));
			parsedObject.setShiftGrouping((String) dbObject
					.get("shiftGrouping"));
			parsedObject.setShiftDefinition((String) dbObject
					.get("shiftDefinition"));
			parsedObject.setSkillLevel((long) dbObject.get("skillLevel"));
			parsedObject.setDeptId((String) dbObject.get("deptId"));
			return parsedObject;
		}
		return null;
	}
	
	public void calculateExperience()
	{
		if(dateOfJoining!=null)
		{
			long today = (new Date()).getTime() -this.dateOfJoining.getTime();
			calcExperience = today/(86400000.0*365);
		}
	}

	/**
	 * @return the calcExperience
	 */
	public double getCalcExperience() {
		calculateExperience();
		return calcExperience;
	}

	/**
	 * @param calcExperience the calcExperience to set
	 */
	public void setCalcExperience(double calcExperience) {
		this.calcExperience = calcExperience;
	}

	/**
	 * @return the calcWorkCount
	 */
	public int getCalcWorkCount() {
		return calcWorkCount;
	}

	/**
	 * @param calcWorkCount the calcWorkCount to set
	 */
	public void setCalcWorkCount(int calcWorkCount) {
		this.calcWorkCount = calcWorkCount;
	}

	/**
	 * @return the score
	 */
	public double getScore() {
		 this.score = Math.round((3*calcWorkCount+calcExperience+skillLevel)*100.0)/100.0;
		 return this.score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}
	
	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

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
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
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
		EmployeeMaster other = (EmployeeMaster) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
}
