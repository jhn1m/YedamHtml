<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<script>
  function formSubmit(id) {
    document.forms.frm.id.value = id
    document.forms.frm.submit()
  }
</script>

<form
  id="frm"
  name="frm"
  action="${pageContext.request.contextPath }/noticeSelect.do"
  method="post"
>
  <input type="hidden" name="id" />
</form>

<table class="table" border="1">
  <thead>
    <tr>
      <th>글번호</th>
      <th>글제목</th>
      <th>작성일시</th>
      <th>조회수</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="notice" items="${NoticeList}">
      <tr onclick="formSubmit(${notice.noticeId})">
        <!-- 조회하기 위해서 매개값으로 id를줌  -->
        <td>${notice.noticeId }</td>
        <td>${notice.noticeTitle }</td>
        <td>${notice.noticeWdate }</td>
        <td>${notice.noticeHit}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath }/noticeForm.do">글등록</a>
