<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	body {
		background-color: #f9f9f9;
	}
</style>
</head>
<body>

<div class="container text-center">
	<h1>All Users</h1>
	<h3>Below you can find the list of all the people who are subscribed to this page</h3>
	<hr>
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>UserName</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
			</thead>
			<c:forEach var="user" items="${users }">
				<tr>
					<td>${user.id }</td>
					<td>${user.username }</td>
					<td>${user.firstname }</td>
					<td>${user.lastname }</td>
					<td>${user.age }</td>
				</tr>
			</c:forEach>
			
			
		</table>
	</div>
</div>

</body>
</html>