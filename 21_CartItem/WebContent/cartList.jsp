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
    <h1>장바구니</h1>
    <a href="itemList.do">쇼핑 계속하기</a>
    <div>
        <table border="1" id="table">
            <tr>
                <th>번호</th>
                <th>상품이미지</th>
                <th>상품명</th>
                <th>상품가격</th>
                <th>수량</th>
                <th><button>삭제</button></th>
            </tr>        
            <tr id="final">
                <td colspan="6">총 결제 금액 : </td>
            </tr>
        </table>
        
    <script>
       
       let count = 1;

        for(let i=0; i<=5; i++) {
            if(localStorage.getItem('cart-'+i)!=null) {
                let cart = localStorage.getItem('cart-'+i).split(',');
				const tr = document.createElement('tr');
                const td1 = document.createElement('td');
                const td2 = document.createElement('td');
                const td3 = document.createElement('td');
                const td4 = document.createElement('td');
                const td5 = document.createElement('td');
                const td6 = document.createElement('td');
                td1.innerHTML = `${i}`;
                td2.innerHTML = <img src="${cart[2]}" />
                td3.innerHTML = `${cart[0]}`;
                td4.innerHTML = `${cart[1] * count}`;
                td5.innerHTML = `${count}`;
                td6.innerHTML = <input type="checkbox"/>
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                tr.appendChild(td4);
                tr.appendChild(td5);
                tr.appendChild(td6);
                const final = document.querySelector('#final');
                const table = document.querySelector('#table');
                table.insertBefore(tr, final);
            }
        }
    </script>
</body>
</html>