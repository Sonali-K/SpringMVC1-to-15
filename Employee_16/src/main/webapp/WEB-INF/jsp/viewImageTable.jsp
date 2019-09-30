<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Data Table</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

</head>
<body>
<!-- NavBar Start -->
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
        <li class="active"><a href="empform">Add Employee <span class="sr-only">(current)</span></a></li>
        <li><a href="viewemp">View Employees</a></li>
        <li><a href="loginPage">Login Page</a></li>
         <li><a href="upload">Upload File</a></li>
         <li><a href="displayFile">Display & Download File</a></li>
          <li><a href="viewEmpDataTable">Employee Data Table</a></li>
          <li><a href="viewImageTable">Image Data Table</a></li>
      </ul>
     
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- NavBar End -->
<table border="1">
	<tr><th>Id</th><th>Name</th><th>Data</th><th>Path</th> <th>Edit</th><th>Delete</th></tr>  
	<c:forEach var="e" items="${list1}">
		<tr>
			<td>${e.id}</td>
			<td>${e.img_title}</td>
			<td>${e.img_data}</td>
			<td>${e.img_path}</td>

			<td><a href="editFile/${e.id}">Edit</a></td>
			<td><a href="deleteFile/${e.id}">Delete</a></td>
		</tr>
	</c:forEach>

</table>
<a href="uploadform">Add New File</a>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">

</body>
</html>