<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <html>

    <head>
        <title>User</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- Bootstrap Styles-->
        <link href="<c:url value="./resources/css/bootstrap.css" />" rel="stylesheet">
        <!-- FontAwesome Styles-->
        <link href="<c:url value="./resources/css/font-awesome.css" />" rel="stylesheet">
        <!-- Morris Chart Styles-->

        <!-- Custom Styles-->
        <link href="<c:url value="./resources/css/custom-styles.css" />" rel="stylesheet">
        <!-- Google Fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- TABLE STYLES-->
        <link href="<c:url value="./resources/js/dataTables/dataTables.bootstrap.css" />" rel="stylesheet">
    </head>

    <body>
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h2>User page</h2>
                        <br> </br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                          <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Logout</a>
                          <br> </br>
                    </div>
                </div>
               
                    
            </div>
        </div>

        
   <script src="./resources/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="./resources/js/bootstrap.min.js"></script>
    </body>
</html>