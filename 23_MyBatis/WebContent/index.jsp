<%@page import="model.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.service.StudentService" %>
<!-- 
	첫 페이지 리스트 뿌려 주기
	service 호출해서 list에 담아 request.setAttribute로 바인딩!
 -->
<% List<StudentVO> list = new StudentService().showStudent(""); 
   request.setAttribute("list", list);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
    body {
        padding-top: 30px;
    }

    .contrainer .row {
        margin-top: 50px;
        margin-bottom: 30px;
    }

    .table {
        margin-top: 30px;
        text-align: center;
    }

</style>
</head>
<body>
	<div class="container">
        <div class="row">
            <div class="col">
                <input type="text" name="search" id="search" class="form-control">
            </div>
            <div class="col">
                <input type="button" value="검색" id="ajaxButton" class="btn btn-danger">
            </div>
        </div>

        <table class="table table-striped table table-hover">
            <thead>
                <tr>
                    <th>학번</th>
                    <th>이름</th>
                    <th>주소</th>
                    <th>학과</th>
                    <th>계열</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${list}" var="student">
            		<tr>
            			<td>${student.studentNo}</td>
            			<td>${student.studentName}</td>
            			<td>${student.studentAddress}</td>
            			<td>${student.department.departmentName}</td>
            			<td>${student.department.category}</td>
            		</tr>
            	</c:forEach>
            </tbody>
        </table>
    </div>
    <script>
        $('#ajaxButton').click(function() {
            const search = $('#search').val();
            $.ajax({
            type: "get",
            url: "find.do",
            data: 'search='+search,
            dataType: 'json',

            success: function(data) {
                const result = eval(data.result);
                let resultHtml = '';
                for(let item of result) {
                    resultHtml += "<tr>" + 
                        "<td>" + item.studentNo + "</td>" + 
                        "<td>" + item.studentName + "</td>"+ 
                        "<td>" + item.studentAddress + "</td>" + 
                        "<td>" + item.department.departmentName + "</td>" + 
                        "<td>" + item.department.category + "</td>" + 
                        "</tr>";
                }
                $('tbody').html(resultHtml);
            }
            })
        })
    </script>
</body>
</html>