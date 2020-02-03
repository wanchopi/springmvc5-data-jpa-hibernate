<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Search Result</title>
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
</head>
<body>
	<div class="container-fluid" align="center">
		<div class="col-lg-12" style="margin:40px">
			<h1><span class="badge badge-secondary">User Manager</span></h1>
		</div>
		<h2>Search Result</h2>
		<div class="col-lg-9" style="margin-top: 50px;">
			<table class="table">
				<thead class="thead-dark">
					<tr align="center">
						<th scope="col">ID</th>
						<th scope="col">FIRST NAME</th>
						<th scope="col">LAST NAME</th>
						<th scope="col">EMAIL</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${result}" var="user">
						<tr align="center">
							<td>${user.id}</td>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>