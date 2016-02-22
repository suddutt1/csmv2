package com.ibm.app.csm.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ibm.app.csm.domain.model.JobDetailsSupervisor;
import com.ibm.app.csm.domain.model.JobDetailsWorker;
import com.ibm.app.csm.services.CSMDataServiceV2;

public class CSMDataServiceV2Test {

	@Test
	public void testGetJobtailsForSupervisor() {
		//JobDetailsSupervisor jobOrder = CSMDataServiceV2.getJobtailsForSupervisor("10000118");
		//assertNotNull(jobOrder);
		//assertNotNull(jobOrder.getJobOrderDetails());
		//assertNotNull(jobOrder.);
		//assertNotNull(jobOrder);
	}

	@Test
	public void testLoadAnalyticData() {
		//JobDetailsSupervisor jobOrder = CSMDataServiceV2.getJobtailsForSupervisor("10000118");
		//assertNotNull(jobOrder);
		//jobOrder = CSMDataServiceV2.loadAnalyticData(jobOrder) ;
	}
	@Test
	public void testAssignJobToWorker()
	{
		JobDetailsSupervisor jobOrder = CSMDataServiceV2.getJobtailsForSupervisor("10089425");
		assertNotNull(jobOrder);
		jobOrder = CSMDataServiceV2.loadAnalyticData(jobOrder,"A") ;
		assertNotNull(jobOrder);
		List<String> empList = Arrays.asList(new String[]{"470007","03446G"});
		jobOrder.setSelectedEmployee(empList);
		CSMDataServiceV2.assignJobToWorker(jobOrder);
	}
	@Test
	public void testGetAssignedJobList()
	{
		//List<JobDetailsWorker> jobList =  CSMDataServiceV2.getAssignedJobList("470007");
		//assertNotNull(jobList);
		//System.out.println(jobList.toString());
	}

}
