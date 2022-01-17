<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberDelete.jsp</title>
</head>
<body>
	<h3>회원정보 검색</h3>
	<%
	MemberVO vo = (MemberVO) request.getAttribute("member");
	%>
	<form action="<%=request.getContextPath()%>/memberSearch.do"
		method="post">
		아이디 : <input type="text" name="id"><br> <input
			type="hidden" name="job" value="delete"><br> <input
			type="submit" value="조회">
	</form>

	<%
	if (vo != null) {
	%>
	<p>조회결과</p>
	<p>아이디 :<%=vo.getId()%>, 이름 :
<%=vo.getName()%></p>
	<form action="<%=request.getContextPath()%>/memberDelete.do"
		method="post">
		<input type="hidden" name="id" value="<%=vo.getId()%>"> <input
			type="submit" value="삭제">
	</form>
	<%
	} else {
	out.println("<p>조회된 결과가 없습니다.</p>");
	}
	%>

</body>
</html>