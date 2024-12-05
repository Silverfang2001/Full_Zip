<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book Search</title>
</head>
<body>
    <h2>Search for a Book</h2>
    <form action="BookSearchServlet" method="post">
        <label>Search by Title, Author, or ISBN:</label>
        <input type="text" name="searchQuery" required><br><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
