package org.exercise.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import com.examples.attsw.exercise.core.controller.IEmployeeController;
import com.examples.attsw.exercise.core.model.Employee;

public class AppControllerTest {

	// SUT
	private AppController appController;
	private IEmployeeController employeeController;
	private String allEmployees;

	@Before
	public void setUp() throws Exception {
		allEmployees = "";
		employeeController = mock(IEmployeeController.class);
		appController = new AppController(employeeController);
	}

	@Test
	public void testShowAllWhenThereAreNoEmployees() {
		when(employeeController.getAllEmployees()).thenReturn("");
		assertShowAll("There are no Employees");
	}

	@Test
	public void testShowAllWhenThereIsOneEmployee() {
		allEmployees = concatNewEmployee("1", "name1");
		when(employeeController.getAllEmployees()).thenReturn(allEmployees);
		assertShowAll(allEmployees);
	}

	@Test
	public void testShowAllWhenThereAreTwoEmployees() {
		allEmployees = concatNewEmployee("1", "name1").concat(concatNewEmployee("2", "name2"));
		when(employeeController.getAllEmployees()).thenReturn(allEmployees);
		assertShowAll(allEmployees);
	}

	private String concatNewEmployee(String id, String name) {
		return (createNewEmployee(id, name).toString()).concat(System.getProperty("line.separator"));
	}

	private Employee createNewEmployee(String id, String name) {
		return new Employee(id, name);
	}

	private void assertShowAll(String expected) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		appController.performAction("showAll", null, out);
		assertEquals(expected, new String(baos.toByteArray(), StandardCharsets.UTF_8));
	}

}
