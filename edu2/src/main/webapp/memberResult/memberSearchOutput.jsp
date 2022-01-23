<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	MemberVO vo = (MemberVO) request.getAttribute("member");
	%>

	<h3>검색결과</h3>
	<p>
		아이디 :
		<%=vo.getId()%>
	<p>
		이름 :
		<%=vo.getName()%>
	<p>
		이메일 :
		<%=vo.getMail()%>
		<%@ include file="home.jsp"%>
</body>
</html>