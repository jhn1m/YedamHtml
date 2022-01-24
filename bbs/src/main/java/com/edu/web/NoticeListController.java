package com.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.NoticeService;
import com.edu.serviceImpl.NoticeDAO;
import com.edu.vo.NoticeVO;

public class NoticeListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "notice/noticeList.tiles";
		
		NoticeService service = new NoticeDAO();
		List<NoticeVO> list = service.selectList();
		
		req.setAttribute("noticeList", list);
		HttpUtil.forward(req, resp, path);
	}

}
