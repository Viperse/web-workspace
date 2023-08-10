<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="servlet.model.vo.MemberVO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
    <div class="container">

		<h2>전체 회원 명단 리스트</h2>
		<table class="table">
			<tr>
				<th></th>
				<th>ID</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
			
			<c:forEach items="${list}" var="i">
			<tr>
				<td></td>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.address}</td>
			</tr>
			</c:forEach>		
		</table>
	</div>
</body>
</html>