<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">



<body id="page-top">

	<jsp:include page="accountantHeader.jsp" />


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
							<th>Month</th>
							
							<th>Action</th>
						</tr>
					</thead>

					<tbody >
						<c:forEach var="month" items="${monthList}">
							<tr>
								<td>${month.getId() }</td>
								<td>${month.getMonth()}</td>
								<td><a href="accountant/viewPLStatement?id=${month.getId()}" class="btn btn-success">View PL Statement</a>
							
							
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