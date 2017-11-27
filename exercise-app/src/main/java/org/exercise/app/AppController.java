package org.exercise.app;

import java.io.PrintStream;

import com.examples.attsw.exercise.core.controller.IEmployeeController;

public class AppController {

	private IEmployeeController employeeController;

	public AppController(IEmployeeController employeeController) {
		this.employeeController = employeeController;
	}

	public void performAction(String actionCode, String arg, PrintStream out) {
		if (actionCode.equals("showAll")) {
			String allEmployees = employeeController.getAllEmployees();
			if (allEmployees.equals("")) {
				out.print("There are no Employees");
				return;
			}
		}
	}

}
