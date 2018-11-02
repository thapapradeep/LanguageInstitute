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

<title>Language Institute-Teachers</title>


</head>

<body id="page-top">

	<jsp:include page="managerHeader.jsp" />


	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-All Batches
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Batch ID</th>
							<th>Name</th>
							<th>Action</th>
							<th>View Students</th>
							<th>View Class</th>
			
							
						</tr>
					</thead>

					<tbody >
						<c:forEach var="batch" items="${batchList }">
							<tr>
								<td>${batch.getId() }</td>
								<td>${batch.getBatchId() }</td>
								<td>${batch.getName() }</td>
								<td><a href="manager/updateBatch?id=${batch.getId()}" class="btn btn-success"><span class="fa fa-edit"></span></a>|<a
									href="manager/deleteBatch?id=${batch.getId()}" class="btn btn-danger"><span class="fa fa-trash"></span></a></td>
								<td><a href="manager/viewStudentBatch?id=${batch.getId()}" class="btn btn-primary">View Student</a></td>
									<td><a href="manager/viewClassBatch?id=${batch.getId()}" class="btn btn-primary">View Class</a></td>
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