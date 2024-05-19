<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new item</title>
</head>
<body>

	<form action="/website/saveProduct" method="POST" enctype="multipart/form-data">
		Name : 
		<input type="text" name="name">
		<br>
		Select Category : 
		<select name="categories.id">
			<c:forEach var="x" items="${category}">
				<option value="${x.id}">${x.name}</option>
			</c:forEach>
		</select>
		<br>
		Price :
		<input type="text" name="price">
		<br>
		Weight in grams :
		<input type="text" name="weight">
		<br>
		Product Description :
		<input type="text" name="description">
		<br>
		Picture Upload:
    	<input type="file" name="picture">
    	<br>
		<input type="submit" name="itemAdded">
	</form>
	
	
</body>
</html>