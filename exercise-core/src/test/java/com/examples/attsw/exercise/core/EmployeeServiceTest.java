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
	
	@Test
	public void testOneEmployeeWhenItsNotThere() {
		when(repository.oneEmployee("Employee 1")).thenReturn(null);
		Employee result = employeeService.oneEmployee("Employee 1");
		assertNull(result);
		verify(repository,times(1)).oneEmployee("Employee 1");
	}
	
	@Test
	public void testOneEmployee() {
		when(repository.oneEmployee("Employee 1")).thenReturn(new Employee("Employee 1"));
		Employee result = employeeService.oneEmployee("Employee 1");
		assertNotNull(result);
		assertEquals("Employee 1",result.getId());
		verify(repository,times(1)).oneEmployee("Employee 1");
	}

	private void assertAllEmployees(int expected) {
		List<Employee> result = employeeService.allEmployees();
		assertEquals(expected,result.size());
		verify(repository,times(1)).allEmployees();
	}

}
