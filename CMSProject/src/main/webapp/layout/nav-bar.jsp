<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
<link rel="stylesheet" href="<c:url value="/resources/css/NavBar.css"/>" />
</head>
<body>
	<div id="navBar">
	<form id= "itemsearch" action="searchcontent" method="post">
		<div id="wrapperSearch">
			<input type="text" name="search" placeholder="Search... " value="<c:out value='${textsearch}'/>" >    
			
			<button>
				<i class="fas fa-search"></i>
			</button type ="submit">
		</div>
		</form>
		
		<!-- /Content/ -->
		<a href="<c:url value="home"/>"> <i
			class="fontContent bi bi-table"></i> View Contents
		</a> <a href="<c:url value="new"/>"> <i
			class="fontContent fas fa-edit"></i> Form Content
		</a>
	</div>
</body>
</html>