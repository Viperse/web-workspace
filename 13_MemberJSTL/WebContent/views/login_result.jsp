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
	<h2>로그인 정보</h2>
	<p>ID : ${dto.id}</p>
	<p>PASSWORD : ${dto.password}</p>
	<p>이름 : ${dto.name}</p>
	<p>주소 : ${dto.address}</p>
	
	<a href="index.jsp">메인 화면으로 가기</a>
</body>
</html>