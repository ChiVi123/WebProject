<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/views/AddContent.css"/>" />
</head>
<body>
	<div id="formAddContent">
		<div id="title">Add Content</div>
		<!-- horizontal line -->
		<hr>
		<div id="wrapper">
			<div id="subTitle">Add Content Elements</div>
			<div id="inputContent">
				<!-- Input Title -->
				<div class="item">
					<label for="titles">Title</label> <input type="text" name="titles"
						placeholder="Enter the title" size="50">
				</div>
				<!-- Input Brief -->
				<div class="item">
					<label for="brief">Brief</label>
					<textarea name="brief" id="" cols="50" rows="4"></textarea>
				</div>
				<!-- Input Content -->
				<div class="item">
					<label for="content">Content</label>
					<textarea name="content" id="" cols="50" rows="8"></textarea>
				</div>
				<!-- Button -->
				<div class="item">
					<!-- Submit All Field -->
					<button>Submit Button</button>
					<!-- Clear Character All Field -->
					<button>Reset Button</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>