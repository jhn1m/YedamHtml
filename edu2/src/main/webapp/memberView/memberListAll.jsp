<%@page import="java.util.List"%>
<%@page import="com.edu.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberListAll.jsp</title>
</head>
<body>
	<%
	MemberVO vo = (MemberVO) request.getAttribute("listall");
	if (vo != null) {
		out.println("<h3>아이디 : " + vo.getId() + "</h3>");
		out.println("<h3>비밀번호 : " + vo.getPasswd() + "</h3>");
		out.println("<h3>이름 : " + vo.getName() + "</h3>");
		out.println("<h3>메일 : " + vo.getMail() + "</h3>");
	}

	List<MemberVO> list = (List<MemberVO>) request.getAttribute("listall");
	if (list != null) {
		out.print("<table border='1'>");
		out.print("<thead><th>아이디</th><th>이름</th><th>내용</th></thead>");
		out.print("<tbody>");

		for (MemberVO mem : list) {
			out.print("<tr><td><a href='listGet.do'?id =" + mem.getId() + "'>" + mem.getId() + "</a></td>" + mem.getPasswd()
			+ "</td><td>" + mem.getName() + "</td><td>" + mem.getMail() + "</td><td>");
		}
		out.print("</tbody>");
		out.print("</table>");
	} else {
		out.print("<h3>내용없음</h3>");
	}
	%>
</body>
</html>