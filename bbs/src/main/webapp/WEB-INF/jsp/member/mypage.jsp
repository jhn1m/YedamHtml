<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action = "" method = "post">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td>${member.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="passwd" value="${member.passwd }"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${member.name }"></td>
		</tr>
		<tr>
			<th>메일</th>
			<td><input type="text" name="mail" value="${member.mail}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="변경"> <input
				type="reset" value="초기화"></td>
		</tr>
	</table>
</form>