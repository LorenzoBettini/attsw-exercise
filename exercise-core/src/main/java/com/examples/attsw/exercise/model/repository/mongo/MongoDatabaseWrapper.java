package com.examples.attsw.exercise.model.repository.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
public class MongoDatabaseWrapper implements Database {
	

	private MongoClient mongoClient;
	private DBCollection employees;

	public MongoDatabaseWrapper(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
		DB db = mongoClient.getDB("factory");
		employees = db.getCollection("employee");
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Employee>();
	}

	@Override
	public Employee findEmployeeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
