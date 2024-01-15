<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<body>

	<div class="container">
		<section class="content d-flex justify-content-center my-5">
			<div>
				<div class="login-box d-flex justify-content-center align-items-start bg-white border rounded">		
					<div class="w-100 p-5">			
						<img src="/static/images/logo.png" width="300px" class="mb-3 justify-content-center">
						<br>
						
						<form id="signInForm">
							<input type="text" id="emailInput" class="form-control mt-3" placeholder="Email">
							<input type="password" id="passwordInput" class="form-control mt-3" placeholder="Password"><br>
							<button id="signInBtn" type="submit" class="btn btn-block mt-3" style="background-color: rgb(252, 234, 136);">Sign In</button>
							<hr/>
						</form>
						
						
						<div class="text-center text-secondary">Forgot Password?</div>
					</div>
					
				</div>
				<div class="mt-4 p-3 d-flex justify-content-center align-items-start bg-white border rounded">
					<div class="mr-2">Don't have an account?</div> 
					<a href="/user/signUp-view">Sign Up</a>
				</div>
			</div>
		</section>
		
	</div>
		
		<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
		<script>
		
			$(document).ready(function() {
				
				$("#signInBtn").on("click", function() {
					
					let email = $("#emailInput").val();
					let password = $("#passwordInput").val();
					
					if(email == "") {
						alert("Enter your Email");
						return ;
					}
					
					if(password == "") {
						alert("Enter your Password");
						return ;
					}
					
					$.ajax({
						
						type:"post"
						, url:"/user/signIn"
						, data:{"email":email, "password":password}
						, success:function(data) {
							
							if(data.result == "success") {
								location.href = "/post/feed-list"
							} else {
								alert("Incorrect email or password.");
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