package org.exercise.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.examples.attsw.exercise.core.controller.IEmployeeController;
import com.examples.attsw.exercise.core.model.Employee;

public class AppControllerTest {

	@InjectMocks
	private AppController appController;
	@Mock
	private IEmployeeController employeeController;
	private String allEmployees;

	@Before
	public void setUp() throws Exception {
		allEmployees = "";
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShowAllWhenThereAreNoEmployees() {
		assertShowAll("There is no Employees");
	}

	@Test
	public void testShowAllWhenThereIsOneEmployee() {
		allEmployees = concatNewEmployee(createNewEmployee("1", "name"));
		assertShowAll(allEmployees);
	}

	@Test
	public void testShowAllWhenThereAreTwoEmployees() {
		allEmployees = concatNewEmployee(createNewEmployee("1", "name1")
				.concat(concatNewEmployee(createNewEmployee("2", "name2"))));
		assertShowAll(allEmployees);
	}

	@Test
	public void testShowOneWhenThereAreNoEmployees() {
		assertShowOne("There is no Employee with this id", "1", "");
	}

	@Test
	public void testShowOneWheneEmployeeDoesNotExists() {
		allEmployees = concatNewEmployee(createNewEmployee("1", "name1"));
		assertShowOne("There is no Employee with this id", "2", "");
	}

	@Test
	public void testShowOneWhenEmployeeExists() {
		String employee = createNewEmployee("1", "name");
		allEmployees = concatNewEmployee(employee);
		assertShowOne(employee, "1", employee);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOtherStringInActionCodeArgument() {
		assertShowWhat("", "", "");
	}

	private String concatNewEmployee(String employee) {
		return employee.concat(System.getProperty("line.separator"));
	}

	private String createNewEmployee(String id, String name) {
		return new Employee(id, name).toString();
	}

	private void assertShowWhat(String expected, String arg, String show) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		appController.performAction(show, arg, out);
		assertEquals(expected, new String(baos.toByteArray(), StandardCharsets.UTF_8));
	}

	private void assertShowAll(String expected) {
		when(employeeController.getAllEmployees()).thenReturn(allEmployees);
		assertShowWhat(expected, "", AppController.SHOW_ALL);
	}

	private void assertShowOne(String expected, String id, String stringToReturn) {
		when(employeeController.getEmployeeById(id)).thenReturn(stringToReturn);
		assertShowWhat(expected, id, AppController.SHOW_ONE);
	}

}
