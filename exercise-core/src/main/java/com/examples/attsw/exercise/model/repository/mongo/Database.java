package com.examples.attsw.exercise.model.repository.mongo;

import java.util.List;

public interface Database {
	List<Employee> findAll();
	Employee findEmployeeById(String id);

}
