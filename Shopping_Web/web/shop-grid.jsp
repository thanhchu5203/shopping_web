<%-- 
    Document   : shop-grid
    Created on : Mar 10, 2024, 6:07:16 PM
    Author     : Lewis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <!-- Meta Tag -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name='copyright' content=''>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Title Tag  -->
        <title>Eshop - eCommerce HTML5 Template.</title>
        <!-- Favicon -->
        <link rel="icon" type="image/png" href="images/favicon.png">
        <!-- Web Font -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

        <!-- StyleSheet -->

        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.css">
        <!-- Fancybox -->
        <link rel="stylesheet" href="css/jquery.fancybox.min.css">
        <!-- Themify Icons -->
        <link rel="stylesheet" href="css/themify-icons.css">
        <!-- Jquery Ui -->
        <link rel="stylesheet" href="css/jquery-ui.css">
        <!-- Nice Select CSS -->
        <link rel="stylesheet" href="css/niceselect.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Flex Slider CSS -->
        <link rel="stylesheet" href="css/flex-slider.min.css">
        <!-- Owl Carousel -->
        <link rel="stylesheet" href="css/owl-carousel.css">
        <!-- Slicknav -->
        <link rel="stylesheet" href="css/slicknav.min.css">

        <!-- Eshop StyleSheet -->
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <style>
            .pagination {
                display: inline-block;
                margin-left: 80%;
            }
            .pagination a {
                color: black;
                font-size: 15px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }
            .pagination a.active {
                background-color: #4CAF50;
                color: white;
                border: aqua;
            }
            .pagination a:hover:not(.active) {
                background-color: #4CAF50;
            }
        </style>


    </head>
    <body class="js">

        <!-- Preloader -->
        <!--        <div class="preloader">
                    <div class="preloader-inner">
                        <div class="preloader-icon">
                            <span></span>
                            <span></span>
                        </div>
                    </div>
                </div>-->
        <!-- End Preloader -->

        <jsp:include page="header1.jsp"/>

        <!-- Breadcrumbs -->
        <div class="breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="bread-inner">
                            <ul class="bread-list">
                                <li><a href="home">Home<i class="ti-arrow-right"></i></a></li>
                                <li class="active"><a href="shop">Shop Grid</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Breadcrumbs -->

        <!-- Product Style -->
        <c:set var="n" value="${requestScope.numperpage}"/>
        <c:set var="p" value="${requestScope.data}"/>
        <c:set var="sort" value="${requestScope.sortType}"/>
        <c:set var="from" value="${requestScope.fromPrice}"/>
        <c:set var="to" value="${requestScope.toPrice}"/>
        <c:set var="ser" value="${requestScope.search}"/>
        <form id="f1" action="shop">
            <section class="product-area shop-sidebar shop section">
                <div class="container">

                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-12">
                            <div class="shop-sidebar">
                                <!-- Single Widget -->
                                <div class="single-widget category">
                                    <h3 class="title">Categories</h3>
                                    <ul class="categor-list">
                                        <c:forEach items="${requestScope.cate}" var="c">
                                            <li><a  class="${c.categoryID==id?'active':''}" href="shop?numperpage=${n}&id=${c.categoryID}&sortType=${sort}&fromPrice=${from}&toPrice=${to}&search=${ser}">${c.categoryName}</a><br></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                                <!--/ End Single Widget -->
                                <!-- Shop By Price -->
                                <div class="single-widget range">
                                    <h3 class="title">Shop by Price</h3>
                                    <div class="label-input" >
                                        <span>Range:</span><input style="border: 1px" type="text" name="fromPrice" value="${param.fromPrice}" placeholder="From Price"/>
                                        -->
                                        <input onchange="change()" type="text" name="toPrice" value="${param.toPrice}" placeholder="To Price"/>
                                    </div>                                    
                                </div>
                                <!--/ End Shop By Price -->

                            </div>
                        </div>
                        <div class="col-lg-9 col-md-8 col-12">
                            <div class="row">
                                <div class="col-12">
                                    <!-- Shop Top -->
                                    <div class="shop-top">
                                            <div class="shop-shorter">
                                                <div class="single-shorter">
                                                    <label>Show :</label>
                                                    <select onchange="change()" name="numperpage">
                                                        <option ${n==9?"selected":""} value="9">9</option>
                                                        <option ${n==12?"selected":""} value="12">12</option>
                                                    </select>
                                                </div>
                                                <div class="single-shorter">
                                                    <label>Sort By :</label>
                                                    <select onchange="change()" name="sortType">
                                                        <option ${sort=="order by p.productName asc"?"selected":""} value="order by p.productName asc">Sort ascending by Name</option>
                                                        <option ${sort=="order by p.productName desc"?"selected":""} value="order by p.productName desc">Sort descending by Name</option>
                                                        <option ${sort=="order by p.productPrice asc"?"selected":""} value="order by p.productPrice asc">Sort ascending by Price</option>
                                                        <option ${sort=="order by p.productPrice desc"?"selected":""} value="order by p.productPrice desc">Sort descending by Price</option>
                                                    </select>
                                                </div>
                                                <input type="submit" hidden value="This">
                                            </div>
                                        <ul class="view-mode">
                                            <li class="active"><a href="shop"><i class="fa fa-th-large"></i></a></li>
                                            <li><a href="shop"><i class="fa fa-th-list"></i></a></li>
                                        </ul>
                                    </div>
                                    <!--/ End Shop Top -->
                                </div>
                            </div>
                            <div class="row">
                                <c:forEach var="p" items="${requestScope.data}">
                                    <div class="col-lg-4 col-md-6 col-12">
                                        <div class="single-product">
                                            <div class="product-img">
                                                <a href="productdetail?id=${p.productID}">
                                                    <img class="default-img" src="${p.productImage}" alt="#">
                                                    <img class="hover-img" src="${p.productImage}" alt="#">
                                                </a>
                                                <div class="button-head">
                                                    <div class="product-action">
                                                        <a style="margin-right: 10px" data-toggle="modal" data-target="#exampleModal" 
                                                           title="Quick View" href="">${p.productStock}</a>
                                                    </div>
                                                    <div class="product-action-2">
                                                        <a title="Add to cart" href="productdetail?id=${p.productID}">Add to cart</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="product-content">
                                                <h3><a href="#">${p.productName}</a></h3>
                                                <div class="product-price">
                                                    <span>$${p.productPrice}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <c:set var="page" value="${requestScope.page}"/>
                            <div class="pagination">
                                <c:forEach begin="1" end="${requestScope.num}" var="i">
                                    <a class="${i==page?'active':''}" href="shop?numperpage=${n}&page=${i}&id=${id}&sortType=${sort}&fromPrice=${from}&toPrice=${to}&search=${ser}">${i}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                </div>
            </section>
        </form>              
        <!--/ End Product Style 1  -->	

        <!-- Start Shop Newsletter  -->
        <section class="shop-newsletter section">
            <div class="container">
                <div class="inner-top">
                    <div class="row">
                        <div class="col-lg-8 offset-lg-2 col-12">
                            <!-- Start Newsletter Inner -->
                            <div class="inner">
                                <h4>Newsletter</h4>
                                <p> Subscribe to our newsletter and get <span>10%</span> off your first purchase</p>
                                <form action="mail/mail.php" method="get" target="_blank" class="newsletter-inner">
                                    <input name="EMAIL" placeholder="Your email address" required="" type="email">
                                    <button class="btn">Subscribe</button>
                                </form>
                            </div>
                            <!-- End Newsletter Inner -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Shop Newsletter -->

        <jsp:include page="footer.jsp"/>


        <!-- Jquery -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.0.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <!-- Popper JS -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap JS -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Color JS -->
        <script src="js/colors.js"></script>
        <!-- Slicknav JS -->
        <script src="js/slicknav.min.js"></script>
        <!-- Owl Carousel JS -->
        <script src="js/owl-carousel.js"></script>
        <!-- Magnific Popup JS -->
        <script src="js/magnific-popup.js"></script>
        <!-- Fancybox JS -->
        <script src="js/facnybox.min.js"></script>
        <!-- Waypoints JS -->
        <script src="js/waypoints.min.js"></script>
        <!-- Countdown JS -->
        <script src="js/finalcountdown.min.js"></script>
        <!-- Nice Select JS -->
        <script src="js/nicesellect.js"></script>
        <!-- Ytplayer JS -->
        <script src="js/ytplayer.min.js"></script>
        <!-- Flex Slider JS -->
        <script src="js/flex-slider.js"></script>
        <!-- ScrollUp JS -->
        <script src="js/scrollup.js"></script>
        <!-- Onepage Nav JS -->
        <script src="js/onepage-nav.min.js"></script>
        <!-- Easing JS -->
        <script src="js/easing.js"></script>
        <!-- Active JS -->
        <script src="js/active.js"></script>

        <script type="text/javascript">
                                                        function change() {
                                                            document.getElementById("f1").submit();
                                                        }
                                                        function change1() {
                                                            document.getElementById("f2").submit();
                                                        }
        </script>
    </body>
</html>
