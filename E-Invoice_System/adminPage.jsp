<%@page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <html>

    <head>
        <title>${title}</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- Bootstrap Styles-->
        <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet">
        <!-- FontAwesome Styles-->
        <link href="<c:url value="resources/css/font-awesome.css" />" rel="stylesheet">
        <!-- Morris Chart Styles-->

        <!-- Custom Styles-->
        <link href="<c:url value="resources/css/custom-styles.css" />" rel="stylesheet">
        <!-- Google Fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- TABLE STYLES-->
        <link href="<c:url value="resources/js/dataTables/dataTables.bootstrap.css" />" rel="stylesheet">
    </head>

    <body>
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
                        <br> </br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                          <a href="${pageContext.request.contextPath}/add" class="btn btn-primary">Add Product</a>
                          <br> </br>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                All Products
                            </div>
                            <div class="panel-body">
                                 <form:form method="POST" modelAttribute="select" action="${pageContext.request.contextPath}/del">
                                     <div class="row">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                <thead>
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Name</th>
                                                        <th>Price</th>
                                                        <th>Number</th>
                                                        <th>Details</th>
                                                        <th>Edit</th>
                                                        <th>Delete</th>
                                                        <th>Select</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="product" items="${productList}">
                                                        <tr>
                                                            <th>${product.masp}</th>
                                                            <th>${product.tensp}</th>
                                                            <th>${product.gia}</th>
                                                            <th>${product.soluong}</th>
                                                            <th>${product.mota}</th>
                                                            <th><a href="${pageContext.request.contextPath}/edit/${product.masp}" class="btn btn-primary">Edit</a></th>
                                                            <th><a href="${pageContext.request.contextPath}/delete/${product.masp}" class="btn btn-danger">Delete</a></th>
                                                            <th><form:checkbox path="selected" value ="${product.masp}" ></form:checkbox></th>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12 text-center"> 
                                            <br></br>
                                            <button type="submit" class="btn btn-danger">Delete Seleted</button>
                                        </div>                                     
                                    </div>
                                </form:form>
                            </div>
                        </div>
                        <!--End Advanced Tables -->
                    </div>
                </div>
            </div>
        </div>

        
   <script src="resources/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="resources/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="resources/js/jquery.metisMenu.js"></script>
    <!-- DATA TABLE SCRIPTS -->
    <script src="resources/js/dataTables/jquery.dataTables.js"></script>
    <script src="resources/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
        $(document).ready(function() {
            $('#dataTables-example').dataTable();
        });
    </script>
    <script type="text/javascript" src="resources/js/jconfirmaction.jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('.ask').jConfirmAction();
        });
    </script>
    <!-- Custom Js -->
    <script src="resources/js/custom-scripts.js"></script>
    </body>
</html>