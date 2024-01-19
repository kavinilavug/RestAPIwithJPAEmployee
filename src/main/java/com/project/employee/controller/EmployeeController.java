package com.project.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.employee.entity.Employee;
import com.project.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empSev;

	@PostMapping("/employee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee empolyee) {
		empSev.createEmployee(empolyee);
		return new ResponseEntity<Employee>(HttpStatus.CREATED);
	}

	@GetMapping("/employee/{empid}")
	Optional<Employee> getEmployee(@PathVariable int empid) {
		Optional<Employee> emp = empSev.readEmployee(empid);
		if(emp.isPresent()) {
			
		}
		return emp;
	}

	@GetMapping("/employee")
	List<Employee> getListOfEmployee() {
		List<Employee> emp = empSev.readListOfEmployee();
		return emp;
	}

	@DeleteMapping("/employee/{empId}")
	ResponseEntity<Employee> removeEmployee(@PathVariable int empId) {
		empSev.deletEmployee(empId);
		return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
	}

	@PatchMapping("/employee/{empId}/{empName}")
	ResponseEntity<Employee> updateEmployeeName(@PathVariable int empId, @PathVariable String empName) {
		empSev.updateEmpName(empId, empName);
		return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
	}

	@PutMapping("employee/{empId}")
	void updateEmployee(@PathVariable int empId, @RequestBody Employee emp) {
		empSev.updateEmployee(empId, emp);

	}

}
