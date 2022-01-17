<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫페이지(index.jsp)</title>
<!-- /edu2/index.jsp -->
</head>
<body>

<%
	MemberVO login = (MemberVO) session.getAttribute("login");
	if (login == null) {
		request.getRequestDispatcher("login/login.jsp").forward(request, response);
	} else {
%>
	<h3><%=login.getName()%>님 환영합니다!<button id = "logout">로그아웃</button></h3>
	<h3>글등록 관련</h3>
	<a href='./comment/commentAddForm.jsp'>글등록페이지</a><br>
	<a href='./commentList.do'>글목록컨트롤</a><br>
	<a href='./comment/commentList.jsp'>글목록</a><br>

	<h3>회원등록 관련</h3>
	<a href="memberView/memberInsert.jsp">회원등록 페이지</a><br>
	<a href="memberView/memberSearch.jsp">회원정보 검색</a><br>
	<a href="memberView/memberDelete.jsp">회원정보 삭제</a><br>
	<a href="memberView/memberUpdate.jsp">회원정보 수정</a><br>
	<a href="memberList.do">모든 회원정보 열람</a>
	<br>
	<%
	}
	%>
	<script>
	document.getElementById("logout").addEventListener("click", logoutFnc)
	function logoutFnc(){
		<% 
		session.invalidate();
		%>
		location.href = "index.jsp";
	}
	</script>
</body>
</html>