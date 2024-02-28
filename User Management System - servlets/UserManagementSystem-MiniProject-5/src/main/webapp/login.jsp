<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 90vh;
    }

    h1 {
        text-align: center;
        margin : 50px;
        color: #333;
        font-size: 38px;
    }

    h2 {
        text-align: center;
       	font: 100px;
        color: purple;
    }
    
    #header {
        background-color: #fff;
        padding: 29px;
        box-shadow: 0 0 10px rgba(128, 128, 128, 0.3);
        width: 500px;
        margin : 60px;
        font-size: 25px;
    }

    table {
        width: 550px;
        height: 500px;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    td {
        padding: 10px;
        text-align: left;
    }

    input[type="text"],
    input[type="password"],
    input[type="submit"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4caf50;
        color: white;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>

</head>
<body>
     <div id="header">
        <h2>Welcome to User Hub</h2>
    </div>
   
    <br>
    <br>
    <form action=loginServlet method=post>
        <table>
         	<h1>Login Page</h1>
            <tr>
                <td>Select User Type</td>
                <td>
                    <input type="radio" name="userType" value="user" checked> User
                    <input type="radio" name="userType" value="admin"> Admin
                </td>
            </tr>
            
            <tr>
                <td>Enter Username</td>
                <td><input type="text" name="userName"></td>
            </tr>
            
            <tr>
                <td>Enter Password</td>
                <td><input type="text" name="userPassword"></td>
            </tr>
            
            <tr>
                <td><input type=submit value=login></td>
            </tr>
            
        </table>
    </form>

</body>
</html>
