<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Predictive Maintenance++</title>
        <link href="themes/demo.css" rel="stylesheet" type="text/css">
		<script src="js/Chart.js"></script>
		<script src="js/legend.js"></script>
		<script src="js/legend.legacy.js"></script>
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/jquery.mobile-1.4.5.min.js"></script>
		<style>
			canvas{
			}
		</style>
<meta name = "viewport" content = "initial-scale = 1, user-scalable = no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<input type="text" id="nameID" value='${NameID }'>
<input type="text" id="workCount" value='${WorkCount }'>
<input type="text" id="experience" value='${Experience }'>
<input type="text" id="skillLevel" value='${SkillLevel }'>

<center><h4>Raju</h4></center>
<div  style="width:500px;overflow:auto;">
<!-- <div style="width:70%;"> -->
			<canvas id="canvas" height="450" width="450"></canvas>
			<div id="legendDiv"></div>
		<!-- </div> -->
</div>



</body>
	<script type="text/javascript">
	var labelsArray=JSON.parse( $("#nameID").val()) ;
	var data1=JSON.parse( $("#workCount").val()) ;
    var data2=JSON.parse( $("#experience").val()) ;
    var data3=JSON.parse($("#skillLevel").val());
   
	var radarChartData = {
		labels: labelsArray,
		datasets: [
			{
				label: "Work-Count",
				fillColor: "rgba(60,159,30,0.2)",
				strokeColor: "rgba(60,159,30,1)",
				pointColor: "rgba(60,159,30,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(60,159,30,1)",
				data: data1
			},
			{
				label: "Experience",
				fillColor: "rgba(151,187,205,0.2)",
				strokeColor: "rgba(151,187,205,1)",
				pointColor: "rgba(151,187,205,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(151,187,205,1)",
				data: data2
			},
			{
				label: "Skill Level",
				fillColor: "rgba(172,18,170,0.2)",
				strokeColor: "rgba(172,18,170,1)",
				pointColor: "rgba(172,18,170,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(172,18,170,1)",
				data: data3
			}
		]
	};

	window.onload = function(){
		   var myChart = new Chart(document.getElementById("canvas").getContext("2d")).Radar(radarChartData);
			//document.getElementById("legendDiv").innerHTML = myChart.generateLegend();
	        legend(document.getElementById("legendDiv"), radarChartData);
	}

	</script>
</html>