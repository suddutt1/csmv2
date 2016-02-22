<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Map"%>
<%@page import="com.ibm.app.csm.data.Operations"%>
<%@page import="com.ibm.app.csm.data.PRTMaster"%>
<%@page import="com.ibm.app.csm.data.SparesMaster"%>
<%@page import="com.ibm.app.csm.services.CSMDataServiceV2"%>
<%

	Map<String,Operations> opetationMaster = CSMDataServiceV2.getOperationsMaster();
	pageContext.setAttribute("opetationMaster", opetationMaster);
	 Map<String, PRTMaster>  partMaster = CSMDataServiceV2.getPRTMaster();
	pageContext.setAttribute("partMaster", partMaster);
	Map<String, SparesMaster> sparesMaster = CSMDataServiceV2.getSparesMaster();
	pageContext.setAttribute("sparesMaster",sparesMaster);
%>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Predictive Maintenance++</title>
	<link rel="stylesheet" href="themes/csm_theme.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.icons.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.structure-1.4.5.min.css" />
	<!-- <script src="themes/jqm-spinbox.js"></script> -->
	<script type="text/javascript" src="http://dev.jtsage.com/cdn/spinbox/latest/jqm-spinbox.min.js"></script>
	<script src="themes/jquery.min.js"></script>
	<script src="themes/jquery.mobile-1.4.5.min.js"></script>
	
	
	
	<script type="text/javascript">
$(document).bind("mobileinit", function () {
    $.mobile.ajaxEnabled = false;
});
</script>
</head>
<body>
	<div data-role="page"  data-theme="a">
	<div data-role="panel" id="myPanel">
	<ul data-role="listview" data-inset="true" data-shadow="false">
	 		<li data-icon="false"><a href="#">Welcome<br/><c:out value="${sessionScope.CSM_USER.empMaster.employeeName }" /></a></li>
	</ul>	
	<ul data-role="listview" data-inset="true" data-shadow="false">
       <li><a href="loadHome.wss" >Job Listing </a></li>
           <li data-icon="power"> <a href="logout.wss"   >Logout</a></li>
 	</ul>
 	</div>
    <div data-role="header" data-position="fixed">
         <a href="#myPanel" class="ui-btn ui-icon-bars ui-btn-icon-notext ui-corner-all">No text</a>
         
         <h2 style="font-size: 1.1em;color:#ffffff">Global Mining Corp</h2>
        <a href="loadHome.wss" class="ui-btn ui-icon-home ui-btn-icon-notext ui-corner-all"  >No Text</a>
    </div>
    <div data-role="content">
     <div id="banner" style="text-align: center">
        	<img src="themes/images/bulb.png" width="50px" height="75px" />
         	<h4>Operation Confirmation</h4>
     </div>
       
      <div style="text-align: center"><b>Job Id :&nbsp;<c:out value="${jobDetails.jobOrderDetails.orderNumber}" /></b></div>
        <div style="text-align: center"><b>PRB - <c:out value="${jobDetails.jobOrderDetails.problem}" />&nbsp;:&nbsp;<c:out value="${jobDetails.jobOrderDetails.description}" /></b></div>
         <div style="text-align: center"><b>OPR - <c:out value="${currentOperation.operationNumber}" />&nbsp;:&nbsp;<c:out value="${opetationMaster[currentOperation.operationNumber].operationShortText }" /></b></div>  
          <br/>
          <form action="updateTask.wss" name="updateTask" data-ajax="false" >  
          		
				 <b>Start Date and Time :</b>
				<div class="ui-grid-d" id="startTime">
				    <div class="ui-block-a"><input type="number" required name="startDate" placeholder="DD" min="1" max="31"></div>
				    <div class="ui-block-b"><input type="number" required name="startMonth" placeholder="MM" min="1" max="12"></div>
				    <div class="ui-block-c"><input type="number" required name="startYr" placeholder="YY" min="13" max="20"></div>
				    <div class="ui-block-d"><input type="number" required name="startHour" placeholder="HH" min="1" max="24"></div>
				    <div class="ui-block-e"><input type="number" required name="startMinute" placeholder="MM" min="1" max="59"></div>
				</div>
				 <b>End Date and Time:</b>
				<div class="ui-grid-d" id='endTime'>
				    <div class="ui-block-a"><input type="number" required name="endDate" placeholder="DD" min="1" max="31"></div>
				    <div class="ui-block-b"><input type="number" required name="endMonth" placeholder="MM" min="1" max="12"></div>
				    <div class="ui-block-c"><input type="number" required name="endYr" placeholder="YY" min="13" max="20"></div>
				    <div class="ui-block-d"><input type="number" required name="endHour" placeholder="HH" min="1" max="24"></div>
				    <div class="ui-block-e"><input type="number" required name="endMinute" placeholder="MM" min="1" max="59"></div>
				</div>
				<b>Actual Hour : </b>
				<div class="ui-grid-a" id='endTime'>
			
				    <div class="ui-block-a"><input type="number" required name="actualHour" placeholder="HH" min="1" ></div>
				    <div class="ui-block-b"><input type="number" required name="actualMinute" placeholder="MM" min="1" max="59"></div>
				    
				</div>
				
				<div class="ui-grid-a" id='button'>			
				    <div class="ui-block-a"><button type="button" class="ui-btn ui-corner-all ui-btn-a" id="backTo">Go Back</button></div>
				    <div class="ui-block-b"><button type="submit"  class="ui-btn ui-corner-all ui-btn-a">Update</button></div>
				    
				</div>     
			</form> 
    </div>    
    <div data-role="footer"> 
	        
	       
       
       
    

  <div data-role="footer"> 
		<h4>&nbsp;</h4> 
</div> 
        
		
    </div>    
</div>
<form action="viewTask.wss" name="backTo" data-ajax="false">
</form>

<script   language="Javascript">

$("#backTo").click(function(){
			var systemSearchFrm = document.forms["backTo"];
			systemSearchFrm.submit();
			
		
});
</script>
</body>
</html>