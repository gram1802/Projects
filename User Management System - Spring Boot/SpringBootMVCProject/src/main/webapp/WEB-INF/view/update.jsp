<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update your profile</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
		<form class="form-signup" method="post" action="/app/updating">
			<h2>Update Your Information</h2>
			<p class="center">Change the desired fields.</p>
			<div class="form-group">
				<input type="text" class="form-control" name="firstname" required value="${u.firstname}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="lastname" required value="${u.lastname}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="age" required value="${u.age}">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="username" required value="${u.username}">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password" required value="${u.password}">
			</div>
			<input type="submit" class="btn btn-success btn-block">
		</form>

</body>
</html>