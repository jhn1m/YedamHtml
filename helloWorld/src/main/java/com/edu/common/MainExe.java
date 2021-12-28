package com.edu.common;

import java.util.List;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;

public class MainExe {
	
	public static void main(String[] args) {
		
		EmpDAO dao = new EmpDAO();
		EmployeeVO emp = dao.getEmployee(100);
		
		System.out.println(emp);
		
		System.out.println();

		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeId(208);
		vo.setFirstName("민수");
		vo.setLastName("김");
		vo.setEmail("kms@email.com");
		vo.setHireDate("2021-05-01");
		vo.setJobId("ST_MAN");
		vo.setSalary(7000);
		//dao.insertEmp(vo);
		//dao.updateEmp(vo);
		dao.deleteEmp(208);
		
		System.out.println();
		
		List<EmployeeVO> empList = dao.getEmpList();
		for(EmployeeVO empl : empList) {
			System.out.println(empl);
		}
		
		
		
	}
}
