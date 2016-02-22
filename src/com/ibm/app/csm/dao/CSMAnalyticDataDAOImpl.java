package com.ibm.app.csm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.tools.utils.MongoDBHelper;
import com.ibm.watson.tradeoffanalysis.bean.AnalyticParamter;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * DAO to access analytic data
 * @author SUDDUTT1
 *
 */
public class CSMAnalyticDataDAOImpl extends CSMBaseDAO {

	/**
	 * Returns available employees in the shift 
	 * @param empMaster
	 * @param shift
	 * @param catalogProfile
	 * @param deptId
	 * @param fromDate
	 * @param toDate
	 * @param selectedEmpMap
	 * @return
	 */
	public List<AnalyticParamter> retriveEmployee(Map<String,EmployeeMaster> empMaster,String shift,
			String catalogProfile,String deptId,
			Date fromDate,Date toDate,Map<String,EmployeeMaster> selectedEmpMap)
	{
		DBCollection collection = MongoDBHelper
				.getCollection(CSMBaseDAO.SERVICE_MGMENT_COLLECTION);
		List<String> jobOrderList = getJobOrderList(collection, catalogProfile);
		List<String> busyEmpList = findBusyEmployeeList(collection,fromDate,toDate);
		List<String> avialableEmpList = getEmployeesFromShift(collection, shift, deptId,busyEmpList);
		BasicDBObject filter = new BasicDBObject("objType", "ord_emp_hist");
		filter.append("orderNumber", new BasicDBObject("$in", jobOrderList));
		filter.append("employeeId", new BasicDBObject("$in", avialableEmpList));
		DBObject match = new BasicDBObject("$match", filter);
		DBObject fields = new BasicDBObject("_id", "$employeeId");
		fields.put("expCount", new BasicDBObject("$sum", 1));
		DBObject groupBy = new BasicDBObject("$group", fields);
		List<DBObject> pipeline = new ArrayList<>();
		pipeline.add(match);
		pipeline.add(groupBy);
		AggregationOutput output = collection.aggregate(pipeline);
		List<AnalyticParamter> results = new ArrayList<>();
		if (output != null && output.results() != null) {

			for (DBObject item : output.results()) {
				AnalyticParamter param = new AnalyticParamter();
				String empId = (String) item.get("_id");
				param.setName(empId);
				param.addAnalyticParam("workCount", item.get("expCount"));
				EmployeeMaster empDetails = new EmployeeMaster(empMaster.get(empId));
				empDetails.setCalcWorkCount((int)item.get("expCount"));
				param.addAnalyticParam("exp", empDetails.getCalcExperience());
				param.addAnalyticParam("skillLevel", empDetails.getSkillLevel());
				results.add(param);
				selectedEmpMap.put(empId,empDetails);
			}
		}
		return results;
	}
	/**
	 * Retrieves spare parts history list
	 * @param catalogProfile
	 * @param maxCountMap
	 * @return
	 */
	public List<AnalyticParamter> retriveSparesAnalyticData(
			String catalogProfile, Map<String, Double> maxCountMap) {
		DBCollection collection = MongoDBHelper
				.getCollection(CSMBaseDAO.SERVICE_MGMENT_COLLECTION);
		List<String> jobOrderList = getJobOrderList(collection, catalogProfile);

		BasicDBObject filter = new BasicDBObject("objType", "ord_spares_hist");
		filter.append("orderNumber", new BasicDBObject("$in", jobOrderList));
		DBObject match = new BasicDBObject("$match", filter);

		List<DBObject> pipeline = new ArrayList<>();
		pipeline.add(match);

		DBObject fields = new BasicDBObject("_id", "$materialNumber");
		fields.put("count", new BasicDBObject("$sum", 1));
		fields.put("max", new BasicDBObject("$max", "$usedQty"));
		DBObject groupBy = new BasicDBObject("$group", fields);

		pipeline.add(groupBy);
		AggregationOutput output = collection.aggregate(pipeline);

		List<AnalyticParamter> results = new ArrayList<>();
		if (output != null && output.results() != null) {

			for (DBObject item : output.results()) {
				AnalyticParamter param = new AnalyticParamter();
				param.setName((String) item.get("_id"));
				param.addAnalyticParam("count", item.get("count"));
				param.addAnalyticParam("maxusage", item.get("max"));
				results.add(param);
				maxCountMap.put(param.getName(), (Double) item.get("max"));
			}
		}
		return results;
	}

