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

 

  </head>

  <body id="page-top">

   <jsp:include page="managerHeader.jsp"/>
          <!-- Area Chart Example-->
         
         <div class="row">
         
         	<div class="col-lg-12">
         		<div class="panel panel-default">
         		
         			<div class="panel-heading">
         				Language Institute-Update Batch Form
         			</div>
         			<hr/>
         			
         			<div class="panel-body">
         				<div class="row">
         				
         					<div class="col-lg-offset-3 col-lg-6">
         						<form:form action="manager/update-updateBatch" method="POST" modelAttribute="batch">
         						
         							<form:hidden path="id" value="${bacth.getId() }"/>
         							<div class="form-group">
         								<label>Batch Code</label>
         								<form:input path="batchId" class="form-control" value="${batch.getBatchId() }" />
         							</div>
         							
         							<div class="form-group">
         								<label>Name</label>
         								<form:input path="name" class="form-control" value="${batch.getName() }"/>
         							</div>
         							
         						
         							
         							<button class="btn btn-success" type="submit">Update Batch</button>
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
    
   