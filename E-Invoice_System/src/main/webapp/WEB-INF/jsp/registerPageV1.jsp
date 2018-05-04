 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <html>

    <head>
        <title>Register</title>
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
                     <div class="col-lg-12 text-center">
                        <h2>Register</h2>
                        <br> </br>
                    </div>
                </div>             
                <!-- /. ROW  -->
                 <div class="row">
                    <div class="col-md-12 text-center">
                        <c:if test="${param.error == 'true'}">
                            <div style="color:red;margin:10px 0px;">

                                   Register Failed!!!<br />
                                   Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

                            </div>
                       </c:if>
                    </div>
                </div> 
               <div class="row">
                     <div class="col-lg-12 text-center">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               Enter user name and password:
                            </div>
                            <div class="panel-body">
                                <form name='f' action="./register" method='POST'>
                                    <div class="row">
                                        <div class="col-lg-3">
                                        </div>
                                        <div class="col-lg-6 ">
                                           <div class="form-group">
                                                <label>Username</label>
                                                <input type='text' name='username' class="form-control" value=''>
                                            </div>
                                            <div class="form-group">
                                                 <label>Password</label>
                                                <input type='password' name='password' class="form-control" />
                                            </div>  
                                        </div>
                                    <div class="row">
                                        <div class="col-lg-12 text-center">
                                        <input name="submit" type="submit" value="Register" class = "btn btn-primary"/>
                                        </div>
                                    </div>                                 
                                </form>

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


    </body>
</html>