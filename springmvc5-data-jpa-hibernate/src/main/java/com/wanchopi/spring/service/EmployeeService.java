package com.wanchopi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanchopi.spring.entity.Employee;
import com.wanchopi.spring.exception.ResourceNotFoundException;
import com.wanchopi.spring.repository.EmployeeRepository;

/**
 * Class that implements the IEmployeeService interface 
 * @author Wanchopi
 *
 */
@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public Employee getEmployeeById(long id) throws ResourceNotFoundException {
		return employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteEmployee(long id) throws ResourceNotFoundException {
		employeeRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws ResourceNotFoundException {
		employeeRepository.deleteAll();
	}

	@Override
	@Transactional
	public List<Employee> search(String keyword) {
		return employeeRepository.search(keyword);
	}

}
