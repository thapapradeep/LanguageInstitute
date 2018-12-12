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

    <title>Language Institute- Add User</title>

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
         						<form:form action="update-updateClass" method="POST" modelAttribute="clas">
         							<div class="form-group">
         							
         							<form:hidden path="id" value="${clas.getId() }"/>
         								<form:hidden path="id" value="${clas.getId() }"/>
         								<div class="form-group">
         								<label>Select Batch</label>
         								<form:select path="batch" items="${batchList}" itemLabel="name" itemValue="id"  class="form-control" value="${clas.getBatch().getName()}"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Classroom number</label>
         								<form:input path="classroomNo" class="form-control" value="${clas.getClassroomNo()}" />
         								<form:errors path="classroomNo" cssClass="error"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Start Time</label>
         								<form:input path="startTime" class="form-control" value="${clas.getStartTime()}" />
         								<form:errors path="startTime" cssClass="error"/>
         							</div>
         							
         							<div class="form-group">
         								<label>End Time</label>
         								<form:input path="endTime" class="form-control" value="${clas.getEndTime()}" />
         								<form:errors path="endTime" cssClass="error"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Duration</label>
         								<form:input path="duration"  class="form-control" value="${clas.getDuration()}" />
         								<form:errors path="duration" cssClass="error"/>
         							</div>
         							
         							<div class="form-group">
         								<label>Student Fee</label>
         								<form:input path="studentFee" class="form-control" value="${clas.getStudentFee()}" />
         								<form:errors path="studentFee" cssClass="error"/>
         							</div>
         							<div class="form-group">
         								<label>Teacher's Payment For This Class</label>
         								<form:input path="teacherSalary" class="form-control" value="${clas.getTeacherSalary()}"/>
         								<form:errors path="teacherSalary" cssClass="error"/>
         							</div>
         								<div class="form-group">
         								<label>Select Language</label>
         								<form:select path="language" items="${languageList}" itemLabel="language" itemValue="id"  class="form-control" value="${clas.getLanguage().getLanguage()}"/>
         							</div>
         							<div class="form-group">
         								<label>Select Teacher</label>
         								<form:select path="teacher" items="${teacherList}" itemLabel="firstname" itemValue="id"  class="form-control" value="${clas.getTeacher().getFirstname()}"/>
         							</div>
         							
         							
         							<button class="btn btn-success" type="submit">Update Class</button>
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
    
   