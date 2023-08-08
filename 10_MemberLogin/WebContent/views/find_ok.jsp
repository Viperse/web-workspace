<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.model.vo.MemberDTO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<% MemberDTO dto = (MemberDTO) request.getAttribute("dto"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이디 검색 정보</h2>
	<p>ID : <%= dto.getId() %></p>
	<p>이름 : <%= dto.getName() %></p>
	<p>주소 : <%= dto.getAddress() %></p>
</body>
</html>