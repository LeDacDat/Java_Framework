package com.example.DemoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DemoSpringBoot.model.Employee;
@Repository
public interface IEmployeeRespo extends JpaRepository<Employee, Long> {

}
