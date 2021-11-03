<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>선수 ${playerConrollerType } 페이지</title>
</head>
<body>

	<form action="/player" method="POST">
	
		<c:if test="${playerConrollerType=='수정' }">
			<input type="hidden" name="_method" value="PUT"/>
			<input type="hidden" name="playerId" value="${player.playerId }" />
		</c:if>
		
		<fieldset>
			<legend>선수 ${playerConrollerType } 페이지</legend>
			<p>
				<input type="text" name="name" placeholder="선수 이름" value="${player.name }"/>
			</p>
			<p>
				<input type="text" name="height" placeholder="키" value="${player.height }"/>
			</p>
			<p>
				<input type="text" name="weight" placeholder="몸무게" value="${player.weight }"/>
			</p>
			<p>
				<input type="text" name="birthDate" placeholder="생년월일(예 2020-02-13)" value="${player.birthDate }"/>
			</p>
			<p>
				<c:forEach items="${clubs }" var="club" varStatus="status">
					<input name="clubId" 
						   type="radio" 
						   value="${club.clubId }" 
						   id="clubId${status.index }" 
						   <c:if test="${club.clubId==player.clubId }">
						   		checked
						   </c:if> 
						   />
					<label for="clubId${status.index }">${club.name }</label>
				</c:forEach>
			</p>
			<button>${playerConrollerType }</button>
		</fieldset>
	</form>

</body>
</html>