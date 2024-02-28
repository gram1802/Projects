<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>

body {
		background-color: #f9f9f9;
		padding : 175px; 
	}
	
</style>
</head>
<body>

<div class="container mt-5 text-center">
    <h5>Delete Account Confirmation</h5>
    <p>Are you sure you want to delete your account? This action cannot be undone.</p>
    <form action="/app/deleting" method="POST">
        <button type="submit" class="btn btn-danger">Yes, Delete My Account</button>
        <a href="/app/initial" class="btn btn-secondary">No, Cancel</a>
    </form>
</div>
   

</body>
</html>