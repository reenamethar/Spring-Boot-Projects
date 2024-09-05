package com.learning.employeedirectory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.employeedirectory.pojo.Employee;
import com.learning.employeedirectory.pojo.ErrorResponse;
import com.learning.employeedirectory.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	private EmployeeService employeeService;
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	@Operation(
			summary ="List of Employees",
			description= "Retrieve all employees",
			responses = {
					@ApiResponse(
							responseCode= "200",
							description= "list of employees successfully retrieved",
							content = @Content(
									schema = @Schema(implementation = Employee.class),
									mediaType = "aplication/json"
									)
							),
					@ApiResponse(
							responseCode = "500",
							description = "Internal server error",
							content = @Content(
									schema = @Schema(implementation = ErrorResponse.class),
									mediaType = "application/json"
									)
							)
			}
			)
	@GetMapping("/employees")
	public List<Employee> listEmployees(){
		return employeeService.listEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") int id) {
		Employee emp = employeeService.findEmployeById(id);
		return emp;
	}
}
