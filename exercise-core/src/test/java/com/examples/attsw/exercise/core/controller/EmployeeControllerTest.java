package com.examples.attsw.exercise.core.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeControllerTest {

	// SUT
	public EmployeeController employeeController;
	private List<Employee> listEmployees;
	private IEmployeeService employeeService;

	@Before
	public void setUp() throws Exception {
		employeeService = mock(IEmployeeService.class);
		employeeController = new EmployeeController(employeeService);
		listEmployees = new LinkedList<Employee>();
		when(employeeService.getEmployees()).thenReturn(listEmployees);
	}

	@Test
	public void testGetAllEmployeeWhenThereAreNoEmployee() {
		assertGetAllEmployee("");
	}

	@Test
	public void testGetAllEmployeeWhenThereIsOneEmployee() {
		Employee employee = newEmployee("nameTest", "idTest");
		listEmployees.add(employee);
		assertGetAllEmployee("Employee [name="+employee.getName()+", id="+employee.getId()+"]");
	}

	@Test (expected = NullPointerException.class)
	public void testGetEmployeeByIdWhenEmployeeDoesntExists() {
		assertEquals(null, employeeController.getEmployeeById("1"));
	}

	@Test
	public void testGetEmployeeByIdWhenEmployeeExists() {
		Employee newEmployee = newEmployee("nameTest", "1");
		when(employeeService.getEmployeeById("1")).thenReturn(newEmployee);
		assertEquals(newEmployee.getName(), employeeController.getEmployeeById("1"));
	}

	private Employee newEmployee(String name, String id) {
		return new Employee(name, id);
	}

	private void assertGetAllEmployee(String expected) {
		String allEmployee = employeeController.getAllEmployee();
		assertEquals(expected, allEmployee);
	}

}
