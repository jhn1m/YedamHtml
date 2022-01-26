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
    document.forms.frm.submit() //input�±��� submit��ư�� ȣ���ϴ� ���
  }
</script>

<form
  id="frm"
  name="frm"
  action="${pageContext.request.contextPath }/bulletinSelect.do"
  method="post"
>
  <input type="hidden" name="id" />
</form>
<table id="example" class="display" style="width: 100%">
  <thead>
    <tr>
      <th>�۹�ȣ</th>
      <th>������</th>
      <th>�ۼ���</th>
      <th>�ۼ��Ͻ�</th>
      <th>��ȸ��</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="bulletin" items="${bulletinList }">
      <tr onclick="formSubmit(${bulletin.bbsId })">
        <!-- ��ȸ�ϱ� ���ؼ� �Ű������� id����  -->
        <td>${bulletin.bbsId }</td>
        <td>${bulletin.bbsTitle }</td>
        <td>${bulletin.bbsWriter }</td>
        <td>${bulletin.bbsCreateDate }</td>
        <td>${bulletin.bbsHit }</td>
      </tr>
    </c:forEach>
  </tbody>
</table>