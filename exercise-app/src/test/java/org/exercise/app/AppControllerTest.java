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
	AppController appController;
	private IEmployeeController employeeController;
	private String allEmployees;

	@Before
	public void setUp() throws Exception {
		allEmployees = "";
		employeeController = mock(IEmployeeController.class);
		when(employeeController.getAllEmployees()).thenReturn(allEmployees);
		appController = new AppController(employeeController);
	}

	@Test
	public void testShowAllWhenThereAreNoEmployees() {
		assertShowAll("There are no Employees");
	}

	@Test
	public void testShowAllWhenThereIsOneEmployee() {
		Employee employee = new Employee("1", "name1");
		allEmployees = allEmployees.concat(employee.toString());
		assertShowAll(allEmployees);
	}

	private void assertShowAll(String expected) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		appController.performAction("showAll", null, out);
		assertEquals(expected, new String(baos.toByteArray(), StandardCharsets.UTF_8));
	}

}
