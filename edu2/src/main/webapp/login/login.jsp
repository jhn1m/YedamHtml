<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login/login.jsp</title>
</head>
<body>
	<h3>로그인페이지</h3>
	<form action='<%=request.getContextPath() %>/login.do' method = 'post'>
	아이디 : <input type = "text" name = "id"><br>
	비밀번호 : <input type = "password" name = "passwd"><br>
	<input type = "submit" value = "로그인">
	</form>
</body>
</html>