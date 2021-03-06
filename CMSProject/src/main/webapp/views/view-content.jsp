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
	<!-- loading -->
	<div id="load">Loading</div>
	<!-- viewcontent -->
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
							<td><c:out value="${content.createdate}" /></td>
							<td>
								<div class="group-flex">
									<div style="height: 40px; padding-top: 10%">
										<a class="link" id="style"
											href="editContent?id=<c:out value="${content.id}" />">Edit</a> <a
											class="link" id="style"
											href="delete?id=<c:out value="${content.id}" />">Delete</a>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
			</table>
		</div>
		<ul class="pagination">
			<c:if test="${ page != 1 }">
				<a href="/CMSProject/home?textsearch=${ textsearch }&page=${ page - 1 }" tabindex="-1"
					aria-disabled="true">&laquo;</a>
			</c:if>
			<c:forEach var="i" begin="1" end="${ totalPage }">
				<c:choose>
					<c:when test="${ page == i }">
						<a class="active" href="/CMSProject/home?textsearch=${ textsearch }&page=${ i }">${ i }</a>
					</c:when>
					<c:otherwise>
						<a href="/CMSProject/home?textsearch=${ textsearch }&page=${ i }">${ i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${ page < totalPage }">
				<a href="/CMSProject/home?textsearch=${ textsearch }&page=${page + 1}">&raquo;</a>
			</c:if>
		</ul>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/loading.js" />"></script>
	<script type="text/javascript">
		Loading({
			load : "#load",
			form : "#formViewContent",
		}, 1000);
	</script>
</body>
</html>