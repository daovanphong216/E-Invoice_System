<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>" />
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>



<title>E-Invoice System</title>

<link rel="stylesheet" href="<c:url value='././resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet" href="<c:url value='././resources/assets/css/UserInfoStyle.css'/>" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="sideBar.jsp"%>
	<div class="page-body">
		<div class="container">
			<div class="row">
				<div
					class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Name Nguyen</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3 col-lg-3 " align="center">
									<img alt="User Pic" src="resources/assets/img/userpic.png"
										class="img-circle img-responsive">
								</div>

								<div class=" col-md-9 col-lg-9 ">
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td>Username:</td>
												<td>ABC XYZ</td>
											<tr>
												<td>Address</td>
												<td>Tran Duy Hung, Ha Noi</td>
											</tr>
											<tr>
												<td>Email</td>
												<td><a
													href="https://www.google.com.vn/webhp?hl=vi&ictx=2&sa=X&ved=0ahUKEwiYrcralOvaAhVW6LwKHadeCWAQPQgD">searchgoogle@gmail.com</a></td>
											</tr>
											<td>Phone Number</td>
											<td>123-4567-890 (Tel)<br>
											<br>555-4567-890 (Mobile)
											</td>
											</tr>

										</tbody>
									</table>

								</div>
							</div>
						</div>
						<div class="panel-footer">
							<span class="pull-right"> <a href="edit.html"
								data-original-title="Edit this user" data-toggle="tooltip"
								type="button" class="btn btn-sm btn-warning"><i
									class="glyphicon glyphicon-edit"></i></a>
							</span>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>