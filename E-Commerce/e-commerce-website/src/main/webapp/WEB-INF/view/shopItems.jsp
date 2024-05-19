<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
<style>

    .container {
        display: flex;
    }
    
    .products {
        padding-right: 300px; /* Add space between products and categories */
    }

    .product {
        background-color: pink;
        width: 500px;
        height: 300px;
        margin-bottom: 20px; /* Add space between products */
        text-align: center;
    }
    
    .product img {
        width: 150px;
        height: 120px;
    }
    
    .center-image {
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
    
    .category {
        border: 5px solid #ccc;
        width: 250px; 
        height: 260px;
        padding: 30px;
        margin-left:350px;
    }
    
    	nav {
            display: flex;
            justify-content: center;
            background-color: #444;
            padding: 10px;
            margin-bottom:30px;
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 10px;
            margin: 0 10px;
        }

        nav a:hover {
            background-color: #555;
        }
    
    
</style>
</head>
<body>

	<nav>
        <a href="/home">Home</a>
        <a href="#">About Us</a>
        <a href="#">Contact</a>
        <a href="/shop">Shop</a>
    </nav>

<div class="container">
    <div class="products">
        <c:forEach var="x" items="${products}">
            <div class="product">
                <img src="/images/${x.imageName}" alt="Product Image" class="center-image">
                <p>${x.description}</p>
                <p>${x.weight} grams</p>
                <p>Rs. ${x.price}</p>
                <a href="/addToCart?productId=${x.id}">
                    <button>Add to cart</button>
                </a>
            </div>
        </c:forEach>
    </div>

    <div class="category">
        <h2>Categories</h2>
       	<ul>
       		<li><a href="/shop">All Categories</a></li>
       		<br>
       		<c:forEach var="x" items="${categories}">
                <li><a href="/shop?x=${x.name}">${x.name}</a></li>
                <br>
                
            </c:forEach>
       	</ul>
        
    </div>
</div>

</body>
</html>
