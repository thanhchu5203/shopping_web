<%-- 
    Document   : header
    Created on : Mar 9, 2024, 10:36:29 AM
    Author     : Lewis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Shop</title>
    </head>
    <body>
        <!-- Header -->
        <header class="header shop">
            <!-- Topbar -->
            <div class="topbar">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-12 col-12">
                            <!-- Top Left -->
                            <!--/ End Top Left -->
                        </div>
                        <div class="col-lg-8 col-md-12 col-12">
                            <!-- Top Right -->
                            <div class="right-content">
                                <ul class="list-main">
                                    <c:if test="${account.accountUser eq 'admin'}">
                                        <li><img src="images/avatars/1.jpg" style="width: 20px" alt="alt"/> <a href="managerproduct">My account</a></li>
                                        </c:if>
                                    <li><i class="ti-user"></i> <a href="profile">My account</a></li>
                                    <li><a href="login">Login</a></li>
                                    <li><i class="ti-power-off"></i><a href="logout">Logout</a></li>
                                </ul>
                            </div>
                            <!-- End Top Right -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Topbar -->
            <div class="middle-inner">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-12">
                            <!-- Logo -->
                            <div class="logo">
                                <a href="home"><img src="images/logo99.png" style="width: 85px; height: 52px" alt="logo"></a>
                            </div>
                            <!--/ End Logo -->
                            <!-- Search Form -->
                            <div class="search-top">
                                <div class="top-search"><a href="#0"><i class="ti-search"></i></a></div>
                                <!-- Search Form -->
                                <div class="search-top">
                                    <form class="search-form">
                                        <input type="text" placeholder="Search here..." name="search">
                                        <button value="search" type="submit"><i class="ti-search"></i></button>
                                    </form>
                                </div>
                                <!--/ End Search Form -->
                            </div>
                            <!--/ End Search Form -->
                            <div class="mobile-nav"></div>
                        </div>
                        <div class="col-lg-8 col-md-7 col-12">
                            <div class="search-bar-top">
                                <div class="search-bar">
                                    <form>
                                        <input name="search" placeholder="Search Products Here....." type="text">
                                        <button class="btnn"><i class="ti-search"></i></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-3 col-12">
                            <div class="right-bar">
                                <!-- Search Form -->
                                <div class="sinlge-bar">
                                    <a href="profile" class="single-icon"><i class="fa fa-user-circle-o" aria-hidden="true"></i></a>
                                </div>
                                <div class="sinlge-bar shopping">
                                    <a href="viewcart" class="single-icon"><i class="ti-bag"></i></a>
           
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header Inner -->
            <div class="header-inner">
                <div class="container">
                    <div class="cat-nav-head">
                        <div class="row">
                            <div class="col-lg-3">
                                <div class="all-category">
                                    <h3 class="cat-heading"><i class="fa fa-bars" aria-hidden="true"></i>CATEGORIES</h3>
                                    <ul class="main-category">
                                        <li><a href="shop">New Arrivals <i class="fa fa-angle-right" aria-hidden="true"></i></a>
                                            <ul class="sub-category">
                                                <c:forEach var="c" items="${requestScope.cate}">
                                                    <li><a href="shop?id=${c.categoryID}">${c.categoryName}</a></li>
                                                    </c:forEach>

                                            </ul>
                                        </li>
                                            <c:forEach var="c" items="${requestScope.cate}">
                                            <li><a href="shop?id=${c.categoryID}">${c.categoryName}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-9 col-12">
                                <div class="menu-area">
                                    <!-- Main Menu -->
                                    <nav class="navbar navbar-expand-lg">
                                        <div class="navbar-collapse">	
                                            <div class="nav-inner">	
                                                <ul class="nav main-menu menu navbar-nav">
                                                    <li class="active"><a href="home">Home</a></li>
                                                    <li><a href="shop">Product</a></li>												

                                                    <li><a href="shop">Shop<i class="ti-angle-down"></i><span class="new">New</span></a>
                                                        <ul class="dropdown">
                                                            <li><a href="shop">Shop Grid</a></li>
                                                            <li><a href="viewcart">Cart</a></li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </nav>
                                    <!--/ End Main Menu -->	
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/ End Header Inner -->
        </header>
        <!--/ End Header -->
    </body>
</html>
