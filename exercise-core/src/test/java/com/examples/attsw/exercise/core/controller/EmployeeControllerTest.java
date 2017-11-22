package com.examples.attsw.exercise.core.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeControllerTest {

	public EmployeeController employeeController;

	@Before
	public void setUp() throws Exception {
		IEmployeeService iEmployeeService = Mockito.mock(IEmployeeService.class);
		employeeController = new EmployeeController(iEmployeeService);
	}

	@Test
	public void testGetAllEmployeeWhenThereAreNoEmployee() {
		String allEmployee = employeeController.getAllEmployee();
		assertEquals("", allEmployee);
	}

}
