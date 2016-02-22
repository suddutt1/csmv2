package com.ibm.app.csm.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.ibm.app.csm.dao.ApplicationConstants.*;

import com.ibm.app.csm.dao.ApplicationConstants;
import com.ibm.app.csm.dao.CSMCommonDAOImpl;
import com.ibm.app.csm.data.CSMUser;
import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.app.csm.data.EquipmentMaster;
import com.ibm.app.csm.data.OperationInstructon;
import com.ibm.app.csm.data.Operations;
import com.ibm.app.csm.data.OrderEmployee;
import com.ibm.app.csm.data.OrderMain;
import com.ibm.app.csm.data.OrderOperation;
import com.ibm.app.csm.data.OrderPRT;
import com.ibm.app.csm.data.OrderRequisition;
import com.ibm.app.csm.data.OrderSpares;
import com.ibm.app.csm.data.PRTMaster;
import com.ibm.app.csm.data.Problem;
import com.ibm.app.csm.data.SparesMaster;
import com.ibm.app.csm.domain.model.JobDetailsSupervisor;
import com.ibm.app.csm.domain.model.JobDetailsWorker;

/**
 * Data services helper.
 * @author SUDDUTT1
 *
 */
public class CSMDataServiceV2 {
	private static final Logger LOGGER = Logger
			.getLogger(CSMDataServiceV2.class.getName());

	private static Map<String, PRTMaster> _prtMasterMap = null;
	private static Map<String, SparesMaster> _sparesMasterMap = null;
	
	private static Map<String, EquipmentMaster> _equipmentMasterMap = null;
	private static Map<String, EmployeeMaster> _employeeMasterMap = null;
	private static CSMCommonDAOImpl _daoImpl = new CSMCommonDAOImpl();
	private static Map<String, Problem> _problemMaster = null;
	private static Map<String, Operations> _operationsMaster = null;

	/**
	 * Authenticate the user in this application
	 * @param userId String 
	 * @param password String 
	 * @return CSMUser
	 */
	public static CSMUser authenticate(String userId, String password) {
		CSMUser csmUser = _daoImpl.findCSMUser(userId);
		if (csmUser != null && csmUser.getPassword().equals(password)) {
			loadEmployeeMaster();
			if(_employeeMasterMap.containsKey(csmUser.getEmpId()))
			{
				csmUser.setEmpMaster(_employeeMasterMap.get(csmUser.getEmpId()));
				return csmUser;
			}
			
		}
		return null;
	}
	/**
	 * @return EmployeeMasterMap
	 */
	public static Map<String,EmployeeMaster> getEmployeeMaster()
	{
		loadEmployeeMaster();
		return _employeeMasterMap;
	}
	
	public static Map<String, PRTMaster> getPRTMaster()
	{
		loadPRTMaster();
		return _prtMasterMap;
	}
	public static Map<String, SparesMaster> getSparesMaster()
	{
		loadSparesMaster();
		return _sparesMasterMap;
	}
	public static Map<String, EquipmentMaster> getEquipmentMaster()
	{
		loadEmployeeMaster();
		return _equipmentMasterMap;
	}
	public static Map<String, Problem> getProblemMaster()
	{
		getProblem("", "");
		return _problemMaster;
	}
	public static Map<String, Operations> getOperationsMaster()
	{
		getOperation("");
		return _operationsMaster;
	}
	public static List<OrderMain> getPrioritzedJobList() {
		List<OrderMain> listofPrevtiveJobs = _daoImpl
				.findOrderMain(JOB_TYPE_PREVTIVE);
		List<OrderMain> listofPredictiveJobs = _daoImpl
				.findOrderMain(JOB_TYPE_PREDICTIVE);
		List<OrderMain> listOfUnplannedJobs = _daoImpl
				.findOrderMain(JOB_TYPE_BREAK);
		if (listOfUnplannedJobs != null && listOfUnplannedJobs.size() > 0) {
			for (OrderMain unplannedJobOrder : listOfUnplannedJobs) {
				EquipmentMaster equipment = getEqipment(
						unplannedJobOrder.getEquipmentNumber(),
						unplannedJobOrder.getModel());

				if (equipment != null) {
					unplannedJobOrder.setDisplayRatePerHours(equipment
							.getRatePerHour());
				}
			}
			Collections.sort(listOfUnplannedJobs, new Comparator<OrderMain>() {

				@Override
				public int compare(OrderMain o1, OrderMain o2) {
					if (o1 == o2) {
						return 0;
					} else {
						return (o1.getDisplayRatePerHours() == o2
								.getDisplayRatePerHours() ? 0 : (o1
								.getDisplayRatePerHours() > o2
								.getDisplayRatePerHours() ? -1 : 1));
					}
				}
			});
		}
		List<OrderMain> prioritizedList = new ArrayList<OrderMain>();
		if (listOfUnplannedJobs != null) {
			prioritizedList.addAll(listOfUnplannedJobs);
		}
		if (listofPrevtiveJobs != null) {

			prioritizedList.addAll(listofPrevtiveJobs);
		}
		if (listofPredictiveJobs != null) {
			prioritizedList.addAll(listofPredictiveJobs);
		}
		populateEquimentName(prioritizedList);
		return prioritizedList;
	}

