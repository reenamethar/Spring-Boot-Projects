package com.learning.employeedirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.employeedirectory.dao.EmployeeDAO;
import com.learning.employeedirectory.errorHandling.EmployeeNotFoundException;
import com.learning.employeedirectory.pojo.Employee;
@Component
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}
	@Override
	public Employee findEmployeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeDAO.findById(id);
		if(!emp.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with employee id "+ id);
		}
		return emp.get();
	}

}
