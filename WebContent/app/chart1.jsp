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
        <div id="banner">
            <center><h2> Manpower Available </h2></center>
        </div>
	<div style="display: table;width:80%;">
		<div style="width:100%;display: table-row;">
			<div style="display: table-cell;width:100%;font-size: 0.8em;" >
				<canvas id="canvas1" height="100%" width="100%"></canvas>
			</div>
		</div>
		<div style="width:100%;display: table-row;">
			<div style="display: table-cell;width:100%;" ><div id="legendDiv1" style="font-size: 0.8em;"></div></div>
		</div>
		<div style="width:100%;display: table-row;">
			<div style="display: table-cell;width:100%;" >
				<canvas id="canvas2" height="100%" width="100%"></canvas>
			</div>
		</div>
		<div style="width:100%;display: table-row;">			
			<div style="display: table-cell;width:100%;" ><div id="legendDiv2" style="font-size: 0.8em;"></div></div>
		</div>
	</div>
     <form action="resourceUpdate.wss" method="post" id="selectEmployee" data-ajax="false" >  
       <fieldset data-role="controlgroup">
     	<c:forEach items="${empList}" var="item" varStatus="countVar">   
    	  	<li >
    	  		<input type="checkbox" class="chkarea" name="employeeId" id="radio_${countVar.index}" value="${ item.employeeId}"  />
                <label for="radio_${countVar.index}">${ item.employeeName}-(${item.workCenter})&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Score :&nbsp; ${ item.score}</label>
    	  	</li>
		</c:forEach>
	   </fieldset>
	     <fieldset class="ui-grid-a">
                    <div class="ui-block-a"><a href="#" data-rel="back" ><button class="ui-btn ui-corner-all ui-btn-a">Go Back</button></a></div>
                    <div class="ui-block-b"><button type="button" class="ui-btn ui-corner-all ui-btn-a" onclick="submitPage()" >Select</button></div>
          </fieldset>
	</form>
    </div>    
    <div data-role="footer"> 
		<h4>&nbsp;</h4> 
	</div>
</div>
</body>
<script>
	var fullData = ${dataInJon} ;
	console.log(fullData);	
	
    
    
    window.onload = function(){
    	var chartData = new Array();
    	var index=0;
    	for (var deptId in fullData) {
	        if (fullData.hasOwnProperty(deptId)) {
	           chartData[index] = fullData[deptId];
	           index++;
	        }
	    }
		console.log(chartData);
        
		for(var index=0;index<chartData.length;index++)
        {
        	var radarChartData = 
        	{
        		labels: chartData[index].names,
        		datasets: [
				{
					label: "Work-Count",
					fillColor: "rgba(60,159,30,0.2)",
					strokeColor: "rgba(60,159,30,1)",
					pointColor: "rgba(60,159,30,1)",
					pointStrokeColor: "#fff",
					pointHighlightFill: "#fff",
					pointHighlightStroke: "rgba(60,159,30,1)",
					data: chartData[index].wrkCount
				},
				{
				label: "Experience",
				fillColor: "rgba(151,187,205,0.2)",
				strokeColor: "rgba(151,187,205,1)",
				pointColor: "rgba(151,187,205,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(151,187,205,1)",
				data: chartData[index].exp
				},
				{
				label: "Skill Level",
				fillColor: "rgba(172,18,170,0.2)",
				strokeColor: "rgba(172,18,170,1)",
				pointColor: "rgba(172,18,170,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(172,18,170,1)",
				data: chartData[index].skill
				}
				]
        	}
        	var myChart = new Chart(document.getElementById("canvas"+(index+1)).getContext("2d")).Radar(radarChartData, {
			responsive: true});
			legend(document.getElementById("legendDiv"+(index+1)), radarChartData);
        }
   	 
	}
	
	function submitPage()
	{
	
		if ($(".chkarea:checked").length < 1){
			alert("Please select at least one resource.");
		}else{
			$("#selectEmployee").submit();
		}
  				  
		
	}
	</script>
</html>