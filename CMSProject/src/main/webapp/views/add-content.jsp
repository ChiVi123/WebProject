<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/AddContent.css"/>" />
</head>
<body>
	<div id="main-content">
		<c:if test="${user == null}">
			<div id="primary-title">Add Content</div>
		</c:if>
		
		<c:if test="${user != null}">
			<div id="primary-title">Edit Content</div>
		</c:if>
		
		<!-- horizontal line -->
		<hr>
		
		<c:if test="${user == null}">
			<form action="insert" class="form" id="form-content">
				<div id="sub-title">Add Content Elements</div>
		</c:if>
		
		<c:if test="${user != null}">
			<form action="edit" class="form" id="form-content">
				<div id="sub-title">Edit Content Elements</div>
		</c:if>
		
				<div id="input-content">
					<c:if test="${user != null}">
						<!--Input ID  -->
						<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
					</c:if>
						<!-- Input Title -->
						<div class="item">
							<label for="title" class="form-label">Title</label>
							<input type="text" name="title" id="title" class="form-control"
								placeholder="Enter the title">
							<span class="form-message"></span>
						</div>
						<!-- Input Brief -->
						<div class="item">
							<label for="brief"  class="form-label">Brief</label>
							<textarea name="brief" id="brief" cols="50" rows="4"
								class="form-control"></textarea>
							<span class="form-message"></span>
						</div>
						<!-- Input Content -->
						<div class="item">
							<label for="content" class="form-label">Content</label>
							<textarea name="content" id="content" cols="50" rows="6"
								class="form-control"></textarea>
							<span class="form-message"></span>
						</div>
						<!-- Submit -->
						<button class="item-button">Submit Button</button>
						<!-- Clear Character All Field -->
						<button class="item-button">Reset Button</button>
				</div>
			</form>
	</div>
	<script src="<c:url value="/resources/js/validator.js"/>"></script>
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
            onSubmit: function (data) {
                console.log(data);
            }
        });
    </script>
</body>
</html>