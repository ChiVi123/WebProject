<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/ViewContent.css"/>" />
</head>
<body>
	<div id="formViewContent">
	<h1>View Content</h1>
	<hr style="opacity: 0.5">
	<br>
		<div class="khung">
			<div style="size: 3px" style="margin-left:10px" id=subTitle>View
				content list</div>
			<hr>
			<table>
				<tr>
					<th style="width: 5%">#</th>
					<th align="left" style="width: 25%">Title</th>
					<th align="left" style="width: 50%">Brief</th>
					<th align="left" style="width: 10%">Created Date</th>
					<th align="left" style="width: 20%">Actions</th>
				</tr>
				<tr>
				<c:forEach var="content" items="${listcontent}">
                                <tr>
                                    <td>
                                        <c:out value="${content.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${content.Title}" />
                                    </td>
                                    <td>
                                        <c:out value="${content.Brief}" />
                                    </td>
                                    <td>
                                        <c:out value="${content.CreateDate}" />
                                    </td>
					<td><div class="group-flex">
							<div>
								<a class="link" href="#">Edit</a> &emsp; <a class="link"
									href="#">Delete</a>
							</div>
						</div></td>
				</tr></c:forEach>
		</table>
		</div>
		<br> <br> <br>
		<ul class="pagination modal-4">
			<li><a href="#" class="prev"> <i class="fa fa-chevron-left"></i>
					Previous
			</a></li>
			<li><a href="#" class="active">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#" class="next"> Next <i
					class="fa fa-chevron-right"></i>
			</a></li>
		</ul>
	</div>
</body>
</html>