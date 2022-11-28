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
<form:form method="post" modelAttribute="customer" action="addcustomer">
	<table>
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
		<tr>
			<td>Gender:</td>
			<td>Male<form:radiobutton path="gender" value="Male"/></td>
			<td>Female<form:radiobutton path="gender" value="Female"/></td>
		</tr>
		<tr>
			<td>Meals:</td>
			<td>BreakFast<form:checkbox path="food" value="BreakFast"/></td>
			<td>Lunch<form:checkbox path="food" value="Lunch"/></td>
			<td>Dinner<form:checkbox path="food" value="Dinner"/></td>
		</tr>
		<tr>
			<td>From:</td>
			<td><form:select path="cityFrom" > 
				<form:option value="Hyderabad" lable="Hyderabad"></form:option>
				<form:option value="Karminagar" lable="Karimnagar"></form:option>
				<form:option value="Jagtial" lable="Jagtial"></form:option>
			</form:select></td>
		</tr>
		<tr>
			<td>To:</td>
			<td><form:select path="cityTo" > 
				<form:option value="Hyderabad" lable="Hyderabad"></form:option>
				<form:option value="Karminagar" lable="Karimnagar"></form:option>
				<form:option value="Jagtial" lable="Jagtial"></form:option>
			</form:select></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save"></td>
		</tr>
		<c:if test="${not empty message }">
			${message }
		</c:if>
	</table>
</form:form>
</body>
</html>