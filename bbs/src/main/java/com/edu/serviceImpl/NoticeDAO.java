package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.NoticeService;
import com.edu.vo.NoticeVO;

public class NoticeDAO extends DAO implements NoticeService {

	@Override
	public List<NoticeVO> selectList() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		connect();
		String sql = "SELECT * FROM notice order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			while (rs.next()) {
				NoticeVO notice = new NoticeVO();
				notice.setNoticeId(rs.getInt("notice_id"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setNoticeWdate(rs.getString("notice_wdate"));
				notice.setNoticeHit(rs.getInt("notice_hit"));
				list.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public NoticeVO selectOne(int ntcId) {
		connect();
		String sql = "select * from notice where notice_id = ?";
		NoticeVO notice = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ntcId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				notice = new NoticeVO();
				notice.setNoticeId(rs.getInt("notice_id"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setNoticeWdate(rs.getString("notice_wdate"));
				notice.setNoticeHit(rs.getInt("notice_hit"));

				// 카운트 증가
				updateCount(ntcId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return notice;
	}

	// 조회수 증가
	public void updateCount(int id) {
		connect();
		String sql = "UPDATE notice set notice_hit = notice_hit + 1 where notice_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + " 건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public NoticeVO insert(NoticeVO vo) {
		connect();
		String sql1 = "select notice_seq.nextval from dual";
		String sql2 = "insert into notice values(?,?,?,sysdate,0)";

		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			int seq = 0;
			if (rs.next()) {
				seq = rs.getInt(1);
			}

			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getNoticeTitle());
			psmt.setString(3, vo.getNoticeContent());

			int r = psmt.executeUpdate();
			System.out.println(r + "입력");

			vo.setNoticeId(seq);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public NoticeVO update(NoticeVO vo) {
		connect();
		String sql = "update notice set notice_title = ?, notice_content = ? where notice_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getNoticeTitle());
			psmt.setString(2, vo.getNoticeContent());
			psmt.setInt(3, vo.getNoticeId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public int delete(int ntcId) {
		connect();
		String sql = "delete from notice where notice_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ntcId);
			int r = psmt.executeUpdate();
			System.out.println(r + "삭제됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return ntcId;
	}
}
