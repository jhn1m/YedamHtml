package com.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private String jdbc_drive = "oracle.jdbc.driver.OracleDriver";
	private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "hr";
	private String pwd = "hr";

	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;

	public void connect() {
		try {
			Class.forName(jdbc_drive);
			conn = DriverManager.getConnection(jdbc_url, id, pwd);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
