package com.ibm.app.csm.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.app.csm.dao.CSMAnalyticDataDAOImpl;
import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.app.csm.data.PRTMaster;
import com.ibm.app.csm.data.SparesMaster;
import com.ibm.watson.tradeoffanalysis.bean.AnalyticColumnDefinition;
import com.ibm.watson.tradeoffanalysis.bean.AnalyticParamter;
import com.ibm.watson.tradeoffanalysis.bean.AnalyticProblem;

/**
 * Helper class for WATSON analytic searches
 * 
 * @author SUDDUTT1
 *
 */
public class AnalyticSearchHelper {

	private static CSMAnalyticDataDAOImpl _daoImpl = new CSMAnalyticDataDAOImpl();

	private AnalyticSearchHelper() {
		super();
	}

	public static List<SparesMaster> getOptimizedSparesList(
			Map<String, SparesMaster> sparesMap, String categoryProfile) {
		Map<String, Double> maxCountmap = new HashMap<String, Double>();
		List<AnalyticParamter> analicParams = _daoImpl
				.retriveSparesAnalyticData(categoryProfile, maxCountmap);
		AnalyticProblem problem = new AnalyticProblem("SparesOptimization");
		AnalyticColumnDefinition colDef = new AnalyticColumnDefinition("count",
				"Count of Spare item",
				AnalyticColumnDefinition.DATA_TYPE_NUMERIC, true,
				AnalyticColumnDefinition.GOAL_MAXIMIZE);
		problem.addColumnDefinition(colDef);
		colDef = new AnalyticColumnDefinition("maxusage",
				"Max usage of Spare item",
				AnalyticColumnDefinition.DATA_TYPE_NUMERIC, true,
				AnalyticColumnDefinition.GOAL_MAXIMIZE);
		problem.setSupportingData(analicParams);
		List<String> optimalSolution = problem.analyze();
		List<SparesMaster> resultSet = new ArrayList<>();
		if (optimalSolution != null && optimalSolution.size() > 0) {
			for (String materialNumber : optimalSolution) {
				SparesMaster spMaster = sparesMap.get(materialNumber);
				if (spMaster != null) {
					SparesMaster copy = new SparesMaster(spMaster);
					copy.setDisplayQuantityRequird(maxCountmap
							.get(materialNumber));
					resultSet.add(copy);
				}
			}
		}
		return resultSet;
	}

	public static List<PRTMaster> getOptimizedPRTList(
			Map<String, PRTMaster> prtMap, String catalogProfile,
			String operation) {
		List<AnalyticParamter> analicParams = _daoImpl
				.retrivePartsAnalyticData(catalogProfile, operation);
		AnalyticProblem problem = new AnalyticProblem("PRTOPtimization");
		AnalyticColumnDefinition colDef = new AnalyticColumnDefinition("count",
				"Count of PRT item",
				AnalyticColumnDefinition.DATA_TYPE_NUMERIC, true,
				AnalyticColumnDefinition.GOAL_MAXIMIZE);
		problem.addColumnDefinition(colDef);
		problem.setSupportingData(analicParams);
		List<String> optimalSolution = problem.analyze();
		List<PRTMaster> resultSet = new ArrayList<>();
		if (optimalSolution != null && optimalSolution.size() > 0) {
			for (String prtNumber : optimalSolution) {
				PRTMaster prtMaster = prtMap.get(prtNumber);
				if (prtMaster != null) {
					resultSet.add(prtMaster);
				}
			}
		}
		return resultSet;

	}

	public static List<EmployeeMaster> getOptimizedWorkers(
			Map<String, EmployeeMaster> empMasterMap, String shift,
			String categoryProf,String deptId,Date startDate,Date endDate) {
		Map<String,EmployeeMaster> selectedEmpMap = new HashMap<>();
		List<AnalyticParamter> analyticParamsList = _daoImpl.retriveEmployee(empMasterMap,
				shift, categoryProf, deptId, startDate, endDate,selectedEmpMap);
		
		AnalyticProblem problem = new AnalyticProblem("EmployeeSkillOptimization");
		AnalyticColumnDefinition colDef = new AnalyticColumnDefinition("workCount",
				"Work count",
				AnalyticColumnDefinition.DATA_TYPE_NUMERIC, true,
				AnalyticColumnDefinition.GOAL_MAXIMIZE);
		problem.addColumnDefinition(colDef);
		colDef = new AnalyticColumnDefinition("exp",
				"Overall experience",
				AnalyticColumnDefinition.DATA_TYPE_NUMERIC, true,
				AnalyticColumnDefinition.GOAL_MAXIMIZE);
		colDef = new AnalyticColumnDefinition("skillLevel",
				"Resouce skill level",
				AnalyticColumnDefinition.DATA_TYPE_NUMERIC, true,
				AnalyticColumnDefinition.GOAL_MAXIMIZE);
		problem.setSupportingData(analyticParamsList);
		List<String> optimalSolution = problem.analyze();
		List<EmployeeMaster> selectedEmpList = new ArrayList<>();
		if (optimalSolution != null && optimalSolution.size() > 0) {
			for (String empNumber : optimalSolution) {
				selectedEmpList.add(selectedEmpMap.get(empNumber));
			}
		}
		return selectedEmpList;

	}

}
