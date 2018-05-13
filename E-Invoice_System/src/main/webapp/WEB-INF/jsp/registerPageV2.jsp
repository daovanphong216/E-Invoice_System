<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<title>E-Invoice System</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>" />

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>




<link rel="stylesheet"
	href="<c:url value='././resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='././resources/assets/css/RegisterStyle.css'/>" />

</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="page-body">
		<div class="container">
			<h1 class="center_title">Register</h1>
			<p class="center_title">Please fill in this form to create
				an account.</p>
			<div class="col-md-12 text-center">
				<c:if test="${error == 'true'}">
					<div class="error">

						Register Failed!!!<br /> Reason : ${message}

					</div>
				</c:if>
			</div>
			<form name='f' action="./register" method='POST'>

<label for="email"><b>Email</b></label><br>
    <input type="email" placeholder="Enter Email" name="email" required>

	<label for="uname"><b>User Name</b></label><br>
    <input type="text" placeholder="Enter User Name" name="username" pattern=".{0}|.{5,25}" required title="Must 5 or more chars (max 25)" maxlength="25">

	<label for="name"><b>Full Name</b></label><br>
    <input type="name" placeholder="Enter Your Name" name="name" pattern=".{0}|.{5,50}" required title="Must 5 or more chars (max 50)" maxlength="50">

	<label for="add"><b>Address</b></label><br>
    <input type="text" placeholder="Enter Address" name="address" required>

	<label for="telNo"><b>Phone Number</b></label><br>
    <input type="tel" placeholder="090xxxxxxx" name="telNo" required size="20" minlength="10" maxlength="14">

    <label for="psw"><b>Password</b></label><br>
    <input name="password" placeholder="Enter Password" required="required" type="password" id="password" />

    <label for="psw-repeat"><b>Confirm Password</b></label><br>
    <input name="password_confirm" placeholder="Confirm Password" required="required" type="password" id="password_confirm" onblur="checkPassword();" />

				<button type="submit" class="registerbtn btn btn-default">Done</button>

			</form>
			<div class="container signin">
				<p>
					Already have an account? <a href="./login">Login</a>.
				</p>
			</div>
		</div>
	</div>



	<%@ include file="footer.jsp"%>
</body>
<script src="./resources/assets/js/RegisterFunction.js" ></script>
</html>