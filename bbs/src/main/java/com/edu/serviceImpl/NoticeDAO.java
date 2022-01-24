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
		connect();
		String sql = "select * from notice order by 1 desc";

		List<NoticeVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				NoticeVO notice = new NoticeVO();

				notice.setNoticeId(rs.getInt("notice_id"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeContent(rs.getString("notice_content"));
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
	public NoticeVO selectOne(int noticeId) {
		connect();
		String sql = "select * from notice where notice_id=?";

		NoticeVO notice = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, noticeId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				notice = new NoticeVO();

				notice.setNoticeId(rs.getInt("notice_id"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeContent(rs.getString("notice_content"));
				notice.setNoticeWdate(rs.getString("notice_wdate"));
				notice.setNoticeHit(rs.getInt("notice_hit"));

				updateCount(noticeId);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return notice;
	}

	// 조회수 1씩 증가
	public void updateCount(int id) {
		connect();
		String sql = "update notice set notice_hit = notice_hit+1 where notice_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건이 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public NoticeVO insert(NoticeVO vo) {
		connect();
		String sql1 = "select notice_seq.nextval from dual";
		String sql2 = "insert into notice(notice_id,notice_title,notice_content,notice_wdate,notice_hit) values(?,?,?,sysdate,0)";
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
			System.out.println(r + "건 입력");

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
		String sql = "update notice set notice_title=?,notice_content=? where notice_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getNoticeTitle());
			psmt.setString(2, vo.getNoticeContent());
			psmt.setInt(3, vo.getNoticeId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건이 업데이트 되었습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;

	}

	@Override
	public int delete(int noticeId) {

		connect();
		String sql = "delete from notice where notice_id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, noticeId);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return noticeId;
	}

}
