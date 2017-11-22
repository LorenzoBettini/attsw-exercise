package com.examples.attsw.exercise.core.service;

import java.util.List;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.repository.Repository;

public class EmployeeService {
	
	private Repository repository;
	
	public EmployeeService(Repository repository) {
		this.repository = repository;
	}

	public List<Employee> allEmployees() {
		// TODO Auto-generated method stub
		return repository.allEmployees();
	}

	public Employee oneEmployee(String id) {
		// TODO Auto-generated method stub
		return repository.oneEmployee(id);
	}
	
}