	/**
	 * Retrieves  parts history list
	 * @param catalogProfile
	 * @param operation
	 * @return
	 */
	public List<AnalyticParamter> retrivePartsAnalyticData(
			String catalogProfile, String operation) {
		DBCollection collection = MongoDBHelper
				.getCollection(CSMBaseDAO.SERVICE_MGMENT_COLLECTION);
		List<String> jobOrderList = getJobOrderList(collection, catalogProfile);

		BasicDBObject filter = new BasicDBObject("objType", "ord_prt_hist");
		filter.append("orderNumber", new BasicDBObject("$in", jobOrderList));
		// filter.append("operation",operation);
		DBObject match = new BasicDBObject("$match", filter);

		List<DBObject> pipeline = new ArrayList<>();
		pipeline.add(match);

		DBObject fields = new BasicDBObject("_id", "$prtNumber");
		fields.put("count", new BasicDBObject("$sum", 1));
		DBObject groupBy = new BasicDBObject("$group", fields);

		pipeline.add(groupBy);
		AggregationOutput output = collection.aggregate(pipeline);

		List<AnalyticParamter> results = new ArrayList<>();
		if (output != null && output.results() != null) {
			for (DBObject item : output.results()) {
				AnalyticParamter param = new AnalyticParamter();
				param.setName((String) item.get("_id"));
				param.addAnalyticParam("count", item.get("count"));
				results.add(param);
			}
		}
		return results;
	}

	/**
	 * Retrieves Job order list of same kind of category.
	 * @param collection
	 * @param catalogProfile
	 * @return
	 */
	private List<String> getJobOrderList(DBCollection collection,
			String catalogProfile) {
		List<String> jobOrderList = new ArrayList<>();
		BasicDBObject filter = new BasicDBObject("objType", "ord_main_hist");
		filter.append("catalogProfile", catalogProfile);
		DBCursor dbCursor = collection.find(filter);
		if (dbCursor != null) {
			while (dbCursor.hasNext()) {
				DBObject dbObject = dbCursor.next();
				jobOrderList.add((String) dbObject.get("orderNumber"));
			}
			dbCursor.close();
		}
		return jobOrderList;
	}
	/**
	 * Returns works in the input shift
	 * @param collection
	 * @param shift
	 * @param deptId
	 * @param busyEmpList
	 * @return
	 */
	private List<String> getEmployeesFromShift(DBCollection collection,
			String shift,String deptId,List<String> busyEmpList) {
		List<String> employeeList = new ArrayList<>();
		
		BasicDBObject filter = new BasicDBObject("objType", "emp_master");
		filter.append("shiftGrouping", shift);
		filter.append("deptId", deptId);
		filter.append("employeeId", new BasicDBObject("$nin", busyEmpList));
		DBCursor dbCursor = collection.find(filter);
		if (dbCursor != null) {
			while (dbCursor.hasNext()) {
				DBObject dbObject = dbCursor.next();
				employeeList.add((String) dbObject.get("employeeId"));
			}
			dbCursor.close();
		}
		return employeeList;
	}
	
	/**
	 * Returns list of already allocated worker.
	 * @param collection
	 * @param startDate
	 * @param toDate
	 * @return
	 */
	public List<String> findBusyEmployeeList(DBCollection collection, Date startDate,Date toDate) {
		BasicDBObject filter = new BasicDBObject();
		List<String> returnList = new ArrayList<String>();
		filter.append("objType", "ord_emp");
		filter.append("startDate", new BasicDBObject("$lte",startDate));
		filter.append("endDate", new BasicDBObject("$gte",toDate));
		filter.append("status", ApplicationConstants.OPERATION_STATUS_ASSIGNED);
		
		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add((String)dbObject.get("employeeId"));
			}
			cursor.close();
		}
		return returnList;
	}
}
