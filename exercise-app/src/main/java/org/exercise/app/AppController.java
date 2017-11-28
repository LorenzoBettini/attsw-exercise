package org.exercise.app;

import java.io.PrintStream;

import com.examples.attsw.exercise.core.controller.IEmployeeController;

public class AppController {

	public static final String SHOW_ONE = "showOne";
	public static final String SHOW_ALL = "showAll";
	private IEmployeeController employeeController;

	public AppController(IEmployeeController employeeController) {
		this.employeeController = employeeController;
	}

	public void performAction(String actionCode, String arg, PrintStream out) throws IllegalArgumentException {
		switch (actionCode) {
		case SHOW_ALL:
			caseShowAll(out);
			return;
		case SHOW_ONE:
			caseShowOne(arg, out);
			return;
		default:
			throw new IllegalArgumentException();
		}
	}

	private void caseShowOne(String arg, PrintStream out) {
		String employeeById = employeeController.getEmployeeById(arg);
		if (employeeById.equals("")) {
			out.print("There is no Employee with this id");
		}
		out.print(employeeById);
	}

	private void caseShowAll(PrintStream out) {
		if (!employeeController.getAllEmployees().equals("")) {
			out.print(employeeController.getAllEmployees());
		} else {
			out.print("There is no Employees");
		}
	}

}
