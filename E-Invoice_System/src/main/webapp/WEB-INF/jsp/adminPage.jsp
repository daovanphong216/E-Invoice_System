<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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
	<script src="./resources/assets/js/ready.js"></script>
</head>
<body class="admin-body">
	<%@ include file="header.jsp"%>
	<%@ include file="AdminSideBar.jsp"%>
	<h3>Manage Users</h3>
	<div class="search-form" action="" method="GET">
		<div id="input-group" class="row">
			<div class="col-lg-3">
				<input id="input-search" type="text" class="form-control"
					placeholder="Search...">
			</div>

			<div class="col-lg-1">
				<button id="button-search" type="button">
					<i class="fa fa-search"></i>
				</button>
			</div>

			<div class=col-lg-2>
                <div >
                    <select id= "select-option">
                      <option value="all">All users</option>
                      <option value="active">Active users</li>
                      <option value="deactive">Deactive users</li>
                      </select>
                </div>
            </div>

			<div class="col-lg-6">
				<button id="settime-button" type="button" placeholder="Setime Alert">
					<i class="fa fa-clock-o"></i>
				</button>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">
				<h5>Please enter a search or view all users</h5>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="tableGroup">
			<table class="listTable">
				<thead>
					<tr>
						<th>Full Name</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody id="table_body">
				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>