<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<% HttpSession session1 = request.getSession(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%session1.invalidate(); %>
	<script>
		alert('로그아웃!');
		location.href='../index.jsp';
	</script>
</body>
</html>