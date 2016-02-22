package com.ibm.app.csm.action;

import static com.ibm.app.csm.dao.ApplicationConstants.USER_OBJECT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.app.csm.dao.ApplicationConstants;
import com.ibm.app.csm.data.CSMUser;
import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.app.csm.data.EquipmentMaster;
import com.ibm.app.csm.data.OrderMain;
import com.ibm.app.csm.data.OrderRequisition;
import com.ibm.app.csm.data.PRTMaster;
import com.ibm.app.csm.data.SparesMaster;
import com.ibm.app.csm.domain.model.JobDetailsSupervisor;
import com.ibm.app.csm.services.CSMDataServiceV2;
import com.ibm.app.web.frmwk.WebActionHandler;
import com.ibm.app.web.frmwk.annotations.RequestMapping;
import com.ibm.app.web.frmwk.bean.ModelAndView;
import com.ibm.app.web.frmwk.bean.ViewType;

/**
 * Action class for Supervisor . Public method of this class implements
 * actions related to Supervisor .
 * 
 * @author Suman Mandal , Sudip Dutta
 * 
 */
public class HomePageAction implements WebActionHandler {
	
	/**
	 * Load the login  Page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 * 
	 */
	@RequestMapping("loginPage.wss")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		request.getSession().setAttribute("CSM_USER",null);
		mvObject.setView("app/loginPage.jsp");
		
