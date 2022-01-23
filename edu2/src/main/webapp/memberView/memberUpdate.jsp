<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form action="${pageContext.request.contextPath }/memberSearch.do" method="post">
		아이디 : <input type="text" name="id"><br> 
		<input type="hidden" name="job" value="update"><br> 
		<input type="submit" value="조회">
	</form>


	<c:choose>
		<c:when test="${member != null }">
			<p>회원정보수정</p>
			<form action="${pageContext.request.contextPath }/memberUpdate.do"
				method="post">
				아이디 : <input type="text" readonly name="id" value="${member.id }"><br>
				비밀번호 : <input type="text" name="passwd" value="${member.passwd }"><br>
				이름 : <input type="text" name="name" value="${member.name }"><br>
				이메일 : <input type="email" name="mail" value="${member.mail }"><br>
				<c:choose>
					<c:when test="${login.id == member.id }">
						<input type="submit" value="수정">
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath }%>/index.jsp">홈으로</a>
					</c:otherwise>
				</c:choose>
			</form>
		</c:when>
		<c:otherwise>
			<p>조회된 결과가 없습니다</p>
		</c:otherwise>
	</c:choose>

</body>
</html>