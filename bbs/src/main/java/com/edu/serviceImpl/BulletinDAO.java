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
		return null;
	}

	@Override
	public BulletinVO insert(BulletinVO vo) {
		return null;
	}

	@Override
	public BulletinVO update(BulletinVO vo) {
		return null;
	}

	@Override
	public int delete(int bbsId) {
		return 0;
	}

}
