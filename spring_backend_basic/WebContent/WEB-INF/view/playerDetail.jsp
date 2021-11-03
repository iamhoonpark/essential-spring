<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>>PSH Entertainment | Players | 상세페이지 </title>
</head>
<body>

	<c:import url="/WEB-INF/template/header.jsp"></c:import>
	
	<h2>${player.name }의 상세정보</h2>
	
	<!-- forEach를 할 필요가 없음 = selectOne -->
	<dl>
		<dt>번호</dt>
		<dd>${player.playerId }</dd>
					
		<dt>소속팀</dt>
		<dd><a href="/club/${player.clubId }">${player.clubId }번 ${player.clubName }</a></dd>
		
		<dt>이름</dt>
		<dd>${player.name }</dd>
		
		<dt>키</dt>
		<dd>${player.height }cm</dd>
		
		<dt>몸무게</dt>
		<dd>${player.weight }kg</dd>
		
		<dt>생일</dt>
		<dd><fmt:formatDate pattern="yyyy년 M월 d일" value="${player.birthDate }"/></dd>
	</dl>
	
	<p>
		<a href="/player/update/${player.playerId }">수정</a>
		<button form="playerDelete">삭제</button>
	</p>
	
	<form action="/player/${player.playerId }" method="POST" id="playerDelete">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	
	<p>
		<a href="/player/page/${pageNo }">목록으로</a>
	</p>
	
	<c:if test="${player==null }">
		<c:redirect url="/player/page/1"/>
	</c:if>
	
</body>
</html>