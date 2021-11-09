package com.santwanivk.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santwanivk.springboot.cruddemo.entity.Employee;
import com.santwanivk.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//	private EmployeeDAO employeeDAO;
	//
	//	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
	//
	//		this.employeeDAO = theEmployeeDAO;
	//	}
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId)
	{
		Employee employee = employeeService.findById(employeeId);
		if(employee == null)
		{
			throw new RuntimeException("Employee Id not found "+employeeId);
		}
		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee udpateEmployee(@RequestBody Employee theEmployee)
	{
		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteById(@PathVariable int employeeId)
	{
		Employee employee = employeeService.findById(employeeId);
		if(employee == null)
		{
			throw new RuntimeException("Employee Id not found "+employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted Successfully";
	}
}
