<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title>Yearly Charts</title>
<link rel="icon" href="${pageContext.request.contextPath}/resources/assets/img/titleImage.png" type="image/x-icon">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/HeaderFooterStyle.css'/>" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

		<h1 class="text-center">
					<a id="yleft" href="#"><</a> <span>&nbsp;</span>
					<span>&nbsp;</span><span id="yyear"> </span> <span>&nbsp;</span> <a
						id="yright" href="#">></a>
		</h1>
		<div id="piechart"></div>
	
	<script type="text/javascript"
		src="././resources/assets/js/Yearly.js"></script>

</body>
</html>