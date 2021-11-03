<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>팀 ${club!=null? "수정":"입력" }폼</title>
</head>
<body>
	
	<!-- #파라미터 넣기 -->
	<c:import url="/WEB-INF/template/header.jsp"></c:import>
	
	<h2>팀 ${club!=null? "수정":"입력" }</h2>
	
	<form action="/club" method="POST">
		<c:if test="${club!=null }">
			<input type="hidden" name="_method" value="PUT"/>
			<input type="hidden" name="clubId" value="${club.clubId }">
		</c:if>
		<fieldset>
			<legend>팀 ${club!=null? "수정":"입력" }폼</legend>
			<p>
				<input type="text" name="name" placeholder="이름" value="${club.name }">
			</p>
			<p>
				<input type="text" name="coach" placeholder="감독명" value="${club.coach }">
			</p>
			<p>
				<input type="text" name="foundingDate" placeholder="창단일" value="${club.foundingDate }">
			</p>
			<button>${club!=null? "수정":"입력" }</button>
		</fieldset>
	</form>

</body>
</html>