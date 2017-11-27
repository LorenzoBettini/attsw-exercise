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
		assertShowWhat("There are no Employees", "showAll", "");
	}

	@Test
	public void testShowAllWhenThereIsOneEmployee() {
		allEmployees = concatNewEmployee("1", "name1");
		assertShowWhat(allEmployees, "showAll", "");
	}

	@Test
	public void testShowAllWhenThereAreTwoEmployees() {
		allEmployees = concatNewEmployee("1", "name1").concat(concatNewEmployee("2", "name2"));
		assertShowWhat(allEmployees, "showAll", "");
	}

	@Test
	public void testShowOneWhenThereAreNoEmployees() {
		assertShowWhat("There are no Employees", "showOne", "1");
	}

	@Test
	public void testShowOneWheneEmployeeDoesNotExists() {
		allEmployees = concatNewEmployee("1", "name1");
		when(employeeController.getEmployeeById("2")).thenReturn("");
		assertShowWhat("There are no Employee with this id", "showOne", "2");
	}

	@Test
	public void testShowOneWhenEmployeeExists() {
		Employee employee = createNewEmployee("1", "name1");
		allEmployees = concatNewEmployee(employee.getId(), employee.getName());
		when(employeeController.getEmployeeById(employee.getId())).thenReturn(employee.getName());
		assertShowWhat(employee.getName(), "showOne", employee.getId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOtherStringInActionCodeArgument() {
		assertShowWhat("", "", "");
	}

	private String concatNewEmployee(String id, String name) {
		return (createNewEmployee(id, name).toString()).concat(System.getProperty("line.separator"));
	}

	private Employee createNewEmployee(String id, String name) {
		return new Employee(id, name);
	}

	private void assertShowWhat(String expected, String showWhat, String arg) {
		when(employeeController.getAllEmployees()).thenReturn(allEmployees);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		appController.performAction(showWhat, arg, out);
		assertEquals(expected, new String(baos.toByteArray(), StandardCharsets.UTF_8));
	}

}
