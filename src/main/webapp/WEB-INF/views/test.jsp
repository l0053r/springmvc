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
			<c:when test="${not empty list}">
				<tr>
					<th>Id</th>				
				</tr>
				<c:forEach var="cust" items="${list }">
					<tr>
						<td>${cust }</td>						
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