<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data Table</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<title>Spring Boot + JPA + Datatables</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
    href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
    src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<%-- <script type="text/javascript"
    src="${pageContext.request.contextPath}/resources/js/datatable.js"></script> --%>
</head>

</head>
<body>
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
<h1>Employee Table</h1>
    <table id="EmployeeTable" class="display">

        <!-- Header Table -->
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                
            </tr>
        </thead>
        <!-- BODY -->
        
        
        <!-- Footer Table -->
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                            </tr>
        </tfoot>
    </table>

</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
    var data =eval('${employeeList}');
    var table = $('#EmployeeTable').DataTable( {
          "aaData": data,
          "aoColumns": [
            { "mData": "id"},
            { "mData": "name"},
            { "mData": "dob"},
            { "mData": "gender"},
            
          ],
          "paging":false
        });
});
</script>





<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>
</html>