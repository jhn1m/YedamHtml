<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberUpdate.jsp</title>
</head>
<body>
<%
	MemberVO vo = (MemberVO) request.getAttribute("member");
	%>
<h3>회원정보 검색</h3>
	<form action="<%=request.getContextPath()%>/memberSearch.do" method="post">
		아이디 : <input type="text" name="id"><br> 
		<input type="hidden" name="job" value="update"><br> 
		<input type="submit" value="조회">
	</form>
	
	<%
	if(){
		
	}
	%>
	
</body>
</html>