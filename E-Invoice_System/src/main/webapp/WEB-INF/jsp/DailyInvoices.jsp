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
	<%@ include file="header.jsp"%>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="sideBar.jsp"%>
		</div>
		<div class="col-sm-10">
			<div class="page-container">
				<h2>Invoices List</h2>
				

				<!-- Modal -->
				<div class="modal fade" id="CreateInvoiceFormModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<%@ include file="invoiceform.jsp"%>
						</div>

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
				<hr>
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<table class="table calendar-table"></table>
					</div>
				</div>
			</div>

			<div class="selectedView list pageAll P-List-invoice list-group">

			</div>
			<!-- Trigger the modal with a button -->
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#CreateInvoiceFormModal">Create
					An Invoice</button>
			<%@ include file="footer.jsp"%>
		</div>
	</div>
	<script type="text/javascript"
			src="././resources/assets/js/calendar.js"></script>
		<script src="././resources/assets/js/InvoicesMain.js"></script>
		<script type="text/javascript"
			src="././resources/assets/js/InvoiceForm.js"></script>
	
</body>
</html>