	private static void populateEquimentName(List<OrderMain> list) {
		if (list != null && list.size() > 0) {
			for (OrderMain jobOrder : list) {
				populateEquimentName(jobOrder);
			}
		}
	}

	private static void populateEquimentName(OrderMain jobOrder) {

		EquipmentMaster equipment = getEqipment(jobOrder.getEquipmentNumber(),
				jobOrder.getModel());
		jobOrder.setDisplayRatePerHours(equipment.getRatePerHour());
		jobOrder.setDisplayEquipmentName(equipment.getDescription());

	}

	public static JobDetailsSupervisor getJobtailsForSupervisor(String jobId) {
		JobDetailsSupervisor jobDetails = null;
		try {
			OrderMain orderMain = _daoImpl.getOrderMain(jobId);
			if (orderMain != null) {
				jobDetails = new JobDetailsSupervisor(orderMain);
				jobDetails.setProblemDetails(getProblem(orderMain.getProblem(),
						orderMain.getCatalogProfile()));
				jobDetails.setOperationsList(getOperationsList(jobDetails
						.getProblemDetails()));
				jobDetails.setEquipmentDetails(getEqipment(
						orderMain.getEquipmentNumber(), orderMain.getModel()));
			}
		} catch (Exception ex) {
			LOGGER.log(Level.WARNING,
					"|CSMDS_V2|Exception to retrieve the job details", ex);
		}
		return jobDetails;
	}

	public static JobDetailsSupervisor getAssignedResources(JobDetailsSupervisor inputJobDetails) {
		JobDetailsSupervisor jobDetails = null;
		try {
			OrderMain orderMain = inputJobDetails.getJobOrderDetails();
			if (orderMain != null) {
				List<OrderEmployee> empList = _daoImpl.findOrderEmployee(new OrderEmployee(orderMain.getOrderNumber()));
				Map<String,String> empMap = new  HashMap<>();
				for(OrderEmployee ordEmp: empList)
				{
					empMap.put(ordEmp.getEmployeeId(), ordEmp.getEmployeeId());
				}
				inputJobDetails.setSelectedEmployee(new ArrayList<>(empMap.keySet()));
				inputJobDetails.setAssignedSparesList(_daoImpl.findOrderSpares(new OrderSpares(orderMain.getOrderNumber())));
				inputJobDetails.setAssignedPRTList(_daoImpl.findOrderPRT(new OrderPRT(orderMain.getOrderNumber())));
				List<OrderRequisition> reqList = _daoImpl.findOrderRequisition(new OrderRequisition(orderMain.getOrderNumber()));
				if(reqList!=null)
				{
					Map<String,String> reqMap = new HashMap<>();
					for(OrderRequisition ordReq: reqList)
					{
						reqMap.put(ordReq.getReqType(),ordReq.getReqNumber());
					}
					inputJobDetails.setRequisitionNumbers(reqMap);
				}
				jobDetails = inputJobDetails;
			}
		} catch (Exception ex) {
			LOGGER.log(Level.WARNING,
					"|CSMDS_V2|Exception to retrieve the job details", ex);
		}
		return jobDetails;
	}
	public static List<JobDetailsWorker> getAssignedJobList(String empId)
	{
		
		List<OrderEmployee> assignedWorkList = _daoImpl.findOrderEmployee(empId);
		if(assignedWorkList!=null && assignedWorkList.size()>0)
		{
			loadEmployeeMaster();
			Map<String,JobDetailsWorker> jobDetailsMap = new LinkedHashMap<>();
			for(OrderEmployee ordEmp: assignedWorkList)
			{
				if(!jobDetailsMap.containsKey(ordEmp.getOrderNumber()))
				{
					OrderMain orderMain = _daoImpl.getOrderMain(ordEmp.getOrderNumber());
					if(orderMain!=null)
					{
						JobDetailsWorker jobDetails = new JobDetailsWorker();
						jobDetails.setJobOrderDetails(orderMain);
						jobDetails.setOrderEmployee(ordEmp);
						jobDetails.setSparesList(_daoImpl.findOrderSpares(new OrderSpares(orderMain.getOrderNumber())));
						jobDetails.setToolsList(_daoImpl.findOrderPRT(new OrderPRT(orderMain.getOrderNumber())));
						jobDetails.setEmpDetails(_employeeMasterMap.get(ordEmp.getEmployeeId()));
						populateEquimentName(orderMain);
						Problem probDetails  = getProblem(orderMain.getProblem(), orderMain.getCatalogProfile());
						if(probDetails!=null)
						{
							jobDetails.setProblemDetails(probDetails.getProblemDescription());
						}
						jobDetails.setOperations(_daoImpl.findOrderOperation(new OrderOperation(orderMain.getOrderNumber())));
						jobDetails.setRequisitionList(_daoImpl.findOrderRequisition(new OrderRequisition(orderMain.getOrderNumber())));
						popoutaeSteps(jobDetails.getOperations());
						jobDetailsMap.put(ordEmp.getOrderNumber(),jobDetails);
					}
				}
				
			}
			return new ArrayList<>(jobDetailsMap.values());
			
		}
		return Collections.emptyList();
	}

