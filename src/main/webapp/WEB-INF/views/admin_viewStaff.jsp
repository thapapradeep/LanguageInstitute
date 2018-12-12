<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">



<body id="page-top">

	<jsp:include page="header.jsp" />


	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-All Staffs
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
							
							<th>Action</th>
						</tr>
					</thead>

					<tbody >
						<c:forEach var="staff" items="${staffList }">
							<tr>
								<td>${staff.getId() }</td>
								<td>${staff.getFirstname() }</td>
								<td>${staff.getLastname() }</td>
								<td>${staff.getAddress() }</td>
								<td>${staff.getEmail() }</td>
								<td>${staff.getContact() }</td>
							
							
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