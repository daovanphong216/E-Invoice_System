<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title>Daily Invoices</title>
<link rel="icon" href="${pageContext.request.contextPath}/resources/assets/img/titleImage.png" type="image/x-icon">
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

</head>
<body>
<div class= "flex-container">
	<%@ include file="header.jsp"%>
	<%@ include file="sideBar.jsp"%>

	<article class="page-container article">
	
		<div class="page-title">
			<h2>Invoices List</h2>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="CreateInvoiceFormModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<%@ include file="invoiceform.jsp"%>
				</div>

			</div>
		</div>
		
		
		<div class="modal fade" id="UpdateInvoiceFormModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<%@ include file="updateinvoiceform.jsp"%>
				</div>

			</div>
		</div>
		
		
		<div class="modal fade" role="dialog" id= "SetLimitMonneyModal">
			<div class="modal-dialog">
			<div class="modal-content">
					<%@ include file="limitmoneyform.jsp"%>
				</div>
			</div>
		</div>
		<div class="modal fade" role="dialog" id= "AddInvoiceTypeModal">
			<div class="modal-dialog">
			<div class="modal-content">
					<%@ include file="AddInvoiceTypeForm.jsp"%>
				</div>
			</div>
		</div>
		
		

		<div class="cal-container" id="main">
			<div class="calendar-title">
				<h1 class="text-center">
					<a id="left" href="#"><</a> <span>&nbsp;</span> <span id="month"></span>
					<span>&nbsp;</span><span id="year"> </span> <span>&nbsp;</span> <a
						id="right" href="#">></a>
				</h1>
			</div>
			<div class="calendar-content">
				<table class="table calendar-table"></table>
			</div>
		</div>
		
		<div class="list-container">
			<div class="list-title">
				<h1 class="text-center">
					Invoices
				</h1>
			</div>
			<div class="selectedView list pageAll P-List-invoice list-group"></div>
		</div>
		<div class="infor">
			<span><b>Total of date: $</b></span><span class= "totalDateMoney">0.00</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<span><b>Total of month: $</b></span><span class= "totalMonthMoney">0.00</span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span><b>Limited Money: $</b></span><span class= "limitedMoney">0.00</span>
		</div>
		
		<div class="buttons">
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#CreateInvoiceFormModal">Create An Invoice</button>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#SetLimitMonneyModal">Reset Limited Money</button>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#AddInvoiceTypeModal">Add Type</button>
		</div>
		

	</article>

	

	<%@ include file="footer.jsp"%>
</div>
	<script type="text/javascript"
		src="././resources/assets/js/calendar.js"></script>
	<script src="././resources/assets/js/InvoicesMain.js"></script>
	<script type="text/javascript"
		src="././resources/assets/js/InvoiceForm.js"></script>
	<script type="text/javascript"
		src="././resources/assets/js/Setlimit.js"></script>

</body>
</html>