	private static void popoutaeSteps(List<OrderOperation> opsList)
	{
		for(OrderOperation orderOps : opsList)
		{
			Operations ops = getOperation(orderOps.getOperationNumber());
			if(ops!=null)
			{
				orderOps.setSteps(ops.getStepList());
			}
		}
	}
	public static JobDetailsSupervisor assignJobToWorker(
			JobDetailsSupervisor jobDetails) {

		JobDetailsSupervisor retObject = null;
		try {
			// First update the status of the job
			// assuming all the details are passed
			if (jobDetails != null && jobDetails.getJobOrderDetails() != null
					&& jobDetails.getOperationsList() != null
					&& jobDetails.getProposedSparesList() != null
					&& jobDetails.getProposedToolsList() != null
					&& jobDetails.getSelectedEmployee() != null) {
				// update jobOrderStatus
				OrderMain orderMain = jobDetails.getJobOrderDetails();
				orderMain.setOrderStatus(JOB_STATUS_ANALYZED);
				_daoImpl.updateOrderMain(orderMain);
				createOrderOps(orderMain, jobDetails.getOperationsList());
				createOrderPRT(orderMain, jobDetails.getProposedToolsList());
				createOrderSpares(orderMain, jobDetails.getProposedSparesList());
				createOderEmployee(orderMain, jobDetails.getSelectedEmployee(),
						jobDetails.getOperationsList());
				jobDetails.setRequisitions(generateRequistions(orderMain,
						jobDetails.getProposedToolsList(),
						jobDetails.getProposedSparesList()));
				retObject = jobDetails;
			}
		} catch (Exception ex) {
			LOGGER.log(Level.WARNING, "|CSMDS_V2|Failed to assign job order",
					ex);
		}
		return retObject;
	}

	private static List<OrderRequisition> generateRequistions(
			OrderMain jobOrder, List<PRTMaster> toolsList,
			List<SparesMaster> sparesList) {
		List<OrderRequisition> reqList = new ArrayList<>();
		String reqNumber = generateRequsitionNumber();
		for (PRTMaster prt : toolsList) {
			OrderRequisition ordReq = new OrderRequisition();
			ordReq.setOrderNumber(jobOrder.getOrderNumber());
			ordReq.setReqNumber(reqNumber);
			ordReq.setReqType(REQUI_TYPE_PARTS);
			ordReq.setCreateDate(new Date());
			ordReq.setStatus(REQUI_STATUS_ASSIGNED);
			ordReq.setRefDataId(prt.getPrtNumber());
			ordReq.setUnitOfMeasure(prt.getUnitOfMeasure());
			ordReq.setQtyAssigned(1.0);
			_daoImpl.saveOrderRequisition(ordReq);
			reqList.add(ordReq);
		}
		reqNumber = generateRequsitionNumber();
		for (SparesMaster sparess : sparesList) {
			OrderRequisition ordReq = new OrderRequisition();
			ordReq.setOrderNumber(jobOrder.getOrderNumber());
			ordReq.setReqNumber(reqNumber);
			ordReq.setReqType(REQUI_TYPE_SPARES);
			ordReq.setCreateDate(new Date());
			ordReq.setStatus(REQUI_STATUS_ASSIGNED);
			ordReq.setRefDataId(sparess.getMaterialNumber());
			ordReq.setUnitOfMeasure(sparess.getUnitOfMeasure());
			ordReq.setQtyAssigned(sparess.getDisplayQuantityRequird());
			_daoImpl.saveOrderRequisition(ordReq);
			reqList.add(ordReq);
		}
		return reqList;
	}

