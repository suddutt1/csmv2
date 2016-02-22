package com.ibm.app.csm.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ibm.app.csm.dao.ApplicationConstants;
import com.ibm.app.csm.data.CSMUser;
import com.ibm.app.csm.data.OrderOperation;
import com.ibm.app.csm.data.OrderPRT;
import com.ibm.app.csm.data.OrderRequisition;
import com.ibm.app.csm.data.OrderSpares;
import com.ibm.app.csm.domain.model.JobDetailsWorker;
import com.ibm.app.csm.services.CSMDataServiceV2;
import com.ibm.app.web.frmwk.WebActionHandler;
import com.ibm.app.web.frmwk.annotations.RequestMapping;
import com.ibm.app.web.frmwk.bean.ModelAndView;
import com.ibm.app.web.frmwk.bean.ViewType;


/**
 * Action class for Worker . Public method of this class implements
 * actions related to Worker .
 * 
 * @author Suman Mandal
 * 
 */

public class WorkerAction  implements WebActionHandler {
	final String TOOLS_COLLECTED="toolsCollected";
	final String SPARES_COLLECTED="sparesCollected";
	final String NOT_COLLECTED="notCollected";
	/**
	 * Load the Worker Home Page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	
	@RequestMapping("WorkerHomePage.wss")
	public ModelAndView workerHomePage(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/workerHomePage.jsp");
		List<JobDetailsWorker> jobList =CSMDataServiceV2.getAssignedJobList(getLoggedInEmployeeId(request));
		HttpSession session=request.getSession();  
	    session.setAttribute("jobList",jobList ); 
		mvObject.addModel("jobList", jobList );
		return mvObject;
	}
	/**
	 * Returns the logged in users employee id
	 * @param request
	 * @return
	 */
	private String getLoggedInEmployeeId(HttpServletRequest request)
	{
		CSMUser user = (CSMUser)request.getSession().getAttribute(ApplicationConstants.USER_OBJECT);
		if(user!=null)
		{
			return user.getEmpId();
		}
		return "";
	}
	/**
	 * Load the Job Details page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	
	@RequestMapping("viewJobDetailsForWorker.wss")
	public ModelAndView viewJobDetailsForWorker(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		HttpSession session=request.getSession(); 
		String orderNumber=request.getParameter("orderNumber");
		String positionInList=request.getParameter("positionInList");
		int positionOfOrder=0;
		if(positionInList==null){
		  positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		}else{
		 positionOfOrder=Integer.parseInt(positionInList);
		}
		String toolsStatus=NOT_COLLECTED;
		String sparesStatus=NOT_COLLECTED;
		
		/*Map<String, PRTMaster> partMap= CSMDataServiceV2.getPRTMaster();
		Map<String, Problem> problemMaster =CSMDataServiceV2.getProblemMaster();
		Map<String, Operations> operationsMaster =CSMDataServiceV2.getOperationsMaster();
		Map<String, SparesMaster> sparesMasterMap =CSMDataServiceV2.getSparesMaster();*/
		
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		session.setAttribute("positionOfOrder",positionOfOrder ); 
		session.setAttribute("toolsStatus",toolsStatus); 
		session.setAttribute("sparesStatus",sparesStatus ); 
		/*session.setAttribute("partMap",partMap ); 
		session.setAttribute("problemMaster",problemMaster); 
		session.setAttribute("operationsMaster",operationsMaster); 
		session.setAttribute("sparesMasterMap",sparesMasterMap);*/
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder);
		mvObject.addModel("jobDetails", jobDetails );
		mvObject.addModel("toolsStatus",toolsStatus);
		mvObject.addModel("sparesStatus",sparesStatus);
		mvObject.setView("app/WorkerJobDetailsPage.jsp");
		return mvObject;
	}
	/**
	 * Load the Tool details page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("viewTools.wss")
	public ModelAndView viewTools(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/ToolsDetailsPage.jsp");
		HttpSession session=request.getSession(); 
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
		List<OrderRequisition> requisitionList=jobDetails.getRequisitionList();
		mvObject.addModel("requisitionList", requisitionList );
		mvObject.addModel("jobDetails", jobDetails);
	
		
		return mvObject;
	}
	/**
	 * Update the status after tool collection
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("updateToolCollction.wss")
	public ModelAndView updateToolCollection(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		HttpSession session=request.getSession(); 
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		String sparesStatus=(String) session.getAttribute("sparesStatus");
		session.setAttribute("toolsStatus",TOOLS_COLLECTED); 
		session.setAttribute("sparesStatus",sparesStatus ); 
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder);
		mvObject.addModel("jobDetails", jobDetails );
		mvObject.addModel("toolsStatus",TOOLS_COLLECTED);
		mvObject.addModel("sparesStatus",sparesStatus);
		mvObject.setView("app/WorkerJobDetailsPage.jsp");
		return mvObject;
	}
	/**
	 * Load the spares details page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("viewSpares.wss")
	public ModelAndView viewSpares(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/SparesDetailsPage.jsp");
		HttpSession session=request.getSession(); 
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
		List<OrderRequisition> requisitionList=jobDetails.getRequisitionList();
		mvObject.addModel("requisitionList", requisitionList );
		mvObject.addModel("jobDetails", jobDetails);
		return mvObject;
	}
	/**
	 * Load the status after spare collection
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("updateSparesCollction.wss")
	public ModelAndView updateSparesCollection(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		HttpSession session=request.getSession(); 
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		String toolsStatus=(String) session.getAttribute("toolsStatus");
		session.setAttribute("sparesStatus",SPARES_COLLECTED ); 
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder);
		mvObject.addModel("jobDetails", jobDetails );
		mvObject.addModel("toolsStatus",toolsStatus);
		mvObject.addModel("sparesStatus",SPARES_COLLECTED);
		mvObject.setView("app/WorkerJobDetailsPage.jsp");
		return mvObject;
	}
	/**
	 * Load the task details page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("viewTask.wss")
	public ModelAndView viewTask(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/TaskDetailsPage.jsp");
		String operationSerialNo=request.getParameter("operationSerialNo");
		int positionOfOperation=0;
		HttpSession session=request.getSession(); 
		if(operationSerialNo==null){
			positionOfOperation=(Integer) session.getAttribute("positionOfOperation");
		}else{
			positionOfOperation=Integer.parseInt(operationSerialNo);
			session.setAttribute("positionOfOperation",positionOfOperation ); 
		}
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
		List<OrderOperation> operations=jobDetails.getOperations();
		OrderOperation operation=operations.get(positionOfOperation);
		session.setAttribute("positionOfOperation",positionOfOperation); 
		List<String> steps=operation.getSteps();
		steps=covertTheList(steps);
		
		mvObject.addModel("currentOperation", operation);
		mvObject.addModel("steps", steps);
		mvObject.addModel("jobDetails",jobDetails);
		
		return mvObject;
	}
	/**
	 * convert each string of the list to a specified format 
	 * 
	 * @param steps  List<String>
	 * 
	 * @return steps
	 *           <list>String
	 */
	private List<String> covertTheList(List<String> steps) {
		List<String> stepsForTextToSpech=new ArrayList<String>();
		for(String step:steps){
			step=step.trim().replaceAll("\\s+", "+");
			stepsForTextToSpech.add(step);
		}
		// TODO Auto-generated method stub
		return stepsForTextToSpech;
	}
	/**
	 * Load the task commit page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("commitTask.wss")
	public ModelAndView commitTask(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/TaskCommitPage.jsp");
		HttpSession session=request.getSession(); 
		Integer	positionOfOperation=(Integer) session.getAttribute("positionOfOperation");
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
		List<OrderOperation> operations=jobDetails.getOperations();
		OrderOperation operation=operations.get(positionOfOperation);
		mvObject.addModel("currentOperation", operation);
		mvObject.addModel("jobDetails",jobDetails);
		return mvObject;
		
	}
	/**
	 * Update the status of the task to Complete
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW) 
	 */
	@RequestMapping("updateTask.wss")
	public ModelAndView updateTask(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		
			String startDate=request.getParameter("startDate");
			String startMonth=request.getParameter("startMonth");
			String startYr=request.getParameter("startYr");
			String startHour=request.getParameter("startHour");
			String startMinute=request.getParameter("startMinute");
			String endDate=request.getParameter("endDate");
			String endMonth=request.getParameter("endMonth");
			String endYr=request.getParameter("endYr");
			String endHour=request.getParameter("endHour");
			String endMinute=request.getParameter("endMinute");
			String actualHour=request.getParameter("actualHour");
			String actualMinute=request.getParameter("actualMinute");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			String startDateInString = "20"+startYr+"/"+startMonth+"/"+startDate+" "+startHour+":"+startMinute;
			String endDateInString = "20"+endYr+"/"+endMonth+"/"+endDate+" "+endHour+":"+endMinute;
			Date startingDate = sdf.parse(startDateInString);
			Date endingDate=sdf.parse(endDateInString);
			int actualhours=Integer.parseInt(actualHour)+(Integer.parseInt(actualMinute)/60);
			Double hours=(double) actualhours;
			
			
		
		
		HttpSession session=request.getSession(); 
		Integer	positionOfOperation=(Integer) session.getAttribute("positionOfOperation");
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
		List<OrderOperation> operations=jobDetails.getOperations();
		OrderOperation operation=operations.get(positionOfOperation);
		
		operation.setActualStartDate(startingDate);
		operation.setActualFinishDate(endingDate);
		operation.setActualDuration(actualhours);
		operations.set(positionOfOperation, operation);
		jobDetails.setOperations(operations);
		
		jobDetails=CSMDataServiceV2.completeOperation(jobDetails, operation.getOperationNumber(), startingDate, endingDate, hours);
		ModelAndView mvObject = new ModelAndView(ViewType.FORWARD_ACTION_VIEW);
		mvObject.setView("viewJobDetailsForWorker.wss");
		mvObject.addModel("currentOperation", operation);
		mvObject.addModel("jobDetails",jobDetails);
		if(jobDetails.getJobOrderDetails().getOrderStatus().equalsIgnoreCase(ApplicationConstants.JOB_STAUS_CLOSED)){
			mvObject.setView("commitJob.wss");
		}
		return mvObject;
		
	}
	/**
	 * Load the job commit page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("commitJob.wss")
	public ModelAndView commitJob(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/JobCommitPage.jsp");
		HttpSession session=request.getSession(); 
		
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
		mvObject.addModel("jobDetails",jobDetails);
		return mvObject;
		
	}
	/**
	 * Update the status of the job to Complete
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW) 
	 */
	@RequestMapping("updateJob.wss")
	public ModelAndView updateJob(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.FORWARD_ACTION_VIEW);
		mvObject.setView("WorkerHomePage.wss");		
		HttpSession session=request.getSession(); 
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
		
		List<OrderSpares> orderSpares=jobDetails.getSparesList();
		for(OrderSpares orderSpare:orderSpares){
			String noOfUsedMaterial=request.getParameter(orderSpare.getMaterialNumber());
			CSMDataServiceV2.updateSparesUsage(jobDetails,orderSpare.getMaterialNumber(), Double.parseDouble(noOfUsedMaterial));
		}
		
		
		
		List<OrderPRT> toolsLists=jobDetails.getToolsList();
		for(OrderPRT orderTool:toolsLists){
			String noOfUsedMaterial=request.getParameter(orderTool.getPrtNumber());
			CSMDataServiceV2.updatePRTUsage(jobDetails, orderTool.getPrtNumber(),Double.parseDouble(noOfUsedMaterial));
		}
		jobDetails.setToolsList(toolsLists);
		
		
		
		return mvObject;
		
	}
	/**
	 * Load the Task Help page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 * 
	 */
	@RequestMapping("viewTaskHelp.wss")
	public ModelAndView viewTaskHelp(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/TaskHelpPage.jsp");
		HttpSession session=request.getSession(); 
		Integer	positionOfOperation=(Integer) session.getAttribute("positionOfOperation");
		@SuppressWarnings("unchecked")
		List<JobDetailsWorker> jobList=(List<JobDetailsWorker>) session.getAttribute("jobList");
		Integer positionOfOrder=(Integer) session.getAttribute("positionOfOrder");
		JobDetailsWorker jobDetails=jobList.get(positionOfOrder.intValue());
		List<OrderOperation> operations=jobDetails.getOperations();
		OrderOperation operation=operations.get(positionOfOperation);
		mvObject.addModel("currentOperation", operation);
		mvObject.addModel("jobDetails",jobDetails);
		return mvObject;
	}

}
