package com.ibm.app.csm.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.app.csm.data.EmployeeMaster;
import com.ibm.app.csm.domain.model.JobDetailsSupervisor;
import com.ibm.app.csm.helper.ChartMaker;
import com.ibm.app.web.frmwk.WebActionHandler;
import com.ibm.app.web.frmwk.annotations.RequestMapping;
import com.ibm.app.web.frmwk.bean.ModelAndView;
import com.ibm.app.web.frmwk.bean.ViewType;

/**
 * Action class for Watson Trade Off  Analytics Api  . 
 * 
 * @author Raju Parashar , Sudip dutta
 * 
 * 
 */
public class GenChartAction implements WebActionHandler {
	
	private static Logger LOGGER = Logger.getLogger(GenChartAction.class.getName());
	
	/**
	 * Load the Resource Selection page
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ModelAndView ( JSP VIEW)
	 */
	@RequestMapping("genChart.wss")
	public ModelAndView getChart(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mvObject =new ModelAndView(ViewType.JSP_VIEW);
		try{
		JobDetailsSupervisor jobDetails = (JobDetailsSupervisor)request.getSession().getAttribute("job_under_analysis");
		
		List<EmployeeMaster> empList=jobDetails.getProposedEmpList();
		java.util.Collections.sort(empList, new Comparator<EmployeeMaster>() {

			@Override
			public int compare(EmployeeMaster o1, EmployeeMaster o2) {
				// TODO Auto-generated method stub
				return (int)(o2.getScore()-o1.getScore());
			}
		});
		
	    
	    StringBuilder strBldrs  = new StringBuilder();
	    Map<String,List<EmployeeMaster>> deptMap = groupEmployees(empList);
	    strBldrs.append("{");
	    for(String key:deptMap.keySet())
	    {
	    	ChartMaker chartMaker=new ChartMaker();
	    	chartMaker.setEmployeeMasterList(deptMap.get(key));
	    	strBldrs.append(" \""+key+"\" :").append(chartMaker.toJson()).append(",");
	    }
	    strBldrs.append("}");
	    mvObject.addModel("dataInJon",strBldrs.toString());
		mvObject.addModel("empList", empList);
	    mvObject.setView("app/chart1.jsp");
		
		}catch(Exception ex)
		{
			LOGGER.log(Level.WARNING,"Error in generating charts",ex);
		}
		return mvObject;
	}
	
	private Map<String,List<EmployeeMaster>> groupEmployees(List<EmployeeMaster> emplIst)
	{
		Map<String,List<EmployeeMaster>> map = new LinkedHashMap<String, List<EmployeeMaster>>();
		for(EmployeeMaster empMaster : emplIst)
		{
			List<EmployeeMaster> deptList = map.get(empMaster.getWorkCenter());
			if(deptList==null)
			{
				deptList = new ArrayList<>();
				map.put(empMaster.getWorkCenter(), deptList);
			}
			deptList.add(empMaster);
		}
		return map;
	}
}
