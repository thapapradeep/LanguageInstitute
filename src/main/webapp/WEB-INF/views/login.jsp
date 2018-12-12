<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Language Institute - Login</title>

<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">

	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Language Institute-Login</div>
			<div class="card-body">
				<form:form action="j_spring_security_check" method="POST"
					modelAttribute="user">

					<c:if test="${not empty param.error}">
						<div>
							<p>Invalid username or password</p>
						</div>
					</c:if>

					<c:if test="${param.logSucc == true}">
						<div>
							<p>You have been logout out successfully from the system</p>
						</div>
					</c:if>
					<div class="form-group">
						<div class="form-label-group">
							<form:input path="email" type="email" id="inputEmail"
								class="form-control" placeholder="Email address"
								required="required" autofocus="autofocus" />
							<label for="inputEmail">Email address</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<form:input path="password" type="password" id="inputPassword"
								class="form-control" placeholder="Password" required="required" />
							<label for="inputPassword">Password</label>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}">

					<button class="btn btn-primary btn-block" type="submit">Login</button>

				</form:form>

			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
