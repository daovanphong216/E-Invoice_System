<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>User Info</title>
<link rel="icon" href="${pageContext.request.contextPath}/resources/assets/img/titleImage.png" type="image/x-icon">
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

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>





<title>E-Invoice System</title>

<link rel="stylesheet"
	href="<c:url value='../resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='../resources/assets/css/UserInfoStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='../resources/assets/css/adminPageStyle.css'/>" />


</head>
<body>
	<div class="flex-container">
		<%@ include file="header.jsp"%>
		<%@ include file="AdminSideBar.jsp"%>
		<article class="page-body article">

			<div class="">
				<!-- Modal -->
				<div class="row">
					<div
						class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


						<div class="panel panel-info">
							<div class="panel-heading" id="nameStr">
								<h3 class="panel-title">${user.name}</h3>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-3 col-lg-3 " align="center">
										<img alt="User Pic"
											src="${pageContext.request.contextPath}/resources/assets/img/userpic.png"
											class="img-circle img-responsive">
									</div>

									<div class=" col-md-9 col-lg-9 ">
										<table class="table table-user-information">
											<tbody>
												<tr>
													<td>Username:</td>
													<td>${username}</td>
													</tr>
												<tr id="addressStr">
													<td>Address</td>
													<td>${user.address}</td>
												</tr>
												<tr id="emailStr">
													<td>Email</td>
													<td>${user.email}</td>
												</tr>
												<tr id="phoneStr">
													<td>Phone Number</td>
													<td>${user.phoneNumber}</td>
												</tr>

											</tbody>
										</table>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</article>

		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>