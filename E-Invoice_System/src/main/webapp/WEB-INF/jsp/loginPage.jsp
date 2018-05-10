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



<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/LoginStyle.css'/>" />

</head>
<body>
	<%@ include file="header.jsp"%>
		<div class="container">
			<h2  class = "center_title">Login</h2>
			<div class="row">
                    <div class="col-md-12 ">
                        <c:if test="${param.error == 'true'}">
                            <div style="color:red;margin:10px 0px;">

                                   Login Failed!!!<br />
                                   Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

                            </div>
                       </c:if>
                    </div>
                </div> 
          <form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
			<label for="uname"><b>User Name</b></label><br> 
			<input
				type="text" placeholder="Enter User Name" name="username" required><br>

			<label for="psw"><b>Password</b></label><br> 
			<input
				type="password" placeholder="Enter Password" name="password" required><br>
			<div class="form-group">
				<div class="checkbox">
					<label><input type="checkbox" name="remember-me">
						Remember me</label>
				</div>

				<button type="submit" class = "center_button">Login</button>
				<br>
			</div>
			</form>
		</div>
	
	<div class="center_link">
		<p>
			No account? <a href="./register">Create one!</a>.
		</p>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>