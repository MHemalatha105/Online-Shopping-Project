package org.ssd.SpringJpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	
	public Long empno;
	public String ename;
	public String job;
	public Long mgr;
	public String hiredate;
	public Double sal;
	public Double comm;
	public Long deptno;
}
