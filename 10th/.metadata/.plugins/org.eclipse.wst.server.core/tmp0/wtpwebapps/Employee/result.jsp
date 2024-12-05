<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h2>Operation Result</h2>

    <!-- Display the message dynamically -->
    <p style="<%= request.getAttribute("status").equals("success") ? "color:green;" : "color:red;" %>">
        <%= request.getAttribute("message") %>
    </p>

    <a href="delete_employee.jsp">Back to Delete Employee</a>
</body>
</html>

