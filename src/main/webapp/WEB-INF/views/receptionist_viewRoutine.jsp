<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">



<body id="page-top">

	<jsp:include page="receptionistHeader.jsp" />


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
							<th>Day</th>
							<th>First Class </th>
							<th>Second Class</th>
							<th>Third Class</th>
							
							
							<th>Action</th>
						</tr>
					</thead>

					<tbody >
						<c:forEach var="routine" items="${routineList }">
							<tr>
								<td>${routine.getId() }</td>
								<td>${routine.getDay().getDay()}</td>
								<td>${routine.getClass1().getClassName()}<br>${routine.getClass1().getStartTime()}-${routine.getClass1().getEndTime()}<br>Teacher: ${routine.getClass1().getTeacher().getFirstname()}</td>
								<td>${routine.getClass2().getClassName()}<br>${routine.getClass2().getStartTime()}-${routine.getClass2().getEndTime()}<br>Teacher: ${routine.getClass2().getTeacher().getFirstname()}</td>
								<td>${routine.getClass3().getClassName()}<br>${routine.getClass3().getStartTime()}-${routine.getClass3().getEndTime()}<br>Teacher: ${routine.getClass3().getTeacher().getFirstname()}</td>
							    
							   
								<td><a href="receptionist/updateClassRoutine?id=${routine.getId()}" class="btn btn-success"><span class="fa fa-edit"></span></a>|<a
									href="receptionist/deleteClassRoutine?id=${routine.getId()}" class="btn btn-danger"><span class="fa fa-trash"></span></a></td>
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