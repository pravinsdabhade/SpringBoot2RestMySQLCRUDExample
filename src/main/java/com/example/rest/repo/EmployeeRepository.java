package com.example.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
