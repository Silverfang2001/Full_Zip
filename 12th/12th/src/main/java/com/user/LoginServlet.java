package com.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "1234");

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("profile.jsp");
            } else {
                out.println("<h3 style='color:red;'>Invalid credentials, please try again.</h3>");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}

// CREAT database User;
// Use User;
// CREATE TABLE users (
// id INT AUTO_INCREMENT PRIMARY KEY,
// username VARCHAR(50),
// password VARCHAR(50)
// );

// INSERT INTO users (username, password) VALUES ('user1', 'password123');
// INSERT INTO users (username, password) VALUES ('user2', 'password456');
