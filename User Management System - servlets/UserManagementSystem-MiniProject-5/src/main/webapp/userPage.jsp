<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        color: #333;
        margin: 20px;
        display: flex;
        justify-content: space-between;
        padding: 110px;
    }

    .user-details {
        width: 45%;
        padding: 10px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        color: #0066cc;
    }

    p {
        margin-bottom: 10px;
    }

    /* Add more styles as needed */
</style>
</head>
<body>
    <div class="user-details">
        <h2>Welcome User: ${requestScope.userDetails.getString("name")}</h2>
    </div>
    <div class="user-details">
        <p>Email: ${requestScope.userDetails.getString("email")}</p>
        <p>Mobile: ${requestScope.userDetails.getString("mobile")}</p>
        <p>Date of Birth: ${requestScope.userDetails.getString("date")}</p>
        <p>City: ${requestScope.userDetails.getString("city")}</p>
        <p>Gender: ${requestScope.userDetails.getString("gender")}</p>
        <p>Notes: ${requestScope.userDetails.getString("notes")}</p>
    </div>
</body>
</html>
