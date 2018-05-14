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
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

</head>
<body>
<div class= "flex-container">
	<%@ include file="header.jsp"%>
	<%@ include file="sideBar.jsp"%>

	<article class="page-container article">
		
		<div class='chartspage'>
			<%@ include file="YearlyChart.jsp"%>
		</div>
		
		<div class='chartspage'>
			<%@ include file="MonthlyChart.jsp"%>
		</div>

	</article>

	

	<%@ include file="footer.jsp"%>
</div>

	

</body>
</html>