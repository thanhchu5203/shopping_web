<%-- 
    Document   : register
    Created on : Mar 13, 2024, 12:32:34 AM
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
        <form action="register" method="post">
            <div class="main">
                <section class="signup">
                    <div class="container">
                        <div class="signup-content">
                            <div class="signup-form">
                                <h2 class="form-title">Sign up</h2>

                                <%-- Display error message if available --%>
                                <% if (request.getAttribute("error") != null) { %>
                                    <div class="error-message" style="color: red;">
                                        <%= request.getAttribute("error") %>
                                    </div>
                                <% } %>

                                <div class="form-group">
                                    <label for="name"><i class="zmdi "></i></label>
                                    <input type="text" name="name" id="name" placeholder="Your Name" />
                                </div>
                                <div class="form-group">
                                    <label for="user"><i class="zmdi "></i></label>
                                    <input type="text" name="user" id="user" placeholder="User Name" />
                                </div>
                                <div class="form-group">
                                    <label for="pass"><i class="zmdi "></i></label>
                                    <input type="password" name="pass" id="pass" placeholder="Password" />
                                </div>
                                <div class="form-group">
                                    <label for="email"><i class="zmdi "></i></label>
                                    <input type="email" name="email" id="email" placeholder="Email" />
                                </div>
                                <div class="form-group">
                                    <label for="dob"><i class="zmdi "></i></label>
                                    <input type="date" name="dob" id="dob" placeholder="Dob" />
                                </div>
                                <div class="form-group">
                                    <label for="mobile"><i class="zmdi "></i></label>
                                    <input type="text" name="mobile" id="mobile" placeholder="Your Mobile" />
                                </div>
                                <div class="form-group">
                                    <label for="address"><i class="zmdi "></i></label>
                                    <input type="text" name="address" id="address" placeholder="Your Address" />
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                                </div>
                                <span><a href="login" class="signup-image-link">Sign In</a></span>
                            </div>
                            <div class="signup-image">
                                <figure><img src="images/signup-image.jpg" alt="sign up image"></figure>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </form>
        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
