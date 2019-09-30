<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data</title>
<style type="text/css">
.error{
color:red;
}
</style>
</head>
<body>
	<h1>Add Employee Data</h1>
	
		<form:form method="post" action="save" modelAttribute="employee">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
                    <td><form:errors path="name" cssClass="error"/></td>
                
			</tr>
			<tr>
				<td>Date Of Birth :</td>
				<td><form:input type="date" path="dob" /></td>
				    <td><form:errors path="dob" cssClass="error"/></td>
				
			</tr>
			<tr>
			<td>Gender :</td>
			<td>Male <form:radiobutton path="gender" value="Male" /> Female
				<form:radiobutton path="gender" value="Female" />
				    <td><form:errors path="gender" cssClass="error"/></td>
				
			</td>
		</tr>
			<!--  <tr>
				<td>Select File:</td>
				<td><input type="file" name="file" /> <input type="submit"
					value="Upload File" /></td>
			</tr>-->

			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>