<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	--border-color: #b8b8b8;
	--hover-color: #e1e1e3;
	--theme-header-navbar: #e6e7eb;
}

html {
	font-family: Arial, Helvetica, sans-serif;
}

header {
	
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

aside {
	float: left;
	width: 20%;
	min-height: 500px;
}

section {
	float: right;
	width: 80%;
	min-height: 500px;
}
</style>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</header>
	<div class="row">
		<aside>
			<tiles:insertAttribute name="nav-bar"></tiles:insertAttribute>
		</aside>
		<section>
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</section>
	</div>
</body>
</html>