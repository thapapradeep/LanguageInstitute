<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
 <!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Language Institute- Add Language</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>
  

  <body id="page-top">

   <jsp:include page="accountantHeader.jsp"/>
          <!-- Area Chart Example-->
         
         <div class="row">
         
         	<div class="col-lg-12">
         		<div class="panel panel-default">
         		
         			<div class="panel-heading">
         				Language Institute-Add Role Form
         			</div>
         			<hr/>
         			
         			<div class="panel-body">
         				<div class="row">
         				
         					<div class="col-lg-offset-3 col-lg-6">
         						<form:form action="accountant/add-addExpense" method="POST" modelAttribute="transaction">
         							<div class="form-group">
         								<label>Heading of Expense</label>
         								<form:input path="particular" class="form-control" placeholder="Enter subject of expenditure"/>
         								
         							</div>
         							<div class="form-group">
         								<label>Amount </label>
         								<form:input path="amount" class="form-control" placeholder="Enter amount in number"/>
         								
         							</div>
         						
         							
         						
         							
         							<button class="btn btn-success" type="submit">Add Expenses</button>
         							<button class="btn btn-primary" type="reset">Reset</button>
         						</form:form>
         					</div>
         				
         				</div>
         			
         			</div>
         		
         		</div>
         	</div>
         
         </div>
         
                
       <jsp:include page="footer.jsp"/>
  pt>
    <script src="js/demo/chart-area-demo.js"></script>

  </body>

</html>
    
   