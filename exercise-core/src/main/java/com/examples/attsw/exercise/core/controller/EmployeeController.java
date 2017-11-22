package com.examples.attsw.exercise.core.controller;

import java.util.List;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeController {

	private IEmployeeService iEmployeeService;

	public EmployeeController(IEmployeeService iEmployeeService) {
		this.iEmployeeService = iEmployeeService;
	}

	public String getAllEmployee() {
		List<Employee> allEmployee = iEmployeeService.getEmployees();
		String stringEmployee = "";
		for (Employee employee : allEmployee) {
			stringEmployee += employee.toString();
		}
		return stringEmployee;
	}

	public String getEmployeeById(String id) {
		return iEmployeeService.getEmployeeById(id).getName();
	}

}
