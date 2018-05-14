<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<link rel="icon" href="${pageContext.request.contextPath}/resources/assets/img/titleImage.png" type="image/x-icon">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<form action="/E-Invoice_System/createtype" enctype="multipart/form-data" method="post">
		<input id="name" type="text" name="name">
        <input class="file" type="file" name="file">
        <input class="submit" type="button">
    </form>
<script type="text/javascript"
		src="././resources/assets/js/fileinputread.js"></script>
</body>
</html>
