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

    <title>Language Institute-Add Language</title>

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

   <jsp:include page="managerHeader.jsp"/>
          <!-- Area Chart Example-->
         
         <div class="row">
         
         	<div class="col-lg-12">
         		<div class="panel panel-default">
         		
         			<div class="panel-heading">
         				Language Institute-Update Teacher Language Form
         			</div>
         			<hr/>
         			
         			<div class="panel-body">
         				<div class="row">
         				
         					<div class="col-lg-offset-3 col-lg-6">
         						<form:form action="manager/update-updateTeacherLanguage" method="POST" modelAttribute="teacher">
         						
         							<form:hidden path="id" value="${teacher.getId() }"/>
         							<div class="form-group">
         								<label>Firstname</label>
         								<form:input path="firstname" class="form-control" value="${teacher.getFirstname() }" placeholder="Enter firstname" disabled="true"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Lastname</label>
         								<form:input path="lastname" class="form-control" value="${teacher.getLastname() }" disabled="true"/>
         							</div>
         							
         							
         							
         							<div class="form-group">
         								<label>Email</label>
         								<form:input path="email" class="form-control" value="${teacher.getEmail() }" disabled="true"/>
         							</div>
         							
    
         							<div class="form-group">
         								<label>Contact Number</label>
         								<form:input path="contact" class="form-control" value="${teacher.getContact() }" disabled="true"/>
         							</div>
         							
         							
         								<div class="form-group">
         								<label>Select Language</label>
         								<form:select path="teacherlanguage" items="${languageList}" itemLabel="language" itemValue="id"  class="form-control" />
         							</div>
         							
         							<button class="btn btn-success" type="submit">Update Teacher</button>
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
    
   