<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Salary Slip</title>

</head>
<body>
<jsp:include page="accountantHeader.jsp"/>
<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-Staff Salary Slip
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Particulars</th>
							<th>Information</th>
							
							
						</tr>
					</thead>

					<tbody >
						
						 <tr>
								<td>Date</td>
								<td>${date} </td>
							</tr>
						  <tr>
								<td>Id</td>
								<td>${staff.getId()} </td>
							</tr>
							<tr>
								<td>Name</td>
								<td>${staff.getFirstname()} ${staff.getLastname()} </td>
							</tr>
							<tr>
								<td> Salary</td>
								<td>${staff.getRole().getSalary()}</td>
							</tr>
							<tr>
								<td>Number of Present Days</td>
								<td>${present}</td>
							</tr>
							<tr>
								<td>Number of absent Days</td>
								<td>${absent}</td>
							</tr>
							<tr>
								<td>Salary Total</td>
								<td>${netSalary}</td>
							</tr>
						

					</tbody>
				</table>
			</div>
			<a href="accountant/payStaff?id=${staff.getId()}&amount=${netSalary}" class="btn btn-success" role="button">Pay Salary</a>
		</div>
		
	</div>

	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>