	private static void createOderEmployee(OrderMain jobOder,
			List<String> empList, List<Operations> opList) {
		if (empList != null && opList != null) {
			loadEmployeeMaster();

			for (Operations ops : opList) {
				String deptId = ops.getDeptId();
				for (String empId : empList) {
					EmployeeMaster emp = _employeeMasterMap.get(empId);
					if (deptId.equalsIgnoreCase(emp.getDeptId())) {
						OrderEmployee ordEmployee = new OrderEmployee(jobOder,
								ops.getOperationId(), emp);
						ordEmployee.setStatus(OPERATION_STATUS_ASSIGNED);
						Date toDay = new Date();
						
						ordEmployee.setStartDate(toDay);
						ordEmployee.setEndDate(new Date(toDay.getTime()+86400000L));
						_daoImpl.saveOrderEmployee(ordEmployee);
					}
				}

			}
		}
	}

	private static void createOrderOps(OrderMain jobOder,
			List<Operations> opsList) {
		if (opsList != null) {
			int index = 0;
			for (Operations ops : opsList) {
				OrderOperation orderOps = new OrderOperation(jobOder, ops,
						index++);
				_daoImpl.saveOrderOperation(orderOps);

			}
		}
	}

	private static void createOrderSpares(OrderMain jobOder,
			List<SparesMaster> spList) {
		if (spList != null) {
			int index = 0;
			for (SparesMaster spare : spList) {
				OrderSpares orderSpares = new OrderSpares(jobOder, "", spare,
						index++);
				orderSpares.setRequiredQty(spare.getDisplayQuantityRequird());
				_daoImpl.saveOrderSpares(orderSpares);

			}
		}
	}

	private static void createOrderPRT(OrderMain jobOder,
			List<PRTMaster> prtList) {
		if (prtList != null) {
			int index = 0;
			for (PRTMaster ops : prtList) {
				OrderPRT orderOps = new OrderPRT(jobOder.getOrderNumber(), "",
						ops, index++);
				orderOps.setQtyAssigned(1);
				_daoImpl.saveOrderPRT(orderOps);

			}
		}
	}

	public static JobDetailsSupervisor loadAnalyticData(
			JobDetailsSupervisor jobDetails,String shift) {
		// Fills uo analytic data and sends back
		loadPRTMaster();
		loadSparesMaster();
		loadEmployeeMaster();
		
		if (jobDetails != null && jobDetails.getJobOrderDetails() != null
				&& jobDetails.getOperationsList()!=null) {
			jobDetails.setProposedSparesList(AnalyticSearchHelper
					.getOptimizedSparesList(_sparesMasterMap, jobDetails
							.getJobOrderDetails().getCatalogProfile()));
			// For each operations we should be loading the proposed tools list
			jobDetails.setProposedToolsList((AnalyticSearchHelper
					.getOptimizedPRTList(_prtMasterMap, jobDetails
							.getJobOrderDetails().getCatalogProfile(), "")));
			List<Operations> opsList = jobDetails.getOperationsList();
			if(opsList!=null)
			{
				List<EmployeeMaster> empList = new ArrayList<>();
				Map<String,String> deptMap = new HashMap<>();
				for(Operations ops: opsList)
				{
					deptMap.put(ops.getDeptId(), ops.getDeptId());
				}
				Date today = new Date();
				
				for(String deptId: deptMap.keySet())
				{
					//_daoImpl.retriveEmployee(_employeeMasterMap, "A"
							//, getOperation(ops).getDeptId(),toDay, toDay);
					empList.addAll(AnalyticSearchHelper.getOptimizedWorkers(_employeeMasterMap, shift, 
							jobDetails.getJobOrderDetails().getCatalogProfile(),
							deptId, today, today));
				}
				jobDetails.setProposedEmpList(empList);
				
			}
		}

		return jobDetails;
	}

