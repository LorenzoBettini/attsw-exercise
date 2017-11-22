package com.examples.attsw.exercise.core.model.repository.mongo;

import static org.junit.Assert.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.examples.attsw.exercise.model.repository.mongo.Database;
import com.examples.attsw.exercise.model.repository.mongo.MongoDatabaseWrapper;
import com.github.fakemongo.Fongo;
import com.mongodb.BasicDBObject;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MongoTest {
	private Database database;
	private DBCollection employees;
	
	@Before
	public void setUp() throws Exception {
		Fongo fongo = new Fongo("mongo server 1");
		MongoClient mongoClient = fongo.getMongo();
		DB db = mongoClient.getDB("factory");
		db.getCollection("employee").drop();
		database = new MongoDatabaseWrapper(mongoClient);
		employees = db.getCollection("employee");
	
	}
	@Test
	public void testGetAllEmployeesEmpty() {
	assertTrue(database.findAll().isEmpty());
	}

	

}
