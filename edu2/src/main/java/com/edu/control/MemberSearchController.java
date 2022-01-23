package com.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.model.MemberDAO;
import com.edu.model.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// memberSearch.jsp 에서 조회 요청 후
		// id 검색 결과 memberResult/memberSearchOutput.jsp
		String id = req.getParameter("id");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);

		req.setAttribute("searchId", id);
		req.setAttribute("member", vo); // 요청정보 member 속성 = vo
		
		String job = req.getParameter("job");
		String path = "";

		if (job.equals("delete")) {
			path = "memberView/memberDelete.jsp";
		} else if (job.equals("update")) {
			path = "memberView/memberUpdate.jsp";
		} else {
			if (vo == null) {
				path = "memberView/memberSearch.jsp";
			} else {
				path = "memberResult/memberSearchOutput.jsp";
			}
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
}