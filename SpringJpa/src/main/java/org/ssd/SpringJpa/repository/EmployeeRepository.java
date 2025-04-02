package org.ssd.SpringJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssd.SpringJpa.entity.EmployeeEntity;

public interface EmployeeRepository  extends JpaRepository<EmployeeEntity, Long>{

	
	public EmployeeEntity findByEname(String ename);
	
	public EmployeeEntity findByEmpno(Long empno);
	
	//public EmployeeEntity findByJob(String job);
	
	public EmployeeEntity findByMgr(Long mgr);
	
	List<EmployeeEntity> findByDeptno(Long deptno);
}
