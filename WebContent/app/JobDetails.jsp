<%@page import="com.ibm.app.csm.data.EmployeeMaster"%>
<%@page import="com.ibm.app.csm.data.SparesMaster"%>
<%@page import="com.ibm.app.csm.services.CSMDataServiceV2"%>
<%@page import="com.ibm.app.csm.data.PRTMaster"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	Map<String,PRTMaster> prtMap = CSMDataServiceV2.getPRTMaster();
	Map<String,SparesMaster> sparesMaster = CSMDataServiceV2.getSparesMaster();
	Map<String,EmployeeMaster> empMaster = CSMDataServiceV2.getEmployeeMaster();
	pageContext.setAttribute("prtMap", prtMap);
	pageContext.setAttribute("sparesMaster", sparesMaster);
	pageContext.setAttribute("empMaster", empMaster);
 %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Predictive Maintenance++</title>
	<link rel="stylesheet" href="themes/csm_theme.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.icons.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.structure-1.4.5.min.css" />
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
           <li><a href="analytics.wss" data-ajax="false" >Analytics</a></li>
           <li><a href="analytics.wss" data-ajax="false" >FAQ</a></li>
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
         	<h4>Job Details</h4>
     </div>
       <c:set var="orderElement" value="${jobDetails.jobOrderDetails }" />
       <div style="text-align: center"><b>Job Id :&nbsp;<c:out value="${orderElement.orderNumber}" /></b></div>
		 <div data-role="collapsibleset" data-filter="true" data-inset="true" id="collapsiblesetForFilter" data-input="#searchForCollapsibleSet">
		  <div data-role="collapsible"  data-iconpos="right" >
   			   <h2><img src="themes/images/Order-history-icon.png"  class="ui-li-icon ui-corner-none">&nbsp;&nbsp;Job Details </h2>
    			<ul data-role="listview" data-inset="true">
     				<li><b>Job Type :</b>&nbsp;<c:out value="${orderElement.orderType}" /></li>
 				     <li><b>Location :</b>&nbsp;<c:out value="${orderElement.plant}" /></li>
      				 <li><b>Equipment No :</b>&nbsp;<c:out value="${orderElement.equipmentNumber}" /></li>
      				 <li><b>Equipment Name :</b>&nbsp;<c:out value="${jobDetails.equipmentDetails.description}" /></li>
      				 <li><b>Problem Description :</b>&nbsp; <c:out value="${orderElement.description}" /></li>
      				 <li><b>Created On :</b>&nbsp; <c:out value="${orderElement.createdOn}" /></li>
      				 <li><b>To be completed by :</b>&nbsp; <c:out value="${orderElement.finishBy}" /></li>
    			</ul>


			</div>
       
	 <div data-role="collapsible"  data-iconpos="right" >
	 
      <h2><img src="themes/images/Male-icon.png"   class="ui-li-icon ui-corner-none">
      			<span style="display:inline-block;width:60%">Selected Resource</span>
      			&nbsp;&nbsp;&nbsp;&nbsp;<img src="themes/images/watson.png" width="26px" height="26px" ></h2>
    
    	
      <ul data-role="listview" data-inset="true">	
     	<c:forEach items="${jobDetails.selectedEmployee}" var="item">   
    	  	<li >
    	  		
    	  		<p><b><c:out value="${empMaster[item].employeeName}" />&nbsp;-&nbsp;(<c:out value="${empMaster[item].workCenter}" />)</b></p>
    	  	</li>
		</c:forEach>
		
     </ul> 

</div>
<div data-role="collapsible"  data-iconpos="right" >
     <h2><img src="themes/images/Utilities-Folder-icon.png"  class="ui-li-icon ui-corner-none">&nbsp;&nbsp;<span style="display:inline-block;width:60%">Proposed Tool List</span>&nbsp;&nbsp;&nbsp;&nbsp;<img src="themes/images/watson.png" width="26px" height="26px" ></h2>
     <h4>Requisition number: <c:out value="${jobDetails.requisitionNumbers['PARTS'] }" /></h4>
     <ul data-role="listview" data-inset="true">
     	<c:forEach items="${jobDetails.assignedPRTList}" var="item">   
    	  	<li >
    	  		<c:out value="${prtMap[item.prtNumber].description}" />
    	  		<p><b>Available :</b>&nbsp; <c:out value="Yes" /></p>
      			<p><b>Location :</b>&nbsp; <c:out value="${prtMap[item.prtNumber].plant}" /></p>
      			<p><b>Quantity required :</b>&nbsp; <c:out value="${item.qtyAssigned}" /></p>
    	  	</li>
		</c:forEach>
    </ul>


</div>
<div data-role="collapsible"  data-iconpos="right" >
    <h2><img  src="themes/images/2-Utilities-icon.png"   class="ui-li-icon ui-corner-none">&nbsp;&nbsp;<span style="display:inline-block;width:60%">Proposed Spare List</span>&nbsp;&nbsp;&nbsp;&nbsp;<img src="themes/images/watson.png" width="26px" height="26px" ></h2>
	<h4>Requisition number: <c:out value="${jobDetails.requisitionNumbers['SPARES'] }" /></h4>
	<ul data-role="listview" data-inset="true">
     	<c:forEach items="${jobDetails.assignedSparesList}" var="item">   
    	  	<li >
    	  		<c:out value="${sparesMaster[item.materialNumber].description}" />
    	  		<p><b>Available :</b>&nbsp; <c:out value="Yes" /></p>
      			<p><b>Location :</b>&nbsp; <c:out value="${sparesMaster[item.materialNumber].plant}" /></p>
      			<p><b>Quantity required :</b>&nbsp; <c:out value="${item.requiredQty}" /></p>
    	  	</li>
		</c:forEach>
    </ul>

</div>
<div data-role="collapsible"  data-iconpos="right">
      <h2><img src="themes/images/write-document-icon.png"  class="ui-li-icon ui-corner-none">&nbsp;&nbsp;Task List</h2>
    
    <ul data-role="listview" data-inset="true">
     	<c:forEach items="${jobDetails.operationsList}" var="item">   
    	  	<li >
    	  		<c:out value="${item.operationShortText}" />
      			<p><b>Location :</b>&nbsp; <c:out value="${ item.deptId}" /></p>
      			<p><b>Document :</b>&nbsp;<a href="./pdf/relocation.pdf" data-ajax="false" download="${ item.taskManual}.pdf"><c:out value="${ item.taskManual}" /></a></p>
    	  	</li>
		</c:forEach>
    </ul>

</div>

    </div>
    <a href="#" data-rel="back" ><button class="ui-btn ui-corner-all ui-btn-a">Go Back</button></a>
	        
	        <!-- <div class="ui-grid-b">
      <div class="ui-block-a">
      <p></p></div>
      <div class="ui-block-b" style="text-align:center">
       <button type="submit" class="ui-btn ui-corner-all ui-btn-a">Submit</button>
      </div>
      <div class="ui-block-c">
      <p></p>
      </div>
    </div> -->
       
       
    

  <div data-role="footer"> 
		<h4>&nbsp;</h4> 
</div> 
        
		
    </div>    
</div>
</body>
</html>