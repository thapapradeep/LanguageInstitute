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

	</div>
	<!-- /.container-fluid -->


	<jsp:include page="footer.jsp" />
	
	

</body>

</html>


</body>
</html>