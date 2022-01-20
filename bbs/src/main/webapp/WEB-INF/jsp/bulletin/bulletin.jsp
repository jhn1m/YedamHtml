<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

${bulletin}
<!-- bulletin.jsp -->

<script>
function deleteFunc(id){
	document.forms.delFrm.id.value = id;
	document.forms.delFrm.submit();
	
}
</script>

<form name="delFrm"
	action="${pageContext.request.contextPath }/bulletinDelete.do"
	method="post">
	<input type="hidden" name="id">
</form>

<form action="${pageContext.request.contextPath }/bulletinUpdate.do"
	method="post">
	<input type="hidden" name="id" value="${bulletin.bbsId }">
	<table class="table" border="1">
		<tbody>
			<tr>
				<th>글번호</th>
				<td>${bulletin.bbsId }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input class="form-control" type="text" name="title"
					value=${bulletin.bbsTitle }></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea class="form-control" name="content" cols="20"
						rows="3">${bulletin.bbsContent}</textarea></td>
			</tr>
			<tr>
				<th>작성일시</th>
				<td>${bulletin.bbsCreateDate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${bulletin.bbsHit }</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"> <input
					type="reset" value="초기화"> <input type="button" value="삭제"
					onclick="deleteFunc(${bulletin.bbsId})"></td>

			</tr>
		</tbody>
	</table>
</form>

<!-- 댓글(작성자, 내용, 등록일시) -->
<div class="reply">
	<h4>댓글목록</h4>
	<div class="reply-list">
		<div class="row">
			<span>작성자1</span> <span>댓글 테스트</span> <span>2022.01.05
				12:23:44</span>
		</div>
		<div class="row">
			<span>작성자1</span> <span>댓글 테스트</span> <span>2022.01.05
				12:23:44</span>
		</div>
	</div>
	<div class="reply-register">
		<div>
			<span id="writer">작성자 : ${bulletin.bbsWriter }</span>
		</div>
		<div>
			<textarea cols="40" rows="5" id="content">
		</textarea>
		</div>
		<div>
			<button id="register">등록</button>
		</div>

	</div>
</div>