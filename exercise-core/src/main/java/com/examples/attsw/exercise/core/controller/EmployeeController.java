package com.examples.attsw.exercise.core.controller;

import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeController {

	private IEmployeeService iEmployeeService;

	public EmployeeController(IEmployeeService iEmployeeService) {
		this.iEmployeeService = iEmployeeService;
	}

}
