<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
</head>
<body>
	<a href = "addCategory">
		<button>Add Category</button>
	</a>
	<br>
	<br>
	<table border=1>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Delete</th>
		</tr>
		<tr>
		<c:forEach var="x" items="${category}">
		<tr>
			<td>${x.id}</td>
			<td>${x.name}</td>
			<td>
				<form action="/website/deleteCategory/${x.id}" method="post">
    				<button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>