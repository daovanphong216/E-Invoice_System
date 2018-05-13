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



<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/HeaderFooterStyle.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/adminPageStyle.css'/>" />





	<link rel="stylesheet" media="screen"
		href="<c:url value='/resources/assets/css/bootstrap-datetimepicker.min.css'/>" />
<script
	src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-datetimepicker.js"></script>





</head>
<body class="admin-body">

	<div class="flex-container">
		<%@ include file="header.jsp"%>
		<%@ include file="AdminSideBar.jsp"%>

		<article class="page-container article">

			<h3 class="title_admin">Manage Users</h3>
			<div class="search-form">
				<div id="input-group" class="row">
					<div class="col-sm-6">
						<form name='f'
							action="${pageContext.request.contextPath}/admin/search"
							method='GET'>
							<div class="col-sm-6">
								<input type="text" class="input-search form-control"
									value="${username}" name="username" id="username-search">
							</div>

							<div class="col-sm-2">
								<button id="button-search" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</div>

							<div class=col-sm-2>
								<div>
									<select id="status-option" name="status">
										<option value="all" ${all}>All</option>
										<option value="active" ${active}>Active</option>
										<option value="deactive" ${deactive}>Deactive</option>
									</select>
								</div>
							</div>
							<div class=col-sm-2>
								<div>
									<select id="role-option" name="role">
										<option value="user" ${searchUser}>User</option>
										<option value="admin" ${searchAdmin}>Admin</option>
									</select>
								</div>
							</div>
							<input type="hidden" value="${page}" name="page" id="page">
						</form>
					</div>
					<div class="group-pickertime col-sm-6">

						<span> <input id="input-time" type="text" readonly
							value=${trigger} > <a href="#" type="button"
							id="trigger_button" class="btn btn-sm btn-warning"><i
								class="glyphicon glyphicon-edit"></i></a>
							<button id="ok-buton" type="button">
								<span class="glyphicon glyphicon-ok"></span>
							</button>
						</span>

					</div>


				</div>
				<div class="row">
				<div class="col-lg-6" id="general_info">
					Totals result: ${totalResults} | Active: ${activeAccount} | Deactive: ${deactiveAccount} 
				</div>
			</div>
			</div>
			


			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content t-modal">
						<%@ include file="datetimepicker.jsp"%>
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

							<c:forEach items="${searchResults}" var="record" varStatus="loop">
								<tr>
									<td>${loop.index}</td>
									<td><a
										href='${pageContext.request.contextPath}/userinfo/${record.id}'>${record.userName}</a></td>
									<c:if test="${record.active==true}">
										<td>Active</td>
										<c:if test="${record.userName!='admin'}">
										<td><a href='#' account_id='${record.id}' status='active'
											pos='${loop.index}'>Deactive this account</a></td>
										</c:if>
										<c:if test="${record.userName=='admin'}">
										<td>Default admin</td>
										</c:if>
									</c:if>
									<c:if test="${record.active==false}">
										<td>Deactive</td>
										<c:if test="${record.userName!='admin'}">
											<td><a href='#' account_id='${record.id}' status='deactive'
												pos='${loop.index}'>Active this account</a></td>
										</c:if>	
										<c:if test="${record.userName=='admin'}">
										<td>Default admin</td>
										</c:if>
									</c:if>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>



			<div class="col-lg-12">
				<div class="pager-center">
					<ul id="pager" class="pagination">
						<c:forEach begin="0" end="8" var="index">
							<c:if test="${pageValue[index]!=''}">
								<c:if test="${pageState[index]==-1}">
									<li class='page-item disabled'><a class='page-link'
										href='#'>${pageValue[index]}</a></li>
								</c:if>
								<c:if test="${pageState[index]==0}">
									<li class='page-item'><a class='page-link'
										href='${pageContext.request.contextPath}/admin/search/?username=${username}&status=${status}&role=${role}&page=${pageLink[index]}'>${pageValue[index]}</a></li>
								</c:if>
								<c:if test="${pageState[index]==1}">
									<li class='page-item active'><a class='page-link'
										href='${pageContext.request.contextPath}/admin/search/?username=${username}&status=${status}&role=${role}&page=${pageLink[index]}'>${pageValue[index]}</a></li>
								</c:if>

							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>


		</article>
		<%@ include file="footer.jsp"%>



	</div>
</body>

<script
	src="${pageContext.request.contextPath}/resources/assets/js/AdminPage.js"></script>

</html>