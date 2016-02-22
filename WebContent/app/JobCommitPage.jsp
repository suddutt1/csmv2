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
          <form action="updateJob.wss" data-ajax="false" >  
          		<div class="ui-corner-all custom-corners" id="123dl">
				  <div class="ui-bar ui-bar-a">
				    <h3>Check Used Tools</h3>
				  </div>
				  <div class="ui-body ui-body-a">
				    <ul data-role="listview" data-inset="true">
		          		<c:forEach items="${jobDetails.toolsList}" var="item"  varStatus="countVar">
			          		 <li>			
								 
								 <b>	Part No :</b> ${item.prtNumber}<br/>
								 <b>Description:</b>${partMaster[item.prtNumber].description}
								 
							<div class="ui-grid-b" id='endTime'>
							    <div class="ui-block-a">Assigned Qty</div>
							    <div class="ui-block-b">Qty Used</div>
							    <div class="ui-block-c">Actual Usage Time</div>
							    <div class="ui-block-a"><input type="number" required name="assQty" value="${item.qtyAssigned}" placeholder="MM" readonly="readonly"></div>
							    <div class="ui-block-b"><input type="number" required name="${item.prtNumber}" value="${item.qtyAssigned}" placeholder="0" min="0"></div>
							    <div class="ui-block-c"><input type="number" required name="usage_${item.prtNumber}" placeholder="MM" min="0"></div>
							    
							</div>
						</li>
						</c:forEach>
						   <li> 	
						 <label for="otherSpares">Other Tool used :</label>
        				<input type="text" name="otherSpares" id="otherSpares"  placeholder="Other Tools Used"> 
        				</li>
					</ul>
				  </div>
				</div>
				
				<div class="ui-corner-all custom-corners" id="123">
				  <div class="ui-bar ui-bar-a">
				    <h3>Check Used Spares</h3>
				  </div>
				  <div class="ui-body ui-body-a">
				    <ul data-role="listview" data-inset="true">
		          		<c:forEach items="${jobDetails.sparesList}" var="item"  varStatus="countVar">
			          		 <li>			
								 
								 <b>	Part No :</b> ${item.materialNumber}<br/>
								 <b>Description:</b>${spareMaster[item.materialNumber].description}
								 
							<div class="ui-grid-b" id='endTime'>
							    <div class="ui-block-a">Assigned Qty</div>
							    <div class="ui-block-b">Qty Used</div>
							    <div class="ui-block-c">Qty to return</div>
							    <div class="ui-block-a"><input type="number" required name="assQty" value="${item.requiredQty}" placeholder="0" readonly></div>
							    <div class="ui-block-b"><input type="number" required name="${item.materialNumber}" value="${item.requiredQty}" placeholder="MM" min="0" ></div>
							    <div class="ui-block-c"><input type="number" required name="return_${item.materialNumber}" placeholder="0" min="0"  max="${item.requiredQty}"  ></div>
							    
							</div>
						</li>
						</c:forEach>
						   <li> 	
						 <label for="otherSpares">Other Spares used :</label>
        				<input type="text" name="otherSpares" id="otherSpares"  placeholder="Other Spares Used"> 
        				</li>
					</ul>
				  </div>
				</div>	
				
				    
				
      			 
				<button type="submit"  class="ui-btn ui-corner-all ui-btn-a">Update</button>	 
		      
			</form> 
    </div>    
    </div>
  <div data-role="footer"> 
		<h4>&nbsp;</h4> 
</div> 
        
		
     


</body>
</html>