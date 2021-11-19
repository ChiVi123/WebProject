<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/edit-profile.css"/>" />
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
						size="50" type="Text" class="form-control"
						id="firstname"	name="firstname" placeholder="Enter the first name" /> <span
						class="text-message"></span>
				</div>
				<div class="form-group">
					<label class="labeltext">Last Name</label> <br> <input
						size="50" type="text"  class="form-control"
					id="lastname"	name="lastname" placeholder="Enter the last name" /> <span
						class="text-message"></span>
				</div>

				<div class="form-group">
			   <label class="labeltext">Email</label> <br>  <p
						 class="emailinput" />yourgmail</p> <span class="text-danger"></span>
				</div>
				<div class="form-group">
					<label class="labeltext">Phone </label> <br> <input size="50"
					 type="text" class="form-control" name="phone" id="phone"
						placeholder="Enter your phone number" /> 
						
						<span class="text-message"></span>
						
				</div>
				<div class="form-group">
					<label class="labeltext"> Description </label> <br>
					<textarea class="form-control" id ="description" name="description" cols="50" rows="6"
						autofocus> </textarea>
					<span class="text-message"> </span>
				</div>

				<div class="form-group">
					<input type="submit" value="Submit Button" class=" btn-space " />
					<input type="reset" value="Reset Button" class=" btn-space " />
	               
				</div>

			</div>
		</form>
	</div>
	<script src="<c:url value="/resources/js/validator.js"/>"></script>
    <script>
        Validator({
            form: "#des",
            formGroup: ".form-group",
            errorSelector: ".text-message",
            rules: [
                Validator.isRequired("#firstname"),
                Validator.checkLength("#firstname", 3, 30),
                Validator.isRequired("#lastname"),
                Validator.checkLength("#lastname", 3, 30),
                Validator.isRequired("#phone"),
                Validator.checkLength("#phone", 9, 13),
                Validator.isRequired("#description"),
                Validator.checkLength("#description", 0, 1000),                        
            ],
         /*   onSubmit: function (data) {
                console.log(data);
            }*/
        });
    </script>
</body>
</html>