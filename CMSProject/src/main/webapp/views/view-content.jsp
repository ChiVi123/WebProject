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
							<td><c:out value="${content.id}" /></td>
							<td><c:out value="${content.title}" /></td>
							<td><c:out value="${content.brief}" /></td>
							<td>
								<%-- <c:out value="${content.createdate}" /> --%>
							</td>
							<td>
								<div class="group-flex">
									<div>
										<a class="link" href="edit?id=<c:out value="${content.id}" />">Edit</a>
										&emsp; <a class="link"
											href="delete?id=<c:out value="${content.id}" />">Delete</a>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
			</table>
		</div>
		<br> <br> <br>
		<ul class="pagination">
			<c:if test="${ page != 1 }">
					<a href="/CMSProject/home?page=${ page - 1 }" tabindex="-1" aria-disabled="true">&laquo;</a>
			</c:if>
			<c:forEach var="i" begin="1" end="${ totalPage }">
				<c:choose>
					<c:when test="${ page == i }">
						<a class="active" href="/CMSProject/home?page=${ i }">${ i }</a>
					</c:when>
				<c:otherwise>
					<a  href="/CMSProject/home?page=${ i }">${ i }</a>
				</c:otherwise>			
				</c:choose>
			</c:forEach>
			<c:if test="${ page < totalPage }">
					<a  href="/CMSProject/home?page=${ page + 1 }">&raquo;</a>
			</c:if>			
		</ul>
	</div>
</body>
</html>