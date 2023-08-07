<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.model.dao.MemberDAO" %>
<%@ page import="servlet.model.vo.MemberDTO" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<% MemberDTO dto = new MemberDTO(); %>
<% dto = (MemberDTO)session.getAttribute("dto"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>ID : <%=dto.getId() %></p>
	<p>PASSWORD : <%=dto.getPassword() %></p>
	<p>이름 : <%=dto.getName() %></p>
	<p>주소 : <%=dto.getAddress() %></p>
	
	<%session.setAttribute("dto", dto); %>
	<a href="index.jsp">메인 화면으로 가기</a>
</body>
</html>