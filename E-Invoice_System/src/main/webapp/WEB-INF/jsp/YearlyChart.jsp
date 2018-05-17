<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
</head>
<body>

		<h1 class="text-center">
					<a id="yleft" href="#"><</a> <span>&nbsp;</span>
					<span>&nbsp;</span><span id="yyear"> </span> <span>&nbsp;</span> <a
						id="yright" href="#">></a>
		</h1>
		<div id="piechart"></div>
		<h3 class="yearChart">Total of money use monthly</h3>
		<hr>
	<script type="text/javascript"
		src="././resources/assets/js/Yearly.js"></script>

</body>
</html>