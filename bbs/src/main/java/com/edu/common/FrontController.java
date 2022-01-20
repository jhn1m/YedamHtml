package com.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.web.BulletinAddController;
import com.edu.web.BulletinDeleteController;
import com.edu.web.BulletinFormController;
import com.edu.web.BulletinListController;
import com.edu.web.BulletinSelectController;
import com.edu.web.BulletinUpdateController;
import com.edu.web.LogOutController;
import com.edu.web.LoginController;
import com.edu.web.LoginFormController;
import com.edu.web.MainController;
import com.edu.web.NoticeListController;
import com.edu.web.NoticeinAddController;
import com.edu.web.NoticeinDeleteController;
import com.edu.web.NoticeinFormController;
import com.edu.web.NoticeinSelectController;
import com.edu.web.NoticeinUpdateController;
import com.edu.web.ReplyDeleteController;
import com.edu.web.ReplyRegisterController;
import com.edu.web.ReplySelectController;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Map<String, Controller> map = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Controller>();

		// url 패턴 - 컨트롤러
		map.put("/main.do", new MainController());

		// 게시판 컨트롤
		map.put("/bulletinList.do", new BulletinListController());
		map.put("/bulletinForm.do", new BulletinFormController());
		map.put("/bulletinAdd.do", new BulletinAddController());
		map.put("/bulletinSelect.do", new BulletinSelectController());
		map.put("/bulletinUpdate.do", new BulletinUpdateController());
		map.put("/bulletinDelete.do", new BulletinDeleteController());

		// 공지사항 컨트롤
		map.put("/noticeList.do", new NoticeListController());
		map.put("/noticeinForm.do", new NoticeinFormController());
		map.put("/noticeinAdd.do", new NoticeinAddController());
		map.put("/noticeinSelect.do", new NoticeinSelectController());
		map.put("/noticeinUpdate.do", new NoticeinUpdateController());
		map.put("/noticeinDelete.do", new NoticeinDeleteController());

		// 댓글 컨트롤
		map.put("/replyRegister.do", new ReplyRegisterController());
		map.put("/replySelect.do", new ReplySelectController());
		map.put("/deleteReply.do", new ReplyDeleteController());
		
		// 회원관련
		map.put("/loginForm.do", new LoginFormController());
		map.put("/login.do", new LoginController());
		map.put("/logOut.do", new LogOutController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글처리
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());

		Controller control = map.get(path);
		control.execute(req, resp);
	}
}
