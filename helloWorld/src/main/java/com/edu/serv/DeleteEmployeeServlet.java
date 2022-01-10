package com.edu.serv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteEmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		String delId = request.getParameter("emp_id");
		String result = "";

		EmpDAO dao = new EmpDAO();
		try {
			if (dao.deleteEmployee(delId)) {
				// // {"retCode" : "Success", "retVal" : "정상적으로 처리됨"}
				result = "// {\"retCode\" : \"Success\", \"retVal\" : \"정상적으로 처리됨\"}";
			} else {
				// {"retCode" : "Fail", "retVal" : "조회된 데이터가 없습니다."}
				result = "{\"retCode\" : \"Fail\", \"retVal\" : \"조회된 데이터가 없습니다.\"}";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// {"retCode" : "Fail", "retVal" : "errormsg"}
			result = "{\"retCode\" : \"Fail\", \"retVal\" : \"" + e.getMessage() + "\"}";
		}
		// 출력 페이지에 json 형식으로 결과값을 보여줌.
		response.getWriter().println(result);
	}
}