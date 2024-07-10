<%-- 
    Document   : cart
    Created on : Mar 10, 2024, 6:05:20 PM
    Author     : Lewis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Profile</title>
        <link rel="stylesheet" href="styles.css">
        <style>
            /* styles.css */

            .container {
                max-width: 500px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .form-group {
                margin-bottom: 20px;
            }

            label {
                display: block;
                font-weight: bold;
            }

            input[type="text"],
            input[type="email"],
            textarea,
            input[type="date"] {
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
                margin-left: -10px
            }

            button {
                padding: 10px 20px;
                font-size: 16px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            button:hover {
                background-color: #0056b3;


            }
            a {
                color: blue; /* Changes the text color to blue */
                text-decoration: none; /* Removes the underline */
            }

            a:hover {
                color: #fff; /* Changes the text color to red on hover */
            }

        </style>
    </head>
    <body>
        <div class="container">
            <c:set var="a" value="${sessionScope.account}"/>
            <h1>${a.accountName} Profile</h1>
            <div class="form-group">
                <input type="hidden" id="id" name="id" value="${a.accountID}">
            </div>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${a.accountName}">
            </div>
            <div class="form-group">
                <label for="dob">Date of Birth:</label>
                <input type="text" id="dob" name="dob" value="${a.accountDob}">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${a.accountEmail}">
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="mobile" value="${a.accountMobile}">
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" value="${a.accountAddress}">
            </div>
            <div class="form-group">
                <button class="btn">
                    <a href="updateprofile">Edit profile</a>
                </button>
            </div>
        </div>
    </body>
</html>
