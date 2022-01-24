package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.MemberService;
import com.edu.serviceImpl.MemberDAO;
import com.edu.vo.MemberVO;

public class MyPageUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 정보를 읽어와서 변경

		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");

		MemberDAO service = new MemberDAO();
		MemberVO vo = new MemberVO();
//		MemberService service = new MemberDAO();

		vo.setId(id);
		vo.setPasswd(pw);
		vo.setName(name);
		vo.setMail(mail);
		service.memberUpdate(vo);
		req.setAttribute("member", vo);
		HttpUtil.forward(req, resp, "member/mypage.tiles");

		// mypage.jsp로 변경된 정보를 전송

	}

}
