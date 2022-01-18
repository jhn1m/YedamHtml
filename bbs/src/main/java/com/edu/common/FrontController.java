package com.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.control.CommentAddController;
import com.edu.control.CommentGetController;
import com.edu.control.CommentListController;
import com.edu.control.CommentUpdateController;
import com.edu.control.LoginController;
import com.edu.control.MemberDeleteController;
import com.edu.control.MemberInsertController;
import com.edu.control.MemberListController;
import com.edu.control.MemberSearchController;
import com.edu.control.MemberUpdateController;

public class FrontController extends HttpServlet {

	Map<String, Controller> map = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Controller>();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글처리
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String uri = req.getRequestURI(); // /edu2/commentAdd.do
		String context = req.getContextPath(); // /edu2
		String path = uri.substring(context.length());

		Controller control = map.get(path);
		control.execute(req, resp);
	}
}
