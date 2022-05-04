<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Locations</title>
</head>
<body>
	<h2 >List Of Locations</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Code</th>
			<th>Type</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach items="${locations}" var="locate">
			<tr>
				<td>${locate.id}</td>
				<td>${locate.name}</td>
				<td>${locate.codes}</td>
				<td>${locate.type}</td>
				<td><a href="Location_delete?id=${locate.id}" style="color: red">delete</a></td>
		<td><a href="update?id=${locate.id}" style="color: blue;">update</a></td>
		</c:forEach>
	</table>
</body>
</html>