package org.edu.common;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	// init() > service() > destroy() : 서블릿의 생명주기.
	@Override
	public void init(ServletConfig config) throws ServletException {

//		super.init(config);
		System.out.println("init method");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		System.out.println("service method");
	}

	@Override
	public void destroy() {
//		super.destroy();
		System.out.println("destroy method");
	}

}
