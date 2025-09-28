package com.springmvc.SpringMVC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.SpringMVC.entity.Employee;
import com.springmvc.SpringMVC.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	public Employee getById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee update(Employee employee, Long id) {
		Employee emp = employeeRepository.findById(id).orElse(null);
		
		
		employee.setName(emp.getName());
		employee.setEmail(emp.getEmail());
		employee.setDob(emp.getDob());
		employee.setDepartment(emp.getDepartment());
		
		return employeeRepository.save(employee);
		
	}
	
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}
}
