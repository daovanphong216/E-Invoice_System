<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>


<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/adminPageStyle.css'/>" />





<link rel="stylesheet" media="screen"
	href="<c:url value='/resources/assets/css/bootstrap-datetimepicker.min.css'/>" />
<script src="./resources/assets/js/bootstrap-datetimepicker.js"></script>
<script
	src="./resources/assets/js/locales/bootstrap-datetimepicker.fr.js"></script>
<script
	src="./resources/assets/js/locales/bootstrap-datetimepicker.min.css"></script>


</head>
<body class="admin-body">
	<%@ include file="header.jsp"%>
	<%@ include file="AdminSideBar.jsp"%>
	<h3>Manage Users</h3>
	<div class="search-form">
		<div id="input-group" class="row">
			<div class="col-sm-3">
				<input id="input-search" type="text" class="form-control"
					placeholder="Search...">
			</div>

			<div class="col-sm-1">
				<button id="button-search" type="button">
					<i class="fa fa-search"></i>
				</button>
			</div>

			<div class=col-sm-2>
				<div>
					<select id="select-option">
						<option value="all">All users</option>
						<option value="active">Active users
							</li>
						<option value="deactive">Deactive users
							</li>
					</select>
				</div>
			</div>

			<div class=col-sm-2></div>

			<div class="group-pickertime">
				<div id="settime-group" class="col-sm-3">
					<div action="" class="form-horizontal" role="form">
						<div>
							<div class="input-group date form_datetime"
								data-date-format="dd MM yyyy - HH:ii p">
								<input id="datetimepicker"
									placeholder="Click to setting time alert" class="form-control"
									size="16" type="text" readonly value=${trigger}> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-time"></span>
								</span>

							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-1">
				<button id="ok-buton" type="button">
					<span class="glyphicon glyphicon-ok"></span>
				</button>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6" id="general_info">
			</div>
		</div>
	</div>
	

	<div class="row">
		<div class="tableGroup">
			<table class="listTable">
				<thead>
					<tr>
						<th>No</th>
						<th>Full Name</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="table_body">
				</tbody>
			</table>
		</div>
	</div>
	</div>


	<div class="col-lg-12">
		<div  class="pager-center">
			<ul id="pager" class="pagination">
			</ul>
		</div>
	</div>


	<%@ include file="footer.jsp"%>
</body>
<script src="./resources/assets/js/RegisterFunction.js"></script>
<script src="./resources/assets/js/AdminPage.js"></script>
</html>