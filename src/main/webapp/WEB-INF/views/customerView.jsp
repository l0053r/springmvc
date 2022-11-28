<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SpringMVC</title>
</head>
<body>
	<h1>Customers List</h1>
	<table border="2" width="70%" cellpadding="2">
		<c:choose>
			<c:when test="${not empty customerlist}">
				<tr>
					<th>Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Food</th>
					<th>CityFrom</th>
					<th>CityTo</th>
					<th>Action</th>
				</tr>
				<c:forEach var="cust" items="${customerlist }">
					<tr>
						<td>${cust.id }</td>
						<td>${cust.first_name }</td>
						<td>${cust.last_name }</td>
						<td>${cust.email }</td>
						<td>${cust.gender }</td>
						<td><c:forEach var="meals" items="${cust.food }">
							${meals }<br>
						</c:forEach>
						</td>
						<td>${cust.cityFrom }</td>
						<td>${cust.cityTo }</td>
						<td><a href="editcust/${cust.id}">Edit</a><br>
						<a href="deletecust/${cust.id}">Delete</a></td>
					</tr>					
				</c:forEach>
			</c:when>
			<c:otherwise>				
				No Data availiable				
			</c:otherwise>
		</c:choose>
	</table>
	<br>
	<a href="customerform">Add new Customer</a>
</body>
</html>