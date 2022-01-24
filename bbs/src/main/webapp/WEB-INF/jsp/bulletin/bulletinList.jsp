<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function formSubmit(id){
		document.forms.frm.id.value = id;
		document.forms.frm.submit();
	}
</script>

<form id="frm" name="frm"
	action="${pageContext.request.contextPath }/bulletinSelect.do"
	method="post">
	<input type="hidden" name="id">
</form>
<table class="table" border="1">
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일지</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="bulletin" items="${bulletinList }">
			<tr onclick="formSubmit(${bulletin.bbsId})">
				<td>${bulletin.bbsId }</td>
				<td>${bulletin.bbsTitle }</td>
				<td>${bulletin.bbsWriter }</td>
				<td>${bulletin.bbsCreateDate }</td>
				<td>${bulletin.bbsHit }</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot></tfoot>
</table>

<form id="frm" name="frm"
	action="${pageContext.request.contextPath }/bulletinSelect.do"
	method="post">
	<input type="hidden" name="id">
</form>


<a href="${pageContext.request.contextPath }/bulletinForm.do">글 등록</a>