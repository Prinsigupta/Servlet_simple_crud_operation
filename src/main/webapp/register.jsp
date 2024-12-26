<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<h3>Registration-Form</h3>
<div>
 <form action="userRegistration" method="get">
<label> USER-ID:</label><br>
<input type="number" placeholder="Enter user id" name="userId"><br>
<label> USER-Name:</label><br>
<input type="text" placeholder="Enter user name" name="userName"><br>
<label> USER-Email:</label><br>
<input type="email" placeholder="Enter user email" name="userEmail"><br>
<label> USER-DOB:</label><br>
<input type="date"  name="userDob"><br>
<label> USER-Gender:</label><br>
<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female">Female<br>
<label> USER-Password:</label><br>
<input type="password" placeholder="Enter user password" name="password"><br>
<input type="submit" value="register">
</form>
</div>
</body>
</html>