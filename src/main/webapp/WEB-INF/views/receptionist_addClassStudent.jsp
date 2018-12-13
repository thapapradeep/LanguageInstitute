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

	<jsp:include page="receptionistHeader.jsp" />


	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i>Language Institute-Assign student to class
		</div>
		<div class="card-body">
			<div class="table-responsive">
			<a href="receptionist/viewClasses" class="btn btn-success">Finish</a>
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
							<th>Status</th>
							<th>Added Date</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody >
						<c:forEach var="student" items="${studentList}">
							<tr>
								<td>${student.getId() }</td>
								<td>${student.getFirstname() }</td>
								<td>${student.getLastname() }</td>
								<td>${student.getAddress() }</td>
								<td>${student.getEmail() }</td>
								<td>${student.getContact() }</td>
								<td>${student.getAddedDate() }</td>
								<td>${student.getStatus() }</td>
								<td><a href="receptionist/add-addStudentClass?id=${student.getId()}&class_id=${clas.getId()}" class="btn btn-success">Add To Class</a>|
									</td>
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