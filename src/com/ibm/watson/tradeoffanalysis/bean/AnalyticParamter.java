package com.ibm.watson.tradeoffanalysis.bean;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class AnalyticParamter {

	private String name;
	private Map<String,Object> analyticParams;
	
	public AnalyticParamter()
	{
		this.analyticParams = new HashMap<String, Object>();
	}
	
	public void addAnalyticParam(String key, Object value)
	{
		this.analyticParams.put(key, value);
	}
	public Object getAnalyticParam(String key)
	{
		return this.analyticParams.get(key);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the analyticParams
	 */
	public Map<String, Object> getAnalyticParams() {
		return analyticParams;
	}

	/**
	 * @param analyticParams the analyticParams to set
	 */
	public void setAnalyticParams(Map<String, Object> analyticParams) {
		this.analyticParams = analyticParams;
	}
	
	public String toAnalyticJSON(String key)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map<String,Object> innerObj = new LinkedHashMap<>();
		innerObj.put("key", key);
		innerObj.put("name",this.name);
		innerObj.put("values",this.getAnalyticParams());
		return gson.toJson(innerObj);
	}
	
	
}
