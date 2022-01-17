<%@page import="java.util.List"%>
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
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList"); // 속성지정
	if (list.size() != 0) {
	%>
	<h3>회원리스트</h3>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>메일</th>
				<th>비밀번호</th>
			</tr>
		<tbody>
			<%
			for (MemberVO vo : list) {
			%>
			<tr>
				<td><%=vo.getId()%></td>
				<td><%=vo.getName()%></td>
				<td><%=vo.getMail()%></td>
				<td><%=vo.getPasswd()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<%
	} else {
	%>
	<h3>회원리스트</h3>
	<p>조회된 정보가 없습니다..</p>
	<%
	}
	%>

	<%@include file="home.jsp"%>
</body>
</html>