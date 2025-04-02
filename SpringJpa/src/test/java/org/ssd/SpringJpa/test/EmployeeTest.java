package org.ssd.SpringJpa.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.ssd.SpringJpa.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeTest {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	
	@Test
	public void  getEmployeeDetailsByName() {
		
	System.err.println(employeeRepository.findByEname("smith"));
	
}
	@Test
	public void  getEmployeeDetailsByEmpno() {
		
		System.err.println(employeeRepository.findByEmpno(7566l));
		
	}
	
	@Test
public void  getEmployeeDetailsByJob() {
		System.err.println(employeeRepository.findByMgr(7902l));
	}
	
	
}
