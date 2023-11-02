<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feed</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<body>

	<div id="wrap" class="container">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section>
			<input id="concernName" class="form-control" placeholder="What is your concern?">
  				
  				<div class="line2 d-flex justify-content-between mt-5">
  					<select id="concernCategory" class="form-control col-5">
						<option value="">Category</option>
						<option value="3"></option>
						<option value="6">b</option>
						<option value="12">c</option>
						<option value="24">d</option>
						<option value="48">e<option>
					</select>
	  				
					<select id="concernVoteDuration" class="form-control col-5">
						<option value="">Vote duration</option>
						<option value="3">3 hours</option>
						<option value="6">6 hours</option>
						<option value="12">12 hours</option>
						<option value="24">24 hours</option>
						<option value="48">48 hours<option>
					</select>
  				</div>
  				
  				<div class="d-flex justify-content-center mt-3 mb-3">
  					<button type="button" id="addConcernBtn" class="btn" style="background-color: rgb(252, 234, 136">고민 추가</button>
  				</div>
  				
  				
  				<div class="border rounded">
  				  	<div id="concernArea" class="row">
  						
  					</div>
  				</div>
  				
  				<div>
  					
  				</div>

  				
  				<div class="d-flex justify-content-center mt-3 mb-3">
  					<button type="button" id="postConcernBtn" class="btn" style="background-color: rgb(252, 234, 136">고민 등록</button>
  				</div>


		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


	<script>
	  // dropdown에서 선택한 숫자만큼의 입력 폼을 동적으로 생성
/* 	  $('#numberOfConcerns').change(function() {
	    var numberOfConcerns = $(this).val();
	    var formFields = '';
	    for (var i = 1; i <= numberOfConcerns; i++) {
			
	    }
	    $('#thoughtForms').html(formFields);
	  }); */
	  var concernIndex = 0;
	  $("#addConcernBtn").click(function() {
		  concernIndex++
		  $("#concernArea").append('<div id="concernIndex' + concernIndex + '" class="col-3">'
				  +'<input type="text" id="concernOptionName' + concernIndex + '" class="form-control" placeholder="Concern ' + concernIndex + '">'
				  +'<textarea id="concernOptionDiscription' + concernIndex + '"  class="form-control" placeholder="Content ' + concernIndex + '"></textarea>'
				  +'<div>'
				  +'<input type="file" id="concernFile' + concernIndex + '" class="btn"></input>'
				  +'<button type="submit" id="concernDelete' + concernIndex + '"  class="btn btn-danger">고민 삭제</button>'
				  +'</div>'
				  +'</div>')
	  });
	  
      $(document).on("click", "button[id^='concernDelete']", function() {
          var concernIndex = $(this).attr("id").replace("concernDelete", "");
          $("#concernIndex" + concernIndex).remove();
      });
	  
	  
	  
	  
	  $("#postConcernBtn").on("click", function() {
		  
		  
		  
		 var formData = new FormData(); 
		  let concernsList = [];
		  
		  let concernTitle = $("#concernTitle").val();
		  
		  let concernCategory = $("#concernCategory :selected").val();
		  
		  let concernDuration = $("#concernDuration :selected").val();
		  
		  
		  
			if(concernTitle == "") {
				alert("Fill your Concern Title");
				return ;
			}
			
			if(concernCategory == "") {
				alert("Fill your Concern Category");
				return ;
			}
			
			if(concernDuration == "") {
				alert("Fill your Concern Concern Duration");
				return ;
			}

		  
/* 		  let concernTitleList = [];
		  let concernContentList = []; */
		  
			for (let i = 1; i <= concernIndex; i++ ) {
				if($("#concernOptionName" + i).val() === undefined) {
				continue;
				}
				let concernOptionName = $("#concernOptionName" + i).val();
				let concernOptionDiscription = $("#concernOptionDiscription" + i).val();
				let fileInput = $("#concernFile" + i)[0].files;
				
				if(concernOptionName == "") {
					alert("Fill your Concern Title");
					return ;
				}
				
				if(concernOptionDiscription == "") {
					alert("Fill your Concern Content");
					return ;
				}
				
				
				
 				let concernData = {
					optionName: concernOptionName
					, optionDiscription: concernOptionDiscription
					, file: fileInput[0]
				}; 
				

				/* formData.append("file", fileInput); */
				
				
					
				concernsList.push(concernData); // Add concern Info to array
/* /* 				concernTitleList.push(concernTitle); 
				concernContentList.push(concernContent);  */ 
				
				
				
				
				console.log(concernData);
				
			

			}
		  
		  console.log(concernTitle + " " + concernCategory + " " + concernDuration);
			
			formData.append("title", concernTitle);
			formData.append("category", concernCategory);
			formData.append("duration", concernDuration);
			
			for(let i = 0; i < concernsList.length; i++) {
				formData.append("concernList[" + i + "].optionName", concernsList[i].optionName);  // concernsList[0].optionName
				formData.append("concernList[" + i + "].optionDiscription", concernsList[i].optionDiscription);
				formData.append("concernList[" + i + "].file", concernsList[i].file);
			}
			
			
			// 파일 데이터를 리스트로 저장해서 컨트롤러를 넘기는법
		  



			
			
			// AJAX Request
			
			
			
			$.ajax({
				type:"post"
				, url:"/post/create"
				, data: formData
				, enctype:"multipart/form-data"
				, processData: false
		        , contentType: false
				, dataType:'json'
				, success:function(data) {
					if(data.result == "success") {
						location.reload();
					} else {
						alert("글쓰기 실패");
					}
					
				}
				, error:function() {
					alert("글쓰기 에러");
				}
			});
			
	  });
			

	  
	  
	</script>

	
	
	
	
	
	
	
	
</body>
</html>