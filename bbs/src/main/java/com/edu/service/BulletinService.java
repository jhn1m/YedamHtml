package com.edu.service;

import java.util.List;

import com.edu.vo.BulletinVO;
import com.edu.vo.ReplyVO;

import oracle.net.nt.ConnectDescription;

public interface BulletinService {
	// 기능 정의
	public List<BulletinVO> selectList();
	public BulletinVO selectOne(int bbsId);
	public BulletinVO insert(BulletinVO vo);
	public BulletinVO update(BulletinVO vo);
	public int delete(int bbsId);
	
	// 댓글 관련
	public List<ReplyVO> selectReplyList(int bbsId);
	public ReplyVO insertReply(ReplyVO vo);
	public boolean deleteReply(int rid);
}