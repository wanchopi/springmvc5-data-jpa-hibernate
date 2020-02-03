<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>index</title>
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="public/css/jquery-ui.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="public/css/mystyle.css">
</head>
<body>
	<div class="container-fluid" align="center">
		<!-- nav -->
		<nav class="navbar navbar-light bg-light">
  			<form class="form-inline" method="post" action="search" style="margin:auto">
    			<input class="form-control mr-sm-2" 
    				type="text" name="keyword" placeholder="Search" 
    					aria-label="Search" id="w-input-search">
    			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  			</form>
		</nav>
		<div class="col-lg-12" style="margin:40px">
			<h1><span class="badge badge-secondary">List of Employees</span></h1>
		</div>
		<div class="col-lg-9" style="margin-top: 50px;">
			<table class="table">
				<thead class="thead-dark">
					<tr align="center">
						<th scope="col">ID</th>
						<th scope="col">NAME</th>
						<th scope="col">E-MAIL</th>
						<th scope="col">EDIT</th>
						<th scope="col">DELETE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employees}" var="employee">
						<tr align="center">
							<td>${employee.id}</td>
							<td>${employee.firstName} ${employee.lastName}</td>
							<td>${employee.email}</td>
							<td><a href="update?id=${employee.id}"><i class="fa fa-edit"></i></a></td>
							<td><a href="delete?id=${employee.id}"><i class="fa fa-times"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="form">save a new user</a>
		</div>
	</div>
	
	<!-- jQuery core JavaScript -->
    <script src="public/js/jquery.min.js"></script>
    <script src="public/js/jquery-ui.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script src="public/js/bootstrap.min.js"></script>
    <!-- jquery code -->
    <script>
    $(document).ready(function() {

    });
    </script>
    <!-- autocomplete -->
  	<script>
		$(document).ready(function() {
			$('#w-input-search').autocomplete({
				source : '/search',
				minLength: '2',
				messages: {
			        noResults: 'no results',
			        results: ''
			    }
			});
		});
	</script>
</body>
</html>
























