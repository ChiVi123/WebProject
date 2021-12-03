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
	<div class="register">
		<form id="des" action="register" method="post">
		<div class= "style">Register</div>
		<br>
		<br>
		<hr>
		<p style="font-family:courier;color:red;">${mess}</p>
		<div class="form-group">
		<input id="username" class="user" name="user" type="text" placeholder="User name">
		<span class="text-message"></span>
		</div>
		<div class="form-group">
		<input id="Email" class="email" name="email" type="email" placeholder="E-mail">
		<span class="text-message"></span>
		</div>
		<div class="form-group">
		<input id="password" class="pass" name="pass" type="password" placeholder="Password">
		<span class="text-message"></span>
		</div>
		<div class="form-group">
		<input id="repass" class="email" name="repass" type="password" placeholder="Re Password">
		<span class="text-message"></span>
		</div>
		<div class="form-group">
		<button>Register</button></div>
		<a href="index.jsp" >Click here to Login</a>
		</form>
		<br>
		<br>
		<br>
	</div>
	<script src="<c:url value="/resources/js/validator.js"/>"></script>
    <script>
        Validator({
            form: "#des",
            formGroup: ".form-group",
            errorSelector: ".text-message",
            rules: [
                Validator.isRequired("#username","Please enter username!!!"),
                Validator.checkLength("#username", 3, 30),
                Validator.isRequired("#Email","Please enter your email!!!"),
                Validator.checkLength("#Email", 5),
                Validator.isRequired("#password","Please enter your password!!!"),
                Validator.checkLength("#password", 8, 30),
                Validator.isRequired("#repass","Please enter your password!!!"),
                Validator.checkLength("#repass", 8, 30),
            ],
        });
    </script>
</body>
</html>