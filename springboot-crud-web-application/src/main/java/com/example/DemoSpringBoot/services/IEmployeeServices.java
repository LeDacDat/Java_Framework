package com.example.DemoSpringBoot.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.DemoSpringBoot.model.Employee;

public interface IEmployeeServices {
	
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeByID(Long id);
	void deleteEmployeeById	(Long id);
	Page<Employee> findPaginated(Integer pageNo, Integer pageSize, String sortField, String sortDirection);
}
