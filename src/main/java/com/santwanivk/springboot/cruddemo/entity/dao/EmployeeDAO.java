package com.santwanivk.springboot.cruddemo.entity.dao;


import java.util.List;
import com.santwanivk.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int theId);
	public void saveEmployee(Employee theEmployee);
	public void deleteById(int theId);

}
