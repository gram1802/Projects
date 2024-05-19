<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Cart</title>
</head>
<body>
    <h1>My Cart</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Image</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cartItem" items="${cartItems}">
                <tr>
                    <td>${cartItem.product.id}</td>
                    <td>${cartItem.product.name}</td> 
                    <td><img src="/images/${cartItem.product.imageName}" alt="Product Image" style="max-width: 100px;"></td> 
                    <td>${cartItem.product.description}</td> 
                    <td>${cartItem.quantity}</td>
                    <td><a href="/deleteCartItem?cartItemId=${cartItem.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
