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

    <title>Language Institute-Add Student</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
    
    <style>
    	.error{
    		color: #ff0000;
    		font-style: italic;
    	}
    </style>

  </head>

  <body id="page-top">

   <jsp:include page="receptionistHeader.jsp"/>
          <!-- Area Chart Example-->
         
         <div class="row">
         
         	<div class="col-lg-12">
         		<div class="panel panel-default">
         		
         			<div class="panel-heading">
         				Language Institute-Add Student Form
         			</div>
         			<hr/>
         			
         			<div class="panel-body">
         				<div class="row">
         				
         					<div class="col-lg-offset-3 col-lg-6">
         						<form:form action="receptionist/add-addStudent" method="POST" modelAttribute="student">
         							<div class="form-group">
         								<div class="form-group">
         								<label>Select Batch</label>
         								<form:select path="batch" items="${batchList}" itemLabel="batchId" itemValue="id"  class="form-control" />
         							</div>
         								<label>Firstname</label>
         								<form:input path="firstname" class="form-control" placeholder="Enter firstname"/>
         								<form:errors path="firstname" cssClass="error"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Lastname</label>
         								<form:input path="lastname" class="form-control" placeholder="Enter lastname"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Address</label>
         								<form:input path="address" class="form-control" placeholder="Enter address"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Email</label>
         								<form:input path="email" class="form-control" placeholder="Enter email"/>
         								<form:errors path="email" cssClass="error"/>
         							</div>
         							
         							
         							
         							<div class="form-group">
         								<label>Contact Number</label>
         								<form:input path="contact" class="form-control" placeholder="Enter contact number"/>
         							</div>
         							
         							<button class="btn btn-success" type="submit">Add Student</button>
         							<button class="btn btn-primary" type="reset">Reset</button>
         						</form:form>
         					</div>
         				
         				</div>
         			
         			</div>
         		
         		</div>
         	</div>
         
         </div>
         
                
       <jsp:include page="footer.jsp"/>
   

  </body>

</html>
    
   