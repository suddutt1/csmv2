<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Map"%>
<%@page import="com.ibm.app.csm.data.PRTMaster"%>
<%@page import="com.ibm.app.csm.services.CSMDataServiceV2"%>
<%
	 Map<String, PRTMaster>  partMaster = CSMDataServiceV2.getPRTMaster();
	pageContext.setAttribute("partMaster", partMaster);
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
         	<h4>Tool Details</h4>
     </div>
       
       <div style="text-align: center"><b>Job Id :&nbsp;<c:out value="${jobDetails.jobOrderDetails.orderNumber}" /></b></div>
          <form action="updateToolCollction.wss"> 
				 
			<fieldset data-role="controlgroup">
          		<c:forEach items="${requisitionList}" var="item"  varStatus="countVar">
	          		<c:if test="${item.reqType=='PARTS'}" >   			
						 <label for="tool_${countVar.index}">
						  	Requisition No : ${item.reqNumber}<br/>
						 	Tool Id : ${item.refDataId}<br/>
						 	Quantity : ${item.qtyAssigned}<br/>
						 	Description:${partMaster[item.refDataId].description }<br>
						 	Location:${partMaster[item.refDataId].storageLocation }
						 </label>
			          	<input type="checkbox" name="toolNo" id="tool_${countVar.index}" value="${item.refDataId}">
			        </c:if>
				</c:forEach> 	
			</fieldset>
		      
			     <fieldset class="ui-grid-a">
		                    <div class="ui-block-a"><a href="#" data-rel="back" ><button class="ui-btn ui-corner-all ui-btn-a">Back</button></a></div>
		                    <div class="ui-block-b"><button type="submit" class="ui-btn ui-corner-all ui-btn-a">Received All</button></div>
		          </fieldset>
			</form>
    </div>    
    <div data-role="footer"> 
	        
	       
       
       
    

  <div data-role="footer"> 
		<h4>&nbsp;</h4> 
</div> 
        
		
    </div>    
</div>
</body>
</html>