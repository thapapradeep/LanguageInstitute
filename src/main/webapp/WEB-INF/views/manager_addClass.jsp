<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Language Institute- Add User</title>

<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
	<script src="${pagecontext.request.contextpath}/vendor/jquery/jquery.min.js"></script>

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>

<body id="page-top">

	<jsp:include page="managerHeader.jsp" />
	<!-- Area Chart Example-->

	<div class="row">

		<div class="col-lg-12">
			<div class="panel panel-default">

				<div class="panel-heading">Language Institute-Add Class Form</div>
				<hr />

				<div class="panel-body">
					<div class="row">

						<div class="col-lg-offset-3 col-lg-6">
							<form:form action="manager/add-addClass" method="POST"
								modelAttribute="clas">
								<div class="form-group">
								
								<div class="form-group">
         								<label>Select Batch</label>
         								<form:select path="batch" items="${batchList}" itemLabel="batchId" itemValue="id"  class="form-control" />
         							</div>
         							<div class="form-group">
									<label>Name for the class</label>
									<form:input path="className" class="form-control"
										placeholder="Enter name for the classs" />
									<form:errors path="className" cssClass="error" />
								</div>

								<div class="form-group">
									<label>Classroom number</label>
									<form:input path="classroomNo" class="form-control"
										placeholder="Enter start time of class" />
									<form:errors path="classroomNo" cssClass="error" />
								</div>

								<div class="form-group">
									<label>Start Time</label>
									<form:input path="startTime" class="form-control"
										placeholder="Enter start time of class" />
									<form:errors path="startTime" cssClass="error" />
								</div>

								<div class="form-group">
									<label>End Time</label>
									<form:input path="endTime" class="form-control"
										placeholder="Enter end time of class" />
									<form:errors path="endTime" cssClass="error" />
								</div>

								<div class="form-group">
									<label>Duration</label>
									<form:input path="duration" class="form-control"
										placeholder="Enter duration of class in days" />
									<form:errors path="duration" cssClass="error" />
								</div>

								<div class="form-group">
									<label>Student Fee</label>
									<form:input path="studentFee" class="form-control"
										placeholder="Enter students fee for this class" />
									<form:errors path="studentFee" cssClass="error" />
								</div>
								<div class="form-group">
									<label>Teacher's Payment For This Class</label>
									<form:input path="teacherSalary" class="form-control"
										placeholder="Enter teacher's paymant for this class" />
									<form:errors path="teacherSalary" cssClass="error" />
								</div>
								<div class="form-group">
									<label>Select Language</label>
									<form:select id="lang" path="language" items="${languageList}"
										itemLabel="language" itemValue="id" class="form-control"></form:select>
								</div>
								<div class="form-group">
									<label>Select Teacher</label>
									<form:select id="teacher" path="teacher" 
										itemLabel="firstname" itemValue="id" class="form-control"/>
								</div>
								
								


								<button class="btn btn-success" type="submit">Add User</button>
								<button class="btn btn-primary" type="reset">Reset</button>
							</form:form>
							
							

						</div>

					</div>

				</div>

			</div>
		</div>

	</div>


	

	<jsp:include page="footer.jsp" />

	
	
	<script>
          $('#lang').change(function(){
        	 var id=$(this).val();
        	 teachers=[];
        	
        	 
        	 
        	 $.get('http://localhost:8080/GetTeacherByLanguage/'+id, function(data, status){
        	        //alert("Data: " + data + "\nStatus: " + status);
        	        
        	         var $dropdown=$('#teacher');
        	        $.each(data,function(i){
        	        	//$dropdown.append($("<option></option>").val(this.id).text(this.firstname));
        	        	teachers[i]="<option value='" + this.id + "'>" + this.firstname + "</option>";
        	        });
        	        $dropdown.html(teachers.join(''));
        	        
        	    });
        	 
        	
          });
         </script>
	

</body>

</html>

