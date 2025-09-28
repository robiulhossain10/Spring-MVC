package com.springmvc.SpringMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.SpringMVC.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
