<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.model.vo.MemberVO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이디 검색 정보</h2>
	<p>ID : ${vo.id}</p>
	<p>이름 : ${vo.name}</p>
	<p>주소 : ${vo.address}</p>
</body>
</html>