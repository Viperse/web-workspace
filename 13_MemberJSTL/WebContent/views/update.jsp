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
    <form action="/UpdateServlet" method="post">

        ID : <input type="text" name="id" value="${dto.id}" readonly><br>
        PASSWORD : <input type="password" name="password" value="${dto.password}"><br>
        이름 : <input type="text" name="name" value="${dto.name}"><br>
        주소 : <input type="text" name="address" value="${dto.address}"><br><br>
        <input type="submit" value="수정하기">

    </form>
</body>
</html>