<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location | Update</title>
</head>
<body>
	<h2>Location | Update location</h2>
	<form action="updatelocation" method="post">
		<pre>
    Id:<input type="text" name="id" value="${location.id }" />
    
	Name:<input type="text" name="name"  value="${location.name }"/>
	
	Code:<input type="text" name="codes"  value="${location.codes }"/>
	
	Type:
	Urban <input type="radio" value="Urban" name="type" />
	Rural <input type="radio" value="Rural" name="type" />
	
	     <input type="submit" value="Update" />
		</pre>
	</form>
	${msg}
</body>
</html>