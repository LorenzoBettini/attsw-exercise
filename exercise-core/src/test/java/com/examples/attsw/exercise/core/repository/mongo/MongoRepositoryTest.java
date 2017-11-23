package com.examples.attsw.exercise.core.repository.mongo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.repository.Repository;
import com.github.fakemongo.Fongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoRepositoryTest {
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
		assertEquals(1, database.findAll().size());
	}

	@Test
	public void testEmployeessize() {
		addEmployee("1");
		addEmployee("2");
		assertEquals(2, database.findAll().size());
	}

	@Test
	public void testNotFound() {
		assertNull(database.findEmployeeById("1"));
	}

	@Test
	public void testFound() {
		addEmployee("1");
		addEmployee("2");
		Employee e = database.findEmployeeById("2");
		assertNotNull(e);
		assertEquals("2", e.getId());
	}

	private void addEmployee(String id) {
		BasicDBObject document = new BasicDBObject();
		document.put("id", id);
		employees.insert(document);
	}
}
