<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>	
	<c:when test="${!empty vo}">
		<h2>로그인 정보</h2>
		<p>ID : ${vo.id}</p>
		<p>PASSWORD : ${vo.password}</p>
		<p>이름 : ${vo.name}</p>
		<p>주소 : ${vo.address}</p>
		
		<a href="/index.jsp">메인 화면으로 가기</a>
	</c:when>
	<c:otherwise>
		<h3>로그인 실패! 로그인부터 하고 오세요!</h3>
		<a href="views/login.html">login.html</a>
	</c:otherwise>
	</c:choose>
	
</body>
</html>