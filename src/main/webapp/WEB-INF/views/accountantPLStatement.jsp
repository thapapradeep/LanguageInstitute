<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PL Statement</title>
<!-- Page level plugin CSS-->

</head>
<body>
<jsp:include page="accountantHeader.jsp"/>
<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Language Institute-Profit and Loss Statement
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Income/Expenses</th>
							<th>Heading</th>
							<th>Amount</th>
							
							
						</tr>
					</thead>

					<tbody >
						
						 <tr>
						         <td rowspan="2">Income</td>
								<td>Student Fee Collection</td>
								<td>${studentFee} </td>
							</tr>
							 <tr>
						         
								<td>miscellaneous Income</td>
								<td>${miscIncome} </td>
							</tr>
							<tr>
							<td colspan="3"><b>Total Income= ${totalIncome}</b></td>
							</tr>
							<tr>
							<td colspan="3"></td>
							</tr>
						  <tr>
						  <td rowspan="3">Expense</td>
								<td>Staff Salary Payment</td>
								<td>${staffSalary} </td>
							</tr>
							<tr>
								<td>Teacher Salary Payment</td>
								<td>${teacherSalary} </td>
							</tr>
							<tr>
								<td> Office Maintenance</td>
								<td>${miscExpense}</td>
							</tr>
						  <tr>
						  <td colspan="3"><b>Total Expenditure=${totalExpense}</b> </td>
						  </tr>
						  <tr>
						  <td colspan="3"><b>Net Income=${netIncome}</b> </td>
						  </tr>
						

					</tbody>
				</table>
				
			</div>
		</div>
		
	</div>

	
</body>
<jsp:include page="footer.jsp"/>
</html>