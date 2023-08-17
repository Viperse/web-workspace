<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .container {
        display: flex;
        justify-content: center;
    }

    .container img {
        width: 200px;
        height: 200px;
        object-fit: cover;
        margin-right: 10px;
    }
    
    h1 {
    	text-align: center;
    }
    h2 {
        text-align: center;
    }

    .container2 img {
        width: 100px;
        height: 100px;
    }

</style>
</head>
<body>
		<h1>Fruit Total List</h1>
        <div class="container container1">  
        <c:forEach items="${list}" var="i">
            <div>
                <a href="itemView.do?itemId=${i.itemId}"><img src="${i.pictureUrl}"></a>
                <p>상품명 : ${i.itemName}</p>
                <p>가격 : ${i.price}원</p>
            </div>      
        </c:forEach>
    </div>
    <hr>
    <c:if test="${not empty fruits}">
    <h2>오늘 본 상품들</h2>
    <div class="container container2">
        <c:forEach items="${fruits}" var="i">
        	<div>
        		<img src="${i}">
        	</div>
        </c:forEach>
    </div>
    </c:if>
</body>
</html>