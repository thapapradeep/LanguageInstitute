<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>language Institute- Manager Dashboard</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>

  <body id="page-top">

   <jsp:include page="managerHeader.jsp"/>
   
   
    <!-- Icon Cards-->
          <div class="row">
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-comments"></i>
                  </div>
                  <div class="mr-5">26 New Students!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="manager/students">
                  <span class="float-left">View Details</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-warning o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-list"></i>
                  </div>
                  <div class="mr-5">2 New Languages!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="manager/viewLangauages">
                  <span class="float-left">View Details</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-success o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-shopping-cart"></i>
                  </div>
                  <div class="mr-5">3 New Staffs</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="manager/viewStaffs">
                  <span class="float-left">View Details</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-danger o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-life-ring"></i>
                  </div>
                  <div class="mr-5">2 New Classes</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="manager/viewClasses">
                  <span class="float-left">View Details</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
            </div>
          </div>
   
   
 <div id="chartContainer" style="height: 500px; width: 90%;"></div>


         

       <script>

window.onload = function () {
var dataPoints = [];
var chart = new CanvasJS.Chart("chartContainer",{
	title:{
		text:"Balance Per Week"
	},
	data: [{
		type: "line",
		dataPoints : dataPoints,
	}]
});

$.getJSON('http://localhost:8080/viewAverageBalance',function(data){
	$.each(data,function(key,value){
		console.log(value[0]);
		console.log(value[1]);
		dataPoints.push({label:value[0],y:parseInt(value[1])});
	});
	chart.render();
});




}
</script>
       <jsp:include page="footer.jsp"/>
    <script src="/js/demo/jQuery-canvas.min.js"></script>

  </body>

</html>
    
   