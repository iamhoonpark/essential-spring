<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>PSH Entertainment | Groups</title>
</head>
<body>

	<!-- 파라미터넣기 -->
	<c:import url="/WEB-INF/template/header.jsp"></c:import>
	
	<h2>총 구단(${total }개)</h2>
	<ul>
		<c:forEach items="${clubs }" var="club">
			<li><a href="/club/${club.clubId }">${club.name }</a></li>
		</c:forEach>
	</ul>
	${paginate }
	
	<a href="/">메인으로</a>
	<a href="/club/register">그룹 등록</a>
	
	<!-- 1페이지가 아니면서 club에 데이터가 없을 경우 1페이지로 되돌림 -->
	<c:if test="${page!='1' && clubs.isEmpty() }">
		<c:redirect url="/club/page/1"></c:redirect>
	</c:if>

</body>
</html>