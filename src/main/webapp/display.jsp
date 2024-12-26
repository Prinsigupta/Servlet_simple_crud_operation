+<%@page import="com.tcs.servlet_simple_crud_operation.dto.User"%>
<%@page import="com.tcs.servlet_simple_crud_operation.dao.UserDao"%>


<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display-Page</title>
</head>
<body>
	<h4>Display-Page</h4>
	<%
	List<User> users= new UserDao().getAllUserDao();
	%>
	<table border="2">
		<!--row for heading -->
		<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>DOB</th>
		<th>Gender</th>
		<th colspan="2">ACTION</th>
		</tr>
		
		

		<%
		for(User userr : users){
		%>
		<!-- row for data -->
		<tr>
			<td><%=userr.getId()%></td>
			<td><%=userr.getName()%></td>
			<td><%=userr.getEmail()%></td>
			<td><%=userr.getDob()%></td>
			<td><%=userr.getGender()%></td>
			<td><a href="delete?id=<%=userr.getId()%>">DELETE</a></td>
			<td><a href="#">EDIT</a></td>
		</tr>
		<%}%>
	</table>
</body>
</html>