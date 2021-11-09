package com.santwanivk.springboot.cruddemo.service;

import java.util.List;

import com.santwanivk.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void saveEmployee(Employee theEmployee);
	public void deleteById(int theId);
}
