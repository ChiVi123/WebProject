<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/Header.css"/>" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
</head>
<body>
	<div id="header">
		<div id="logo">CMS</div>
		<ul id="nav">
			<button onclick="myFunction()" class="dropbtn">
				<i class="fas fa-user"></i> 
				<i class="fas fa-sort-down"></i>
			</button>
			<ul id="subNav" class="dropdown-content">
				<li>
					<a href="edit-profile.tiles"> 
						<i class="fas fa-user"></i>
							User Profile
					</a>
				</li>
				<li>
					<a href="index.jsp"> 
					<i class="fas fa-sign-out-alt"></i>
						Logout
					</a>
				</li>
			</ul>
		</ul>
	</div>
	<script type="text/javascript" src="<c:url value="/resources/js/dropdown-menu.js"/>"></script>
</body>
</html>