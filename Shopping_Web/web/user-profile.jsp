<%-- 
    Document   : manager-account
    Created on : Mar 15, 2024, 11:27:19 AM
    Author     : Lewis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <body class="h-100">


        <div class="container-fluid">
            <div class="row">
                <jsp:include page="left-dashboard.jsp"/>
                <main class="main-content col-lg-10 col-md-9 col-sm-12 p-0 offset-lg-2 offset-md-3">
                    <div class="main-navbar sticky-top bg-white">

                        <!-- / .main-navbar -->
                        <div class="row">
                            <div class="main-content-container container-fluid px-4">
                                <!-- Page Header -->
                                <div class="page-header row no-gutters py-4">
                                    <div class="col-12 col-sm-4 text-center text-sm-left mb-0">
                                        <span class="text-uppercase page-subtitle">Overview</span>
                                        <h3 class="page-title">User Profile</h3>
                                    </div>
                                </div>
                                <!-- End Page Header -->

                                <div class="col-lg-12">
                                    <div class="card card-small mb-4">
                                        <div class="card-header border-bottom">
                                            <h6 class="m-0">Account Details</h6>
                                        </div>
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item p-3">
                                                <div class="row">
                                                    <div class="col">
                                                        <form>
                                                            <div class="form-row">
                                                                <div class="form-group col-md-6">
                                                                    <label for="feFirstName">First Name</label>
                                                                    <input type="text" class="form-control" id="feFirstName" placeholder="First Name" value="Sierra"> </div>
                                                                <div class="form-group col-md-6">
                                                                    <label for="feLastName">Last Name</label>
                                                                    <input type="text" class="form-control" id="feLastName" placeholder="Last Name" value="Brooks"> </div>
                                                            </div>
                                                            <div class="form-row">
                                                                <div class="form-group col-md-6">
                                                                    <label for="feEmailAddress">Email</label>
                                                                    <input type="email" class="form-control" id="feEmailAddress" placeholder="Email" value="sierra@example.com"> </div>
                                                                <div class="form-group col-md-6">
                                                                    <label for="fePassword">Password</label>
                                                                    <input type="password" class="form-control" id="fePassword" placeholder="Password"> </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="feInputAddress">Address</label>
                                                                <input type="text" class="form-control" id="feInputAddress" placeholder="1234 Main St"> </div>
                                                            <div class="form-row">
                                                                <div class="form-group col-md-6">
                                                                    <label for="feInputCity">City</label>
                                                                    <input type="text" class="form-control" id="feInputCity"> </div>
                                                                <div class="form-group col-md-4">
                                                                    <label for="feInputState">State</label>
                                                                    <select id="feInputState" class="form-control">
                                                                        <option selected>Choose...</option>
                                                                        <option>...</option>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group col-md-2">
                                                                    <label for="inputZip">Zip</label>
                                                                    <input type="text" class="form-control" id="inputZip"> </div>
                                                            </div>
                                                            <div class="form-row">
                                                                <div class="form-group col-md-12">
                                                                    <label for="feDescription">Description</label>
                                                                    <textarea class="form-control" name="feDescription" rows="5">Lorem ipsum dolor sit amet consectetur adipisicing elit. Odio eaque, quidem, commodi soluta qui quae minima obcaecati quod dolorum sint alias, possimus illum assumenda eligendi cumque?</textarea>
                                                                </div>
                                                            </div>
                                                            <button type="submit" class="btn btn-accent">Update Account</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>

                                <!-- End Default Light Table -->
                            </div>
                        </div>
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
