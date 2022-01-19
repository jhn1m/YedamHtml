package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.NoticeService;
import com.edu.serviceImpl.NoticeDAO;
import com.edu.vo.NoticeVO;

public class NoticeinUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.parseInt(id));
		vo.setNoticeTitle(title);
		vo.setNoticeContent(content);
		
		NoticeService service = new NoticeDAO();
		service.update(vo);
		
		resp.sendRedirect("noticeList.do");
		
	}

}