	private static void loadPRTMaster() {
		if (_prtMasterMap == null) {
			List<PRTMaster> prtMasterList = _daoImpl.findPRTMaster(null);
			if (prtMasterList != null) {
				_prtMasterMap = new HashMap<String, PRTMaster>();
				for (PRTMaster equomentDetails : prtMasterList) {
					_prtMasterMap.put(equomentDetails.getPrtNumber(),
							equomentDetails);
				}
			}
		}
	}

	private static void loadEmployeeMaster() {
		if (_employeeMasterMap == null) {
			List<EmployeeMaster> empMasterList = _daoImpl
					.findEmployeeMaster(null);
			if (empMasterList != null) {
				_employeeMasterMap = new HashMap<String, EmployeeMaster>();
				for (EmployeeMaster empDetails : empMasterList) {
					_employeeMasterMap.put(empDetails.getEmployeeId(),
							empDetails);
				}
			}
		}
	}

	private static void loadSparesMaster() {
		if (_sparesMasterMap == null) {
			List<SparesMaster> prtMasterList = _daoImpl.findSparesMaster(null);
			if (prtMasterList != null) {
				_sparesMasterMap = new HashMap<String, SparesMaster>();
				for (SparesMaster equomentDetails : prtMasterList) {
					_sparesMasterMap.put(equomentDetails.getMaterialNumber(),
							equomentDetails);
				}
			}
		}
	}

	private static EquipmentMaster getEqipment(String equipmentNumber,
			String model) {
		// Ignoring the model number due to data unavailability
		if (_equipmentMasterMap == null) {
			List<EquipmentMaster> eqipmentMasterList = _daoImpl
					.findEquipmentMaster(null);
			if (eqipmentMasterList != null) {
				_equipmentMasterMap = new HashMap<String, EquipmentMaster>();
				for (EquipmentMaster equomentDetails : eqipmentMasterList) {
					_equipmentMasterMap.put(
							equomentDetails.getEquipmentNumber(),
							equomentDetails);
				}
			}
		}
		if (_equipmentMasterMap != null) {
			return _equipmentMasterMap.get(equipmentNumber);
		}
		return null;

	}

	private static Problem getProblem(String problemId, String calatogProf) {
		if (_problemMaster == null) {
			List<Problem> problemMasterList = _daoImpl.findProblem(null);
			if (problemMasterList != null) {
				_problemMaster = new HashMap<String, Problem>();
				for (Problem probDetails : problemMasterList) {
					_problemMaster.put(probDetails.getProblemId() + "_"
							+ probDetails.getCatalogProfile(), probDetails);
				}
			}
		}
		if (_problemMaster != null) {
			return _problemMaster.get(problemId + "_" + calatogProf);
		}
		return null;

	}

	private static List<Operations> getOperationsList(Problem problemDetails) {
		if (problemDetails != null) {
			String[] opsList = problemDetails.getOperationList();
			if (opsList != null) {
				List<Operations> returnList = new ArrayList<>();
				for (String opId : opsList) {
					returnList.add(getOperation(opId));
				}
				return returnList;
			}
		}
		return null;
	}

	private static void loadSteps()
	{
		List<OperationInstructon> steps =  _daoImpl.findOperationInstructon(null);
		if(steps!=null && steps.size()>0)
		{
			for(OperationInstructon step: steps)
			{
				if(_operationsMaster.containsKey(step.getOperationId()))
				{
					_operationsMaster.get(step.getOperationId()).getStepList().add(step.getStep());
				}
			}
		}
	}
	private static Operations getOperation(String id) {
		if (_operationsMaster == null) {
			List<Operations> opsList = _daoImpl.findOperations(null);
			if (opsList != null) {
				_operationsMaster = new HashMap<>();
				for (Operations opsDetails : opsList) {
					_operationsMaster.put(opsDetails.getOperationId(),
							opsDetails);
				}
				loadSteps();
			}
		}
		if (_operationsMaster != null) {
			return _operationsMaster.get(id);
		}
		return null;
	}

	private static String generateRequsitionNumber() {
		long number = (long) Math.floor(Math.random() * 10000L) + 100000L;
		return String.valueOf("RN" + number);
	}
	
