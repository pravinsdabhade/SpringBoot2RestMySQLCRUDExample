package com.example.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.custom.exception.EmployeeNotFoundExcetion;
import com.example.rest.model.Employee;
import com.example.rest.repo.EmployeeRepository;
import com.example.rest.service.IEmployeeService;
import com.example.rest.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	EmployeeUtil util;

	/**
	 * It will do caculation of hra,ta insert data into db table
	 */

	@Override
	public Integer saveEmployee(Employee e) {
		util.calcuateData(e);
		e = empRepo.save(e);
		return e.getEmpId();
	}

	/**
	 * Read id from given object if id not null and exist db then call update else
	 * throw exception
	 */

	@Override
	public void updateEmploee(Employee e) {
		if (e.getEmpId() != null || empRepo.existsById(e.getEmpId())) {
			util.calcuateData(e);
			empRepo.save(e);
		} else {
			throw new EmployeeNotFoundExcetion((e.getEmpId()==null?
					"No Id is provided!!" :
					"Employee '"+e.getEmpId()+"' not exist"));
		}
	}

	/***
	 * First check given id exist in Database 
	 * 	If exist perform Delete operation
	 *  else throw exception 
	 */
	
	@Override
	public void deleteEmployee(Integer id) {
//		empRepo.deleteById(id);
		empRepo.delete(getEmployeeById(id));
	}

	/***
	 * If given id exist in database load object and return same else throw
	 * exception
	 */

	@Override
	public Employee getEmployeeById(Integer id) {
		return empRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundExcetion("Employee id: '" + id + "'not existed.."));
		/*
		 * Optional<Employee> employeeById = empRepo.findById(id);
		 * if(employeeById.isPresent()) { return employeeById.get(); }else { throw new
		 * EmployeeNotFoundExcetion("Employee id: '" + id + "'not existed.."); }
		 */
	}

	/***
	 * Fetch all rows from Database table
	 * 
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

}
