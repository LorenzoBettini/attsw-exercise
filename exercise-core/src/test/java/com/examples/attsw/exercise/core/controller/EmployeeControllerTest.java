package com.examples.attsw.exercise.core.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeControllerTest {

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
		assertGetAllEmployees("");
	}

	@Test
	public void testGetAllEmployeeWhenThereIsOneEmployee() {
		Employee employee = newEmployee("idTest", "nameTest");
		listEmployees.add(employee);
		assertGetAllEmployees(extractAllEmployeesStringFromList(listEmployees));
	}

	@Test
	public void testGetAllEmployeeWhenThereAreTwoEmployees() {
		Employee employee0 = newEmployee("idEmployee0", "nameEmployee0");
		Employee employee1 = newEmployee("idEmployee1", "nameEmployee1");
		listEmployees.add(employee0);
		listEmployees.add(employee1);
		assertGetAllEmployees(extractAllEmployeesStringFromList(listEmployees));
	}

	@Test(expected = NullPointerException.class)
	public void testGetEmployeeByIdWhenEmployeeDoesntExists() {
		assertEquals(null, employeeController.getEmployeeById("1"));
	}

	@Test
	public void testGetEmployeeByIdWhenEmployeeExists() {
		Employee newEmployee = newEmployee("1", "nameTest");
		when(employeeService.getEmployeeById("1")).thenReturn(newEmployee);
		assertEquals(newEmployee.toString(), employeeController.getEmployeeById("1"));
	}

	private String extractAllEmployeesStringFromList(List<Employee> allEmployees) {
		String stringAllEmployees = allEmployees.stream()
				.map(employee -> employee.toString() + System.getProperty("line.separator"))
				.collect(Collectors.joining());
		return stringAllEmployees;
	}

	private Employee newEmployee(String id, String name) {
		return new Employee(id, name);
	}

	private void assertGetAllEmployees(String expected) {
		String allEmployees = employeeController.getAllEmployees();
		assertEquals(expected, allEmployees);
	}

}
