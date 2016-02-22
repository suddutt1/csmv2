
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
         	<h4>Job Details</h4>
     </div>
       
       <div style="text-align: center"><b>Job Id :&nbsp;<c:out value="${jobDetails.jobOrderDetails.equipmentNumber}" /></b></div>

		 <div data-role="collapsibleset" data-filter="true" data-inset="true" id="collapsiblesetForFilter" data-input="#searchForCollapsibleSet">
			  <div data-role="collapsible"  data-iconpos="right" >
	   			   <h2><img src="themes/images/Order-history-icon.png"  class="ui-li-icon ui-corner-none">&nbsp;&nbsp;Job Details </h2>
	    			<ul data-role="listview" data-inset="true">
	     			 <li><b>Job Type :</b>&nbsp;<c:out value="${jobDetails.jobOrderDetails.orderType}" /></li>
 				     <li><b>Location :</b>&nbsp;<c:out value="${jobDetails.jobOrderDetails.plant}" /></li>
      				 <li><b>Equipment No :</b>&nbsp;<c:out value="${jobDetails.jobOrderDetails.equipmentNumber}" /></li>
      				 <li><b>Problem Id :</b>&nbsp;<c:out value="${jobDetails.jobOrderDetails.problem}" /></li>
      				 <li><b>Problem Description :</b>&nbsp;<c:out value="${jobDetails.jobOrderDetails.description}" /></li>
      				 <li><b>Loss per hour($) :</b>&nbsp;<fmt:formatNumber pattern="#.00" value="${jobDetails.jobOrderDetails.displayRatePerHours}"/></li>
      				 <li><b>Created On :</b>&nbsp; <c:out value="${jobDetails.jobOrderDetails.createdOn}" /></li>
      				 <li><b>To be completed by :</b>&nbsp; <c:out value="${jobDetails.jobOrderDetails.finishBy}" /></li>
	  		       	 <li><b>Order Status :</b>&nbsp; <c:out value="${jobDetails.jobOrderDetails.orderStatus}" /></li>
	    			</ul>
				</div>
				<div data-role="collapsible"  data-iconpos="right" >
				     <h2><img src="themes/images/Utilities-Folder-icon.png"  class="ui-li-icon ui-corner-none">&nbsp;&nbsp;Proposed Tools List</h2>
				    <c:if test="${toolsStatus!= 'toolsCollected' }">
							 <div>
							  	 <form action="viewTools.wss" data-ajax="false">
									<button type="submit" class="ui-btn ui-corner-all ui-btn-a">Collect the tools</button>   
								  </form>  
							 </div>
					</c:if>
				<c:if test="${toolsStatus =='toolsCollected' }">
					<ul data-role="listview" data-inset="true">
				     	<c:forEach items="${jobDetails.toolsList}" var="item">   
				    	  	<li >
				    	  		<h2>Parts No : ${item.prtNumber}</h2>
			    				 <p><b>Part Type :</b>&nbsp;<c:out value="${item.prtType}" /></p>
			 				     <p><b>Quantity Asssigned:</b>&nbsp;<c:out value="${item.qtyAssigned}" /></p>
			      				 <p><b>Description:</b>&nbsp;<c:out value=" ${partMaster[item.prtNumber].description }" /></p>
			      				 <p><b>Location:</b>&nbsp;<c:out value=" ${partMaster[item.prtNumber].storageLocation }" /></p>
			      				 <p><b>Plant:</b>&nbsp;<c:out value=" ${partMaster[item.prtNumber].plant}" /></p>
				    	  	</li>
						</c:forEach>
				    </ul>
				</c:if>
					  
				    
				
				</div>
				<div data-role="collapsible"  data-iconpos="right" >
				     <h2><img  src="themes/images/2-Utilities-icon.png"   class="ui-li-icon ui-corner-none">&nbsp;&nbsp;<span style="display:inline-block;width:60%">Proposed Spares List</span></h2>
				     <c:if test="${sparesStatus!= 'sparesCollected' }">
						  <div>
						    
								  <form action="viewSpares.wss" data-ajax="false">
									<button type="submit" class="ui-btn ui-corner-all ui-btn-a">Collect the Spares</button>   
								  </form> 
						       
					      </div>
					</c:if>
				<c:if test="${sparesStatus =='sparesCollected' }">
					<ul data-role="listview" data-inset="true">
				     	<c:forEach items="${jobDetails.sparesList}" var="item">   
				    	  	<li >
				    	  		<h2>Material No : ${item.materialNumber}</h2>  				
			    				 <p><b>Plant :</b>&nbsp;<c:out value="${item.plant}" /></p>
			 				     <p><b>Storage Location:</b>&nbsp;<c:out value="${item.storageLocation}" /></p>
			      				 <p><b>Description:</b>&nbsp;<c:out value=" ${sparesMaster[item.materialNumber].description }" /></p>
			      				<p><b>Plant:</b>&nbsp;<c:out value=" ${sparesMaster[item.materialNumber].plant}" /></p>
				    	  
				    	  	</li>
						</c:forEach>
				    </ul>
				</c:if>
				     
					
				
				</div>
				<div data-role="collapsible"  data-iconpos="right">
				      <h2><img src="themes/images/write-document-icon.png"  class="ui-li-icon ui-corner-none">&nbsp;&nbsp;Operations</h2>
				     <div>
				     <ul data-role="listview" data-inset="true">
				     	<c:forEach items="${jobDetails.operations}" var="operationItem" varStatus="countVar"> 
						   <li> <a href="viewTask.wss?operationNumber=${operationItem.operationNumber}&operationSerialNo=${countVar.index}" data-ajax="false" ><c:out value="${operationItem.operationNumber}" /> : <c:out value="${opetationMaster[operationItem.operationNumber].operationShortText }" /></a></li>
					   	</c:forEach>
					</ul>
				     
				      </div>
				
				</div>

    </div>
   		 <form action="WorkerHomePage.wss" data-ajax="false">
			<button type="submit" class="ui-btn ui-corner-all ui-btn-a">Go Back</button>   
		</form> 
    	        
  <div data-role="footer"> 
		<h4>&nbsp;</h4> 
</div> 
        
		
    </div>    
</div>
</body>
</html>