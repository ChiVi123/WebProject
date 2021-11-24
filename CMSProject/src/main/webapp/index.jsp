<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Login.css"/>" />
</head>
<body>
	<div class="login">
		<form id="des" action="home.tiles" id="login" method="post">
		<div class= "style">Please Sign In</div>
		<br>
		<br>
		<br>
		<hr>
		<div class="form-group">
		<input id="email" class="email" name="email" type="email" placeholder="E-mail">			
		<span class="text-message"></span>
		</div>
		<div class="form-group">
		<input id="pass" class="pass" name="pass" type="password" placeholder="Password">
		<span class="text-message"></span>
		</div>
		<div class="check">
			<input class="checkbox" type="checkbox" placeholder="Enter password"> Remember me
		</div>
		<div class="form-group">
		<button>Login</button>
		</div>
		<a href="register.jsp">Click here to Register</a>
		</form>
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
                Validator.isRequired("#email"),
                Validator.checkLength("#email", 5, 50),
                Validator.isEmail("#email","error"),
                Validator.isRequired("#pass"),
                Validator.checkLength("#pass", 8, 30),                     
            ],
        });
    </script>
</body>
</html>