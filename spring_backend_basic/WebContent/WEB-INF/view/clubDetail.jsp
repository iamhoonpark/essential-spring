<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>PSH Entertainment | Groups | ${club.name } 상세페이지</title>
</head>
<body>
	<!-- #import/param 배워서 추가할 것 -->
	<c:import url="/WEB-INF/template/header.jsp"></c:import>
	
	<h2>${club.name }</h2>
	<dl>
		<dt>번호</dt>
		<dd>${club.clubId }</dd>
		
		<dt>구단명</dt>
		<dd>${club.name }</dd>		
		
		<dt>창립일</dt>
		<dd>taglib c: ${club.foundingDate }</dd>
		<dd>taglib fmt: <fmt:formatDate value="${club.foundingDate }" pattern="yyyy년 M월 d일"/> </dd>
		<h4>${wondering.name }</h4>
	</dl>
	<p>
		<a href="/club/${club.clubId }/edit">수정</a>
		<button form="deleteForm" id="deleteBtn">삭제</button>
	</p>
	
	<form action="/club/${club.clubId }" method="POST" id="deleteForm">
		<input type="hidden" name="_method" value="DELETE">
	</form>	
	
	<h3>선수 목록</h3>
	<c:choose>
		<c:when test="${clubPlayers.isEmpty() }">
			<p>등록된 선수가 없습니다.</p>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${clubPlayers }" var="player">
					<li><a href="/player/${player.playerId }">${player.name }</a></li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<p>
		<a href="/player/register">선수 입력</a>
		<a href="/club/page/${pageNo }">목록으로</a>
	</p>
	
<!-- 리스트 객체가 비어있지 않을 때, 삭제버튼 알림 활성화 -->
<c:if test="${!clubPlayers.isEmpty() }">
	<script src="/js/jquery.js"></script>
	<script>
		$("#deleteBtn").on("click",function() {
			return confirm("선수가 존재합니다. 전부 삭제하시겠습니까?");
		});
	</script>
</c:if>

<!-- clubId 값이 0인 구단으로 접속하면 1로 돌려보냄 -->
<c:if test="${club.clubId==0 }">
	<c:redirect url="/club/page/1"/>
</c:if>

</body>
</html>