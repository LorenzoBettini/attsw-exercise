package com.examples.attsw.exercise.core.controller;

import java.util.stream.Collectors;

import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeController {

	private IEmployeeService employeeService;

	public EmployeeController(IEmployeeService iEmployeeService) {
		this.employeeService = iEmployeeService;
	}

	public String getAllEmployees() {
		String stringEmployee = employeeService.getEmployees().stream()
				.map(employee -> employee.toString() + System.getProperty("line.separator"))
				.collect(Collectors.joining());
		return stringEmployee;
	}

	public String getEmployeeById(String id) {
		return employeeService.getEmployeeById(id).getName();
	}

}
