<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/Register.css"/>" />
</head>
<body>
	<div id="des" class="register">
		<h2>Register</h2>
		<br>
		<div class="form-group">
		<input id="user" class="user" type="text" placeholder="User name">
		<span class="text-message"></span>
		</div>
		<br>
		<div class="form-group">
		<input id="email" class="email" type="email" placeholder="E-mail">
		<span class="text-message"></span>
		</div>
		<br>
		<div class="form-group">
		<input id="pass" class="pass" type="password" placeholder="Password">
		<span class="text-message"></span>
		</div>
		<br>
		<div class="form-group">
		<input id="repass" class="email" type="password" placeholder="Re Password">
		<span class="text-message"></span>
		</div>
		<br>
		<div class="form-group">
		<button>Register</button></div>
		<a href="index.jsp" >Click here to Login</a>
	</div>
	<script src="<c:url value="/resources/js/validator.js"/>"></script>
    <script>
        Validator({
            form: "#des",
            formGroup: ".form-group",
            errorSelector: ".text-message",
            rules: [
                Validator.isRequired("#user"),
                Validator.checkLength("#user", 3, 30),
                Validator.isRequired("#email"),
                Validator.checkLength("#email", 5),
                Validator.isRequired("#pass"),
                Validator.checkLength("#pass", 8, 30),
                Validator.isRequired("#repass"),
                Validator.checkLength("#repass", 8, 30),
            ],
        });
    </script>
</body>
</html>