package com.RestTempletProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestTempletProject.payload.SsdEmployee;

public interface SsdEmployeeRepository extends JpaRepository<SsdEmployee, Long> {

	public SsdEmployee findByEmail(String email);

	public SsdEmployee findByFirstName(String firstName);

	

}
