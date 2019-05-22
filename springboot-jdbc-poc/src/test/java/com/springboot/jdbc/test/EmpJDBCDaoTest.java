package com.springboot.jdbc.test;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.jdbc.Emp;
import com.springboot.jdbc.EmpJDBCDaoImpl;
import com.springboot.jdbc.JDBCAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =JDBCAppConfiguration.class)
public class EmpJDBCDaoTest {

	@Autowired
	EmpJDBCDaoImpl empJDBCDaoImpl;
	
	@Test
	public void createEmp() {
		Emp emp = empJDBCDaoImpl.create(getEmp());
		System.out.println("EMP "+emp);
		
	}
	
	@Test
	public void getEmpProc() {
		 empJDBCDaoImpl.callProcedure(getEmp());
		System.out.println("EMP Success");
		
	}
	
	private Emp getEmp() {
		Emp emp = new Emp();
		emp.setEmpno(9012);
		emp.setEname("@empname");
		emp.setJob("Test");
		emp.setMgr(123);
		emp.setHiredate(new Date(1));
		emp.setSal(234);
		emp.setComm(54);
		emp.setDeptno(60);
		return emp;
	}
}
