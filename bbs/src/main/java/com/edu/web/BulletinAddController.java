package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;
import com.edu.vo.BulletinVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BulletinAddController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 입력값을 저장 처리 결과 : 게시판 리스트.
		String path = "bulletinList.do";

		ServletContext context = req.getServletContext();
		String uploadpath = context.getRealPath("/upload");

		// new MultipartRequest("요청정보", "저장위치", "maxSize"(5mb초과시 에러), "encoding", "rename정보");

		MultipartRequest multi = new MultipartRequest(req, uploadpath, 1024 * 1024 * 5, "utf-8", new DefaultFileRenamePolicy());
		// rename 정책에 의해 동일한 파일이 있으면 바꿔버림
		// image1.png > image11.png

		BulletinVO vo = new BulletinVO();
//		vo.setBbsWriter(req.getParameter("writer"));
//		vo.setBbsImage(req.getParameter("image"));
//		vo.setBbsTitle(req.getParameter("title"));
//		vo.setBbsContent(req.getParameter("content"));

		vo.setBbsWriter(multi.getParameter("writer"));
		vo.setBbsTitle(multi.getParameter("title"));
		vo.setBbsContent(multi.getParameter("content"));
		vo.setBbsImage(multi.getFilesystemName("image"));

		System.out.println(vo);

		BulletinService service = new BulletinDAO();
		service.insert(vo);
		HttpUtil.forward(req, resp, path);
	}
}