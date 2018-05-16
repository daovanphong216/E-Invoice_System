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
			<input type="month" name="mmonth">
		</h1>
		<div id="barchart"></div>
		<div id="linechart"></div>
	


	<script type="text/javascript"
		src="././resources/assets/js/Monthly.js"></script>

</body>
</html>