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
import com.edu.web.ItemListJsonController;
import com.edu.web.LogOutController;
import com.edu.web.LoginController;
import com.edu.web.LoginFormController;
import com.edu.web.MainController;
import com.edu.web.MyPageController;
import com.edu.web.MyPageUpdateController;
import com.edu.web.NoticeListController;
import com.edu.web.NoticeinAddController;
import com.edu.web.NoticeinDeleteController;
import com.edu.web.NoticeinFormController;
import com.edu.web.NoticeinSelectController;
import com.edu.web.NoticeinUpdateController;
import com.edu.web.ReplyDeleteController;
import com.edu.web.ReplyRegisterController;
import com.edu.web.ReplySelectController;
import com.edu.web.ShopItemListController;

public class FrontController extends HttpServlet { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// 서블릿이 될려면 HttpServlet을 상속받아야된다
	Map<String, Controller> map = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Controller>(); // Hash<String,Controller> map=new HashMap<>();

		// url패턴 , 컨트롤러
		map.put("/main.do", new MainController());

		// 게시판 컨트롤
		map.put("/bulletinList.do", new BulletinListController());
		map.put("/bulletinForm.do", new BulletinFormController());
		map.put("/bulletinAdd.do", new BulletinAddController());
		map.put("/bulletinSelect.do", new BulletinSelectController());
		map.put("/bulletinUpdate.do", new BulletinUpdateController());
		map.put("/bulletinDelete.do", new BulletinDeleteController());

		// 댓글관련 컨트롤
		map.put("/replySelect.do", new ReplySelectController());
		map.put("/replyRegister.do", new ReplyRegisterController());
		map.put("/deleteReply.do", new ReplyDeleteController());

		// 공지사항 컨트롤
		map.put("/noticeList.do", new NoticeListController());
		map.put("/noticeForm.do", new NoticeinFormController());
		map.put("/noticeAdd.do", new NoticeinAddController());
		map.put("/noticeSelect.do", new NoticeinSelectController());
		map.put("/noticeUpdate.do", new NoticeinUpdateController());
		map.put("/noticeDelete.do", new NoticeinDeleteController());

		// 회원관련
		map.put("/loginForm.do", new LoginFormController());
		map.put("/login.do", new LoginController());
		map.put("/logOut.do", new LogOutController());
		map.put("/myPage.do", new MyPageController());
		map.put("/myUpdate.do", new MyPageUpdateController());

		// 아작스 처리
		map.put("/shopItemList.do", new ShopItemListController());
		map.put("/itemListJson.do", new ItemListJsonController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");// 요청정보 한글처리
		resp.setCharacterEncoding("utf-8"); // 응답정보 한글

		String uri = req.getRequestURI(); // equ2/memberList.do 요청정보에서 uri정보를 읽어오기
		String context = req.getContextPath();// edu2 정보 가져오기
		String path = uri.substring(context.length()); // uri값에서 /memberList.do
		System.out.println(path);
		Controller control = map.get(path); // get으로 키값 넣기
		control.execute(req, resp);
	}

}
