package com.examples.attsw.exercise.core.controller;

import java.util.Iterator;
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

	public Employee getEmployeeById(String id) {
		Iterator<Employee> iteratorAllEmployee = iEmployeeService.getEmployees().iterator();
		while (iteratorAllEmployee.hasNext()) {
			Employee actualEmployee = iteratorAllEmployee.next();
			if (actualEmployee.getId() == id) {
				return actualEmployee;
			}
		}
		return null;
	}

}
