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

        </style>
    </head>
    <body>
        <form action="updateproduct" method="post">
            <div class="container">
                <c:set value="${requestScope.pd}" var="pd"/>
                <c:set var="p" value="${requestScope.p}"/>
                <h1>Edit Product</h1>
                <div class="form-group">
                    <input type="hidden" id="id" name="id" value="${p.productID}">
                </div>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" value="${p.productName}">
                </div>
                <div class="form-group">
                    <label for="name">Price:</label>
                    <input type="text" id="price" name="price" value="${p.productPrice}">
                </div>
                <div class="form-group">
                    <label for="name">Image:</label>
                    <input type="text" id="image" name="image" value="${p.productImage}">
                </div>
                <div class="form-group">
                    <label for="name">Stock:</label>
                    <input type="text" id="stock" name="stock" value="${p.productStock}">
                </div>
                <div class="form-group">
                    <label for="name">Describle:</label>
                    <input type="text" id="des" name="des" value="${p.productDescrible}">
                </div>
                <div class="form-group">
                    <label for="name">Status:</label>
                    <input type="text" id="status" name="status" value="${p.productStatus?"1":""}">
                </div>
                <div class="form-group">
                    <label for="name">Size:</label>
                    <input type="text" id="size" name="size" value="${pd.productDetailSize}">
                </div>
                <div class="form-group">
                    <label for="name">Color:</label>
                    <input type="text" id="color" name="color" value="${pd.productDetailColor}">
                </div>
                
                <div class="form-group">
                    <button class="btn" type="submit">
                        Update Product
                    </button>
                </div>
            </div>
        </form>
    </body>
</html>