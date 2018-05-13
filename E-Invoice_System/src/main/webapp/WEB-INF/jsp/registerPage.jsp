<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<title>Register</title>
<link rel="icon" href="${pageContext.request.contextPath}/resources/assets/img/titleImage.png" type="image/x-icon">
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
	href="<c:url value='/resources/assets/css/RegisterStyle.css'/>" />

</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="container">
			<div class="row main">
				<div class="panel-heading">
					<div class="panel-title text-center">
						<h1 class="title">Register</h1>
						<hr />
						<p class="center_title">Please fill in this form to create an
							account.</p>
						<div class="col-md-12 text-center">
							<c:if test="${error == 'true'}">
								<div class="error">
	
									Register Failed!!!<br /> Reason : ${message}
	
								</div>
							</c:if>
						</div>
					</div>
				</div>
			<div class="main-login main-center">
					<form class="form-horizontal" method="post" action="#">
						
						<label for="email" class="control-label">Email</label>
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-envelope-o" aria-hidden="true"></i>
                    </span>
                    <input class="form-control" type="email" placeholder="Enter Email" name="email" required/>
                </div>
                <br>

                <label for="username" class="control-label">Username</label>
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-user fa" aria-hidden="true"></i>
                    </span>
                    <input class="form-control" type="text" placeholder="Enter User Name" name="username" pattern=".{0}|.{5,25}" required title="Must 5 or more chars (max 25)" maxlength="25" />
                </div>
                <br>

                <label for="fullname" class="control-label">Full Name</label>
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-user-circle" aria-hidden="true"></i>
                    </span>
                    <input class="form-control" type="name" placeholder="Enter Your Name" name="name" pattern=".{0}|.{5,50}" required title="Must 5 or more chars (max 50)" maxlength="50"/>
                </div>
                <br>

                <label for="fullname" class="control-label">Address</label>
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-address-book-o" aria-hidden="true"></i>
                    </span>
                    <input class="form-control" type="text" placeholder="Enter Address" name="address" required/>
                </div>
                <br>

                <label for="fullname" class="control-label">Phone Number</label>
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="glyphicon glyphicon-phone-alt" aria-hidden="true"></i>
                    </span>
                    <input class="form-control" type="tel" placeholder="090xxxxxxx" name="telNo" required size="20" minlength="10" maxlength="14"/>
                </div>
                <br>

                <label for="password" class="control-label">Password</label>
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-lock fa-lg" aria-hidden="true"></i>
                    </span>
                    <input class="form-control" name="password" placeholder="Enter Password" required="required" type="password" id="password"/>
                </div>
                <br>

                <label for="password" class="control-label">Confirm Password</label>
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-lock fa-lg" aria-hidden="true"></i>
                    </span>
                    <input class="form-control" name="password_confirm" placeholder="Confirm Password" required="required" type="password" id="password_confirm" onblur="checkPassword();"/>
                </div>
                <br>

                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg  done-button">Done</button>
                </div>
                <div class="container signin t-footer">
                    <p>
                        Already have an account? <a href="./login">Login</a>.
                    </p>
                </div>
					</form>
				</div>
			</div>
		</div>
	<%@ include file="footer.jsp"%>
</body>
<script src="./resources/assets/js/RegisterFunction.js" ></script>
</html>