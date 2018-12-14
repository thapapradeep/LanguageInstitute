<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Language Institute-Students</title>

<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

	<jsp:include page="managerHeader.jsp" />


	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-All Teachers
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
							<th>Salary</th>
							<th>Status</th>
							
							
							<th>Action</th>
							<th>Add Language Skill </th>
							<th>View Attendance History</th>
							<th>View Salary History</th>
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
								<td>${teacher.getSalary() }</td>
								<td>${teacher.getStatus() }</td>
								
								<td><a href="manager/updateTeachers?id=${teacher.getId()}" class="btn btn-success"><span class="fa fa-edit"></span></a>|<a
									href="manager/deleteTeachers?id=${teacher.getId()}" class="btn btn-danger"><span class="fa fa-trash"></span></a></td>
									
						<td><a href="manager/teacherlanguages?id=${teacher.getId()}" class="btn btn-primary">Add Language</a></td>
						<td><a href="manager/viewTeacherAttencence?id=${teacher.getId()}" class="btn btn-primary">View</a></td>
							<td><a href="manager/teacherHistory?id=${teacher.getId()}" class="btn btn-primary">View</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		
	</div>

	</div>
	<!-- /.container-fluid -->


	<jsp:include page="footer.jsp" />
	

</body>

</html>


</body>
</html>