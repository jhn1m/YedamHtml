package com.edu.serv;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;

@WebServlet("/RegisterSurvlet")
public class RegisterSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterSurvlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String fn = request.getParameter("first_name");
		String ln = request.getParameter("last_name");
		String em = request.getParameter("email");
		String hd = request.getParameter("hire_date");
		String ji = request.getParameter("job_id");
		String sal = request.getParameter("salary");
		EmpDAO dao = new EmpDAO();
		EmployeeVO vo = new EmployeeVO();
		vo.setFirstName(fn);
		vo.setLastName(ln);
		vo.setEmail(em);
		vo.setHireDate(hd);
		vo.setJobId(ji);
		vo.setSalary(Integer.parseInt(sal));
		
		dao.insertEmp(vo);
		
		response.getWriter().print("<h2>처리완료</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
