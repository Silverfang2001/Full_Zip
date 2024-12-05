package com.book;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/BookRegistrationServlet")
public class BookRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books", "root", "1234");

            String query = "INSERT INTO books (title, author, isbn) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, isbn);
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                out.println("<h3>Book successfully added!</h3>");
            } else {
                out.println("<h3>Error while adding book.</h3>");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}

// CREATE DATABASE Books;

// use database Books;

// CREATE TABLE books (
// id INT AUTO_INCREMENT PRIMARY KEY,
// title VARCHAR(100),
// author VARCHAR(100),
// isbn VARCHAR(50)
// );

// INSERT INTO books (title, author, isbn) VALUES ('Java Basics', 'John Doe',
// '123456');
// INSERT INTO books (title, author, isbn) VALUES ('Advanced Java', 'Jane
// Smith', '789101');
