package com.zubala.rafal.repository;

import java.util.stream.Stream;

import com.zubala.rafal.model.Employee;

public class EmployeeRepository {
	public static Employee[] arrayOfEmps = {
		    new Employee(1, "Jeff Bezos", 100000.0), 
		    new Employee(2, "Bill Gates", 200000.0), 
		    new Employee(3, "Mark Zuckerberg", 300000.0)
	};

	public Employee findById(int id) {
		return Stream.of(arrayOfEmps).filter((e) -> e.getId() == id).findFirst().orElse(null);
	}
}
