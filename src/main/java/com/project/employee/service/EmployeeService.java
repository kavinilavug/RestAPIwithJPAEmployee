package com.project.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employee.entity.Employee;
import com.project.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRep;

	public Employee createEmployee(Employee emp) {
		return empRep.save(emp);

	}

	public Optional<Employee> readEmployee(int empId) {
		Optional<Employee> emp = empRep.findById(empId);
		return emp;

	}

	public List<Employee> readListOfEmployee() {
		List<Employee> emp = (List<Employee>) empRep.findAll();
		return emp;

	}

	public void deletEmployee(int empId) {
		empRep.deleteById(empId);

	}

	public void updateEmpName(int empId, String empName) {
		 empRep.findById(empId);
	}

	public void updateEmployee(int empId, Employee emp) {
		empRep.save(emp);
	}

}
