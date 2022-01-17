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
	MemberVO login = (MemberVO) session.getAttribute("login");
	%>
	<h3>회원정보 검색</h3>
	<form action="<%=request.getContextPath()%>/memberSearch.do"
		method="post">
		아이디 : <input type="text" name="id"><br> <input
			type="hidden" name="job" value="update"><br> <input
			type="submit" value="조회">
	</form>

	<%
	if (vo != null) {
	%>
	<p>회원정보수정</p>
	<form action="<%=request.getContextPath()%>/memberUpdate.do"
		method="post">
		아이디 : <input type="text" readonly name="id" value="<%=vo.getId()%>"><br>
		비밀번호 : <input type="text" name="passwd" value="<%=vo.getPasswd()%>"><br>
		이름 : <input type="text" name="name" value="<%=vo.getName()%>"><br>
		이메일 : <input type="email" name="mail" value="<%=vo.getMail()%>"><br>
		<%
		if (login.getId().equals(vo.getId())) {
		%>
		<input type="submit" value="수정">
		<%
		} else {
		%>
		<a href="<%=request.getContextPath()%>/index.jsp">홈으로</a>
		<%
		}
		%>
	</form>
	<%
	
	%>
		<input type="submit" value="수정">

	<%
	} else {
	%>
	<p>조회된 결과가 없습니다</p>
	<%
	}
	%>
</body>
</html>