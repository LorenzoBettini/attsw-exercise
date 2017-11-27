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

public class AppControllerTest {

	// SUT
	AppController appController;
	private IEmployeeController employeeController;

	@Before
	public void setUp() throws Exception {
		employeeController = mock(IEmployeeController.class);
		appController = new AppController(employeeController);
	}

	@Test
	public void testPerformActionWhenActionCodeIsShowAllWhenThereAreNoEmployees() {
		when(employeeController.getAllEmployees()).thenReturn("");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		appController.performAction("showAll", "", out);
		assertEquals("There are no Employees", new String(baos.toByteArray(), StandardCharsets.UTF_8));
	}

}
