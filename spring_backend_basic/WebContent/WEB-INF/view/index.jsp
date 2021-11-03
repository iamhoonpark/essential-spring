<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>PSH Entertainment</title>
</head>
<body>
	<c:choose>
		<c:when test="${loginMember!=null }">
		<c:import url="/WEB-INF/template/header.jsp"/>
			<h2>Artist</h2>
			<ul>
				<li><a href="/club/page/1">GROUP</a></li>
				<li><a href="/player/page/1">SOLO</a></li>
			</ul>
		</c:when>
	
		<c:otherwise>
			<h1>로그인</h1>
			<form action="/session" method="post">
				<fieldset>
					<legend>로그인폼</legend>
					<p>
						<input name="id" placeholder="아이디">
					</p>
					<p>
						<input type="password" name="password" placeholder="비밀번호">
					</p>
					<c:if test="${msg!=null }">
						<p>${msg }</p>
					</c:if>
					<button>로그인</button>
				</fieldset>
			</form>
		</c:otherwise>
	</c:choose>
	
</body>
</html>