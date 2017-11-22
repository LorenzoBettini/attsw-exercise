package com.examples.attsw.exercise.core.controller;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeControllerTest {

	// SUT
	public EmployeeController employeeController;
	private List<Employee> listEmployees;
	private IEmployeeService iEmployeeService;

	@Before
	public void setUp() throws Exception {
		iEmployeeService = Mockito.mock(IEmployeeService.class);
		employeeController = new EmployeeController(iEmployeeService);
		listEmployees = new LinkedList<Employee>();
		Mockito.when(iEmployeeService.getEmployees()).thenReturn(listEmployees);
	}

	@Test
	public void testGetAllEmployeeWhenThereAreNoEmployee() {
		assertGetAllEmployee("");
	}

	@Test
	public void testGetAllEmployeeWhenThereIsOneEmployee() {
		Employee employee = newEmployee("nameTest", "idTest");
		listEmployees.add(employee);
		assertGetAllEmployee(employee.getName());
	}

	@Test (expected = NullPointerException.class)
	public void testGetEmployeeByIdWhenEmployeeDoesntExists() {
		assertEquals(null, employeeController.getEmployeeById("1"));
	}

	@Test
	public void testGetEmployeeByIdWhenEmployeeExists() {
		Employee newEmployee = newEmployee("nameTest", "1");
		Mockito.when(iEmployeeService.getEmployeeById("1")).thenReturn(newEmployee);
		String employee = employeeController.getEmployeeById("1");
		assertEquals(newEmployee.getName(), employee);
	}

	private Employee newEmployee(String name, String id) {
		return new Employee(name, id);
	}

	private void assertGetAllEmployee(String expected) {
		String allEmployee = employeeController.getAllEmployee();
		assertEquals(expected, allEmployee);
	}

}
