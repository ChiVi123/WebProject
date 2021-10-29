<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/views/Register.css"/>" />
</head>
<body>
	<div class="register">
		<h2>Register</h2>
		<br>
		<input class="user" type="text" placeholder="User name">
		<br>
		<input class="email" type="email" placeholder="E-mail">
		<br>
		<input class="pass" type="password" placeholder="Password">
		<br>
		<input class="email" type="password" placeholder="Re Password">
		<br>
		<button>Register</button>
		<a href="index.jsp" >Click here to Login</a>
	</div>
</body>
</html>