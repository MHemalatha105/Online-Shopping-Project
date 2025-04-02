package com.RestTempletProject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.RestTempletProject.exception.EmployeeAlredyExisted;
import com.RestTempletProject.payload.SsdEmployee;
import com.RestTempletProject.repository.SsdEmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class SsdEmployeeServiceTest {

	@Mock
	public SsdEmployeeRepository ssdEmployeeRepository;

	@InjectMocks
	public SsdEmployeeService employeeService;

	public SsdEmployee emp = null;

	@BeforeEach
	public void empData() {
		emp = new SsdEmployee();
		emp.setEmail("harik2069@gmail.com");
		emp.setFirstName("hari");
		emp.setLastName("krishna");

	}

	@Test
	@DisplayName("employee save test")
	public void givenEmployee_whenSaveEmp_thenReturnEmp() {
		// given

		given(ssdEmployeeRepository.findByEmail(emp.getEmail())).willReturn(null);
		given(ssdEmployeeRepository.save(emp)).willReturn(emp);
		SsdEmployee emp1 = null;
		// when

		emp1 = employeeService.saveEmp(emp);

		assertThat(emp1.getEmail()).isEqualTo("harik2069@gmail.com");

	}

	@Test
	@DisplayName("employee already exsited exception")
	public void givenexception_whenSaveEmp_thenReturnEmp() {
		// given

		given(ssdEmployeeRepository.findByEmail(emp.getEmail())).willReturn(emp);

		// when
		assertThrows(EmployeeAlredyExisted.class, () -> employeeService.saveEmp(emp));

		// then

		verify(ssdEmployeeRepository, never()).save(emp);

	}

	@Test
	@DisplayName("find all employees")
	public void givenlistOfEmp_whengetEmp_thenReturnListEmp() {
		// given

		SsdEmployee emp1 = new SsdEmployee();
		emp1.setEmail("harik2069@gmail.com");
		emp1.setFirstName("hari");
		emp1.setLastName("krishna");

		SsdEmployee emp2 = new SsdEmployee();
		emp2.setEmail("harik2069@gmail.com");
		emp2.setFirstName("hari");
		emp2.setLastName("krishna");

		List<SsdEmployee> empList = new ArrayList<>();

		empList.add(emp);
		empList.add(emp1);
		empList.add(emp2);

		given(ssdEmployeeRepository.findAll()).willReturn(empList);

		// when

		List<SsdEmployee> empLists = employeeService.findAllEmployees();

		// then

		assertThat(empLists.size()).isEqualTo(3);

	}

	@Test
	@DisplayName("find all employees not equal Size")
	public void givenlistOfEmp_whengetEmp_thenReturnListEmpNotEquals() {
		// given

		SsdEmployee emp1 = new SsdEmployee();
		emp1.setEmail("harik2069@gmail.com");
		emp1.setFirstName("hari");
		emp1.setLastName("krishna");

		SsdEmployee emp2 = new SsdEmployee();
		emp2.setEmail("harik2069@gmail.com");
		emp2.setFirstName("hari");
		emp2.setLastName("krishna");

		List<SsdEmployee> empList = new ArrayList<>();

		empList.add(emp);
		empList.add(emp1);
		empList.add(emp2);

		given(ssdEmployeeRepository.findAll()).willReturn(empList);

		// when

		List<SsdEmployee> empLists = employeeService.findAllEmployees();

		// then

		assertThat(empLists.size()).isNotEqualTo(2);

	}

	@Test
	@DisplayName("Find By Employee Id")
	public void givenId_whenFindById_thenreturnEmp() {

		// given

		SsdEmployee emp11 = new SsdEmployee();
		emp11.setEmail("harik2069@gmail.com");
		emp11.setFirstName("hari");
		emp11.setLastName("krishna");

		Optional<SsdEmployee> em = Optional.ofNullable(emp11);

		given(ssdEmployeeRepository.findById(emp.getId())).willReturn(em);
		

		// when

		SsdEmployee empppp = null;
		try {
			empppp = employeeService.findById(emp11.getId());
			System.out.println(empppp.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// then

		assertThat(empppp.getEmail()).isEqualTo("harik2069@gmail.com");
		// assertThat(empppp.getId()).isEqualTo(1l);
	}

	
	
	
	
	
	
	
	
	
	
	
}
