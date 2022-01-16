package org.edu.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String method = req.getMethod();
		String result = "";
		if (method.equals("GET")) {
			result = doGet();
		} else if (method.equals("POST")) {
			result = doPost();
		}

		// [{"id":1, "name":"HONG"},{"id":2, "name":"Kim"},{"id":3, "name":"Lee"}]
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String score = req.getParameter("score");

		resp.setContentType("text/json; charset=utf=8");
		String json = "[{\"id\":1, \"name\":\"HONG\"},{\"id\":2, \"name\":\"Kim\"},{\"id\":3, \"name\":\"Lee\"},"
				+ "{\"id\":" + id + ",\"name\":\"" + name + "\"},{\"id\":4, \"name\":\""+result+"\"}]";
		resp.getWriter().print(json);
	}

	public String doGet() {
		return "get방식 호출";
	}

	public String doPost() {
		return "post방식 호출";
	}

}