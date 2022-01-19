package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.BulletinService;
import com.edu.vo.BulletinVO;

public class BulletinDAO extends DAO implements BulletinService {

	@Override
	public List<BulletinVO> selectList() {
		List<BulletinVO> list = new ArrayList<BulletinVO>();
		connect();
		String sql = "SELECT * FROM bbs order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BulletinVO bulletin = new BulletinVO();
				bulletin.setBbsId(rs.getInt("bbs_id"));
				bulletin.setBbsTitle(rs.getString("bbs_title"));
				bulletin.setBbsWriter(rs.getString("bbs_writer"));
				bulletin.setBbsContent(rs.getString("bbs_content"));
				bulletin.setBbsImage(rs.getString("bbs_image"));
				bulletin.setBbsHit(rs.getInt("bbs_hit"));
				bulletin.setBbsCreateDate(rs.getString("bbs_create_date"));
				list.add(bulletin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public BulletinVO selectOne(int bbsId) {
		connect();
		String sql = "SELECT * FROM bbs WHERE bbs_id = ?";
		BulletinVO bulletin = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bbsId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				bulletin = new BulletinVO();
				bulletin.setBbsId(rs.getInt("bbs_id"));
				bulletin.setBbsTitle(rs.getString("bbs_title"));
				bulletin.setBbsWriter(rs.getString("bbs_writer"));
				bulletin.setBbsContent(rs.getString("bbs_content"));
				bulletin.setBbsImage(rs.getString("bbs_image"));
				bulletin.setBbsHit(rs.getInt("bbs_hit"));
				bulletin.setBbsCreateDate(rs.getString("bbs_create_date"));

				// 카운트 증가
				updateCount(bbsId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bulletin;
	}

	// 조회수 증가
	public void updateCount(int id) {
		connect();
		String sql = "update bbs set bbs_hit = bbs_hit + 1 where bbs_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public BulletinVO insert(BulletinVO vo) {
		connect();
		String sql1 = "select bbs_id_seq.nextval from dual";
		String sql2 = "insert into bbs(bbs_id, bbs_title, bbs_content, bbs_writer, bbs_image, bbs_create_date, bbs_hit) values(?,?,?,?,?,sysdate,0)";
		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			int seq = 0;
			if (rs.next()) {
				seq = rs.getInt(1);
			}

			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getBbsTitle());
			psmt.setString(3, vo.getBbsContent());
			psmt.setString(4, vo.getBbsWriter());
			psmt.setString(5, vo.getBbsImage());

			int r = psmt.executeUpdate();
			System.out.println(r + "입력");

			// 반환할 값에 bbs_id 값만 추가해서 반환.
			vo.setBbsId(seq);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public BulletinVO update(BulletinVO vo) {
		connect();
		String sql = "update bbs set bbs_title = ?, bbs_content = ?, bbs_image = nvl(?, bbs_image)"
				+ "where bbs_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBbsTitle());
			psmt.setString(2, vo.getBbsContent());
			psmt.setString(3, vo.getBbsImage());
			psmt.setInt(4, vo.getBbsId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return vo;
	}

	@Override
	public int delete(int bbsId) {
		connect();
		String sql = "delete from bbs where bbs_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bbsId);
			int r = psmt.executeUpdate();
			System.out.println(r + "삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return bbsId;
	}

}
