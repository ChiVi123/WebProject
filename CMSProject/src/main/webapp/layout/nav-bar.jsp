<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
<link rel="stylesheet" href="<c:url value="/resources/css/NavBar.css"/>" />
</head>
<body>
	<div id="navBar">
		<div id="wrapperSearch">
			<input type="text" name="search" id="" placeholder="Search...">
			<button>
				<i class="fas fa-search"></i>
			</button>
		</div>
		<a href="home"> <i class="fontContent bi bi-table"></i> View Contents
		</a> <a href="new"> <i class="fontContent fas fa-edit"></i>
			Form Content
		</a>
	</div>
</body>
</html>