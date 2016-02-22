package com.ibm.app.csm.dao;

import java.util.Date;

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

/**
 * Supporting uitlity . Please ignore. 
 * @author SUDDUTT1
 *
 */
public class DataCreatorUtil {

	private static final CSMCommonDAOImpl _daoImpl = new CSMCommonDAOImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//copyJobOrder("10000103",ApplicationConstants.JOB_TYPE_BREAK);
		cleanJobOrder("10000102");
		//String[] objectTypes = {(new OrderEmployeeHistory()).getObjType(),(new EmployeeMaster()).getObjType()};
		//removeData(objectTypes);
		
//		String[] objectTypes = {
//				
//						(new EmployeeMaster()).getObjType(),
//						(new EquipmentMaster()).getObjType(),
//						(new OperationInstructon()).getObjType(),
//						(new Operations()).getObjType(),
//						(new OrderEmployee()).getObjType(),
//						(new OrderEmployeeHistory()).getObjType(),
//						(new OrderMain()).getObjType(),
//						(new OrderMainHistory()).getObjType(),
//						(new OrderOperation()).getObjType(),
//						(new OrderPRT()).getObjType(),
//						(new OrderPRTHistory()).getObjType(),
//						(new OrderRequisition()).getObjType(),
//						(new OrderSpares()).getObjType(),
//						(new OrderSparesHistory()).getObjType(),
//						(new Problem()).getObjType(),
//						(new PRTMaster()).getObjType(),
//						(new SparesMaster()).getObjType()
//		};

	}
	private static void removeData(String[] objectTypes)
	{
		DBCollection collection = MongoDBHelper
				.getCollection(CSMBaseDAO.SERVICE_MGMENT_COLLECTION);
		for(String objectType: objectTypes)
		{
			BasicDBObject filter = new BasicDBObject();
			filter.append("objType", objectType);
			collection.remove(filter);
			System.out.println("Data clened for obj type "+ objectType);
		}
	}
	public static void cleanJobOrder(String jobOrder)
	{
		DBCollection collection = MongoDBHelper
				.getCollection(CSMBaseDAO.SERVICE_MGMENT_COLLECTION);
		BasicDBObject filter = new BasicDBObject();
		filter.append("objType", "ord_operation");
		filter.append("orderNumber", jobOrder);
		collection.remove(filter);
		filter = new BasicDBObject();
		filter.append("objType", "ord_prt");
		filter.append("orderNumber", jobOrder);
		collection.remove(filter);
		
		filter = new BasicDBObject();
		filter.append("objType", "ord_req");
		filter.append("orderNumber", jobOrder);
		collection.remove(filter);
		
		filter = new BasicDBObject();
		filter.append("objType", "ord_spares");
		filter.append("orderNumber", jobOrder);
		collection.remove(filter);
		
		filter = new BasicDBObject();
		filter.append("objType", "ord_emp");
		filter.append("orderNumber", jobOrder);
		collection.remove(filter);
		OrderMain ordMain = new OrderMain(jobOrder);
		ordMain.setOrderStatus(ApplicationConstants.JOB_STAUS_CREATED);
		_daoImpl.updateOrderMain(ordMain);
		
	}
	
	public static void copyJobOrder(String jobOrderToCopy,String orderType)
	{
		OrderMain orderMain = _daoImpl.getOrderMain(jobOrderToCopy);
		OrderMain newOrderMain = new OrderMain(orderMain);
		newOrderMain.setOrderNumber(generateOrderNumber());
		if(orderType!=null)
		{
			newOrderMain.setOrderType(orderType);
		}
		Date toDay = new Date();
		newOrderMain.setCreatedOn(toDay);
		newOrderMain.setFinishBy(new Date(toDay.getTime()+2*86400000L));
		
		_daoImpl.saveOrderMain(newOrderMain);
		System.out.println("New jobOrderNumber: "+newOrderMain.getOrderNumber());
		
	}
	private static String generateOrderNumber()
	{
		long number = (long) Math.floor(Math.random() * 1000000L) + 10000000L;
		return String.valueOf(number);
	}
}
