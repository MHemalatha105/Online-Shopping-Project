package com.RestTempletProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestTempletProject.exception.EmployeeAlredyExisted;
import com.RestTempletProject.payload.SsdEmployee;
import com.RestTempletProject.repository.SsdEmployeeRepository;

@Service
public class SsdEmployeeService {

	@Autowired
	public SsdEmployeeRepository employeeRepository;

	public SsdEmployee saveEmp(SsdEmployee employee) {

		SsdEmployee emp = employeeRepository.findByEmail(employee.getEmail());

		if (emp != null) {
			throw new EmployeeAlredyExisted("employee alredy existed");
		} else {
			employee = employeeRepository.save(employee);
		}
		return employee;
	}

	public List<SsdEmployee> findAllEmployees() {

		return employeeRepository.findAll();
	}

	public SsdEmployee findById(Long id) throws Exception {
		SsdEmployee emp = null;
		if (employeeRepository.findById(id).get().getId() != null) {

			throw new EmployeeAlredyExisted("please check id ");
		} else {
			emp = employeeRepository.findById(id).get();

		}
		return emp;

	}

}
