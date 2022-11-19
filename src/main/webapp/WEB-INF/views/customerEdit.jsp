<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SpringMVC</title>
</head>
<body>
<h1>Edit Customer</h1>
<form:form method="post" modelAttribute="customer" action="editcustomer">
	<table>
		<tr>
			<td><form:hidden path="id"/></td>
		</tr>
		<tr>
			
			<td>FirstName:</td>
			<td><form:input path="first_name"/></td>
		</tr>
		<tr>
			<td>Lastname:</td>
			<td><form:input path="last_name"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Update"></td>
		</tr>
	</table>
</form:form>
</body>
</html>