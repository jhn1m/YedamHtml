package com.edu.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertBookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");

		request.setCharacterEncoding("utf-8");

		String bid = request.getParameter("book_id");
		String bn = request.getParameter("book_name");
		String au = request.getParameter("author");
		String pu = request.getParameter("publisher");
		String pr = request.getParameter("price");

		// empList.html 페이지 Ajax (현재페이지) 호출.
		// 사용자가 입력한 값들...
		EmployeeVO vo = new EmployeeVO();

		vo.setEmployeeId(Integer.parseInt(eid));
		vo.setFirstName(fn);
		vo.setLastName(ln);
		vo.setEmail(em);
		vo.setHireDate(hd);
		vo.setJobId("IT_PROG");
		vo.setSalary(Integer.parseInt(sa));

		EmpDAO dao = new EmpDAO();
		dao.insertEmployee(vo);

		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));	}

}
