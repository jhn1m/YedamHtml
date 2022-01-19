package com.edu.service;

import java.util.List;

import com.edu.vo.NoticeVO;

public interface NoticeService {
	// 기능 정의
	public List<NoticeVO> selectList();

	public NoticeVO selectOne(int ntcId);

	public NoticeVO insert(NoticeVO vo);

	public NoticeVO update(NoticeVO vo);

	public int delete(int ntcId);
}
