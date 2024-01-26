<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<header class="d-flex align-items-center">
		<i class="bi bi-list fs-3 col-4"></i>
		<a href="/post/feed-list" class="col-4"><img src="/static/images/logo.png" width="200px"></a>
		<div class="d-flex col-4 justify-content-end">
			<div class="font-weight-bold">${userFullName }</div>
			<a href="/user/signOut">Sign out</a>
		</div>
	</header>
	
</body>
</html>