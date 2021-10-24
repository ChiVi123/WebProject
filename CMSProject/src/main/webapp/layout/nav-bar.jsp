<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
<link rel="stylesheet" href="<c:url value="/layout/NavBar.css"/>" />
</head>
<body>
	<div id="navBar">
		<div id="wrapperSearch">
			<input type="text" name="search" id="" placeholder="Search...">
			<button>
				<i class="fas fa-search"></i>
			</button>
		</div>
		<a href="#"> <i class="fontContent far fa-calendar-alt"></i> View
			Contents
		</a> <a href="add-content.tiles"> <i class="fontContent fas fa-edit"></i> Form Content
		</a>
	</div>
</body>
</html>