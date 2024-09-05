package com.learning.employeedirectory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.employeedirectory.dao.EmployeeDAO;
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

}
