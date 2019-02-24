package com.zubala.rafal.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zubala.rafal.model.Employee;
import com.zubala.rafal.repository.EmployeeRepository;

//Test from: https://stackify.com/streams-guide-java-8/

public class StreamTest {
	
	private static EmployeeRepository employeeRepository = new EmployeeRepository();
	
	private static List<Employee> empList = Arrays.asList(EmployeeRepository.arrayOfEmps);

	public static final Logger logger = Logger.getLogger("com.zubala.rafal.test.StreamTest");

	@BeforeAll
	public static void init() throws Exception {
		BasicConfigurator.configure();
	}

	@Test
	public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {    
	    empList.stream().forEach(e -> e.salaryIncrement(10.0));
	    
	    assertThat(empList, contains(
	      hasProperty("salary", equalTo(110000.0)),
	      hasProperty("salary", equalTo(220000.0)),
	      hasProperty("salary", equalTo(330000.0))
	    ));
	}
	
	@Test
	public void whenMapIdToEmployees_thenGetEmployeeStream() {
	    Integer[] empIds = { 1, 2, 3 };
	    
	    List<Employee> employees = Stream.of(empIds)
	    		.map(employeeRepository::findById)
	    		.collect(Collectors.toList());
	    
	    assertEquals(employees.size(), empIds.length);
	}	
}
