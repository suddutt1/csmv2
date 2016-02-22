<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map"%>
<%@page import="com.ibm.app.csm.data.Operations"%>
<%@page import="com.ibm.app.csm.services.CSMDataServiceV2"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
         	<h4>Task Details</h4>
     </div>
       
       <div style="text-align: center"><b>Job Id :&nbsp;<c:out value="${jobDetails.jobOrderDetails.orderNumber}" /></b></div>
        <div style="text-align: center"><b>PRB - <c:out value="${jobDetails.jobOrderDetails.problem}" />&nbsp;:&nbsp;<c:out value="${jobDetails.jobOrderDetails.description}" /></b></div>
         <div style="text-align: center"><b>OPR - <c:out value="${currentOperation.operationNumber}" />&nbsp;:&nbsp;<c:out value="${opetationMaster[currentOperation.operationNumber].operationShortText }" /></b></div>  
          
          
          		<a href="./pdf/${opetationMaster[currentOperation.operationNumber].taskManual}" data-ajax="false" download="${opetationMaster[currentOperation.operationNumber].taskManual}"><button><c:out value="${opetationMaster[currentOperation.operationNumber].taskManual}" /></button></a>
				 <div class="ui-corner-all custom-corners" id="123">
				  <div class="ui-bar ui-bar-a" style="background-color: #993366; ">
				    <h2 style="font-size: 1.3em"> Listen to the Steps</h2>
				  </div>
				  <div class="ui-body ui-body-a">
				  		<c:forEach items="${steps}" var="item" varStatus="countVar"> 
						   <div id="${countVar.index+1}" style="text-align: center" class="audioContainer"><p>Step ${countVar.index+1} of ${fn:length(steps)}<p><audio src="genAudio.wss?text=${item}" type="audio/wav" controls="controls"  ></audio> </div>
						</c:forEach>
				  
				  
				  <fieldset class="ui-grid-a">
		                   <div class="ui-block-a"><button class="ui-btn ui-corner-all ui-btn-a" id="previous" value="1">Previous</button></div>
		                   <div class="ui-block-b"><button class="ui-btn ui-corner-all ui-btn-b" id="next" value="1" maxValue="${fn:length(steps)}">Next</button></div>
		          </fieldset>
			
				    
				  </div>
				</div>
				 
		      <form action="viewTaskHelp.wss" name="navigation" data-ajax="false">
			     <fieldset class="ui-grid-a">
		                   <div class="ui-block-a"><button type="button" class="ui-btn ui-corner-all ui-btn-a" id="oprtnCmplt">Operation Complete</button></div>
		                   <div class="ui-block-b"><button type="submit" class="ui-btn ui-corner-all ui-btn-b">Online Support</button></div>
		          </fieldset>
			 </form>
    </div>    
    <div data-role="footer"> 
	        
	       
       
       
    

  <div data-role="footer"> 
		<h4>&nbsp;</h4> 
</div> 
        
		
    </div>    
</div>
<script>
$( ".audioContainer" ).hide();
$( "#1" ).show();
$("#next").click(function(){
			var hideId=$(this).val();
			var max=$(this).attr("maxValue");
			if(hideId!=max){
				$("#next").attr("value", function(i, origValue){
			        return  parseFloat(origValue)+1;
			    });
			    $("#previous").attr("value", function(i, origValue){
			        return  parseFloat(origValue)+1;
			    });
			    
			    var showId=$(this).val();
			  
			    	
				$( '#'+hideId ).hide();
				$( '#'+showId ).show();
			}
		
});
$("#previous").click(function(){
			var hideId=$(this).val();
			if(hideId!="1"){
				$("#previous").attr("value", function(i, origValue){
			        return  parseFloat(origValue)-1;
			    });
			    $("#next").attr("value", function(i, origValue){
			        return  parseFloat(origValue)-1;
			    });
			    var showId=$(this).val();	
				$( '#'+hideId ).hide();
				$( '#'+showId ).show();
			}
		
});
$("#oprtnCmplt").click(function(){
			var systemSearchFrm = document.forms["navigation"];
			systemSearchFrm.action = "commitTask.wss";
			systemSearchFrm.submit();
			
		
});

</script>
</body>
</html>