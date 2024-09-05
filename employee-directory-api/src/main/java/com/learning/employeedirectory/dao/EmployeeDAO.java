package com.learning.employeedirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.employeedirectory.pojo.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
