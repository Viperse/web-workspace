<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container container1">
        <h1>Fruit Total List</h1>
        <c:forEach items="${list}" var="i">
        <a href="itemView.do?itemId=${i.itemId}"><img src="${i.pictureUrl}"></a>
        <p>상품명 : ${i.itemName}</p>
        <p>가격 : ${i.price}원</p>
        </c:forEach>
    </div>
    <hr>
    <div class="container container2">
        <h2>오늘 본 상품들</h2>
    </div>
</body>
</html>