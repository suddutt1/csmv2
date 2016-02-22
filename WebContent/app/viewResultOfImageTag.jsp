<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>|
<%@page import="java.util.Map"%>

<%@page import="com.ibm.app.csm.data.Operations"%>
<%@page import="com.ibm.app.csm.services.CSMDataServiceV2"%>
<%
	Map<String,Operations> opetationMaster = CSMDataServiceV2.getOperationsMaster();
	pageContext.setAttribute("opetationMaster", opetationMaster);
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
	$(document).ready(function() {  
document.getElementById("ItemPreview").src = "data:image/jpeg;base64," + ${uploadedImage};  
});
	
$(document).bind("mobileinit", function () {
    $.mobile.ajaxEnabled = false;
});
</script>
</head>
<body>
	<div data-role="page"  data-theme="a">
	<div data-role="panel" id="myPanel">
	<ul data-role="listview" data-inset="true" data-shadow="false">
		<li data-icon="false"><a href="#">Welcome<br/><c:out value="${sessionScope.CSM_USER.empMaster.employeeName }" /></a></li>	</ul>	
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
         	<h4>Image Tag Result</h4>
     </div>
       
      <div style="text-align: center"><b>Job Id :&nbsp;<c:out value="${jobDetails.jobOrderDetails.orderNumber}" /></b></div>
        <div style="text-align: center"><b>PRB - <c:out value="${jobDetails.jobOrderDetails.problem}" />&nbsp;:&nbsp;<c:out value="${jobDetails.jobOrderDetails.description}" /></b></div>
         <div style="text-align: center"><b>OPR - <c:out value="${currentOperation.operationNumber}" />&nbsp;:&nbsp;<c:out value="${opetationMaster[currentOperation.operationNumber].operationShortText }" /></b></div>  	 
				<br/>
	<form action="viewTaskHelp.wss" method="POST"  data-ajax="false">
				<div class="ui-corner-all custom-corners" id="123">
				  <div class="ui-bar ui-bar-a">
				    <h3 style="color:black;">Visual Analytic Result </h3>
				  </div>
				  <div class="ui-body ui-body-a">
				  <img id="ItemPreview" src='data:image/jpeg;base64,${uploadedImage}'  style="height: 120px; width :120px"/>
				   <div style="height: 120px;
    overflow-y: scroll;">
				
				<b>Analytics Output</b>
					<fieldset data-role="controlgroup">
							<c:forEach var="entry" items="${mapOfSolutions }" varStatus="countVar"> 
									<input type="radio" name="employeeId" required id="radio_${countVar.index}" value="${entry.key}"  />
					                <label for="radio_${countVar.index}">${entry.key }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Score :&nbsp; ${entry.value }%</label>
							</c:forEach>
					</fieldset>	
				  </div>  
				  </div>
				</div>
				<br/> 
		
		   <fieldset class="ui-grid-a">
                    <div class="ui-block-a"><button class="ui-btn ui-corner-all ui-btn-a" id="backTo">Go Back</button></div>
                    <div class="ui-block-b"><button type="submit" class="ui-btn ui-corner-all ui-btn-a" id="sentMail">Sent the Mail</button></div>
          </fieldset> 
         </form>
			
    </div>    
 
	        
	       
       
       
    

  <div data-role="footer"> 
		<h4>&nbsp;</h4> 
</div> 
         
</div>
<form action="viewTaskHelp.wss" name="backTo" data-ajax="false" >
</form>

<script   language="Javascript">
$("#sentMail").click(function(){
var date = Math.random()*10000;
alert("Purchase requisition number PRN"+date+" generated");
			
		
});
$("#backTo").click(function(){
			var systemSearchFrm = document.forms["backTo"];
			systemSearchFrm.submit();
			
		
});
</script>
</body>
</html>