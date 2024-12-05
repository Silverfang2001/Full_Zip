<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>
    <h2>Student Registration Form</h2>
    <form action="StudentRegistration" method="post">
        <label>Roll Number:</label>
        <input type="text" name="rollNumber" required><br><br>

        <label>First Name:</label>
        <input type="text" name="firstName" required><br><br>

        <label>Last Name:</label>
        <input type="text" name="lastName" required><br><br>

        <label>Academic Year:</label>
        <select name="academicYear" required>
            <option value="2023">2023</option>
            <option value="2024">2024</option>
            <option value="2025">2025</option>
        </select><br><br>

        <label>Gender:</label>
        <input type="radio" name="gender" value="Male" required> Male
        <input type="radio" name="gender" value="Female" required> Female<br><br>

        <label>Qualification:</label><br>
        <input type="checkbox" name="qualification" value="HSC"> HSC<br>
        <input type="checkbox" name="qualification" value="SSC"> SSC<br>
        <input type="checkbox" name="qualification" value="Diploma"> Diploma<br>
        <input type="checkbox" name="qualification" value="BE"> BE<br><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>

</html>