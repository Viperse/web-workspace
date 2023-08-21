<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>회원 정보 수정하기</h2>
    <form action="/update.do" method="post">
	
        ID : <input type="text" name="id" value="${vo.id}" readonly><br>
        PASSWORD : <input type="password" name="password" value="${vo.password}"><br>
        이름 : <input type="text" name="name" value="${vo.name}"><br>
        주소 : <input type="text" name="address" value="${vo.address}"><br><br>
        <input type="submit" value="수정하기">

    </form>
    
    <h2>비밀번호만 변경</h2>
    <form action="/update.do" method="post">
	
        ID : <input type="text" name="id" value="${vo.id}" readonly><br>
        PASSWORD : <input type="password" name="password" value="${vo.password}"><br>
        <input type="submit" value="수정하기">

    </form>
    
</body>
</html>