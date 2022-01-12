package com.edu.full;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScheduleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 조회할때 사용
		response.setContentType("text/json; charset=utf-8");
		FullDAO dao = new FullDAO();
		List<Map<String, String>> schedules = dao.getSchedules();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(schedules)); // 웹브라우저에 출력
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// INSERT
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action.equals("insert")) {
			String title = request.getParameter("title");
			String start = request.getParameter("start");
			String end = request.getParameter("end");

			// map 타입에 사용자 입력값을 전부 담아두기.
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", title);
			map.put("startDate", start);
			map.put("endDate", end);

			FullDAO dao = new FullDAO();
			String result = "";
			try {
				if (dao.insertSchedule(map)) {
					// {"retCode" : "Success"}
					result = "{\"retCode\" : \"Success\"}";
				} else {
					result = "{\"retCode\" : \"fail\"}";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				result = "{\"retCode\" : \"fail\"}";
			}
			// 웹브라우저로 json 형태의 값을 송신
			response.getWriter().print(result);

		} else if (action.equals("delete")) {
			// DELETE
			String title = request.getParameter("title");
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", title);
			FullDAO dao = new FullDAO();
			String result = "";
			try {
				if (dao.deleteSchedule(map)) {
					result = "{\"retCode\" : \"Success\"}";
				} else {
					result = "{\"retCode\" : \"fail\"}";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				result = "{\"retCode\" : \"fail\"}";
			}
			response.getWriter().print(result);
		}

	}

}
