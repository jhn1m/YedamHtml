package com.edu.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;

public class EmpDAO extends DAO {

	public List<EmployeeVO> getEmpList() {
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		try {
			connect();
			String select = "SELECT * FROM emp_temp ORDER BY 1";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					EmployeeVO emp = new EmployeeVO();
					emp.setEmployeeId(rs.getInt("employee_id"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setLastName(rs.getString("last_name"));
					emp.setEmail(rs.getString("email"));
					emp.setHireDate(rs.getString("hire_date").substring(0, 10));
					emp.setJobId(rs.getString("job_id"));
					emp.setSalary(rs.getInt("salary"));

					list.add(emp);
				}
			} else {
				System.out.println("자료가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public EmployeeVO getEmployee(int eid) {
		EmployeeVO emp = new EmployeeVO();
		try {
			connect();
			String select = "SELECT * FROM employees WHERE employee_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, eid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return null;
	}

	// 시퀀스를 사용하지 않기 위함
	public void insertEmployee(EmployeeVO vo) {
		String sql = "insert into emp_temp(employee_id, first_name, last_name, salary, email, hire_date, job_id) values(?, ?, ?, ?, ?, ?, ?)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmployeeId());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getLastName());
			pstmt.setInt(4, vo.getSalary());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getHireDate());
			pstmt.setString(7, "IT_PROG");
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 입력 값을 gn, ln, em, hd, ji, sa
	// 한 건 입력.
	public void insertEmp(EmployeeVO emp) {
		try {
			connect();
			String insert = "INSERT INTO emp_temp(employee_id,first_name,last_name,email,hire_date,job_id,salary) "
					+ "VALUES (employees_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getHireDate());
			pstmt.setString(5, emp.getJobId());
			pstmt.setInt(6, emp.getSalary());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	public void updateEmp(EmployeeVO emp) {
		try {
			connect();
			String update = "UPDATE emp_temp SET salary = ?, job_id = ?, email = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, emp.getSalary());
			pstmt.setString(2, emp.getJobId());
			pstmt.setString(3, emp.getEmail());
			pstmt.setInt(4, emp.getEmployeeId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 수정했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public boolean deleteEmployee(String empId) throws SQLException {
		String sql = "delete from emp_temp where employee_id = ?";
		connect();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, empId);
		int r = pstmt.executeUpdate(); // 처리된 건수 반환.
		if (r > 0) {
			System.out.println(r + "건 삭제했습니다.");
			return true;
		} else {
			return false;
		}
	}

	// 삭제
	public void deleteEmp(int empId) {
		try {
			connect();
			String delete = "DELETE FROM emp_temp WHERE employee_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, empId);
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
