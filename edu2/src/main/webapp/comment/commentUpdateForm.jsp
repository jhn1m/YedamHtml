<%@page import="com.edu.model.CommentVO"%>
<%@page import="com.edu.dao.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commentUpdateForm.jsp</title>
</head>
<body>
   <%
   String id = request.getParameter("id");
   CommentDAO dao = new CommentDAO();
   CommentVO vo = dao.selectOne(id);
   %>
   <form action="../commentUpdate.do" method="post">
      <input type="hidden" name="id" value="<%=vo.getId()%>">
      <table border='1'>
         <tr>
            <th>아이디</th>
            <td><%=vo.getId()%></td>
         </tr>
         <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="<%=vo.getName()%>"></td>
         </tr>
         <tr>
            <th>내용</th>
            <td><textarea name="content"><%=vo.getContent()%></textarea></td>
         </tr>
         <tr>
            <td colspan="2"><input type="submit" value="변경"></td>
         </tr>
      </table>
   </form>
</body>
</html>