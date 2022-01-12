package com.edu.full;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edu.common.DAO;

// com.edu.full.FullDAO
// title, startDate, endDate => VO, Map : key, value => 한건.

public class FullDAO extends DAO {
	// 일정등록하는 메소드
	public boolean insertSchedule(Map<String, String> map) throws SQLException {
		String sql = "INSERT INTO full_calendar VALUES(?,?,?)";
		connect();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, map.get("title"));
		pstmt.setString(2, map.get("startDate"));
		pstmt.setString(3, map.get("endDate"));

		int r = pstmt.executeUpdate();
		if (r > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteSchedule(Map<String, String> map) throws SQLException {
		String sql = "DELETE FROM full_calendar WHERE title = ?";
		connect();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, map.get("title"));
		int r = pstmt.executeUpdate();
		if(r > 0) {
			return true;
		}else {
			return false;
		}			
	}

	// 전체 일정을 가지고 오는 메소드.
	public List<Map<String, String>> getSchedules() {
		String sql = "SELECT * FROM full_calendar";
		connect();

		// 반환타입 : List<Map<String, String>>
		// {title : "test", start : "2020-01-01", end : "2020-01-02"}
		List<Map<String, String>> scheduleList = new ArrayList<Map<String, String>>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("title", rs.getString("title"));
				map.put("start", rs.getString("start_date"));
				map.put("end", rs.getString("end_date"));

				scheduleList.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return scheduleList;
	}
}
