package com.ibm.watson.tradeoffanalysis.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AnalyticColumnDefinition {

	public static final String DATA_TYPE_NUMERIC = "NUMERIC";
	public static final String GOAL_MAXIMIZE = "MAX";
	public static final String GOAL_MINIMIZE = "MIN";
	private String key;
	private String fullName;
	private String type;
	private boolean objective;
	private String goal;
	
	public AnalyticColumnDefinition()
	{
		super();
	}

	/**
	 * @param key
	 * @param fullName
	 * @param type
	 * @param objective
	 * @param goal
	 */
	public AnalyticColumnDefinition(String analyticFieldKey, String analyticFieldName, String type,
			boolean includeInDecision, String goal) {
		super();
		this.key = analyticFieldKey;
		this.fullName = analyticFieldName;
		this.type = type;
		this.objective = includeInDecision;
		this.goal = goal;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the objective
	 */
	public boolean isObjective() {
		return objective;
	}

	/**
	 * @param objective the objective to set
	 */
	public void setObjective(boolean objective) {
		this.objective = objective;
	}

	/**
	 * @return the goal
	 */
	public String getGoal() {
		return goal;
	}

	/**
	 * @param goal the goal to set
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	public String toAnalyticJSON()
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map<String,Object> innerObj = new LinkedHashMap<>();
		innerObj.put("key", this.key);
		innerObj.put("full_name",this.fullName);
		innerObj.put("type",this.type);
		innerObj.put("is_objective",this.objective);
		innerObj.put("goal",this.goal);
		return gson.toJson(innerObj);
	}
}
