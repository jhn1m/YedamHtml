package com.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.model.CommentVO;

public class CommentDAO extends DAO {

	// 한건조회
	public CommentVO selectOne(String id) {
		String sql = "select * from comments where id=?";
		connect();
		CommentVO vo = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new CommentVO(rs.getInt("id")//
						, rs.getString("name")//
						, rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 글삭제
	public boolean deleteComment(String id) {
		String sql = "delete from comments where id=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			// 삭제된 건수가 있으면
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 글수정
	public boolean updateComment(CommentVO vo) {
		String sql = "update comments set name=?, content=? where id=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getId());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 글등록
	public CommentVO insertComment(String name, String content) {
		String sql = "select value from id_repository where name = 'COMMENT'";
		String insertSql = "insert into comments values(?,?,?)";
		String updateSql = "update id_repository set value = ? where name='COMMENT' ";
		CommentVO comment = null;
		connect();
		try {
			// 시퀀스 가져오기
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int seq = -1;
			if (rs.next()) {
				seq = rs.getInt("value");
			}
			// 한건 입력
			psmt = conn.prepareStatement(insertSql);
			psmt.setInt(1, seq);
			psmt.setString(2, name);
			psmt.setString(3, content);
			int r = psmt.executeUpdate();
			System.out.println(r + "입력됨.");

			// 비정상적으로 처리
			if (r < 1) {
				return null;
			}
			comment = new CommentVO();
			comment.setId(seq);
			comment.setName(name);
			comment.setContent(content);

			// 시퀀스 증가처리
			psmt = conn.prepareStatement(updateSql);
			psmt.setInt(1, ++seq);

			r = psmt.executeUpdate();

			if (r < 1) {
				return null;
			}
			// 정상 완료
			return comment;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 전체목록
	public List<CommentVO> selectAll() {
		String sql = "select * from comments order by 1";
		connect();
		List<CommentVO> list = new ArrayList<CommentVO>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				CommentVO vo = new CommentVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
