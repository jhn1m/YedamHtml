package com.edu.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;

@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		EmpDAO dao = new EmpDAO();
		List<EmployeeVO> list = dao.getEmpList();
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>"
				+ "<th>사원번호</th>"
				+ "<th>이름</th>"
				+ "<th>이메일</th>"
				+ "<th>입사일</th>"
				+ "<th>직무</th>"
				+ "<th>급여</th>"
				+ "<th>입사일</th>"
				+ "</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(EmployeeVO emp : list) {
			out.println("<tr>");
			out.println("<td><a href='html/GetEmplServlet?id="+emp.getEmployeeId()+"'>"+emp.getEmployeeId()+"</a></td>");
			out.println("<td>"+emp.getFirstName()+"</td>");
			out.println("<td>"+emp.getLastName()+"</td>");
			out.println("<td>"+emp.getEmail()+"</td>");
			out.println("<td>"+emp.getJobId()+"</td>");
			out.println("<td>"+emp.getSalary()+"</td>");
			out.println("<td>"+emp.getHireDate()+"</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
