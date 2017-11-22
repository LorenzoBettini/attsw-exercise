package com.examples.attsw.exercise.core.repository;

import java.util.List;

import com.examples.attsw.exercise.core.model.*;
import com.examples.attsw.exercise.core.model.repository.mongo.Employee;

public interface Repository {
	List<Employee> findAll();
	Employee findEmployeeById(String id);
	
}