package com.edu.serviceImpl;

import java.util.List;

import com.edu.common.DAO;
import com.edu.service.MemberSerivce;
import com.edu.vo.MemberVO;

public class MemberDAO extends DAO implements MemberSerivce {

	@Override
	public boolean memberInsert(MemberVO vo) {
		return false;
	}

	@Override
	public boolean memberUpdate(MemberVO vo) {
		return false;
	}

	@Override
	public List<MemberVO> memberList() {
		return null;
	}

	@Override
	public MemberVO login(String id, String pw) {
		String sql = "Select * from members where id = ? and passwd = ?";
		return null;
	}

}
