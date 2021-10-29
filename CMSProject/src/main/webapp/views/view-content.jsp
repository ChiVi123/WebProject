<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/views/ViewContent.css"/>" />
</head>
<body>
	<h1>View Content</h1>
	<div class="khung">
		<font size="3px" style="margin-left:10px">View content list</font>
		<hr>
		<table>
			<tr>
				<th style="width:3%">#</th>
				<th align="left" style="width:15%">Title</th>
				<th align="left" style="width:40%">Brief</th>
				<th align="left" style="width:10%">Created Date</th>
				<th align="left" style="width:7%">Actions</th>
			</tr>
			<c:forEach var="table" items="${alluser.rows}">
				<tr>
					<td><c:out value="${table.ID}"></c:out></td>
					<td><c:out value="${table.Title}"></c:out></td>
					<td><c:out value="${table.Brief}"></c:out></td>
					<td><c:out value="${table.CreatedDate}"></c:out></td>
					<td><div class="group-flex">
							<div>
								<a class="link"
									href="#">Edit</a>
									&emsp;
								<a class="link"
									href="#">Delete</a>
							</div>
						</div></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<br>
		<br>
		<br>
		<ul class="pagination modal-4">
  		<li><a href="#" class="prev">
    	<i class="fa fa-chevron-left"></i>
      	Previous
    	</a>
  		</li>
  		<li><a href="#" class="active">1</a></li>
  		<li> <a href="#">2</a></li>
  		<li> <a href="#">3</a></li>
  		<li> <a href="#">4</a></li>
  		<li> <a href="#">5</a></li>
  		<li> <a href="#">6</a></li>
  		<li> <a href="#">7</a></li>
  		<li><a href="#" class="next"> Next 
    		<i class="fa fa-chevron-right"></i>
  		</a></li>
		</ul>
</body>
</html>