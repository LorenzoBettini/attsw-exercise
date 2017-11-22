package com.examples.attsw.exercise.core.model.repository.mongo;

import static org.junit.Assert.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import com.examples.attsw.exercise.core.model.repository.mongo.Employee;
import com.examples.attsw.exercise.core.repository.Repository;
import com.github.fakemongo.Fongo;
import com.mongodb.BasicDBObject;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MongoTest {
	private Repository database;
	private DBCollection employees;
	
	@Before
	public void setUp() throws Exception {
		Fongo fongo = new Fongo("mongo server 1");
		MongoClient mongoClient = fongo.getMongo();
		DB db = mongoClient.getDB("factory");
		db.getCollection("employee").drop();
		database = new MongoRepository(mongoClient);
		employees = db.getCollection("employee");
	
	}
	@Test
	public void testGetAllEmployeesEmpty() {
	assertTrue(database.findAll().isEmpty());
	}
	@Test
	public void testOneEmployee() {
		addEmployee("1");
		Employee e=database.findEmployeeById("1");
		assertEquals("1",e.getId());
		
		
	}
	
	private void addEmployee(String id) {
		BasicDBObject document = new BasicDBObject();
		document.put("id", id);
		employees.insert(document);
		
		
		}

	

}
