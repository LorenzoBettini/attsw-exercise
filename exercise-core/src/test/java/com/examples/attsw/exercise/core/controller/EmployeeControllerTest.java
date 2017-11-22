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
	private List<Employee> employees;
	private IEmployeeService iEmployeeService;

	@Before
	public void setUp() throws Exception {
		iEmployeeService = Mockito.mock(IEmployeeService.class);
		employeeController = new EmployeeController(iEmployeeService);
		employees = new LinkedList<Employee>();
		Mockito.when(iEmployeeService.getEmployees()).thenReturn(employees);
	}

	@Test
	public void testGetAllEmployeeWhenThereAreNoEmployee() {
		assertGetAllEmployee("");
	}

	@Test
	public void testGetAllEmployeeWhenThereIsOneEmployee() {
		Employee employee = newEmployee("nameTest", "idTest");
		employees.add(employee);
		assertGetAllEmployee(employee.getName());
	}

	@Test
	public void testGetEmployeeByIdWhenEmployeeDoesntExists() {
		Employee employee = employeeController.getEmployeeById("1");
		assertNull(employee);
	}

	@Test
	public void testGetEmployeeByIdWhenEmployeeExists() {
		Employee newEmployee = newEmployee("nameTest", "1");
		employees.add(newEmployee);
		Employee employee = employeeController.getEmployeeById("1");
		assertEquals(newEmployee.getName(), employee.getName());
	}

	private Employee newEmployee(String name, String id) {
		return new Employee(name, id);
	}

	private void assertGetAllEmployee(String expected) {
		String allEmployee = employeeController.getAllEmployee();
		assertEquals(expected, allEmployee);
	}

}
