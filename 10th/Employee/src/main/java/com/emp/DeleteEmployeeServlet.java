package com.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database credentials
    String DB_URL = "jdbc:mysql://localhost:3306/EmployeeDB?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root"; // Replace with your MySQL username
    private static final String DB_PASSWORD = "1234"; // Replace with your MySQL password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve employee ID from the form
        String empId = request.getParameter("empId");

        String message = "";
        String status = "";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Check if employee exists
            String checkQuery = "SELECT * FROM employees WHERE emp_id = ?";
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setInt(1, Integer.parseInt(empId));
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Employee exists; proceed to delete
                String deleteQuery = "DELETE FROM employees WHERE emp_id = ?";
                PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
                deleteStmt.setInt(1, Integer.parseInt(empId));

                int rowsDeleted = deleteStmt.executeUpdate();

                if (rowsDeleted > 0) {
                    message = "Employee with ID " + empId + " deleted successfully!";
                    status = "success";
                } else {
                    message = "Error occurred while deleting employee. Please try again.";
                    status = "error";
                }

                deleteStmt.close();
            } else {
                // Employee does not exist
                message = "Employee with ID " + empId + " not found.";
                status = "not_found";
            }

            checkStmt.close();
            con.close();

        } catch (Exception e) {
            message = "An error occurred: " + e.getMessage();
            status = "error";
            e.printStackTrace();
        }

        // Set attributes to pass to result.jsp
        request.setAttribute("message", message);
        request.setAttribute("status", status);

        // Redirect to result.jsp
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}

// CREATE TABLE employees (
// emp_id INT PRIMARY KEY,
// first_name VARCHAR(50),
// last_name VARCHAR(50),
// department VARCHAR(50),
// salary DOUBLE
// );

// INSERT INTO employees VALUES (1, 'John', 'Doe', 'IT', 60000);
// INSERT INTO employees VALUES (2, 'Jane', 'Smith', 'HR', 50000);
