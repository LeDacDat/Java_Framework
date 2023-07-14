package com.example.DemoSpringBoot.services;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.model.Employee;
import com.example.DemoSpringBoot.repository.IEmployeeRespo;
@Service
public class EmployeeServiceImpl implements IEmployeeServices {
	
	@Autowired
	private IEmployeeRespo employeeRespo;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRespo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRespo.save(employee);
		
	}

	@Override
	public Employee getEmployeeByID(Long id) {
		Optional<Employee> optional = employeeRespo.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id :" +id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		this.employeeRespo.deleteById(id);
		
	}

	@Override
	public Page<Employee> findPaginated(Integer pageNo, Integer pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
				
		
		org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNo-1, pageSize,sort);
		return this.employeeRespo.findAll(pageable);
		
	}

	

	

}
