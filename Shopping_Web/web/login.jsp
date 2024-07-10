<%-- 
    Document   : login
    Created on : Mar 13, 2024, 12:32:28 AM
    Author     : Lewis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up Form by Colorlib</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <form action="login" method="post">
            <div class="main">
                <div class="row">
                    <div class="container">
                        <div class="signin-content">
                            <div class="signin-image">
                                <figure><img src="images/signin-image.jpg" alt="sing up image"></figure>
                            </div>
                            <div class="signin-form">
                                <h2 class="form-title">Sign In</h2>
                                <h4 style="color: red">${requestScope.mess}</h4>
                                <div class="form-group">
                                    <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="user" id="user" value="${param.user}" placeholder="User Name"/>
                                </div>
                                <div class="form-group">
                                    <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="pass" id="pass" value="${param.pass}" placeholder="Password"/>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                                </div>
                                <span><a href="register" class="signup-image-link">Create an account</a></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
