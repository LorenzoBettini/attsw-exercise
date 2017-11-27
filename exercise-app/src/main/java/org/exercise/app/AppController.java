package org.exercise.app;

import java.io.PrintStream;

import com.examples.attsw.exercise.core.controller.IEmployeeController;

public class AppController {

	private IEmployeeController employeeController;

	public AppController(IEmployeeController employeeController) {
		this.employeeController = employeeController;
	}

	public void performAction(String actionCode, String arg, PrintStream out) {
		String allEmployees = employeeController.getAllEmployees();
		if (!allEmployees.equals("")) {
			if (actionCode.equals("showAll")) {
				out.print(allEmployees);
			} else if (actionCode.equals("showOne")) {
				out.print(employeeController.getEmployeeById(arg));
			}
			return;
		}
		out.print("There are no Employees");
	}

}
