package com.examples.attsw.exercise.core.model;

public class Employee {

	private String id;
	private String name;

	public Employee(String id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
