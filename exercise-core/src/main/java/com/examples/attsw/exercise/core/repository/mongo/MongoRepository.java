package com.examples.attsw.exercise.core.repository.mongo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.repository.Repository;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoRepository implements Repository {

	private DBCollection employees;

	public MongoRepository(MongoClient mongoClient) {
		DB db = mongoClient.getDB("factory");
		employees = db.getCollection("employee");
	}

	@Override
	public List<Employee> findAll() {
		DBCursor cursor = employees.find();
		return StreamSupport.stream(cursor.spliterator(), false)
				.map(e -> new Employee((String) e.get("id"), (String) e.get("name"))).collect(Collectors.toList());
	}

	@Override
	public Employee findEmployeeById(String id) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", id);
		DBObject findOne = employees.findOne(searchQuery);
		return findOne != null ? new Employee((String) findOne.get("id"), "name") : null;
	}

}
