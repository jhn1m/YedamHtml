<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form action="${pageContext.request.contextPath }/memberSearch.do"
		method="post">
		아이디 : <input type="text" name="id"><br> <input
			type="hidden" name="job" value="delete"><br> <input
			type="submit" value="조회">
	</form>

	<c:choose>
		<c:when test="${member != null }">
			<p>조회결과</p>
			<p>아이디 : ${member.id }, 이름 : ${member.name }</p>
			<form action="${pageContext.request.contextPath }/memberDelete.do"
				method="post">
				<input type="hidden" name="id" value="${member.id }">
				<!-- 삭제권한이 있는지 체크 삭제 / 불가 -->
				<c:choose>
					<c:when test="${member.id == login.id}">
						<input type="submit" value="삭제">
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath }">홈으로</a>
					</c:otherwise>
				</c:choose>
			</form>
		</c:when>
		<c:otherwise>
			<p>조회된 결과가 없습니다.</p>
		</c:otherwise>
	</c:choose>

</body>
</html>