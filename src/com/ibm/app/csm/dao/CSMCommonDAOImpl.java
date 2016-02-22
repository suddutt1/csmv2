package com.ibm.app.csm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.app.csm.data.CSMUser;
import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.app.csm.data.EquipmentMaster;
import com.ibm.app.csm.data.OperationInstructon;
import com.ibm.app.csm.data.Operations;
import com.ibm.app.csm.data.OrderEmployee;
import com.ibm.app.csm.data.OrderEmployeeHistory;
import com.ibm.app.csm.data.OrderMain;
import com.ibm.app.csm.data.OrderMainHistory;
import com.ibm.app.csm.data.OrderOperation;
import com.ibm.app.csm.data.OrderPRT;
import com.ibm.app.csm.data.OrderPRTHistory;
import com.ibm.app.csm.data.OrderRequisition;
import com.ibm.app.csm.data.OrderSpares;
import com.ibm.app.csm.data.OrderSparesHistory;
import com.ibm.app.csm.data.PRTMaster;
import com.ibm.app.csm.data.Problem;
import com.ibm.app.csm.data.SparesMaster;
import com.ibm.tools.utils.MongoDBHelper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * DAO implementation for the application
 * @author SUDDUTT1
 *
 */
public class CSMCommonDAOImpl extends CSMBaseDAO {

	
	public OrderMain updateOrderMain(OrderMain objToUpdate) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		BasicDBObject filter = new BasicDBObject();
		filter.append("objType", "ord_main");
		filter.append("orderNumber", objToUpdate.getOrderNumber());
		
		DBObject existingObject = collection.findOne(filter);
		
