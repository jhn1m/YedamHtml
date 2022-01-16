package org.edu.comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.edu.common.DAO;

public class CommentDAO extends DAO {

	// 글등록
	public CommentVO insertComment(String name, String content) {
		String sql = "select value from id_repository where name = 'COMMENT'";
		String insertSql = "insert into comments values(?,?,?)";
		String updateSql = "update id_repository set value = ? where name='COMMENT' ";
		CommentVO comment = null;
		connect();
		try {
			// 시퀀스 가져오기
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int seq = -1;
			if (rs.next()) {
				seq = rs.getInt("value");
			}
			// 한건 입력
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setInt(1, seq);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			int r = pstmt.executeUpdate();
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
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setInt(1, ++seq);

			r = pstmt.executeUpdate();

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
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
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
