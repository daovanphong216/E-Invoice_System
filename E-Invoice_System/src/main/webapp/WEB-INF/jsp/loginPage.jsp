<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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



<link rel="stylesheet"
	href="<c:url value='././resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='././resources/assets/css/LoginStyle.css'/>" />

</head>
<body>
	<%@ include file="header.jsp"%>
	<form>
		<div class="container">
			<h2 style="margin-bottom: 40px;">Login Form</h2>

			<label for="uname"><b>User Name</b></label><br> <input
				type="text" placeholder="Enter User Name" name="uname" required><br>

			<label for="psw"><b>Password</b></label><br> <input
				type="password" placeholder="Enter Password" name="psw" required><br>
			<div class="form-group">
				<div class="checkbox">
					<label><input type="checkbox" name="remember">
						Remember me</label>
				</div>

				<button type="submit">Submit</button>
				<br>
			</div>
		</div>
	</form>
	<div class="container signin">
		<p>
			No account? <a href="./register">Create one!</a>.
		</p>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>