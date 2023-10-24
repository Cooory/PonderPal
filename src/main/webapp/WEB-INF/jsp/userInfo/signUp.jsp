<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<body>

	<div id="wrap" class="container">
		<section class="content d-flex justify-content-center my-5">
			<div>
				<div class="login-box d-flex justify-content-center align-items-start bg-white border rounded">
					<div class="w-100 p-4">
						<img src="/static/images/logo.png" width="382px" class="mb-3 justify-content-center">
						<br>
						<div class="text-center">
							<b class="text-secondary">SHARE YOUR MIND</b>
						</div> <br>
						
						<div class="d-flex mt-3">
							<input type="text" id="emailInput" class="form-control" placeholder="Email">
							<button type="button" class="btn btn-sm ml-2" id="isDuplicateBtn" style="background-color: rgb(252, 234, 136);">Duplicate Check</button>
						</div>
						<div class="small text-success d-none" id="availableText">Available Email</div>
						<div class="small text-danger d-none" id="duplicateText">Duplicated Email</div>
					
						<input type="password" id="passwordInput" class="form-control mt-3" placeholder="Password">
						<input type="password" id="passwordConfirmInput" class="form-control mt-3" placeholder="Confirm password">
						
						<input type="text" id="fullNameInput" class="form-control mt-3" placeholder="Full Name">
						<input type="text" id="userNameInput" class="form-control mt-3" placeholder="Username">
						<input type="text" id="contactNumberInput" class="form-control mt-3" placeholder="Contact Number">
						<select class="form-control mt-3" id="genderSelect">
							<option value="">Gender</option>
							<option value="1">Male</option>
							<option value="1">Female</option>
							<option value="1">Other</option>
				        </select>   
						<input type="text" id="birthInput" class="form-control mt-3" placeholder="Birth"> <br>
						<textarea id="introductionInput" class="form-control" cols="40px" rows="5" placeholder="Introduction"></textarea>
						
						<button type="button" id="signUpBtn" class="btn btn-block mt-3" style="background-color: rgb(252, 234, 136);">Sign Up</button>
				
					</div>
					
				</div>
				<div class="mt-4 p-3 d-flex justify-content-center align-items-start bg-white  border rounded">
					<div class="mr-2">
					Already have an account?
					</div>
					<a href="/user/signIn">Sign In</a>
				</div>

			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


	<script>
		$(document).ready(function() {
			
			$("#signUpBtn").on("click", function() {
				let email = $("#emailInput").val();
				let password = $("#passwordInput").val();
				let passwordConfirm = $("#passwordConfirmInput").val();
				let fullName = $("#fullNameInput").val();
				let userName = $("#userNameInput").val();
				let contactNumber = $("#contactNumberInput").val();
				let gender = $("#genderSelect").val();
				let birth = $("#birthInput").val();
				let introduction = $("#introductionInput").val();
				
				if(email == "") {
					alert("Enter your Email");
					return ;
				}
				
				if(password == "") {
					alert("Enter your Password");
					return ;
				}
				
				if(passwordConfirm != password) {
					alert("The Password does not match");
					return ;
				}
				
				if(fullName == "") {
					alert("Enter your Fullname");
					return ;
				}
				
				if(userName == "") {
					alert("Enter your Username");
					return ;
				}
				
				if(contactNumber == "") {
					alert("Enter your Contact Number");
					return ;
				}
				
				if(gender === "Gender") {
					alert("Enter your Gender");
					return ;
				}
				
				if(birth == "") {
					alert("Enter your Birth");
					return ;
				}
				
				if(introduction == "") {
					alert("Enter your introduction");
					return ;
				}
				
				$.ajax({
					type:"post"
					, url:"/user/signUp"
					, data:{"email":email, "password":password, "fullName":fullName, "userName":userName, "contactNumber":contactNumber, "gender":gender, "birth":birth, "introduction":introduction}
					, success:function(data) {
						
						if(data.result == "success") {
							location.href = "/user/signIn-view"
						} else {
							alert("Sign Up Failed");
						}
					}
					, error:function() {
						alert("Sign Up Error");
					}
				});
				
			});
		});
	</script>

	
	
	
	
	
	
	
	
</body>
</html>