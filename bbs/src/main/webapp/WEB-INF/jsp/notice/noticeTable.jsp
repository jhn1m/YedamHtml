<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<link
  rel="stylesheet"
  href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css"
/>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>

<script>
  $(document).ready(function () {
    $("#example").DataTable()
  })
</script>
<script>
  function formSubmit(id) {
    document.forms.frm.id.value = id
    document.forms.frm.submit() //input태그의 submit버튼을 호출하는 기능
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
<table id="example" class="display" style="width: 100%">
  <thead>
    <tr>
      <th>글번호</th>
      <th>글제목</th>
      <th>작성일시</th>
      <th>조회수</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="notice" items="${NoticeList }">
      <tr onclick="formSubmit(${notice.noticeId })">
        <!-- 조회하기 위해서 매개값으로 id를줌  -->
        <td>${notice.noticeId }</td>
        <td>${notice.noticeTitle }</td>
        <td>${notice.noticeWdate }</td>
        <td>${notice.noticeHit }</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
