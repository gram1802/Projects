<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<style>
	.shaded-block{
		background-color: #000; /* Set the background color (black in this case) */
        opacity: 0.3; /* Set the opacity to control the shading effect (0.5 for 50% opacity) */
        width: 1500px; /* Set the width of the block */
        height: 300px;
        border-radius: 10px; /* Add rounded corners */
        margin-top: 30px;
        margin-left:10px;
	}
	.text{
		color : white;
		text-align : center;
		font-size : 20px;
		padding : 40px;
	}
	.products{
		margin-top: 50px;
		margin-left:10px;
		border:solid black 1px;
		padding : 5px;
		width:350px;
		height:150px;
		display: inline-block;
	}
</style>
</head>
<body>
	
	<div class="shaded-block">
		<div class="text">
			<h1>Welcome Back, Admin</h1>
			<p>Easily manage your data here</p>
		</div>
	</div>
	
	<div class="products">
		<h1>Category</h1>
		<p>All the Categories are listed here</p>
		<a href="/website/displayCategory">
			<button>View</button>
		</a>	
	</div>
	
	<div class="products">
		<h1>Products</h1>
		<p>All the products are listed here</p>
		<a href="/website/displayProducts">
			<button>View</button>
		</a>
	</div>
</body>
</html>