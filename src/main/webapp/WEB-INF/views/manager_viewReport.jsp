<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="managerHeader.jsp"/>
</head>
<body>
<div id="chartContainer" style="height: 500px; width: 90%;"></div>
<div style="height:10px; width=100%;"></div>
<div id="chartContainerrr" style="height: 500px; width: 90%;"></div>



<script>

window.onload = function () {
var dataPoints = [];
var chart = new CanvasJS.Chart("chartContainer",{
	title:{
		text:"No of students for month Nov"
	},
	data: [{
		type: "line",
		dataPoints : dataPoints,
	}]
});

$.getJSON('http://localhost:8080/viewNoOfStudentsPerClassOct',function(data){
	$.each(data,function(key,value){
		console.log(value[0]);
		console.log(value[1]);
		dataPoints.push({label:value[0],y:parseInt(value[1])});
	});
	chart.render();
});
var dataPoint = [];
var chart1 = new CanvasJS.Chart("chartContainerrr",{
	title:{
		text:"No of students for month Nov"
	},
	data: [{
		type: "line",
		dataPoints : dataPoint,
	}]
});

$.getJSON('http://localhost:8080/viewNoOfStudentsPerClassNov',function(data){
	$.each(data,function(key,value){
		console.log(value[0]);
		console.log(value[1]);
		dataPoint.push({label:value[0],y:parseInt(value[1])});
	});
	chart1.render();
});

}
</script>
       <jsp:include page="footer.jsp"/>
    <script src="/js/demo/jQuery-canvas.min.js"></script>

</body>
</html>