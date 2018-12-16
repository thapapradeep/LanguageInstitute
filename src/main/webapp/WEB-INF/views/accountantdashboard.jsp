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

   <jsp:include page="accountantHeader.jsp"/>
   
   
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
                <a class="card-footer text-white clearfix small z-1" href="/students">
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
                  <div class="mr-5">11 New Languages!</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="viewLangauages">
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
                  <div class="mr-5">50 Staffs</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="viewStaffs">
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
                  <div class="mr-5">20 New Classes</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="viewClasses">
                  <span class="float-left">View Details</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
            </div>
          </div>
   
   
        

          <!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-All Unpaid Staff of This Month
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Firstname</th>
							<th>Lastname</th>
							<th>Address</th>
							<th>Email</th>
							<th>Contact</th>
							<th>Salary</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody >
						<c:forEach var="staff" items="${staffList}">
							<tr>
								<td>${staff.getId() }</td>
								<td>${staff.getFirstname() }</td>
								<td>${staff.getLastname() }</td>
								<td>${staff.getAddress() }</td>
								<td>${staff.getEmail() }</td>
								<td>${staff.getContact() }</td>
								<td>${staff.getRole().getSalary()}</td>
								<td><a href="accountant/paySatff?id=${staff.getId()}&amount=${staff.getRole().getSalary()}" class="btn btn-success">Pay Salary</a>
							
							
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		
	</div>

	</div>
	
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-All Unpaid Teachers of This Month
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Firstname</th>
							<th>Lastname</th>
							<th>Address</th>
							<th>Email</th>
							<th>Contact</th>
							<th>Status</th>
							<th>Salary</th>
							<th>Pay Salary</th>
							
						</tr>
					</thead>

					<tbody >
						<c:forEach var="teacher" items="${teacherList }">
							<tr>
								<td>${teacher.getId() }</td>
								<td>${teacher.getFirstname() }</td>
								<td>${teacher.getLastname() }</td>
								<td>${teacher.getAddress() }</td>
								<td>${teacher.getEmail() }</td>
								<td>${teacher.getContact() }</td>
								<td>${teacher.getSalary()}</td>
								<td>${teacher.getStatus() }</td>
								<td><a href="accountant/payTeacher?id=${teacher.getId()}&amount=${teacher.getSalary()}" class="btn btn-success">Pay Salary</a>
									
						
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		
	</div>

	</div>

       
       <jsp:include page="footer.jsp"/>


  </body>

</html>
    
   