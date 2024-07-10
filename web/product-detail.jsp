<%-- 
    Document   : product-detail
    Created on : Mar 10, 2024, 9:39:28 PM
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


    </head>
    <body class="js">

<!--         Preloader 
        <div class="preloader">
            <div class="preloader-inner">
                <div class="preloader-icon">
                    <span></span>
                    <span></span>
                </div>
            </div>
        </div>
         End Preloader -->

        <jsp:include page="header1.jsp"/>
        <c:set var="p" value="${requestScope.product}"/>
        <!-- Breadcrumbs -->
        <div class="breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="bread-inner">
                            <ul class="bread-list">
                                <li><a href="home">Home<i class="ti-arrow-right"></i></a></li>
                                <li class="active"><a href="productdetail?id=${p.productID}">${p.category.categoryName}</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Breadcrumbs -->

        <!-- Start Blog Single -->
        <!-- Modal -->
        
        <div class="modal-body">
            
            <div class="row no-gutters col-12">
                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <!-- Product Slider -->
                    <div class="product-gallery">
                        <img src="${p.productImage}" style="width: 85%; margin-left: 60px" alt="#">
                    </div>
                    <!-- End Product slider -->
                </div>
                <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <div class="quickview-content">
                        <h2>${p.productName}</h2>
                        
                        <h3>$${p.productPrice}</h3>
                        <div class="quickview-peragraph">
                            <p>${p.productDescrible}</p>
                        </div>
                        <div class="size">
                            <div class="row">
                                <div class="col-lg-6 col-12">
                                    <h5 class="title">Size</h5>
                                    <select>
                                        <c:forEach var="s" items="${requestScope.size}">
                                            <option>${s}</option>
                                        </c:forEach>
                                            <!--<option selected="selected">S</option>-->
                                    </select>
                                </div>
                                <div class="col-lg-6 col-12">
                                    <h5 class="title">Color</h5>
                                    <select>
                                        <c:forEach var="s" items="${requestScope.color}">
                                            <option selected="selected">${s}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
<!--                        <div class="quantity" >
                             Input Order 
                            <div class="input-group">
                                <div class="button minus">
                                    <button type="button" class="btn btn-primary btn-number" disabled="disabled" data-type="minus" data-field="quant[1]">
                                        <i class="ti-minus"></i>
                                    </button>
                                </div>
                                <input type="text" name="quant[1]" class="input-number"  data-min="1" data-max="1000" value="1">
                                <div class="button plus">
                                    <button type="button" class="btn btn-primary btn-number" data-type="plus" data-field="quant[1]">
                                        <i class="ti-plus"></i>
                                    </button>
                                </div>
                            </div>
                            / End Input Order 
                        </div>-->
                        <div class="add-to-cart">
                            <a href="cart?num=${sessionScope.num}&id=${p.productID}" class="btn">Add to cart</a>
                        </div>
                        <div class="default-social">
                            <h4 class="share-now">Share:</h4>
                            <ul>
                                <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
    </body>
</html>