		if (existingObject != null) {
			OrderMain oldBean = OrderMain.parseToObject(existingObject);
			oldBean.updateWith(objToUpdate);
			collection.update(filter,oldBean.toDBObject());
			return oldBean;
		}
		return null;
	}
	
	public OrderMain getOrderMain(String jobOrder)
	{
		OrderMain ordMain = null;
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		filter.append("objType", "ord_main");
		filter.append("orderNumber",jobOrder);
		DBObject resultObject  = collection.findOne(filter);
		if(resultObject!=null)
		{
			ordMain = OrderMain.parseToObject(resultObject);
		}
		return ordMain;
	}
	public void saveEmployeeMaster(EmployeeMaster objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<EmployeeMaster> findEmployeeMaster(EmployeeMaster srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<EmployeeMaster> returnList = new ArrayList<EmployeeMaster>();
		filter.append("objType", "emp_master");

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(EmployeeMaster.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveEquipmentMaster(EquipmentMaster objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<EquipmentMaster> findEquipmentMaster(EquipmentMaster srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<EquipmentMaster> returnList = new ArrayList<EquipmentMaster>();
		filter.append("objType", "equipment_master");

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(EquipmentMaster.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveOperations(Operations objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<Operations> findOperations(Operations srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<Operations> returnList = new ArrayList<Operations>();
		filter.append("objType", "operations");

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(Operations.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveOrderEmployee(OrderEmployee objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<OrderEmployee> findOrderEmployee(OrderEmployee srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderEmployee> returnList = new ArrayList<OrderEmployee>();
		filter.append("objType", "ord_emp");
		if(srchObject!=null && srchObject.getOrderNumber()!=null)
		{
			filter.append("orderNumber", srchObject.getOrderNumber());
		}
		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(OrderEmployee.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}
	
	public List<OrderEmployee> findOrderEmployee(String employeeId) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderEmployee> returnList = new ArrayList<OrderEmployee>();
		filter.append("objType", "ord_emp");
		filter.append("employeeId", employeeId);
		filter.append("status", ApplicationConstants.OPERATION_STATUS_ASSIGNED);
		
		
		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			DBCursor sortedCursor = cursor.sort(new BasicDBObject("assignedDate",1));
			while (sortedCursor.hasNext()) {
				DBObject dbObject = sortedCursor.next();
				returnList.add(OrderEmployee.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveOrderMain(OrderMain objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<OrderMain> findOrderMain(OrderMain srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderMain> returnList = new ArrayList<OrderMain>();
		filter.append("objType", "ord_main");

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(OrderMain.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}
	public List<OrderMain> findOrderMain(String orderType) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderMain> returnList = new ArrayList<OrderMain>();
		filter.append("objType", "ord_main");
		filter.append("orderType", orderType);
		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			DBCursor sortedCursor = cursor.sort(new BasicDBObject("finishBy",1));
			while (sortedCursor.hasNext()) {
				DBObject dbObject = sortedCursor.next();
				returnList.add(OrderMain.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveOrderOperation(OrderOperation objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<OrderOperation> findOrderOperation(OrderOperation srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderOperation> returnList = new ArrayList<OrderOperation>();
		filter.append("objType", "ord_operation");
		if(srchObject!=null && srchObject.getOrderNumber()!=null)
		{
			filter.append("orderNumber", srchObject.getOrderNumber());
		}
		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(OrderOperation.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveOrderPRT(OrderPRT objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<OrderPRT> findOrderPRT(OrderPRT srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderPRT> returnList = new ArrayList<OrderPRT>();
		filter.append("objType", "ord_prt");
		if(srchObject!=null && srchObject.getOrderNumber()!=null)
		{
			filter.append("orderNumber", srchObject.getOrderNumber());
		}

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(OrderPRT.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveOrderRequisition(OrderRequisition objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<OrderRequisition> findOrderRequisition(
			OrderRequisition srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderRequisition> returnList = new ArrayList<OrderRequisition>();
		filter.append("objType", "ord_req");
		if(srchObject!=null && srchObject.getOrderNumber()!=null)
		{
			filter.append("orderNumber", srchObject.getOrderNumber());
		}

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(OrderRequisition.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveOrderSpares(OrderSpares objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<OrderSpares> findOrderSpares(OrderSpares srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderSpares> returnList = new ArrayList<OrderSpares>();
		filter.append("objType", "ord_spares");
		if(srchObject!=null && srchObject.getOrderNumber()!=null)
		{
			filter.append("orderNumber", srchObject.getOrderNumber());
		}

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(OrderSpares.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveProblem(Problem objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<Problem> findProblem(Problem srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<Problem> returnList = new ArrayList<Problem>();
		filter.append("objType", "problem");

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(Problem.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void savePRTMaster(PRTMaster objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<PRTMaster> findPRTMaster(PRTMaster srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<PRTMaster> returnList = new ArrayList<PRTMaster>();
		filter.append("objType", "prt_master");

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(PRTMaster.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveSparesMaster(SparesMaster objToSave) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		if (objToSave != null) {
			collection.save(objToSave.toDBObject());
		}

	}

	public List<SparesMaster> findSparesMaster(SparesMaster srchObject) {
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		List<SparesMaster> returnList = new ArrayList<SparesMaster>();
		filter.append("objType", "spares_master");

		DBCursor cursor = collection.find(filter);
		if (cursor != null) {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				returnList.add(SparesMaster.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;
	}

	public void saveOrderMainHistory(OrderMainHistory objToSave)
	{
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		if(objToSave!=null)
		{
			collection.save(objToSave.toDBObject());
		}
			
	}
	public List<OrderMainHistory> findOrderMainHistory(OrderMainHistory srchObject)
	{
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderMainHistory> returnList = new ArrayList<OrderMainHistory>();
		filter.append("objType", "ord_main_hist");
		
		
		DBCursor cursor = collection.find(filter);
		if(cursor!=null)
		{
			while(cursor.hasNext())
			{
				DBObject dbObject = cursor.next();
								returnList.add(OrderMainHistory.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;	
	}
	public void saveOrderPRTHistory(OrderPRTHistory objToSave)
	{
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		if(objToSave!=null)
		{
			collection.save(objToSave.toDBObject());
		}
			
	}
	public List<OrderPRTHistory> findOrderPRTHistory(OrderPRTHistory srchObject)
	{
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderPRTHistory> returnList = new ArrayList<OrderPRTHistory>();
		filter.append("objType", "ord_prt_hist");
		
		
		DBCursor cursor = collection.find(filter);
		if(cursor!=null)
		{
			while(cursor.hasNext())
			{
				DBObject dbObject = cursor.next();
								returnList.add(OrderPRTHistory.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;	
	}

	public void saveOrderSparesHistory(OrderSparesHistory objToSave)
	{
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		if(objToSave!=null)
		{
			collection.save(objToSave.toDBObject());
		}
			
	}
	public List<OrderSparesHistory> findOrderSparesHistory(OrderSparesHistory srchObject)
	{
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderSparesHistory> returnList = new ArrayList<OrderSparesHistory>();
		filter.append("objType", "ord_spares_hist");
		
		
		DBCursor cursor = collection.find(filter);
		if(cursor!=null)
		{
			while(cursor.hasNext())
			{
				DBObject dbObject = cursor.next();
								returnList.add(OrderSparesHistory.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;	
	}
	public void saveOperationInstructon(OperationInstructon objToSave)
	{
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		if(objToSave!=null)
		{
			collection.save(objToSave.toDBObject());
		}
			
	}
	public List<OperationInstructon> findOperationInstructon(OperationInstructon srchObject)
	{
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OperationInstructon> returnList = new ArrayList<OperationInstructon>();
		filter.append("objType", "op_instruction");
		
		
		DBCursor cursor = collection.find(filter);
		if(cursor!=null)
		{
			while(cursor.hasNext())
			{
				DBObject dbObject = cursor.next();
								returnList.add(OperationInstructon.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;	
	}

	public OrderEmployeeHistory updateOrderEmployeeHistory(OrderEmployeeHistory objToUpdate) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		BasicDBObject filter = new BasicDBObject();
		filter.append("objType", "ord_emp_hist");
		//Add other parameters here
		
		DBObject existingObject = collection.findOne(filter);
		
		if (existingObject != null) {
			OrderEmployeeHistory oldBean = OrderEmployeeHistory.parseToObject(existingObject) ;
			//oldBean.updateWith(objToUpdate);
			collection.update(filter,oldBean.toDBObject());
			return oldBean;
		}
		return null;
	}
	
	
	public void saveOrderEmployeeHistory(OrderEmployeeHistory objToSave)
	{
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		if(objToSave!=null)
		{
			collection.save(objToSave.toDBObject());
		}
			
	}
	public List<OrderEmployeeHistory> findOrderEmployeeHistory(OrderEmployeeHistory srchObject)
	{
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		List<OrderEmployeeHistory> returnList = new ArrayList<OrderEmployeeHistory>();
		filter.append("objType", "ord_emp_hist");
		
		
		DBCursor cursor = collection.find(filter);
		if(cursor!=null)
		{
			while(cursor.hasNext())
			{
				DBObject dbObject = cursor.next();
								returnList.add(OrderEmployeeHistory.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;	
	}
	
	public CSMUser findCSMUser(String userId)
	{
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		
		filter.append("objType", "csm_user");
		filter.append("userId", userId);
		
		DBObject dbObject = collection.findOne(filter);
		if(dbObject!=null)
		{	
			return CSMUser.parseToObject(dbObject);
		}
		return null;	
	}
	public void saveCSMUser(CSMUser objToSave)
	{
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		if(objToSave!=null)
		{
			collection.save(objToSave.toDBObject());
		}
			
	}
	public List<CSMUser> findCSMUser(CSMUser srchObject)
	{
		BasicDBObject filter = new BasicDBObject();
		DBCollection collection = MongoDBHelper.getCollection(SERVICE_MGMENT_COLLECTION);
		List<CSMUser> returnList = new ArrayList<CSMUser>();
		filter.append("objType", "csm_user");
		
		
		DBCursor cursor = collection.find(filter);
		if(cursor!=null)
		{
			while(cursor.hasNext())
			{
				DBObject dbObject = cursor.next();
								returnList.add(CSMUser.parseToObject(dbObject));
			}
			cursor.close();
		}
		return returnList;	
	}
	
	public OrderSpares updateOrderSpares(OrderSpares objToUpdate) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		BasicDBObject filter = new BasicDBObject();
		filter.append("objType", "ord_spares");
		//Add other parameters here
		filter.append("orderNumber", objToUpdate.getOrderNumber());
		filter.append("materialNumber", objToUpdate.getMaterialNumber());
		DBObject existingObject = collection.findOne(filter);
		
		if (existingObject != null) {
			OrderSpares oldBean = OrderSpares.parseToObject(existingObject); 
			oldBean.updateWith(objToUpdate);
			collection.update(filter,oldBean.toDBObject());
			return oldBean;
		}
		return null;
	}
	public OrderPRT updateOrderPRT(OrderPRT objToUpdate) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		BasicDBObject filter = new BasicDBObject();
		filter.append("objType", "ord_prt");
		//Add other parameters here
		filter.append("orderNumber", objToUpdate.getOrderNumber());
		filter.append("prtNumber", objToUpdate.getPrtNumber());
		DBObject existingObject = collection.findOne(filter);
		
		if (existingObject != null) {
			OrderPRT oldBean = OrderPRT.parseToObject(existingObject); 
			oldBean.updateWith(objToUpdate);
			collection.update(filter,oldBean.toDBObject());
			return oldBean;
		}
		return null;
	}
	
	public OrderOperation updateOrderOperation(OrderOperation objToUpdate) {
		DBCollection collection = MongoDBHelper
				.getCollection(SERVICE_MGMENT_COLLECTION);
		BasicDBObject filter = new BasicDBObject();
		filter.append("objType", "ord_operation");
		filter.append("orderNumber", objToUpdate.getOrderNumber());
		filter.append("operationNumber", objToUpdate.getOperationNumber());
		
		//Add other parameters here
		
		DBObject existingObject = collection.findOne(filter);
		
		if (existingObject != null) {
						OrderOperation oldBean = OrderOperation.parseToObject(existingObject); 
			oldBean.updateWith(objToUpdate);
			collection.update(filter,oldBean.toDBObject());
			return oldBean;
		}
		return null;
	}
}
