package com.examples.attsw.exercise.core.repository;

import java.util.List;

import com.examples.attsw.exercise.core.model.*;

public interface Repository {

	/**
	 * It is assumed that allEmployees() never returns a NULL lists
	 */
	public List<Employee> findAll();

	public Employee findEmployeeById(String id);

}
