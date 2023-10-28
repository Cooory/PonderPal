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

	<header class="d-flex align-items-center justify-content-between">
		<img src="/static/images/logo.png" width="200px">
		<div>${userFullName } 님 <a href="/user/signOut">로그아웃</a></div>
	</header>
	
</body>
</html>