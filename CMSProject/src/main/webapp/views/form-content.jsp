<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/Content.css"/>" />
</head>
<body>
	<div id="load">Loading</div>
	<div id="main-content">
		<c:if test="${content == null}">
			<div id="primary-title">Add Content</div>
		</c:if>
		
		<c:if test="${content != null}">
			<div id="primary-title">Edit Content</div>
		</c:if>
		
		<!-- horizontal line -->
		<hr>
		
		<c:if test="${content == null}">
			<form action="insertContent" class="form" id="form-content" method="post">
				<div id="sub-title">Add Content Elements</div>
		</c:if>
		
		<c:if test="${content != null}">
			<form action="updateContent" class="form" id="form-content" method="post">
				<div id="sub-title">Edit Content Elements</div>
		</c:if>
		
				<div id="input-content">
					<c:if test="${content != null}">
						<!--Input ID -->
						<input type="hidden" name="id" value="<c:out value='${content.id}'/>" />
						<!--Input AUTHOR ID -->
						<%-- <input type="hidden" name="id" value="<c:out value='${content.AuthorId}' />" /> --%>
					</c:if>
						<!-- Input Title -->
						<div class="item">
							<label for="title" class="form-label">Title</label>
							<input type="text" name="title" id="title" class="form-control"
								placeholder="Enter the title" value="<c:out value='${content.title}' />" />
							<span class="form-message"></span>
						</div>
						<!-- Input Brief -->
						<div class="item">
							<label for="brief"  class="form-label">Brief</label>
							<textarea name="brief" id="brief"cols="50" rows="4" class="form-control" >
								<c:out value='${content.brief}' />
							</textarea>
							<span class="form-message"></span>
						</div>
						<!-- Input Content -->
						<div class="item">
							<label for="content" class="form-label">Content</label>
							<textarea name="content" id="content"cols="50" rows="6" class="form-control" >
								<c:out value='${content.content}' />	
							</textarea>
							<span class="form-message"></span>
						</div>
						<!-- Submit -->
						<button class="item-button">Submit Button</button>
						
						<!-- Clear Character All Field -->
						<button id="reset" class="item-button">Reset Button</button>
				</div>
			</form>
	</div>
	<script src="<c:url value="/resources/js/validator.js"/>"></script>
	<script src="<c:url value="/resources/js/reset.js"/>"></script>
    <script>
        Validator({
            form: "#form-content",
            formGroup: ".item",
            errorSelector: ".form-message",
            rules: [
                Validator.isRequired("#title"),
                Validator.checkLength("#title", 10, 200),
                Validator.isRequired("#brief"),
                Validator.checkLength("#brief", 30, 150),
                Validator.isRequired("#content"),
                Validator.checkLength("#content", 50, 1000),                        
            ],
        });
        
        Reset({
        	form: "#form-content",
        	resetButton: "#reset",
        });
    </script>
    <script type="text/javascript"
		src="<c:url value="/resources/js/loading.js" />"></script>
	<script type="text/javascript">
		Loading({
			load : "#load",
			form : "#main-content",
		}, 5000);
	</script>
</body>
</html>