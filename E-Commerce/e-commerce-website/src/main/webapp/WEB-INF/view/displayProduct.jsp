<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Data</title>
</head>
<body>

	<a href="addProduct">
		<button>Add Product</button>
	</a>
	<br>
	<br>
	<table border="1">
	
		<tr>
			<th>id</th>
			<th>description</th>
			<th>image</th>
			<th>name</th>
			<th>price</th>
			<th>weight</th>
			<th>category</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
		
		<tr>
		
			<c:forEach var="x" items="${products}">
			
				<tr>
				
				 <tr>
                <td>${x.id}</td>
                <td>${x.description}</td>
                <td><img src="/images/${x.imageName}" alt="Product Image" style="max-width: 120px;"></td>
                <td>${x.name}</td>
                <td>${x.price}</td>
                <td>${x.weight}</td>
                <td>${x.categories.name}</td>
				<td>
					
					<form action="/website/deleteProduct/${x.id}" method="POST">
						<button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
					</form>
					
				</td>
				<td>
					
					<form action="/website/updateProduct/${x.id}" method="POST">
						<button type="submit">Update</button>
					</form>
					
				</td>
				
				</tr>
			
			</c:forEach>
		
		</tr>
			
	
	</table>
	
</body>
</html>