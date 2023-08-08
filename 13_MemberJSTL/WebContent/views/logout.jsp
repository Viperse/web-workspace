<%@page import="model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% HttpSession session1 = request.getSession(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<%
	MemberDTO dto = (MemberDTO) session1.getAttribute("dto");
	if(dto!=null) {
	session1.invalidate(); %>
<body onload="return logout()">
	<script>
		function logout() {
			alert('Logout!');
			location.href="../index.jsp";
		}
	</script>
</body>
<%} %>
</html>