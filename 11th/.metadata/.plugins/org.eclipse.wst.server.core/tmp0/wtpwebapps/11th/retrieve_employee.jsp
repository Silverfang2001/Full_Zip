<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Employee</title>
</head>
<body>
    <h2>Search Employee</h2>
    <form action="RetrieveEmployee" method="POST">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required>
        <br><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
