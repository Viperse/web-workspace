<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
    <h1>장바구니</h1>
    <a href="itemList.do">쇼핑 계속하기</a>
    <div>
        <table border="1" style="width:100%">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>상품이미지</th>
                    <th>상품명</th>
                    <th>상품가격</th>
                    <th>수량</th>
                    <th><button onclick="deleteStorage()">삭제</button></th>
                </tr> 
            </thead>
            <tbody></tbody>
            <tfoot>
                <tr>
                    <td colspan="6">총 결제 금액 : <span id="resultTotal"></span></td>
                </tr>
            </tfoot>          
        </table>
    </div>
    <script>
        let amount = 1;
        let totalPrice = 0;
        refreshPage();

        $('.up').on('click', function() {
            $(this).next().html(eval($(this).next().html())+1);
            amount = $(this).next().html();
            totalPrice += eval($(this).parent().prev().html());
            $('#resultTotal').html(totalPrice);
        });

        $('.down').on('click', function() {  
            if(amount > 1) {
                $(this).prev().html(eval($(this).prev().html())-1);
                amount = $(this).prev().html();
                totalPrice -= eval($(this).parent().prev().html());
                $('#resultTotal').html(totalPrice);
            }         
        });

       function refreshPage() {
        let html = '';
        let count = 0;
            for(let key in localStorage) {
                if(key === 'length') break;
                const data = localStorage.getItem(key).split(",");
                html += '<tr>' +
                            '<td>' + ++count + '</td>' + '<td>' + '<img src=' + data[2] + ' width="150px" height="150px"></td>' +
                            '<td>' + data[0] + '</td>' +
                            '<td>' + data[1] + '</td>' +
                            '<td><img src=img/up.jpg width="10px" height="10px" style=cursor:pointer; class=up><div>' + amount + '</div>' + '<img src=img/down.jpg width="10px" height="10px" style=cursor:pointer; class=down>' + '</td>' +
                            '<td><input value='+key+' type="checkbox" class="deleteItem"></td>' +
                        '</tr>';
                totalPrice += eval(data[1]);
            }
            $('tbody').append(html);
            $('#resultTotal').html(totalPrice);
       }

       function deleteStorage() {
                const check = document.querySelectorAll('.deleteItem');
                for(let i=0; i<check.length; i++) {
                    if(check[i].checked === true) {
                        localStorage.removeItem(check[i].value);
                        location.reload();
                    }
                }
            }
    </script>
</body>
</html>