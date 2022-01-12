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
	// 전체 일정을 가지고 오는 메소드.
	public List<Map<String,String>> getSchedules(){
		String sql = "SELECT * FROM full_calendar";
		connect();
		
		// 반환타입 : List<Map<String, String>>
		// {title : "test", start : "2020-01-01", end : "2020-01-02"}
		List<Map<String, String>> scheduleList = new ArrayList<Map<String, String>>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("title", rs.getString("title"));
				map.put("start", rs.getString("start_date"));
				map.put("end", rs.getString("end_date"));

				scheduleList.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return scheduleList;
	}
}
