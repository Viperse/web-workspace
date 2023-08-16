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
    <h1>${item.itemName}의 정보</h1>
    <div class="menu">
        조회수 : ${item.count}
        <button onclick="cartAdd()">장바구니 담기</button>
        <a href="cartList.jsp">장바구니 확인</a>
        <a href="itemList.do">상품 목록 보기</a>
    </div>
    <div class="main">
        <img src="${item.pictureUrl}">
        <br>
        종류 : <span id="name">${item.itemName}</span>
        <br>
        가격 : <span id="price"> ${item.price}</span>
        <br>
        설명 : <span>${item.description}</span>
    </div>

    <script>
    function cartAdd() {
        localStorage.setItem("img", document.querySelector('#'))
        localStorage.setItem("name", document.querySelector('#name').value);
        alert('장바구니에 담겨졌습니다!');
    }
    </script>
</body>
</html>