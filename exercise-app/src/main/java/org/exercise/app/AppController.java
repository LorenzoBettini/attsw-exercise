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
				String employeeById = employeeController.getEmployeeById(arg);
				if (employeeById.equals("")) {
					out.print("There are no Employee with this id");
				}
				out.print(employeeById);
			}
			return;
		}
		out.print("There are no Employees");
	}

}
