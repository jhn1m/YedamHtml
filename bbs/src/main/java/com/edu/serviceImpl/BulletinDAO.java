package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.BulletinService;
import com.edu.vo.BulletinVO;
import com.edu.vo.ReplyVO;

public class BulletinDAO extends DAO implements BulletinService{

	@Override
	//public List<BulletinVO> selectList(int page) {
	public List<BulletinVO> selectList() {
		int startCnt,endCnt = 0;
		//startCnt = (page-1) *10 +1;
		//endCnt = page *10;
		connect();
		
//		String sql = "select b.* from\r\n"
//				+ "(select rownum rn,a.* from\r\n"
//				+ "(select * from bbs order by 1)a)b\r\n"
//				+ "where b.rn between ? and ?";
		
		String sql = "select *from bbs order by 1 desc";
		List<BulletinVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			//psmt.setInt(1, startCnt); //페이지의 첫번째 rownum rn
			//psmt.setInt(2, endCnt); //페이지의 마지막 rn
			rs = psmt.executeQuery();
			while(rs.next()) {
				BulletinVO bulletin = new BulletinVO();
				
				bulletin.setBbsId(rs.getInt("bbs_id"));
				bulletin.setBbsTitle(rs.getString("bbs_title"));
				bulletin.setBbsContent(rs.getString("bbs_content"));
				bulletin.setBbsImage(rs.getString("bbs_image"));
				bulletin.setBbsHit(rs.getInt("bbs_hit"));
				bulletin.setBbsCreateDate(rs.getString("bbs_create_date"));
				bulletin.setBbsWriter(rs.getString("bbs_writer"));
				
				list.add(bulletin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return list;
	}

	@Override
	public BulletinVO selectOne(int bbsId) {
		connect();
		String sql = "select * from bbs where bbs_id=?";
		BulletinVO bulletin = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bbsId); //매개값으로 들어온 bbsid를 넣어서 쿼리
			rs = psmt.executeQuery();
			if(rs.next()) {
				bulletin = new BulletinVO();
				
				bulletin.setBbsId(rs.getInt("bbs_id"));
				bulletin.setBbsTitle(rs.getString("bbs_title"));
				bulletin.setBbsContent(rs.getString("bbs_content"));
				bulletin.setBbsImage(rs.getString("bbs_image"));
				bulletin.setBbsHit(rs.getInt("bbs_hit"));
				bulletin.setBbsCreateDate(rs.getString("bbs_create_date"));
				bulletin.setBbsWriter(rs.getString("bbs_writer"));
				
				//카운트증가
				updateCount(bbsId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return bulletin;
		
	}
	
	//조회수 1씩 증가
	public void updateCount(int id) {
		connect();
		String sql = "update bbs set bbs_hit = bbs_hit+1 where bbs_id=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r =psmt.executeUpdate();
			System.out.println(r + "건이 수정되었습니다" );
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	@Override
	public BulletinVO insert(BulletinVO vo) {
		connect();
		String sql1 = "select bbs_id_seq.nextval from dual";
		String sql2 = "insert into bbs(bbs_id,bbs_title,bbs_content,bbs_writer,bbs_image,bbs_create_date,bbs_hit) values(?,?,?,?,?,sysdate,0)";
		
		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getBbsTitle());
			psmt.setString(3, vo.getBbsContent());
			psmt.setString(4, vo.getBbsWriter());
			psmt.setString(5, vo.getBbsImage());
			int r = psmt.executeUpdate();
			System.out.println(r+ "건 입력");
			
			//입력값에 bbs_id 값만 추가해서 반환.
			vo.setBbsId(seq);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public BulletinVO update(BulletinVO vo) {
		connect();
		String sql = "update bbs set bbs_title=?,bbs_content=?,bbs_image=nvl(?,bbs_image) where bbs_id=?";//bbs_image=nvl(?,bbs_image) 값이 널이면 원래 값으로 처리
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getBbsTitle());
			psmt.setString(2, vo.getBbsContent());
			psmt.setString(3, vo.getBbsImage());
			psmt.setInt(4, vo.getBbsId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건이 업데이트 되었습니다");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public int delete(int bbsId) {
		connect();
		String sql = "delete from bbs where bbs_id=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, bbsId);
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제됨");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return bbsId;
	}

	@Override
	public List<ReplyVO> selectReplyList(int bbsId) {
		connect();
		String sql = "select * from reply where bbs_id=?";
		List<ReplyVO> rList = new ArrayList<>();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, bbsId);
			rs=psmt.executeQuery();
			while(rs.next()) {
				ReplyVO vo = new ReplyVO();
				vo.setBbsId(rs.getInt("bbs_id"));
				vo.setReplyContent(rs.getString("reply_content"));
				vo.setReplyDate(rs.getString("reply_date"));
				vo.setReplyId(rs.getInt("reply_id"));
				vo.setReplyWriter(rs.getString("reply_writer"));
				rList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return rList;
	}

	@Override
	public ReplyVO insertReply(ReplyVO vo) {
		connect();
		
		String sql1 = "select reply_id_seq.nextval, sysdate from dual";
		String sql2 = "insert into reply(reply_id,reply_content,reply_writer,reply_date,bbs_id)"
					+ "values(?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),?)";
		//to_date 문자열을 데이트 타입으로
		try {
			psmt=conn.prepareStatement(sql1);
			rs=psmt.executeQuery();
			int replySeq = 0;
			String replyDate = "";
			if(rs.next()) {
				replySeq = rs.getInt(1);//첫번째 칼럼값
				replyDate = rs.getString(2);
				System.out.println(replyDate);
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, replySeq);
			psmt.setString(2, vo.getReplyContent());
			psmt.setString(3, vo.getReplyWriter());
			psmt.setString(4, replyDate);
			psmt.setInt(5, vo.getBbsId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
			
			vo.setReplyId(replySeq);//생성된값
			vo.setReplyDate(replyDate); //생성된값.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		
		return vo;
	}

	@Override
	public boolean deleteReply(int rid) {
		String sql = "delete from reply where reply_id=?";
		connect();
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, rid);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 댓글 삭제됨");
			
			if(r>0) {	//정상 삭제
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		
		return false;
	}

	@Override
	public int selectCnt() {
		connect();
		String sql = "select count(*) from bbs";
		
		int totalCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		
		return totalCnt;
	}
	
}
