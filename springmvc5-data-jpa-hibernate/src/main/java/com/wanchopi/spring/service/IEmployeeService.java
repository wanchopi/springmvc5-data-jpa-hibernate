package com.wanchopi.spring.service;

import java.util.List;

import com.wanchopi.spring.entity.Employee;
import com.wanchopi.spring.exception.ResourceNotFoundException;

/**
 * IEmployeeService
 * 
 * @author Wanchopi
 *
 */
public interface IEmployeeService {
	
	public List<Employee> getAllEmployees();
	public void saveEmployee(Employee employee);
	public Employee getEmployeeById(long id) throws ResourceNotFoundException;
	public void deleteEmployee(long id) throws ResourceNotFoundException;
	public void deleteAll() throws ResourceNotFoundException;
	public List<Employee> search(String keyword);

}
