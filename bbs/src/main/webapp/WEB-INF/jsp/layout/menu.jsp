<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 메뉴.jsp -->

<title>menu.jsp</title>

<div class="list-group list-group-flush">
	<a
		class="list-group-item list-group-item-action list-group-item-light p-3"
		href="#!">공지사항</a> <a
		class="list-group-item list-group-item-action list-group-item-light p-3"
		href="${pageContext.request.contextPath }/bulletinList.do">자유게시판</a> <a
		class="list-group-item list-group-item-action list-group-item-light p-3"
		href="${pageContext.request.contextPath }/main.do">홈으로</a>
</div>
