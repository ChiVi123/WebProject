<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<style type="text/css">
header {
	border: red;
	border-style: solid;
}

aside {
	border: blue;
	border-style: solid;
}

section {
	border: green;
	border-style: solid;
}
</style>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</header>
	<div>
		<aside>
			<tiles:insertAttribute name="navigation"></tiles:insertAttribute>
		</aside>
		<section>
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</section>
	</div>
</body>
</html>