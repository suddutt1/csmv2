<%@page import="com.ibm.app.csm.services.CSMDataServiceV2"%>
<%@page import="com.ibm.app.csm.data.Problem"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	
	Map<String,Problem> probMaster = CSMDataServiceV2.getProblemMaster();
	pageContext.setAttribute("probMaster", probMaster);
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
</head>
<body>
	<div data-role="page"  data-theme="a">
	<div data-role="panel" id="myPanel">
	<ul data-role="listview" data-inset="true" data-shadow="false">
	 		<li data-icon="false"><a href="#">Welcome<br/><c:out value="${sessionScope.CSM_USER.empMaster.employeeName }" /></a></li>
	 		
	</ul>
	<ul data-role="listview" data-inset="true" data-shadow="false">
	       <li><a href="loadHome.wss" >Job Listing </a></li>
	           <li><a href="analytics.wss" data-ajax="false">Analytics</a></li>
	           <li><a href="analytics.wss" data-ajax="false">FAQ</a></li>
	         <li data-icon="power"> <a href="logout.wss"   >Logout</a></li>
	 </ul>
	 
	 
 </div>
    <div data-role="header" data-position="fixed">
         <a href="#myPanel" class="ui-btn ui-icon-bars ui-btn-icon-notext ui-corner-all">No text</a>
         <h2 style="font-size: 1.1em;color:#ffffff;">Global Mining Corp</h2>
        <a href="loadHome.wss" class="ui-btn ui-icon-home ui-btn-icon-notext ui-corner-all"  >No Text</a>
    </div>
    <div data-role="content">
    	<c:if test="${reqList !=null }" >
    			<script>
    			alert("Requistions created : ${reqList}");
    			</script>
    		
    	</c:if>
        <div id="banner" style="text-align: center;">
             <img src="themes/images/bulb.png" width="50px" height="75px" />
        </div>
       <span style="font-size: 125%"> <p>  Analyse Job & Assign Resource </p></span>
	<form action="analyse.wss" data-ajax="false">
		 
		 <div data-role="collapsibleset" data-filter="true" data-inset="true" id="collapsiblesetForFilter" data-input="#searchForCollapsibleSet">
		 	<div data-role="collapsible" data-collapsed-icon="info" data-expanded-icon="info" data-iconpos="right" >
      			<h2 >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Job Id &nbsp;&nbsp;&nbsp;&nbsp;Priority&nbsp; &nbsp;Sequence &nbsp;</h2>
			</div>

          <c:forEach items="${listOfOrder}" var="item"  varStatus="countVar">
			 <div data-role="collapsible" data-collapsed-icon="carat-d" data-expanded-icon="carat-u" data-iconpos="right" >
			 		<c:set var="stk" value="button-round-cancel-icon.png"/>
      			<c:if test="${item.orderType =='BREK' }" >
      				<c:set var="stk" value="error-icon.png"/>
      				<c:set var="colorValue" value="red" />
      			</c:if>
      			<c:if test="${item.orderType =='PREV' }" >
      				<c:set var="stk" value="App-error-icon.png"/>
      				<c:set var="colorValue" value="#FFBF00" />
      			</c:if>
      			<c:if test="${item.orderType =='PRED' }" >
      				<c:set var="stk" value="button-round-cancel-icon.png"/>
      				<c:set var="colorValue" value="#0047AB" />
      			</c:if>
      			
      			<h2><img src="themes/images/${stk}" class="ui-li-icon ui-corner-none" /><span style="color:<c:out value="${colorValue}" />">${item.orderNumber}&nbsp;&nbsp;&nbsp;Pty: &nbsp;${item.priority} &nbsp;&nbsp;Seq: &nbsp;${countVar.index+1}</span></h2>
    				 <c:set var="probKey" value="${item.problem}_${item.catalogProfile}" />
    				 <p><b>Job Type :</b>&nbsp;<c:out value="${item.orderType}" /></p>
 				     <p><b>Location :</b>&nbsp;<c:out value="${item.plant}" /></p>
      				 <p><b>Equipment No :</b>&nbsp;<c:out value="${item.equipmentNumber}" /></p>
      				 <p><b>Equipment Name :</b>&nbsp;<c:out value="${item.displayEquipmentName}" /></p>
      				 <p><b>Problem Description :</b>&nbsp;<c:out value="${item.description}" /></p>
      				 <p><b>Loss per hour($) :</b>&nbsp;<fmt:formatNumber pattern="#.00" value="${item.displayRatePerHours}"/></p>
      				 <p><b>Created On :</b>&nbsp; <c:out value="${item.createdOn}" /></p>
      				 <p><b>To be completed by :</b>&nbsp; <c:out value="${item.finishBy}" /></p>
	  		       	 <p><b>Order Status :</b>&nbsp; <c:out value="${item.orderStatus}" /></p>
      				 
				<c:if test="${item.orderStatus != 'ANZ' }">
				<div class="ui-checkbox">
				<label>
       					 <input name="orderno" value="${item.orderNumber}" id="radio-choice-0${countVar.index+1}" type="radio" required>Select Job
   				 </label>
				
    			</div>
				</c:if>
				<c:if test="${item.orderStatus =='ANZ' }">
					<a href="viewDetails.wss?jobId=${item.orderNumber}"  data-ajax="false" ><button type="button" class="ui-btn ui-corner-all ui-btn-a">View</button></a> 
				</c:if>
				
			</div>	
		</c:forEach> 
	
	    </div>
	        
            <fieldset class="ui-grid-a">
                    <div class="ui-block-b"><a href="loadHome.wss"  data-ajax="false" ><button type="button" class="ui-btn ui-corner-all ui-btn-a">Reset</button></a></div>
                    <div class="ui-block-b"><button type="submit" class="ui-btn ui-corner-all ui-btn-a" onclick="checkJob();">Analyse</button></div>
            </fieldset>
       
   
	</form>
    </div> 
    <div data-role="footer"> 
	<h4>&nbsp;</h4> 
	</div>    
</div>
<script>
function checkJob()
{
	if (!$("input:radio[name=orderno]").is(":checked"))
	{
		alert("Please select a job to proceed");
	}
}
</script>
</body>
</html>