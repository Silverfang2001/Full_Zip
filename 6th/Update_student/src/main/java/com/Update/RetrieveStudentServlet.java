package com.Update;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/RetrieveStudentServlet")
public class RetrieveStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rollNumber = request.getParameter("rollNumber");
        response.setContentType("text/html");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            System.out.println("HI");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "1234");

            String query = "SELECT * FROM Student WHERE roll_number = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(rollNumber));
            rs = ps.executeQuery();

            if (rs.next()) {
                // Forward data to update form JSP
                request.setAttribute("rollNumber", rollNumber);
                request.setAttribute("firstName", rs.getString("first_name"));
                request.setAttribute("academicYear", rs.getString("academic_year"));
                request.setAttribute("mobileNumber", rs.getString("mobile_number"));

                RequestDispatcher dispatcher = request.getRequestDispatcher("updateForm.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter()
                        .println("<h3 style='color:red;'>Data not found for Roll Number: " + rollNumber + "</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (Exception ex) {
            }
        }
    }
}

// CREATE DATABASE StudentDB;

// USE StudentDB;

// CREATE TABLE Student (
// roll_number INT PRIMARY KEY,
// first_name VARCHAR(50),
// last_name VARCHAR(50),
// gender VARCHAR(10),
// mobile_number VARCHAR(15),
// college_name VARCHAR(100),
// academic_year VARCHAR(10)
// );

// -- Insert sample data
// INSERT INTO Student (roll_number, first_name, last_name, gender,
// mobile_number, college_name, academic_year)
// VALUES (101, 'John', 'Doe', 'Male', '1234567890', 'ABC College', '2023'),
// (102, 'Jane', 'Smith', 'Female', '0987654321', 'XYZ University', '2024');
