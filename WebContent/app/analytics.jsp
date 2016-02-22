<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Predictive Maintenance++</title>
	<script src="js/Chart.js"></script>
	<link href="themes/demo.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="themes/csm_theme.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.icons.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.structure-1.4.5.min.css" />
	<script src="js/legend.js"></script>
	<script src="js/legend.legacy.js"></script>
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
           <li><a href="analytics.wss">FAQ</a></li>
         <li data-icon="power"> <a href="logout.wss"   >Logout</a></li>
 </ul>
 </div>
    <div data-role="header" data-position="fixed">
         <a href="#myPanel" class="ui-btn ui-icon-bars ui-btn-icon-notext ui-corner-all">No text</a>
         <h2 style="font-size: 1.1em;color:#ffffff">Global Mining Corp</h2>
        <a href="loadHome.wss" class="ui-btn ui-icon-home ui-btn-icon-notext ui-corner-all"  >No Text</a>
    </div>
    <div data-role="content">
        <div id="banner" style="text-align: center;">
            <img src="themes/images/bulb.png" width="50px" height="75px" />
        </div>
        <center><h3>Work progress</h3></center>
        <div>
        	<ul data-role="listview" data-inset="true" data-shadow="false">
		 		<li data-icon="false"><span style="display:inline-block;width:5%;float:left;">&nbsp;&nbsp;</span><span style="display:inline-block;width:20%;float:left;">&nbsp;Total Job Orders</span><span style="float:right;"><c:out value="${total}" /></span><span style="float:clear;">&nbsp;</span></li>
		 		<li data-icon="false"><span style="display:inline-block;width:5%;float:left;background:#1109f0;">&nbsp;&nbsp;</span><span style="display:inline-block;width:20%;float:left;">&nbsp;Complete</span><span style="float:right;"><c:out value="${completeCount}" /></span><span style="float:clear;">&nbsp;</span></li>
		 		<li data-icon="false"><span style="display:inline-block;width:5%;float:left;background:#1000f0;">&nbsp;&nbsp;</span><span style="display:inline-block;width:20%;float:left;">&nbsp;WIP</span><span style="float:right;"><c:out value="${wipCount}" /></span><span style="float:clear;">&nbsp;</span></li>
		 		<li data-icon="false"><span style="display:inline-block;width:5%;float:left;background:#110990;">&nbsp;&nbsp;</span><span style="display:inline-block;width:20%;float:left;">&nbsp;Referred</span><span style="float:right;"><c:out value="${refCout}" /></span><span style="float:clear;">&nbsp;</span></li>
		 		<li data-icon="false"><span style="display:inline-block;width:5%;float:left;background:#00ff00;">&nbsp;&nbsp;</span><span style="display:inline-block;width:20%;float:left;">&nbsp;Analyzed</span><span style="float:right;"><c:out value="${analyzed}" /></span><span style="float:clear;">&nbsp;</span></li>
		 		<li data-icon="false"><span style="display:inline-block;width:5%;float:left;background:#F7464A;">&nbsp;&nbsp;</span><span style="display:inline-block;width:20%;float:left;">&nbsp;Not Analyzed</span><span style="float:right;"><c:out value="${notAnalyzed}" /></span><span style="float:clear;">&nbsp;</span></li>
			</ul>
		</div>	
        <div class="ui-grid-solo">
        	<div>
			<canvas id="canvas" height="50%" width="50%" style="float:center"></canvas>
			</div>
		</div>
		<fieldset class="ui-grid-solo">
            <div class="ui-block-a"><a href="#" data-rel="back" ><button class="ui-btn ui-corner-all ui-btn-a">Go Back</button></a></div>
         </fieldset>
    </div>  
	<div data-role="footer"> 
		<h4>&nbsp;</h4> 
	</div>      
</div>
</body>
<script>
 var data = [
    {
        value: <c:out value="${notAnalyzed}" /> ,
        color:"#F7464A",
        highlight: "#FF5A5E",
        label: "Not analyzed"
    },
    {
        value: <c:out value="${analyzed}" />,
        color: "#00ff00",
        highlight: "#5AD3D1",
        label: "Analzed"
    },
     {
        value: <c:out value="${wipCount}" />,
        color: "#1000f0",
        highlight: "#5AD0D1",
        label: "WIP"
    },
     {
        value: <c:out value="${completeCount}" />,
        color: "#1109f0",
        highlight: "#5AD0D1",
        label: "Complete"
    },
     {
        value: <c:out value="${refCout}" />,
        color: "#110990",
        highlight: "#5AD0D1",
        label: "Referred"
    },
   ];
    
window.onload = function(){
		var myChart = new Chart(document.getElementById("canvas").getContext("2d")).Doughnut(data, {
			responsive: true});
		
	}
	
</script>
</html>