		return mvObject;
	}
	/**
	 * logout the user
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 * 
	 */
	@RequestMapping("logout.wss")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		request.getSession().invalidate();
		mvObject.setView("app/loginPage.jsp");
		
		return mvObject;
	}
	/**
	 * Load the home page 
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 * 
	 */
	@RequestMapping("loadHome.wss")
	public ModelAndView loadHome(HttpServletRequest request, HttpServletResponse response)
	{
		
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		if(isAuthenticated(request, response))
		{
			//Check the type of user 
			if(isSupervisor(request))
			{
				List<OrderMain> listOfOrder=CSMDataServiceV2.getPrioritzedJobList();
				HttpSession session=request.getSession();  
			    session.setAttribute("listOfOrder",listOfOrder); 
				mvObject.addModel("listOfOrder", listOfOrder);
				mvObject.setView("app/home.jsp");
			}
			else
			{
				mvObject = new ModelAndView(ViewType.FORWARD_ACTION_VIEW);
				mvObject.setView("WorkerHomePage.wss");
			}
		}
		else
		{
			mvObject.addModel("loginError", "Invalid credentials");
			mvObject.setView("app/loginPage.jsp");
		}
		return mvObject;
	}
	
	/** check if the user is a supervisor
	 * @param request
	 * @return true if supervisor, false if worker
	 */
	private boolean isSupervisor(HttpServletRequest request)
	{
		EmployeeMaster emp = getLoggedInUser(request);
		if(emp!=null && "SUP".equalsIgnoreCase(emp.getWorkCenter()))
		{
			return true;
		}
		return false;
	}
	
	/** 
	 * Get the details of the logged in User
	 * @param request
	 * @return EmployeeMaster
	 */
	private EmployeeMaster getLoggedInUser(HttpServletRequest request)
	{
		CSMUser csmUser = (CSMUser)request.getSession().getAttribute(USER_OBJECT);
		if(csmUser!=null)
		{
			return csmUser.getEmpMaster();
		}
		return null;
	}
	/**Check if the User is Authenticated
	 * @param request
	 * @param response
	 * @return
	 */
	private boolean isAuthenticated(HttpServletRequest request, HttpServletResponse response)
	{
		if(request.getSession().getAttribute(USER_OBJECT)!=null)
		{
			return true;
		}
		else
		{
			//Try the authenticate the person
			String userId = request.getParameter("username");
			String password = request.getParameter("password");
			if(userId!=null && password!=null)
			{
				CSMUser loggedInUser = CSMDataServiceV2.authenticate(userId, password);
				if(loggedInUser!=null)
				{
					request.getSession().setAttribute(USER_OBJECT,loggedInUser);
					request.getSession().setAttribute("user_role", loggedInUser.getRole());
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Load the Analytics Page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("analytics.wss")
	public ModelAndView analytics(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/analytics.jsp");
		
		List<OrderMain> jobList = (List<OrderMain>) request.getSession().getAttribute("listOfOrder");
		if(jobList!=null)
		{
			int analyzedCount = 0;
			int wipCount = 0;
			int completeCount = 0;
			int refCout =0;
			
			for(OrderMain jobOrder: jobList)
			{
				if(ApplicationConstants.JOB_STATUS_ANALYZED.equalsIgnoreCase(jobOrder.getOrderStatus()))
				{
					analyzedCount++;
				}
				else if(ApplicationConstants.JOB_STAUS_WIP.equalsIgnoreCase(jobOrder.getOrderStatus()))
				{
					wipCount++;
				}
				else if(ApplicationConstants.JOB_STAUS_CLOSED.equalsIgnoreCase(jobOrder.getOrderStatus()))
				{
					completeCount ++;
				}
				else if(ApplicationConstants.JOB_STAUS_REFRRED.equalsIgnoreCase(jobOrder.getOrderStatus()))
				{
					refCout ++;
				}
				
			}
			mvObject.addModel("analyzed", analyzedCount);
			mvObject.addModel("notAnalyzed", jobList.size()-(analyzedCount+wipCount+completeCount+refCout));
			mvObject.addModel("wipCount", wipCount);
			mvObject.addModel("completeCount", completeCount);
			mvObject.addModel("refCout", refCout);
			mvObject.addModel("total",jobList.size());
		}
		else
		{
			mvObject.addModel("analyzed", 0);
			mvObject.addModel("notAnalyzed",0);
			mvObject.addModel("wipCount", 0);
			mvObject.addModel("completeCount", 0);
			mvObject.addModel("refCout", 0);
			mvObject.addModel("total",0);
		}
		return mvObject;
	}
	
	/**
	 * Load the Analyzed job details page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	
	@RequestMapping("analyse.wss")
	public ModelAndView analyse(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		String orderNumbers=request.getParameter("orderno");
				//getParameterValues();
		List<String> selectedId= new ArrayList<String>();
		selectedId.add(orderNumbers);
		/*for(String orderId:orderNumbers){
			selectedId.add(orderId);
		}*/
		
		HttpSession session=request.getSession(); 
		List<OrderMain> listOfOrder=(List<OrderMain>) session.getAttribute("listOfOrder");
		OrderMain orderElement=listOfOrder.get(listOfOrder.indexOf(new OrderMain(orderNumbers)));
		JobDetailsSupervisor jobDetails = CSMDataServiceV2.getJobtailsForSupervisor(orderNumbers);
		jobDetails = CSMDataServiceV2.loadAnalyticData(jobDetails,getLoggedInUser(request).getShiftGrouping());
		List<PRTMaster> partsList = jobDetails.getProposedToolsList();
		List<SparesMaster> sparesList = jobDetails.getProposedSparesList();
	    session.setAttribute("selectedId",selectedId);  
	    mvObject.addModel("orderElement",orderElement);
		mvObject.addModel("orderNumber",orderNumbers);
		mvObject.addModel("partsList", partsList);
		mvObject.addModel("sparesList", sparesList);
		mvObject.addModel("jobDetails",jobDetails);
		request.getSession().setAttribute("job_under_analysis", jobDetails);

		if(selectedId.size()==1){
			mvObject.addModel("skipWss", "loadHome.wss");
		}else{

			mvObject.addModel("skipWss", "skipPage.wss");
			
		}
		mvObject.setView("app/analysedResult.jsp");
		
		
		return mvObject;
	}
	
	/**
	 * Select the resource for the job
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("resourceUpdate.wss")
	public ModelAndView resourceUpdate(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		String[] employeeIdList=request.getParameterValues("employeeId");
		
		HttpSession session=request.getSession(); 
		List<OrderMain> listOfOrder=(List<OrderMain>) session.getAttribute("listOfOrder");
		List<String> selectedId=(List<String>) session.getAttribute("selectedId");
		JobDetailsSupervisor jobDetails = (JobDetailsSupervisor)request.getSession().getAttribute("job_under_analysis");
		OrderMain orderElement=jobDetails.getJobOrderDetails();
		
		List<PRTMaster> partsList = jobDetails.getProposedToolsList();
		List<SparesMaster> sparesList = jobDetails.getProposedSparesList();
		List<String> selectedEmpIdList =Arrays.asList(employeeIdList);		
		jobDetails.setSelectedEmployee(selectedEmpIdList);
		if(selectedId.size()==1){

			mvObject.addModel("updateWss", "loadHomeAfterUpdate.wss");
			mvObject.addModel("skipWss", "loadHome.wss");
		}else{

			mvObject.addModel("skipWss", "skipPage.wss");
			mvObject.addModel("updateWss", "updateOrder.wss");
		}
		 
	    mvObject.addModel("orderElement",orderElement);
		mvObject.addModel("orderNumber",selectedId.get(0));
		mvObject.addModel("partsList", partsList);
		mvObject.addModel("sparesList", sparesList);
		mvObject.addModel("jobDetails",jobDetails);
		mvObject.setView("app/resultAfterEmpSel.jsp");
		return mvObject;
	}
	/**
	 * Show the analyzed result for the next job
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("skipPage.wss")
	public ModelAndView submitPage(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		
		HttpSession session=request.getSession(); 
		List<OrderMain> listOfOrder=(List<OrderMain>) session.getAttribute("listOfOrder");
		List<String> selectedId=(List<String>) session.getAttribute("selectedId");
		selectedId.remove(0);
		
		 OrderMain orderElement=null;
		Iterator itr = listOfOrder.iterator();
	      while(itr.hasNext()) {
	    	  OrderMain element = (OrderMain) itr.next();
	    	  if(element.getOrderNumber().equals(selectedId.get(0))){
	    		  orderElement=element;
	    		  
	    	  }
	         
	         System.out.print(element.getOrderNumber());
	      }
	     // System.out.print(orderElement.getOrderNumber());
		
		List<PRTMaster> partsList = null;//CSMDataServices.getPartsListForJobOrder(selectedId.get(0));
		List<SparesMaster> sparesList = null;//CSMDataServices.getSparesForJobOrder(selectedId.get(0));
		List<EquipmentMaster> taskList = null;//CSMDataServices.getTaskList(selectedId.get(0));
		List<EmployeeMaster> empList = null;//CSMDataServices.getAvailableEmployee(selectedId.get(0));
		
		if(selectedId.size()==1){

			mvObject.addModel("updateWss", "loadHomeAfterSubmit.wss");
			mvObject.addModel("skipWss", "loadHome.wss");
		}else{

			mvObject.addModel("skipWss", "skipPage.wss");
			mvObject.addModel("updateWss", "updateOrder.wss");
		}
		
		
		 
	    session.setAttribute("selectedId",selectedId); 
	    mvObject.addModel("orderElement",orderElement);
		mvObject.addModel("orderNumber",selectedId.get(0));
		mvObject.addModel("partsList", partsList);
		mvObject.addModel("sparesList", sparesList);
		mvObject.addModel("taskList", taskList);
		mvObject.addModel("empList", empList);
		mvObject.setView("app/analysedResult.jsp");
		
		return mvObject;
	}
	/**
	 * Update the job status to analysed , and generate the requisition no 
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("updateOrder.wss")
	public ModelAndView updateOrder(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		
		
		
		HttpSession session=request.getSession(); 
		List<OrderMain> listOfOrder=(List<OrderMain>) session.getAttribute("listOfOrder");
		List<String> selectedId=(List<String>) session.getAttribute("selectedId");
		EmployeeMaster selectedEmp=(EmployeeMaster) session.getAttribute("selectedEmp");
		
		//null;//CSMDataServices.submitAnalyzedJobOrder(selectedId.get(0),selectedEmp);
		
		
		selectedId.remove(0);
		
		 OrderMain orderElement=null;
		Iterator itr = listOfOrder.iterator();
	      while(itr.hasNext()) {
	    	  OrderMain element = (OrderMain) itr.next();
	    	  if(element.getOrderNumber().equals(selectedId.get(0))){
	    		  orderElement=element;
	    		  //System.out.print("mileche");
	    	  }
	         
	        // System.out.print(element.getOrderNumber());
	      }
	     // System.out.print(orderElement.getOrderNumber());
		
		List<PRTMaster> partsList = null;//CSMDataServices.getPartsListForJobOrder(selectedId.get(0));
		List<SparesMaster> sparesList = null;//CSMDataServices.getSparesForJobOrder(selectedId.get(0));
		List<EquipmentMaster> taskList = null;//CSMDataServices.getTaskList(selectedId.get(0));
		List<EmployeeMaster> empList = null;//CSMDataServices.getAvailableEmployee(selectedId.get(0));
		
		if(selectedId.size()==1){

			mvObject.addModel("updateWss", "loadHome.wss");
			mvObject.addModel("skipWss", "loadHome.wss");
		}else{

			mvObject.addModel("skipWss", "skipPage.wss");
			mvObject.addModel("updateWss", "updateOrder.wss");
		}
		
		 
	    session.setAttribute("selectedId",selectedId); 
	    mvObject.addModel("orderElement",orderElement);
		mvObject.addModel("orderNumber",selectedId.get(0));
		mvObject.addModel("partsList", partsList);
		mvObject.addModel("sparesList", sparesList);
		mvObject.addModel("taskList", taskList);
		mvObject.addModel("empList", empList);
		mvObject.setView("app/analysedResult.jsp");
		
		return mvObject;
	}
	/**
	 * Load Home after analyzed the job
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("loadHomeAfterUpdate.wss")
	public ModelAndView loadHomeAfterUpdate(HttpServletRequest request, HttpServletResponse response)
	{
		
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		HttpSession session=request.getSession(); 
		JobDetailsSupervisor jobDetails = (JobDetailsSupervisor)session.getAttribute("job_under_analysis");
		CSMDataServiceV2.assignJobToWorker(jobDetails);
		List<OrderMain> listOfOrder=CSMDataServiceV2.getPrioritzedJobList();
		session.setAttribute("listOfOrder",listOfOrder); 
		mvObject.addModel("listOfOrder", listOfOrder);
		List<OrderRequisition> reqList = jobDetails.getRequisitions();
		if(reqList!=null )
		{
			Map<String,String> reqMap = new HashMap<>();
			for(OrderRequisition ordReq: reqList)
			{
				reqMap.put(ordReq.getReqNumber(),ordReq.getReqNumber());
			}
			mvObject.addModel("reqList", reqMap.keySet().toString());
		}
		
		mvObject.setView("app/home.jsp");
		return mvObject;
	}
	/**
	 * Load the Job Details page for a Analyzed Job
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("viewDetails.wss")
	public ModelAndView viewDetails(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mvObject = new ModelAndView(ViewType.JSP_VIEW);
		mvObject.setView("app/JobDetails.jsp");
		String jobId = request.getParameter("jobId");
		JobDetailsSupervisor jobDetails = CSMDataServiceV2.getJobtailsForSupervisor(jobId);
		jobDetails = CSMDataServiceV2.getAssignedResources(jobDetails);
	    mvObject.addModel("jobDetails",jobDetails);
		return mvObject;
	}
}
