<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<link rel="stylesheet" href="././resources/assets/css/Invoices.css">

</head>
<body>

	<div class="page-container">
		<h2>Invoices List</h2>
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#CreateInvoiceFormModal">Create An Invoice</button>

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

	<script src="././resources/assets/js/InvoicesMain.js"></script>
	<script type="text/javascript" src="././resources/assets/js/InvoiceForm.js"></script>

</body>
</html>
