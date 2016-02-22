package com.ibm.watson.tradeoffanalysis.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.ibm.watson.util.TradeoffAnalysisUtil;

public class AnalyticProblem {

	private String problemStatement;
	private List<AnalyticColumnDefinition> colDefs;
	private List<AnalyticParamter> supportingData;

	public AnalyticProblem(String problemStatement) {
		this.problemStatement = problemStatement;
		this.colDefs = new ArrayList<>();
		this.supportingData = new ArrayList<>();
	}

	public void addColumnDefinition(AnalyticColumnDefinition columDef) {
		this.colDefs.add(columDef);
	}

	public void addSupportingData(AnalyticParamter data) {
		this.supportingData.add(data);
	}

	/**
	 * @return the problemStatement
	 */
	public String getProblemStatement() {
		return problemStatement;
	}

	/**
	 * @param problemStatement
	 *            the problemStatement to set
	 */
	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}

	/**
	 * @return the colDefs
	 */
	public List<AnalyticColumnDefinition> getColDefs() {
		return colDefs;
	}

	/**
	 * @param colDefs
	 *            the colDefs to set
	 */
	public void setColDefs(List<AnalyticColumnDefinition> colDefs) {
		this.colDefs = colDefs;
	}

	/**
	 * @return the dupportingData
	 */
	public List<AnalyticParamter> getSupportingData() {
		return supportingData;
	}

	/**
	 * @param dupportingData
	 *            the dupportingData to set
	 */
	public void setSupportingData(List<AnalyticParamter> supportingData) {
		this.supportingData = supportingData;
	}

	public List<String> analyze() {
		Map<String, AnalyticParamter> dataMap = new HashMap<String, AnalyticParamter>();
		// Build the input json;
		boolean isFirstElement = true;
		StringBuilder strBldrColumns = new StringBuilder("{ \"columns\":[")
				.append("\n");

		for (AnalyticColumnDefinition colDefn : this.colDefs) {
			if (!isFirstElement) {
				strBldrColumns.append(" , ");
			}
			strBldrColumns.append(colDefn.toAnalyticJSON());
			isFirstElement = false;
		}
		strBldrColumns.append("],").append("\n");
		strBldrColumns.append("\"subject\": \"").append(problemStatement)
				.append("\",").append("\n");
		strBldrColumns.append("\"options\": [");
		int index = 0;
		isFirstElement = true;
		for (AnalyticParamter param : this.supportingData) {
			if (!isFirstElement) {
				strBldrColumns.append(" , ");
			}
			dataMap.put(String.valueOf(index), param);
			strBldrColumns.append(param.toAnalyticJSON(String.valueOf(index)));
			isFirstElement = false;
			index++;
		}
		strBldrColumns.append("]");
		strBldrColumns.append("}");
		String output = TradeoffAnalysisUtil
				.applyTradeoffAnalytics(strBldrColumns.toString());
		List<String> optimalSolution = getSelectedSolutionKey(output, dataMap);
		return optimalSolution;
	}

	private List<String> getSelectedSolutionKey(String output,
			Map<String, AnalyticParamter> dataMap) {
		List<String> optimalSolutionSet = new ArrayList<>();
		Gson gson = new Gson();
		Object responseObj = gson.fromJson(output, Object.class);
		if (responseObj instanceof Map) {
			Object resolution = ((Map) responseObj).get("resolution");
			if (resolution != null && (resolution instanceof Map)) {
				Object solutions = ((Map) resolution).get("solutions");
				if (solutions != null && (solutions instanceof List)) {
					List<Map> solutionList = (List<Map>) solutions;
					for (int index = 0; index < solutionList.size(); index++) {
						Map<String, Object> solutionInfo = (Map<String, Object>) solutionList
								.get(index);
						if (solutionInfo.get("status") != null
								&& solutionInfo.get("status").equals("FRONT")) {
							optimalSolutionSet.add(dataMap.get(
									String.valueOf(index)).getName());
						}
					}
				}
			}

		}
		return optimalSolutionSet;
	}
}
