<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student Information</title>
</head>
<body>
    <%
        String rollNumber = request.getAttribute("rollNumber").toString();
        String firstName = request.getAttribute("firstName").toString();
        String academicYear = request.getAttribute("academicYear").toString();
        String mobileNumber = request.getAttribute("mobileNumber").toString();
    %>
    <h2>Update Student Information</h2>
    <form action="UpdateStudentServlet" method="POST">
        <input type="hidden" name="rollNumber" value="<%= rollNumber %>">
        
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="<%= firstName %>" required><br>
        
        <label for="academicYear">Academic Year:</label>
        <input type="text" id="academicYear" name="academicYear" value="<%= academicYear %>" required><br>
        
        <label for="mobileNumber">Mobile Number:</label>
        <input type="text" id="mobileNumber" name="mobileNumber" value="<%= mobileNumber %>" required><br>
        
        <button type="submit">Update</button>
    </form>
</body>
</html>
