<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Data</h1>
<table border="2" width="70%" cellpadding="2">
<tr>
<th>Id</th>
<th>Name</th>
<th>Dob</th>

</tr>
<c:forEach var="e" items="${list}">
<tr>
<td>${e.id}</td>
<td>${e.name}</td>
<td>${e.dob}</td>


<td><a href="empedit/${e.id}">Edit</a></td>
<td><a href="deletemp/${e.id}">Delete</a></td>
</tr>
</c:forEach>

</table>
<a href="employeeForm">Add New Employee</a>
</body>
</html>