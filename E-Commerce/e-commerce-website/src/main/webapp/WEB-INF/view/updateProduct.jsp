<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
<form action="/website/newProduct" method="POST" enctype="multipart/form-data">
    Name : 
    <input type="text" name="name" value="${product.name}">
    <br>
    Select Category : 
    <select name="categoryId">
        <c:forEach var="x" items="${category}">
            <option value="${x.id}" ${x.id eq product.category.id ? 'selected' : ''}>${x.name}</option>
        </c:forEach>
    </select>
    <br>
    Price :
    <input type="text" name="price" value="${product.price}">
    <br>
    Weight in grams :
    <input type="text" name="weight" value="${product.weight}">
    <br>
    Product Description :
    <input type="text" name="description" value="${product.description}">
    <br>
    Picture Upload:
    <input type="file" name="picture">
    <br>
    <input type="submit">
</form>

</body>
</html>