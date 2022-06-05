<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>PSH Entertainment | Artists</title>
</head>
<body>

	<c:import url="/WEB-INF/template/header.jsp"/>
	
	<h2>총 선수(${total }명)</h2>
	<ul>
		<c:forEach items="${players }" var="player">
			<li>
				<a href="/player/${player.playerId }">
					<!-- <img alt="프로필사진" src="/profile/${player.profile }"> -->
					<h3>${player.name }</h3>
				</a>
			</li>
		</c:forEach>
		${paginate }
	</ul>

	<a href="/">메인으로</a>
	<a href="/player/register">선수 등록</a>
	
</body>
</html>