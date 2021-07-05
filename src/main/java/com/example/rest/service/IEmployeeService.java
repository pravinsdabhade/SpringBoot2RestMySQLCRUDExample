package com.example.rest.service;

import java.util.List;

import com.example.rest.model.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee e);

	void updateEmploee(Employee e);

	void deleteEmployee(Integer id);

	Employee getEmployeeById(Integer id);

	List<Employee> getAllEmployees();
}
