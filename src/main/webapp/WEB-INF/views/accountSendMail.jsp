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

    <title>Language Institute- Send Mail</title>

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
         				Language Institute-Send Mail
         			</div>
         			<hr/>
         			
         			<div class="panel-body">
         				<div class="row">
         				
         					<div class="col-lg-offset-3 col-lg-6">
         					
         							<div class="form-group">
         								<label>First name</label>
         								<input type="text" class="form-control" id="studentName" value="${student.getFirstname()}" disabled/>
         								
         							</div>
         						
         							<div class="form-group">
         								<label>Email Address Of Student</label>
         								<input type="text" class="form-control" id="studentEmail" value="${student.getEmail()}" disabled/>
         								
         							</div>
         							<div class="form-group">
         								<label>Enter Body of Mail</label>
         								 <textarea class="form-control" id="studentSubject"></textarea>
         								
         							</div>
         						
         							
         						
         							
         							<button class="btn btn-success" id="sendMail">Send Mail</button>
         							<button class="btn btn-primary" type="reset">Reset</button>
         						
         					</div>
         				
         				</div>
         			
         			</div>
         		
         		</div>
         	</div>
         
         </div>
         
                
       <jsp:include page="footer.jsp"/>
  <script>
	
	$(document).ready(function(){
		$('#sendMail').click(function(){
			var jsondata = {"name":$('#studentName').val(),
							"email":$('#studentEmail').val(),
							"message":$('#studentSubject').val()};
			console.log(jsondata);
			$.ajax({
	            url: "http://localhost:8080/sendMessage",
	            type: "POST",
	            contentType: 'application/json',
	            data:JSON.stringify(jsondata),
	            success: function (response) {
	                if(response.status == 200){
	                	alert('Email sent successfully to the student:):)');
	                }else{
	                	alert('Failed to sent the email. Please try again ');
	                }	           
	                },
	            error: function (xhr, status) {
	                
	            }
	        });
		});
		
	});
	</script>

  </body>

</html>
    
   