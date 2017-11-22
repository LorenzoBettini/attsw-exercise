package com.examples.attsw.exercise.core;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.repository.Repository;
import com.examples.attsw.exercise.core.service.EmployeeService;

public class EmployeeServiceTest {

	private EmployeeService employeeService;
	
	private Repository repository;
	
	List<Employee> list;
	
	@Before
	public void init() {
		list = new ArrayList<Employee>();
		repository = mock(Repository.class);
		when(repository.allEmployees()).thenReturn(list);
		employeeService = new EmployeeService(repository);
	}
	
	@Test
	public void testAllEmployeesWithNoEmployees() {
		assertAllEmployees(0);
	}
	
	@Test
	public void testAllEmployees() {
		list.add(new Employee("Employee 1"));
		list.add(new Employee("Employee 2"));
		assertAllEmployees(2);
	}

	private void assertAllEmployees(int expected) {
		List<Employee> result = employeeService.allEmployees();
		assertEquals(expected,result.size());
	}

}
