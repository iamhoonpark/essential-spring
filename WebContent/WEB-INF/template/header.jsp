<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<form action="/session" id="logoutForm" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>	
	</form>
	<button form="logoutForm">로그아웃</button>
</header>