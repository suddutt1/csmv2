package com.ibm.app.csm.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.app.csm.data.EmployeeMaster;
public class ChartMaker {
	private List<EmployeeMaster> employeeMasterList;

	public ChartMaker(){
		this.employeeMasterList=null;
	}

	public List<EmployeeMaster> getEmployeeMaster() {
		return employeeMasterList;
	}

	public void setEmployeeMasterList(List<EmployeeMaster> employeeMasterList) {
		this.employeeMasterList = employeeMasterList;
	}

	public String[] getNameIDArrayFromList(){
		String[] nameIdArray= new String[employeeMasterList.size()];
    int i=0,k;
	for(EmployeeMaster employee:employeeMasterList){
		k=employee.getEmployeeName().indexOf(" ");
		if(k==-1){
			k=employee.getEmployeeName().length();
		}

     nameIdArray[i++]=employee.getEmployeeName().substring(0,k)+"-("+employee.getWorkCenter()+")";	
    }
	return nameIdArray;
		
	}

	public Integer[] getWorkCountArrayFromList(){
		Integer[] workCountArray =new Integer[employeeMasterList.size()];
		int i=0;
		for (EmployeeMaster employee:employeeMasterList){
			workCountArray[i++]=employee.getCalcWorkCount();
		}
		return workCountArray;
	}

	public Double[] getExperienceArrayFromList(){
		Double[] experienceArray =new Double[employeeMasterList.size()];
		int i=0;
		for (EmployeeMaster employee:employeeMasterList){
			experienceArray[i++]=employee.getCalcExperience();
		}
		return experienceArray;
	}

	public Long[] getSkillLevelArrayFromList(){
		Long[] skillLevelArray =new Long[employeeMasterList.size()];
		int i=0;
		for (EmployeeMaster employee:employeeMasterList){
			skillLevelArray[i++]=employee.getSkillLevel();
		}
		return skillLevelArray;
	}
	
	public String toJson()
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put("names", getNameIDArrayFromList());
		dataMap.put("skill", getSkillLevelArrayFromList());
		dataMap.put("exp", getExperienceArrayFromList());
		dataMap.put("wrkCount", getWorkCountArrayFromList());
		return gson.toJson(dataMap);
	}
}