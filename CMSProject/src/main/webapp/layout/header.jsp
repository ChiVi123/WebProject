<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/layout/Header.css"/>" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
</head>
<body>
	<div id="header">
		<div id="logo">CMS</div>
		<ul id="nav">
			<li><a href="#"> <i class="fas fa-user"></i> <i
					class="fas fa-sort-down"></i>
			</a></li>
			<ul id="subNav">
				<li><a href="edit-profile.tiles"> <i class="fas fa-user"></i>
						User Profile
				</a></li>
				<li><a href="index.jsp"> <i class="fas fa-sign-out-alt"></i>
						Logout
				</a></li>
			</ul>
		</ul>
	</div>
</body>
</html>