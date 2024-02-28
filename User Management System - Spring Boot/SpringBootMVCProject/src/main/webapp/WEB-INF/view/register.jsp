<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>

.form-signup {
	margin : 0 auto;
	max-width: 400px;
	background-color:white;
	padding : 15px;	
}

body {
	padding-top: 250px;
	background-color:powderblue;
}

.form-signup h2{
	text-align:center;
}

.center {
	text-align : center;
}

</style>
</head>
<body>
	<div class="container">
		<form class="form-signup" method="post" action="/app/add">
			<h2>Register</h2>
			<p class="center">Create your account for free.</p>
			<div class="form-group">
				<div class="row">
					<div class="col-md-6">
						<input type="text" class="form-control"  name="firstname" placeholder="First Name">
					</div>
					<div class="col-md-6">
						<input type="text" class="form-control" name="lastname" placeholder="Last Name">
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="age" placeholder="Enter your age">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="username" placeholder="Username">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password" placeholder="Password">
			</div>
			<input type="submit" class="btn btn-success btn-block">
		</form>
		<br/>
		<div class="center">
				<label>
					Already have an Account? 
					<a href="/app/sign-in">
						Click to login
					</a>
				</label>		
			</div>
	</div>
</body>
</html>