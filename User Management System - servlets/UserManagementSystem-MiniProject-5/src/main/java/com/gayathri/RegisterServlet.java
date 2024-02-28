package com.gayathri;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final static String query = "insert into user(name,password,email,mobile,date,city,gender,notes) values(?,?,?,?,?,?,?,?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Show the index.html page for GET requests
        req.getRequestDispatcher("/index.html").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        PrintWriter pw = null;

        try {
            pw = res.getWriter();
            res.setContentType("text/html");

            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String mobile = req.getParameter("mobile");
            String date = req.getParameter("date");
            String city = req.getParameter("city");
            String gender = req.getParameter("gender");
            String notes = req.getParameter("notes");

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/usermanagement";
            String usr = "root";
            String pass = "root123";

            con = DriverManager.getConnection(url, usr, pass);

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, mobile);
            ps.setString(5, date);
            ps.setString(6, city);
            ps.setString(7, gender);
            ps.setString(8, notes);

            int count = ps.executeUpdate();
            if (count == 1) {
            	pw.println("<div style='text-align: center; margin-top: 80px;'>");
                pw.println("<h2 style='color:green;'>Record Registered Successfully</h2>");
                pw.println("</div>");
            } else {
                pw.println("<h2 style='color:red;'>Record Not Registered</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pw.println("<div style='text-align: center; margin-top: 80px;'>");
        pw.println("<a href = 'index.html' ><button>Home</button></a>");
        pw.println("</div>");

    }
    
}
