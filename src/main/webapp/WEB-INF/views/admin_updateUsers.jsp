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

    <title>Language Institute- Update User</title>

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

   <jsp:include page="header.jsp"/>
          <!-- Area Chart Example-->
         
         <div class="row">
         
         	<div class="col-lg-12">
         		<div class="panel panel-default">
         		
         			<div class="panel-heading">
         				Language Institute-Update User Form
         			</div>
         			<hr/>
         			
         			<div class="panel-body">
         				<div class="row">
         				
         					<div class="col-lg-offset-3 col-lg-6">
         						<form:form action="update-updateUser" method="POST" modelAttribute="user">
         						
         							<form:hidden path="id" value="${user.getId() }"/>
         							<div class="form-group">
         								<label>Firstname</label>
         								<form:input path="firstname" class="form-control" value="${user.getFirstname() }" placeholder="Enter firstname"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Lastname</label>
         								<form:input path="lastname" class="form-control" value="${user.getLastname() }"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Address</label>
         								<form:input path="address" class="form-control" value="${user.getAddress() }" />
         							</div>
         							
         							<div class="form-group">
         								<label>Email</label>
         								<form:input path="email" class="form-control" value="${user.getEmail() }" />
         							</div>
         							
         							<div class="form-group">
         								<label>Password</label>
         								<form:input path="password" type="password" class="form-control" value="${user.getPassword() }" />
         							</div>
         							
         							<div class="form-group">
         								<label>Contact Number</label>
         								<form:input path="contactnumber" class="form-control" value="${user.getContactnumber() }"/>
         							</div>
         							
         							<button class="btn btn-success" type="submit">Update User</button>
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
    
   