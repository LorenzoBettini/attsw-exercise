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
	
	public EmployeeController employeeController;

	@Before
	public void setUp() throws Exception {
			List<Employee> employees = new LinkedList<Employee>();
			IEmployeeService iEmployeeService = Mockito.mock(IEmployeeService.class);
			employeeController = new EmployeeController(iEmployeeService);
	}

	@Test
	public void test() {
		
	}

}
