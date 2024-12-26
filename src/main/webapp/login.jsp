<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login-Page</title>
</head>
<body>
     <% 
     String message=(String)request.getAttribute("msg");
     if(message!=null){
     %>
    	 <h4 style="color:red"><%=message %></h4>
     <%}%>
     
     
<form action="loginUser" method="get">
<label>USEREMAIL:</label><br>
 <input type="email" placeholder="enter your email" name="userEmail"><br>
 <label>USERPASSWORD:</label><br>
 <input type="password" placeholder="enter your password" name="password"><br>
 <input type="submit" value="LOGIN">
</form>
</body>
</html>