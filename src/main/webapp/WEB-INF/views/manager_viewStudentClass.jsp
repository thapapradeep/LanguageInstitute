<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">



<body id="page-top">

	<jsp:include page="managerHeader.jsp" />


	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-All Classes
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Batch Name</th>
							<th>Classroom Number</th>
							<th>Start Time </th>
							<th>End Time</th>
							<th>Duration</th>
							<th>Language</th>
							<th>Teacher</th>
							<th>Student's Fee</th>
							<th>View Attendance</th>
						</tr>
					</thead>

					<tbody >
						<c:forEach var="clas" items="${classList }">
							<tr>
								<td>${clas.getId() }</td>
								<td>${clas.getBatch().getBatchId() }</td>
								<td>${clas.getClassroomNo() }</td>
								<td>${clas.getStartTime() }</td>
								<td>${clas.getEndTime() }</td>
								<td>${clas.getDuration() }</td>
							    <td>${clas.getLanguage().getLanguage() }</td>
							    <td>${clas.getTeacher().getFirstname() }</td>
							    <td>${clas.getStudentFee() }</td>
								<td><a href="manager/viewStudentAttendence?id=${clas.getId()}&student_id=${student.getId()}" class="btn btn-success">View Attendance</a></td>
									
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