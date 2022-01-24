<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>글등록</h3>
<form action="${pageContext.request.contextPath }/noticeAdd.do"
	method="post">
	<table class='table' border="1">
		<tbody>
			<tr>
				<th>제목</th>
				<td><input class='form-control' type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea class='form-control' name="content" cols="20"
						rows="4"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"> <input
					type="reset"></td>
			</tr>
		</tbody>
	</table>
</form>