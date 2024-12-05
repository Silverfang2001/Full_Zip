<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book Registration</title>
</head>
<body>
    <h2>Book Registration</h2>
    <form action="BookRegistrationServlet" method="post">
        <label>Title:</label>
        <input type="text" name="title" required><br><br>
        <label>Author:</label>
        <input type="text" name="author" required><br><br>
        <label>ISBN:</label>
        <input type="text" name="isbn" required><br><br>
        <input type="submit" value="Add Book">
    </form>
</body>
</html>
