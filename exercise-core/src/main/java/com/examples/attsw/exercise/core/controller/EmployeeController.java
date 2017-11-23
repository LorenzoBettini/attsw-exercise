package com.examples.attsw.exercise.core.controller;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeController {

	private IEmployeeService employeeService;

	public EmployeeController(IEmployeeService iEmployeeService) {
		this.employeeService = iEmployeeService;
	}

	public String getAllEmployee() {
		String stringEmployee = "";
		for (Employee employee : employeeService.getEmployees()) {
			stringEmployee += employee.toString();
		}
		return stringEmployee;
	}

	public String getEmployeeById(String id) {
		return employeeService.getEmployeeById(id).getName();
	}

}
