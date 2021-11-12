<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/views/edit-profile.css"/>" />
</head>
<body>
<body>
	<div class="formEdit">

		<label class="index"> Edit Profile</label>
		<hr>
		<br>
		<form id="des" action="Edituser" method="post">
			<div class="mainFormElement">
				<label class="labelelement"> Profile Form Element </label>
			</div>

			<div class="form-element">


				<div class="itemhidden">
					<input type="hidden" class="userid" name="id" /> <span
						class="userid"></span>
				</div>

				<div class="form-group">
					<label class="labeltext"> First Name</label> <br> <input
						size="50" maxlength="30" type="Text" class="form-control"
						name="firstname" placeholder="Enter the first name" /> <span
						class="text-danger"></span>
				</div>
				<div class="form-group">
					<label class="labeltext">Last Name</label> <br> <input
						size="50" type="text" maxlength="30" class="form-control"
						name="lastname" placeholder="Enter the last name" /> <span
						class="text-danger"></span>
				</div>

				<div class="form-group">
			   <label class="labeltext">Email</label> <br>  <p
						 class="emailinput" />yourgmail</p> <span class="text-danger"></span>
				</div>
				<div class="form-group">
					<label class="labeltext">Phone </label> <br> <input size="50"
						maxlength="13" type="text" class="form-control" name="phone"
						placeholder="Enter your phone number" /> <span class="text-danger"></span>
				</div>
				<div class="form-group">
					<label class="labeltext"> Description </label> <br>
					<textarea class="form-control" name="description" cols="50" rows="6"
						autofocus> </textarea>
					<span class="text-danger"> </span>
				</div>

				<div class="form-group">
					<input type="submit" value="Submit Button" class=" btn-space " />
					<input type="reset" value="Reset Button" class=" btn-space " />

				</div>

			</div>
		</form>



	</div>
</body>
</html>