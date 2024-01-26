<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feed</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/feedList.css" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<body>

<div id="wrap" class="container">
    <c:import url="/WEB-INF/jsp/include/header.jsp"/>

	<section class="d-flex justify-content-center">
		<div>
	        <nav class="d-flex justify-content-between">
	            <div class="dropdown">
	                <button class="btn dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
	                        aria-haspopup="true" aria-expanded="false">
	                    Latest
	                </button>
	                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	                    <a class="dropdown-item" href="#">Latest</a>
	                    <a class="dropdown-item" href="#">Trending</a>
	                </div>
	            </div>
	            <button id="signInBtn" type="submit" onclick="location.href= '/post/create-view'" class="btn"
	                    style="background-color: rgb(252, 234, 136);">Add
	            </button>
	        </nav>
	        
	         <!-- 타임라인  -->
			<c:forEach items="${postList}" var="post" varStatus="status">
			<div>
				<div class="row">
					<div class="col-3">
						<div>
							<img src="/images/person.jpeg">
						</div>
						<div>${post.creator}</div>
						<button id="followBtn${status.index}">팔로우</button>
					</div>
				</div>
	
				<div class="row">
					<div class="col-12">
						<div class="row">
							<c:forEach items="${post.voteOptions}" var="voteOption" varStatus="voteOptionStatus">
								<div class="d-flex justify-content-between">
									<div>
										<div>${voteOption.voteOptionName}</div>
										<img src="/static${voteOption.imagePath}" width="100" height="200"/>
										<div><input type="radio" name="voteOption${status.index}" id="post${status.index}Btn${voteOptionStatus.index}" value="post${status.index}Btn${voteOptionStatus.index}" /></div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="row">
							<button id="btnVote${status.index}" class="voteButton">Vote</button>
						</div>
					</div>
				</div>
	
				<div class="row">
					<div>
						<div>${post.title}</div>
						<div>${post.content}</div>
						<div>20 people</div>
						<div>
							<div>
								<div id="like${status.index}">Icon</div>
								<div id="dislike${status.index}">${post.likeCount}</div>
							</div>
							<div>
								<div id="like${status.index}">Icon</div>
								<div id="dislike${status.index}">${post.dislikeCount}</div>
							</div>
						</div>
					</div>
				</div>
	
				<div class="row" >
					<div>
						<input type="text" placeholder="댓글 달기..." />
						<button type="button">게시</button>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</section>

    <c:import url="/WEB-INF/jsp/include/footer.jsp"/>

	<script>

		// 글쓰기 버튼 누르면 서버로 RestAPI 호출하는 코드. 여기서는 사용자가 클릭하는 기능들이 많이 있음. 여러개 만들어야 함.
		$("팔로우 버튼").on("click", function () {});
		$("라이크 버튼").on("click", function () {})
		$("싫어요 버튼").on("click", function () {})
		$("덧글 작성 버튼").on("click", function () {})
		$(".voteButton").on("click", function () {
			const postIndex = $(this).attr('id').split("btnVote")[1];
			const voteOptionIndex = $("input[name='voteOption'"+postIndex+"]:checked").val().split("Btn")[1];

			$.ajax({
				type: "post"
				, url: "/post/create" // => 투표하기 api 호출
				, data: formData
				, enctype: "multipart/form-data"
				, processData: false
				, contentType: false
				, success: function (data) {
					if (data.result == "success") {
						location.reload();
					} else {
						alert("글쓰기 실패");
					}
				}
				, error: function () {
					alert("글쓰기 에러");
				}
			});
		})
	</script>

		<script src="https://code.jquery.com/jquery-3.7.1.min.js"  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>