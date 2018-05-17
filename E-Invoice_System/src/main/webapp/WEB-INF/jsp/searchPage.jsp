<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<head>
<meta charset="utf-8" />
<title>Daily Invoices</title>
<!-- Latest compiled and minified CSS -->
<link rel="icon" href="${pageContext.request.contextPath}/resources/assets/img/titleImage.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="././resources/assets/css/calender.css" />
<link rel="stylesheet" href="././resources/assets/css/list_style.css" />
<link rel="stylesheet" href="././resources/assets/css/Invoices.css">
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/HeaderFooterStyle.css'/>" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>


</head>
<body>
<div class= "flex-container">
	<%@ include file="header.jsp"%>
	<%@ include file="sideBar.jsp"%>
	
	<article class="page-container article">
		<c:if test="${totalResults ==0}">
			<h5>0 invoice founded</h5>
		</c:if>
		<c:if test="${totalResults >0}">
			<h5>From ${from} to ${to} of ${totalResults} invoices founded</h5>
		
		
			<input type="hidden" value="${totalPages}" name="totalPages" id="totalPages">
			<input type="hidden" value="${currentPage}" name="currentPage" id="currentPage">
			<div class="search-result"></div>
			<div class="col-lg-12">
				<div class="pager-center pagination" id="pager"></div>
			</div>
		</c:if>
	</article>
<div class="modal fade" id="UpdateInvoiceFormModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<%@ include file="updateinvoiceform.jsp"%>
				</div>

			</div>
		</div>
	

	<%@ include file="footer.jsp"%>
</div>
	
<script type="text/javascript" src="././resources/assets/js/searchPage.js"></script>	
<script type="text/javascript"
		src="././resources/assets/js/UpdateForm.js"></script>
</body>
</html>