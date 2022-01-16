package org.edu.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html; charset=utf-8");

		PrintWriter out = resp.getWriter(); // 2byte char : stream : 1byte
		out.print("<h2>요청정보</h2>");
		out.print("<h3>요청 컨텐츠 : " + req.getContentType() + "</h3>");
		out.print("<h3>요청 방식 : " + req.getMethod() + "</h3>");
		out.print("<h3>요청 uri : " + req.getRequestURI() + "</h3>");
		out.print("<h3>요청 세션 : " + req.getSession() + "</h3>");
		
		resp.sendRedirect("index.jsp");
		
	}

}
