<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
	<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>
	<div class="login">
		<form action="home.tiles" id="login" method="post">
		<h3>Please Sign In</h3>
		<br>
		<br>
		<br>
		<hr>
		<br>
		<input class="email" name="email" type="email" placeholder="E-mail">
		<br>
		<input class="pass" name="pass" type="password" placeholder="Password">
		<br>
		<div class="check">
			<input class="checkbox" type="checkbox" placeholder="Enter password"> Remember me
		</div>
		<br>
		<button>Login</button>
		<br>
		<a href="register.jsp">Click here to Register</a>
		</form>
	</div>
</body>
</html>