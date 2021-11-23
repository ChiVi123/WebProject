<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	width: 100%;
	position: fixed;
	top: 0;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

aside {
	float: left;
	position: fixed;
	top: 46px;
	width: 20%;
	height: 100%;
	background-color: var(--theme-header-navbar);
}

section {
	float: left;
	width: 80%;
	margin-top: 46px;
	margin-left: 20%;
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