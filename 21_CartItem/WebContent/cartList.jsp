<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>장바구니</h1>
    <a href="itemList.do">쇼핑 계속하기</a>
    <div>
        <table border="1">
            <tr>
                <th>번호</th>
                <th>상품이미지</th>
                <th>상품명</th>
                <th>상품가격</th>
                <th>수량</th>
                <th><button>삭제</button></th>
            </tr>
            <c:forEach begin="1" var="{value}">
            <tr>
            	<td>${value}</td>
            	<td></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="6">총 결제 금액 : </td>
            </tr>
        </table>
    </div>
</body>
</html>