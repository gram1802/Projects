<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<style>
    table {
        width: 50%;
        margin: auto;
        border-collapse: collapse;
    }
    
    td, th {
        padding: 32px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    
    tr:hover {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
    <%
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/usermanagement";
            String usr = "root";
            String pass = "root123";
            con = DriverManager.getConnection(url, usr, pass);
            
            Integer id = Integer.parseInt(request.getParameter("id"));
            String query = "select name, email, mobile, date, city, gender, notes from user where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
    %>
    <form action="edited?id=<%= id %>" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="<%= rs.getString(1) %>"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" value="<%= rs.getString(2) %>"></td>
            </tr>
            <tr>
                <td>Mobile</td>
                <td><input type="text" name="mobile" value="<%= rs.getString(3) %>"></td>
            </tr>
            <tr>
                <td>DOB</td>
                <td><input type="date" name="date" value="<%= rs.getString(4) %>"></td>
            </tr>
            <tr>
                <td>City</td>
                <td><input type="text" name="city" value="<%= rs.getString(5) %>"></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input type="text" name="gender" value="<%= rs.getString(6) %>"></td>
            </tr>
            <tr>
                <td>Notes</td>
                <td><input type="text" name="notes" value="<%= rs.getString(7) %>"></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Edit</button></td>
            </tr>
        </table>
    </form>
    <%
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources (Connection, PreparedStatement, ResultSet) here
        }
    %>
</body>
</html>
