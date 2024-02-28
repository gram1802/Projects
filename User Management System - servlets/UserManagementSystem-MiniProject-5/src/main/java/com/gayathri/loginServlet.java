package com.gayathri;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        PrintWriter pw = null;
	        
	        try {
	        	
	        	pw = response.getWriter();
	            response.setContentType("text/html");
	            
	            String userType = request.getParameter("userType");
	            String userName = request.getParameter("userName");
	            String userPassword = request.getParameter("userPassword");
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");


	            // JDBC URL, username, and password of MySQL server
	            String jdbcURL = "jdbc:mysql://localhost:3306/usermanagement";
	            String dbUser = "root";
	            String dbPassword = "root123";
	            
	            
	            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

	            if ("admin".equals(userType)) {
	            	
	                String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
	                preparedStatement = connection.prepareStatement(query);
	                preparedStatement.setString(1, userName);
	                preparedStatement.setString(2, userPassword);

	                ResultSet resultSet = preparedStatement.executeQuery();

	                if (resultSet.next()) {
	                    // Successful login for admin
	                    pw.println("<html><body><h2>Welcome Admin: " + userName + "</h2></body></html>");
	                 // Redirect to the register servlet
	                    response.sendRedirect("index.html");
	                } else {
	                    // Invalid credentials for admin
	                    pw.println("<html><body><h2>Invalid Admin credentials</h2></body></html>");
	                }
	            } else {
	                // Handle other user types or implement user login logic as needed
	            	 	String query = "SELECT * FROM user WHERE name = ? AND password = ?";
		                preparedStatement = connection.prepareStatement(query);
		                preparedStatement.setString(1, userName);
		                preparedStatement.setString(2, userPassword);

		                ResultSet resultSet = preparedStatement.executeQuery();

		                if (resultSet.next()) {
		                    // Successful login for user
		                	request.setAttribute("userDetails", resultSet);
		                	request.getRequestDispatcher("userPage.jsp").forward(request, response);
		                } else {
		                    // Invalid credentials for user
		                    pw.println("<html><body><h2>Invalid User credentials</h2></body></html>");
		                }
	            }
	            
	            
	        } 
	        
	        catch (Exception e) {
	            e.printStackTrace();
	        } 
	        
	}
}
