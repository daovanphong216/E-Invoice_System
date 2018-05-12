<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<title>E-Invoice System</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>" />

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='https://fonts.googleapis.com/css?family=Roboto|Varela+Round'/>" />


<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/LoginStyle.css'/>" />

</head>
<body>
	<div class="col-sm-12">
		<div class="row top-content">
			<h1>Welcome to E-Invoice System</h1>
			<div class="container">
				<button href="#myModal" data-toggle="modal" type="button"
					class=" btn start-button">Get Started</button>
			</div>
		</div>
	</div>

	<!-- Modal HTML -->
	<div id="myModal" class="modal fade">
		<div class="modal-dialog modal-login">
			<div class="modal-content">
				<div class="modal-header">
					<div class="avatar">
						<img src="./resources/assets/img/avatar.png" alt="Avatar">
					</div>
					<h4 class="modal-title">Member Login</h4>
					<div class="row">
					<div class="col-md-12 ">
						<c:if test="${param.error == 'true'}">
							<div style="color: red; margin: 10px 0px;">

								Login Failed!!!<br /> Reason :
								${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

							</div>
						</c:if>
					</div>
					</div>
					
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="input-group">
							<span class="input-group-addon"> <i class="fa fa-user fa" aria-hidden="true"></i></span> 
							<input type="text" class="form-control" id="name" placeholder="Enter your Name" name="username" required />
						</div>
						<br> <label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="fa fa-lock fa-lg" aria-hidden="true"></i>
							</span> 
							<input type="password" class="form-control" id="password" placeholder="Enter your Password" name="password" required />
						</div>
						<br>
						<div class="form-group">
							<!-- <div class="checkbox"> -->
							<label><input type="checkbox" name="remember-me">
								Remember me</label>
							<button type="submit"
								class="btn btn-primary btn-lg btn-block login-btn">Login</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="center_link">
						<p>
							No account? <a href="./register">Create one!</a>.
						</p>
					</div>
				</div>

			</div>
		</div>
	</div>




</body>
</html>