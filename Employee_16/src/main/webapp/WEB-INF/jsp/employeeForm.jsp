<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    



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
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

</head>
<body>
	<h1>Add Employee Data</h1>
 <!-- Nav bar  Start -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="employeeForm">Employee Info Form <span class="sr-only">(current)</span></a></li>
        <li><a href="viewemp">View Employee Data</a></li>
        <li><a href="viewempDataTable">View Employee DataTable</a></li>
        <li><a href="upload">Upload File</a></li>
        <li><a href="displayFile">Display & Download File</a></li>
               <li><a href="viewImageTable">Display Image Table</a></li>
        </li>
      </ul>
       </form>
       </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- Nav Bar End -->
        Language : <a href="?language=en">English</a>|<a href="?language=hi">HINDI</a>
    
    
     Current Locale : ${pageContext.response.locale}

	
		<form:form method="post" action="save" modelAttribute="employee">
		<table>
			<tr>
				<td><!--  Name :--><spring:message code="lbl.name"/></td>
				
				<td><form:input path="name" /></td>
                    <td><form:errors path="name" cssClass="error"/></td>
                
			</tr>
			<tr>
				<td><!--  Date Of Birth :--><spring:message code="lbl.dob"/></td>
				<td><form:input type="date" path="dob" /></td>
				    <td><form:errors path="dob" cssClass="error"/></td>
				
			</tr>
			<tr>
			<td><!--  Gender : --><spring:message code="lbl.gender"/></td>
			<td><!--  Male --><spring:message code="lbl.male"/><form:radiobutton path="gender" value="Male" /> <!--  Female--><spring:message code="lbl.female"/>
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
	welcome.springmvc : <spring:message code="welcome.emp" text="default text" />
	
	<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
</body>
</html>