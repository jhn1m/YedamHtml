<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<script>
  function deleteFunc(id) {
    document.forms.delFrm.id.value = id
    document.forms.delFrm.submit()
  }
</script>

<form
  name="delFrm"
  action="${pageContext.request.contextPath }/noticeDelete.do"
  method="post"
>
  <input type="hidden" name="id" />
</form>

<form
  action="${pageContext.request.contextPath }/noticeUpdate.do"
  method="post"
>
  <input type="hidden" name="id" value="${notice.noticeId }" />
  <table class="table" border="1">
    <tbody>
      <tr>
        <th>글번호</th>
        <td>${notice.noticeId }</td>
      </tr>
      <tr>
        <th>제목</th>
        <td>
          <input
            class="form-control"
            type="text"
            name="title"
            value="${notice.noticeTitle}"
          />
        </td>
      </tr>
      <tr>
        <th>내용</th>
        <td>
          <textarea class="form-control" name="content" cols="20" rows="3">
${notice.noticeContent }</textarea
          >
        </td>
      </tr>
      <tr>
        <th>작성일시</th>
        <td>${notice.noticeWdate }</td>
      </tr>
      <tr>
        <th>조회수</th>
        <td>${notice.noticeHit }</td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="수정" />
          <input type="reset" value="초기화" />
          <input
            type="button"
            value="삭제"
            onclick="deleteFunc(${notice.noticeId})"
          />
        </td>
      </tr>
    </tbody>
  </table>
</form>
