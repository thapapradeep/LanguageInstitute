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

    <title>Language Institute- Update Class</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>
  
   <style>
    	.error{
    		color: #ff0000;
    		font-style: italic;
    	}
    </style>

  <body id="page-top">

   <jsp:include page="receptionistHeader.jsp"/>
          <!-- Area Chart Example-->
         
         <div class="row">
         
         	<div class="col-lg-12">
         		<div class="panel panel-default">
         		
         			<div class="panel-heading">
         				Language Institute-Add Class Form
         			</div>
         			<hr/>
         			
         			<div class="panel-body">
         				<div class="row">
         				
         					<div class="col-lg-offset-3 col-lg-6">
         						<form:form action="receptionist/update-updateClassRoutine" method="POST" modelAttribute="classRoutine">
         							<div class="form-group">
         							
         							<form:hidden path="id" value="${classRoutine.getId() }"/>
         								<div class="form-group">
         								<label>Select Batch</label>
         								<form:select path="batch1" items="${batchList}" itemLabel="name" itemValue="id"  class="form-control" value="${clasRoutine.getBatch1().getName()}"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Select First Class</label>
         								<form:select path="class1" items="${classList}" itemLabel="className" itemValue="id"  class="form-control" value="${classRoutine.getClass1().getClassName()}"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Select Batch</label>
         								<form:select path="class2" items="${classList}" itemLabel="className" itemValue="id"  class="form-control" value="${classRoutine.getClass3().getClassName()}"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Select Batch</label>
         								<form:select path="class3" items="${classList}" itemLabel="className" itemValue="id"  class="form-control" value="${classRoutine.getClass3().getClassName()}"/>
         							</div>
         							
         							
         							
         							
         							<button class="btn btn-success" type="submit">Update Routine</button>
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
    
   