	private static OrderMain updateJobStatus(OrderMain ordMain,List<OrderOperation> opsList)
	{
	
		if(opsList!=null)
		{
			boolean isAllcompleted = true;
			for(OrderOperation ops: opsList)
			{
				if(ops.getStatus()==null || !ops.getStatus().equalsIgnoreCase(ApplicationConstants.OPERATION_STATUS_COMPLETED))
				{
					isAllcompleted = true;
					break;
				}
			}
			String status = ApplicationConstants.JOB_STAUS_WIP;
			if(isAllcompleted)
			{
				status = ApplicationConstants.JOB_STAUS_CLOSED;
			}
			ordMain.setOrderStatus(status);
			_daoImpl.updateOrderMain(ordMain);
		}
		return ordMain;
	}
	/**
	 * @param jobDetails
	 * @param operationId
	 * @param startDate
	 * @param endDate
	 * @param hours
	 * @return
	 */
	public static JobDetailsWorker completeOperation(JobDetailsWorker jobDetails,String operationId,Date startDate,Date endDate,double hours)
	{
		if(jobDetails!=null )
		{
			List<OrderOperation> opsList = jobDetails.getOperations();
			if(opsList!=null )
			{
				OrderOperation srchObj = new OrderOperation(jobDetails.getJobOrderDetails().getOrderNumber(),operationId);
				int pos = opsList.indexOf(srchObj);
				if(pos!=-1)
				{
					OrderOperation updatedItem = opsList.get(pos);
					updatedItem.setActualDuration(hours);
					updatedItem.setActualFinishDate(endDate);
					updatedItem.setActualStartDate(startDate);
					updatedItem.setStatus(ApplicationConstants.OPERATION_STATUS_COMPLETED);
					_daoImpl.updateOrderOperation(updatedItem);
					updateJobStatus(jobDetails.getJobOrderDetails(),opsList);
				}
				
			}
		}
		return jobDetails;
		
	}
	/**
	 * @param jobDetails
	 * @param operationId
	 * @param startDate
	 * @param endDate
	 * @param hours
	 * @return
	 */
	public static JobDetailsWorker referOperation(JobDetailsWorker jobDetails,String operationId,Date startDate,Date endDate,double hours)
	{
		if(jobDetails!=null )
		{
			List<OrderOperation> opsList = jobDetails.getOperations();
			if(opsList!=null )
			{
				OrderOperation srchObj = new OrderOperation(jobDetails.getJobOrderDetails().getOrderNumber(),operationId);
				int pos = opsList.indexOf(srchObj);
				if(pos!=-1)
				{
					OrderOperation updatedItem = opsList.get(pos);
					updatedItem.setActualDuration(hours);
					updatedItem.setActualFinishDate(endDate);
					updatedItem.setActualStartDate(startDate);
					updatedItem.setStatus(ApplicationConstants.OPERATION_STATUS_REFERRED);
					_daoImpl.updateOrderOperation(updatedItem);
					jobDetails.getJobOrderDetails().setOrderStatus(ApplicationConstants.JOB_STAUS_REFRRED);
					_daoImpl.updateOrderMain(jobDetails.getJobOrderDetails());
				}
				
			}
		}
		return jobDetails;
		
	}
	public static JobDetailsWorker updatePRTUsage(JobDetailsWorker jobDetails,String prtNumber,double qtyUsed)
	{
		if(jobDetails!=null )
		{
			List<OrderPRT> toolsList = jobDetails.getToolsList();
			if(toolsList!=null )
			{
				OrderPRT srchObj = new OrderPRT(jobDetails.getJobOrderDetails().getOrderNumber(),prtNumber);
				int pos = toolsList.indexOf(srchObj);
				if(pos!=-1)
				{
					OrderPRT updatedItem = toolsList.get(pos);
					updatedItem.setQuantityUsed(qtyUsed);
					updatedItem.setUsageStartDate(new Date());
					updatedItem.setUsageEndDtae(new Date());
					_daoImpl.updateOrderPRT(updatedItem);
				}
				
			}
		}
		return jobDetails;
		
	}
	public static JobDetailsWorker updateSparesUsage(JobDetailsWorker jobDetails,String materialNumber,double qtyUsed)
	{
		if(jobDetails!=null )
		{
			List<OrderSpares> sparesList = jobDetails.getSparesList();
			if(sparesList!=null )
			{
				OrderSpares srchObj = new OrderSpares(jobDetails.getJobOrderDetails().getOrderNumber());
				srchObj.setMaterialNumber(materialNumber);
				
				int pos = sparesList.indexOf(srchObj);
				if(pos!=-1)
				{
					OrderSpares updatedItem = sparesList.get(pos);
					updatedItem.setUsedQty(qtyUsed);
					_daoImpl.updateOrderSpares(updatedItem);
				}
				
			}
		}
		return jobDetails;
		
	}
}
