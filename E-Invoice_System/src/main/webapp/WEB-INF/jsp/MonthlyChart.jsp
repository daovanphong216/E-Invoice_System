<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet" href="././resources/assets/css/calender.css" />
<link rel="stylesheet" href="././resources/assets/css/list_style.css" />
<link rel="stylesheet" href="././resources/assets/css/Invoices.css">
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/HeaderFooterStyle.css'/>" />
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class= "flex-container">
	<%@ include file="header.jsp"%>
	<%@ include file="sideBar.jsp"%>

	<article class="page-container article">
		<input type="button" id="bar" value="Chart">
		<div id="barchart"></div>
		<div id="linechart"></div>
		

	</article>

	

	<%@ include file="footer.jsp"%>
</div>
	<script type="text/javascript"
		src="././resources/assets/js/calendar.js"></script>
	<script src="././resources/assets/js/InvoicesMain.js"></script>
	<script type="text/javascript"
		src="././resources/assets/js/InvoiceForm.js"></script>
	<script type="text/javascript"
		src="././resources/assets/js/Monthly.js"></script>

</body>
</html>