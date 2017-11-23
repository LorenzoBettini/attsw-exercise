package com.examples.attsw.exercise.core.repository;

import java.util.List;

import com.examples.attsw.exercise.core.model.*;

public interface Repository {
	List<Employee> findAll();
	Employee findEmployeeById(String id);
	
}