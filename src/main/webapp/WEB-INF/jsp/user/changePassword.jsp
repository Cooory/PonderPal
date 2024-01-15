<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
</head>
<body>

	<div id="wrap" class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="content d-flex justify-content-center my-5">
		
		<div>
			<div class="display-4 font-weight-bold">Change Password</div><br><br><br>
			
			<div class="current-password">
				<div class="d-flex justify-content-between mb-2">
					<label class="mr-3">Current Password</label>
					<input type="text" id="currentPassword" class="form-control col-6">
				</div>
				<div class="small text-danger d-none" id="duplicateText">The password does not match</div>
				<div class="small text-success d-none" id="availableText">The password match</div>
				<br>
				<br>
				<hr>
			</div>

			<div class="mt-3 new-password">
				<div class="d-flex justify-content-between mb-2">
					<label class="mr-3">New Password</label>
					<input type="text" id="newPassword" class="form-control col-6">
				</div>
				<br>
				<br>
				<hr>
			</div>
			
			<div class="mt-3 confirm-password">
				<div class="d-flex justify-content-between mb-2">
					<label class="mr-3">Confirm Password</label>
					<input type="text" id="confirmPassword" class="form-control col-6">
				</div>
				<div class="small text-danger d-none" id="duplicateText">The password does not match</div>
				<div class="small text-success d-none" id="availableText">The password match</div>
				<br>
				<br>
				<hr>
				
				<button id="changePasswordBtn" type="submit" class="btn btn-block btn-danger mt-4">Change Password</button>
			</div>
		</div>

			

		


		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>


	<script>
	
	$(document).ready(function() {
		
		$("#newPassword").focusout(function() {
			
			let currentPassword = $("#currentPassword").val();
			let newPassword = $("#newPassword").val();
			let confirmPassword = $("#confirmPassword").val();
			
			
			$.ajax({
				type:"get"
				, url:"/user/duplicateNewPassword"
				, data:{"password":password}
				, success:function(data) {
					
					isCheckDuplicate = true;
					
					if(data.isDuplicate) {
						// Duplicated
						$("#duplicateText").removeClass("d-none");
						$("#availableText").addClass("d-none");
						
						isDuplicate = true;
					} else {
						// Doesn't duplicated
						$("#availableText").removeClass("d-none");
						$("#duplicateText").addClass("d-none");
						
						isDuplicate = false;
					}
				}
				, error:function() {
					alert("Duplicate Check Error");
				}
				
			});
		
		
	});


			
	</script>

	
	
	
	
	
	
	
	
</body>
</html>