package com.gayathri;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showdata")
public class ShowUserServlet extends HttpServlet {

    private final static String query = "select id,name,email,mobile,date,city,gender,notes from user";

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        PrintWriter pw = null;
        Connection con = null;
        PreparedStatement ps = null;

        try {
        	
            pw = res.getWriter();
            res.setContentType("text/html");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/usermanagement";
            String usr = "root";
            String pass = "root123";
            con = DriverManager.getConnection(url, usr, pass);
            
            
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            pw.println("<table align='center' border='1' style='width: 1000px; height:600px;  margin-top: 20px;'>");
            pw.println("<tr>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>ID</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>Name</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>Email</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>Mobile</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>Date</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>City</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>Gender</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>Notes</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>Delete</th>");
            pw.println("<th style='color:saddleBrown;font-size : 20px;'>Edit</th>");
            pw.println("</tr>");

            while (rs.next()) {
                pw.println("<tr>");
                pw.println("<td>" + rs.getInt(1) + "</td>");
                pw.println("<td>" + rs.getString(2) + "</td>");
                pw.println("<td>" + rs.getString(3) + "</td>");
                pw.println("<td>" + rs.getString(4) + "</td>");
                pw.println("<td>" + rs.getString(5) + "</td>");
                pw.println("<td>" + rs.getString(6) + "</td>");
                pw.println("<td>" + rs.getString(7) + "</td>");
                pw.println("<td>" + rs.getString(8) + "</td>");
                pw.println("<td><a href='delete?id=" + rs.getInt(1) + "'>Delete</a></td>");
                pw.println("<td><a href='editUser.jsp?id=" + rs.getInt(1) + "'>Edit</a></td>");
            }
            pw.println("</table>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.println("<br/><br/>");
        pw.println("<div style='text-align:center;'><a href='index.html'><button style='width:275px';>Home</button></div>");
    }
}
