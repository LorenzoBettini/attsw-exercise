package com.examples.attsw.exercise.core;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.service.EmployeeService;

public class EmployeeServiceTest {

	private EmployeeService employeeService;
	
	@Test
	public void testAllEmployees() {
		List<Employee> list = employeeService.allEmployees();
	}

}
