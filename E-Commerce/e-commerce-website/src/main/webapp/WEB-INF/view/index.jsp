<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #555;
            padding: 15px;
            text-align: center;
        }

        nav {
            display: flex;
            justify-content: center;
            background-color: #444;
            padding: 10px;
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
    <header>
        <h1>Welcome to Sweet Truth</h1>
    </header>

    <nav>
        <a href="#">Home</a>
        <a href="#">About Us</a>
        <a href="#">Contact</a>
        <a href="/shop">Shop</a>
        <a href="/displayCart">My Cart</a>
    </nav>
</body>
</html>
