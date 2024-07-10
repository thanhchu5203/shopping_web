<%-- 
    Document   : manager-account
    Created on : Mar 15, 2024, 11:27:19 AM
    Author     : Lewis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!doctype html>
<html class="no-js h-100" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Shards Dashboard Lite - Free Bootstrap Admin Template – DesignRevision</title>
        <meta name="description" content="A high-quality &amp; free Bootstrap admin dashboard template pack that comes with lots of templates and components.">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" id="main-stylesheet" data-version="1.1.0" href="styles/shards-dashboards.1.1.0.min.css">
        <link rel="stylesheet" href="styles/extras.1.1.0.min.css">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <!-- Web Font -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

        <!-- StyleSheet -->


        <link rel="stylesheet" href="css/themify-icons.css">

        <script async defer src="https://buttons.github.io/buttons.js"></script>
    </head>
    <%  ResultSet rs =  (ResultSet) request.getAttribute("list");%>
    <body class="h-100">

        <div class="container-fluid">
            <div class="row">
                <jsp:include page="left-dashboard.jsp"/>
                <main class="main-content col-lg-10 col-md-9 col-sm-12 p-0 offset-lg-2 offset-md-3">
                    <div class="main-navbar sticky-top bg-white">

                        <!-- / .main-navbar -->
                        <div class="main-content-container container-fluid px-4">
                            <!-- Page Header -->
                            <div class="page-header row no-gutters py-4">
                                <div class="col-12 col-sm-4 text-center text-sm-left mb-0">
                                    <span class="text-uppercase page-subtitle">Overview</span>
                                    <h3 class="page-title">Data Tables</h3>
                                </div>
                            </div>
                            <!-- End Page Header -->
                            <!-- Default Light Table -->
                            <div class="row">
                                <div class="col">
                                    <div class="card card-small mb-4">
                                        <div class="card-header border-bottom">
                                            <h6 class="m-0">Product</h6>
                                            <div>
                                                <a href="insertproduct" style="margin-top: 10px; margin-left: 0px" class="btn btn-primary btn-group">Add product</a>
                                            </div>
                                        </div>

                                        <div class="card-body p-0 pb-3 text-center">
                                            <table class="table mb-0">
                                                <thead class="bg-light">
                                                    <tr>
                                                        <th scope="col" class="border-0">STT</th>
                                                        <th scope="col" class="border-0">Name</th>
                                                        <th scope="col" class="border-0">Price</th>
                                                        <th scope="col" class="border-0">URL Image</th>
                                                        <th scope="col" class="border-0">Stock</th>
                                                        <th scope="col" class="border-0">Describle</th>
                                                        <th scope="col" class="border-0">Size</th>
                                                        <th scope="col" class="border-0">Color</th>
                                                        <th scope="col" class="border-0">Action</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%--<c:set var="pd" value="${requestScope.pd}"/>--%>
                                                    <%--<c:forEach var="p" items="${requestScope.listproduct}" varStatus="loop">--%>
                                                    <%
                                                        int count = 1;
                                                        while(rs.next()){%>
                                                    <tr>
                                                        <td><%= count++ %></td>
                                                        <td><%=rs.getString(2)%></td>
                                                        <td><%=rs.getInt(3)%></td>
                                                        <td><%=rs.getString("productImage")%></td>
                                                        <td><%=rs.getInt("productStock")%></td>
                                                        <td><%=rs.getString("productDescrible")%></td>
                                                        <td><%=rs.getString("productDetailSize")%></td>
                                                        <td><%=rs.getString("productDetailColor")%></td>

                                                        <td style="width: 100px">
                                                            <a href="updateproduct?id=<%=rs.getInt("productID")%>">Edit</a>&nbsp&nbsp&nbsp&nbsp
                                                            <a href="deleteproduct?id=<%=rs.getInt("productID")%>" class="ti-trash edit-icon"></a>
                                                        </td>

                                                    </tr>
                                                    <%}%>

                                                    <%--</c:forEach>--%>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Default Light Table -->

                        </div>
                </main>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
        <script src="https://unpkg.com/shards-ui@latest/dist/js/shards.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Sharrre/2.0.1/jquery.sharrre.min.js"></script>
        <script src="scripts/extras.1.1.0.min.js"></script>
        <script src="scripts/shards-dashboards.1.1.0.min.js"></script>

    </body>
</html>
