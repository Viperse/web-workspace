<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.service.StudentService" %>
<!-- 
	첫 페이지 리스트 뿌려 주기
	service 호출해서 list에 담아 request.setAttribute로 바인딩!
 -->  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
    body {
        padding: 20px;
    }

    .table {
        margin-top: 30px;
    }
</style>
</head>
<body>
	<div class="container">
        <form>
            <input type="text" name="search" style="width: 50%;">
            <input type="button" value="검색" id="ajaxButton">
        </form>

        <table class="table">
            <tr>
                <td>학번</td>
                <td>이름</td>
                <td>주소</td>
                <td>학과</td>
                <td>계열</td>
            </tr>
			<c:forEach items="${list}" var="i">
			<tr>
				<td>${i.studentNo}</td>
				<td>${i.studentName}</td>
				<td>${i.studentAddress}</td>
				<td>${i.department.departmentName}</td>
				<td>${i.department.category}</td>
			</tr>
			</c:forEach>
        </table>
    </div>
    <script>
        $
    </script>
</body>
</html>