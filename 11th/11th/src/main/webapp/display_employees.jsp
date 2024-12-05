<%@ page import="java.util.List, java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Information</title>
</head>
<body>
    <h2>Employee Information</h2>

    <% String message = (String) request.getAttribute("message"); %>
    <% if (message != null) { %>
        <p style="color: red;"><%= message %></p>
    <% } else { %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Department</th>
                <th>Salary</th>
            </tr>
            <%
                List<Map<String, String>> employees = (List<Map<String, String>>) request.getAttribute("employees");
                for (Map<String, String> emp : employees) {
            %>
                <tr>
                    <td><%= emp.get("emp_id") %></td>
                    <td><%= emp.get("first_name") %></td>
                    <td><%= emp.get("last_name") %></td>
                    <td><%= emp.get("department") %></td>
                    <td><%= emp.get("salary") %></td>
                </tr>
            <% } %>
        </table>
    <% } %>

    <a href="retrieve_employee.jsp">Search Again</a>
</body>
</html>
