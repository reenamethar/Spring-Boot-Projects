package com.learning.employeedirectory.service;

import java.util.List;

import com.learning.employeedirectory.pojo.Employee;

public interface EmployeeService {
	List<Employee> listEmployees();
	Employee findEmployeById(int id);

}
