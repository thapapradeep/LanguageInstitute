<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
 <!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>language Institute- Accountant Dashboard</title>

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

   <jsp:include page="receptionistHeader.jsp"/>
   
   
    <!-- Icon Cards-->
          <div class="row">
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-comments"></i>
                  </div>
                  <div class="mr-5"> New Students!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="receptionist/students">
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
                  <div class="mr-5"> New Languages!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="receptionist/viewLangauages">
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
                  <div class="mr-5"> Staffs</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="receeptionist/viewStaffs">
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
                  <div class="mr-5"> New Classes</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="receptionist/viewClasses">
                  <span class="float-left">View Details</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
            </div>
          </div>
          
   
   
        

          <div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-Routine
		</div>
		<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-Today's Class of Batch 1
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Day</th>
							<th>First Class </th>
							<th>Second Class</th>
							<th>Third Class</th>
							
							
							
						</tr>
					</thead>

					<tbody >
						<c:forEach var="routine" items="${classList}">
							<tr>
								<td>${routine.getId() }</td>
								<td>${routine.getDay().getDay()}</td>
								<td>${routine.getClass1().getClassName()}<br><a href="receptionist/receptionist/attendStudent?id=${routine.getClass1().getId()}" class="btn btn-primary">Attendance</a></td>
								<td>${routine.getClass2().getClassName()}<br><a href="receptionist/receptionist/attendStudent?id=${routine.getClass2().getId()}" class="btn btn-primary">Attendance</a></td>
								<td>${routine.getClass2().getClassName()}<br><a href="receptionist/receptionist/attendStudent?id=${routine.getClass3().getId()}" class="btn btn-primary">Attendance</a></td>
							    
							   
								
									
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		
	</div>

	</div>
	
	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-Today's Class of Batch 2
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Day</th>
							<th>First Class </th>
							<th>Second Class</th>
							<th>Third Class</th>
							
							
							
						</tr>
					</thead>

					<tbody >
						<c:forEach var="routine" items="${classList1}">
							<tr>
								<td>${routine.getId() }</td>
								<td>${routine.getDay().getDay()}</td>
								<td>${routine.getClass1().getClassName()}<br><a href="receptionist/receptionist/attendStudent?id=${routine.getClass1().getId()}" class="btn btn-primary">Attendance</a></td>
								<td>${routine.getClass2().getClassName()}<br><a href="receptionist/receptionist/attendStudent?id=${routine.getClass2().getId()}" class="btn btn-primary">Attendance</a></td>
								<td>${routine.getClass2().getClassName()}<br><a href="receptionist/receptionist/attendStudent?id=${routine.getClass3().getId()}" class="btn btn-primary">Attendance</a></td>
							    
							   
								
									
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		
	</div>

	<!-- /.container-fluid -->

       
       <jsp:include page="footer.jsp"/>
   

  </body>

</html>
    
   